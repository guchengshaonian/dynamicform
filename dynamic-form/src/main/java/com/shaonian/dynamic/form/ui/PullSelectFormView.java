package com.shaonian.dynamic.form.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.shaonian.dynamic.form.R;
import com.shaonian.dynamic.form.bean.DictBean;
import com.shaonian.dynamic.form.formitem.PullSelectFormItem;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

/**
 * 下拉选择框
 *
 * @author wk
 * @date 2021/04/28
 */

public class PullSelectFormView extends BaseFormView<PullSelectFormItem> {

    private List<DictBean> mSelectList = new ArrayList<>();
    private TextView mSelectText;
    private int mMode;

    public PullSelectFormView(Context context) {
        super(context);
    }

    public PullSelectFormView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PullSelectFormView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected View getValueView(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.form_view_single_select, this, false);
    }

    @Override
    protected void initAttrs(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.PullSelectFormView);
        isRequired = array.getBoolean(R.styleable.PullSelectFormView_is_required, true);
        isViewOnly = array.getBoolean(R.styleable.PullSelectFormView_is_view_only, false);
        mTitle = array.getString(R.styleable.PullSelectFormView_item_title);
        mFormViewValue = array.getString(R.styleable.PullSelectFormView_form_value);
        mMode = array.getInt(R.styleable.PullSelectFormView_mode, 1);
        array.recycle();
    }

    @Override
    protected void initView() {
        mSelectText = mContainerLayout.findViewById(R.id.tv_select_text);
        TextView pullDown = mContainerLayout.findViewById(R.id.tv_pull_down);
        mRequireView.setVisibility(isRequired ? VISIBLE : GONE);
        if (!isViewOnly) {
            mSelectText.setOnClickListener(this::onSelect);
            pullDown.setOnClickListener(this::onSelect);
        } else {
            pullDown.setVisibility(GONE);
            mSelectText.setOnClickListener(null);
            pullDown.setOnClickListener(null);
        }
        mSelectText.setText(mFormViewValue);
    }

    /**
     * 展示下拉框
     */
    private void onSelect(View view) {
        showPopWindow(mMode);
    }

    private void showPopWindow(int mode) {

    }

    @Override
    public void setDifferenceAttribute(PullSelectFormItem formItem) {
        mSelectList.clear();
        mMode = formItem.getMode();
        mSelectList.addAll(formItem.getSelectFormList());
    }

    @Override
    protected Object getValue() {
        return mFormItem.getValue();
    }

    @Override
    public void setFormViewValue(String value) {
        for (DictBean dictBean : mSelectList) {
            if (dictBean.getValue().equals(value) || dictBean.getName().equals(value)) {
                mSelectText.setText(value);
                mFormItem.setValue(dictBean.getValue());
                return;
            }
        }
    }
}
