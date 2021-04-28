package com.shaonian.dynamic.form.ui;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.shaonian.dynamic.form.R;
import com.shaonian.dynamic.form.formitem.DateSelectFormItem;
import com.shaonian.dynamic.form.widget.DateTimePickerDialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;

import androidx.annotation.Nullable;

/**
 * 时间选择formView
 *
 * @author wk
 * @date 2021/04/27
 */

public class DateSelectFormView extends BaseFormView<DateSelectFormItem> implements DatePickerDialog.OnDateSetListener, DateTimePickerDialog.DataTimeSetListener {
    private TextView mDateSelect;
    private String mDateFormat;
    private static final int LENGTH_NYR = 3;
    private static final int LENGTH_SFM = 6;

    public DateSelectFormView(Context context) {
        super(context);
    }

    public DateSelectFormView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DateSelectFormView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected View getValueView(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.form_view_date_select, this, false);
    }

    @Override
    protected void initAttrs(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.DateSelectFormView);
        isRequired = array.getBoolean(R.styleable.DateSelectFormView_is_required, true);
        isViewOnly = array.getBoolean(R.styleable.DateSelectFormView_is_view_only, false);
        mTitle = array.getString(R.styleable.DateSelectFormView_item_title);
        mFormViewValue = array.getString(R.styleable.DateSelectFormView_form_value);
        array.recycle();
    }

    @Override
    protected void initView() {
        mDateSelect = mContainerLayout.findViewById(R.id.tv_date_select);
        mRequireView.setVisibility(isRequired ? VISIBLE : GONE);
        if (!isViewOnly) {
            mDateSelect.setOnClickListener(this::onShowDateSelect);
        }
        mTitleView.setText(mTitle);
        mDateSelect.setText(mFormViewValue);
    }

    /**
     * 弹窗展示时间选择器
     *
     * @param view view
     */
    private void onShowDateSelect(View view) {
        int[] dates = getDate(mFormViewValue);
        switch (mDateFormat) {
            case DateSelectFormItem.DATA_FORMAT_NYR:
                if (dates.length < LENGTH_NYR) {
                    ToastUtils.showShort("时间解析失误");
                    return;
                }
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), this, dates[0], dates[1], dates[2]);
                datePickerDialog.show();
                break;
            case DateSelectFormItem.DATA_FORMAT_SFM:
                if (dates.length < LENGTH_SFM) {
                    ToastUtils.showShort("时间解析失误");
                    return;
                }
                //年月日时分秒的选择器
                DateTimePickerDialog dateTimePickerDialog = new DateTimePickerDialog(getContext(), this,
                        dates[0], dates[1], dates[2], dates[3], dates[4], dates[5]);
                dateTimePickerDialog.show();
                break;
            default:
                break;
        }
    }

    /**
     * 根据时间字符串转换成int
     *
     * @param formViewValue 时间字符串
     * @return 年月日，时分秒对应的int数组
     */
    private int[] getDate(String formViewValue) {
        Calendar calendar = Calendar.getInstance();
        int[] dates;
        if (!TextUtils.isEmpty(formViewValue)) {
            try {
                calendar.setTime(Objects.requireNonNull(new SimpleDateFormat(mDateFormat, Locale.CHINA).parse(formViewValue)));
            } catch (ParseException e) {
                e.printStackTrace();
                return new int[0];
            }
        }
        switch (mDateFormat) {
            case DateSelectFormItem.DATA_FORMAT_NYR:
                dates = new int[]{
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH) + 1,
                        calendar.get(Calendar.DAY_OF_MONTH)
                };
                return dates;
            case DateSelectFormItem.DATA_FORMAT_SFM:
                dates = new int[]{
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH) + 1,
                        calendar.get(Calendar.DAY_OF_MONTH),
                        calendar.get(Calendar.HOUR_OF_DAY),
                        calendar.get(Calendar.MINUTE),
                        calendar.get(Calendar.SECOND)
                };
                return dates;
            default:
                return new int[0];
        }
    }

    @Override
    public void setDifferenceAttribute(DateSelectFormItem formItem) {
        mDateFormat = formItem.getDateFormat();
    }

    @Override
    protected Object getValue() {
        return mDateSelect.getText().toString();
    }

    @Override
    public void setFormViewValue(String value) {
        mDateSelect.setText(value);
        mFormItem.setValue(value);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        mDateSelect.setText(String.format("%s-%s-%s", year, month, dayOfMonth));
        mFormItem.setValue(mDateSelect.getText().toString());
    }

    @Override
    public void onDateSet(int year, int month, int day, int hour, int minute, int second) {
        mDateSelect.setText(String.format("%s-%s-%s %s:%s:%s", year, month, day, hour, minute, second));
        mFormItem.setValue(mDateSelect.getText().toString());
    }
}
