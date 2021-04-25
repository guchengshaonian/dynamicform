package com.shaonian.dynamic.form.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioGroup;

import com.shaonian.dynamic.form.R;
import com.shaonian.dynamic.form.bean.DictBean;
import com.shaonian.dynamic.form.formitem.RadioButtonFormItem;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

/**
 * 数量较少的单选表单view
 *
 * @author wk
 * @date 2021/04/25
 */

public class RadioButtonFormView extends BaseFormView<RadioButtonFormItem> {

    private RadioGroup mRadioGroup;
    private List<DictBean> mDictBeans = new ArrayList<>();

    public RadioButtonFormView(Context context) {
        super(context);
    }

    public RadioButtonFormView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RadioButtonFormView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected View getValueView(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.form_view_radio_button, this, false);
    }

    @Override
    protected void initAttrs(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.RadioButtonFormView);
        isRequired = array.getBoolean(R.styleable.RadioButtonFormView_is_required, true);
        isViewOnly = array.getBoolean(R.styleable.RadioButtonFormView_is_view_only, false);
        mTitle = array.getString(R.styleable.RadioButtonFormView_item_title);
        array.recycle();
    }

    @Override
    protected void initView() {
        mRadioGroup = mContainerLayout.findViewById(R.id.form_view_rg);
        mRequireView.setVisibility(isRequired ? VISIBLE : GONE);
        mTitleView.setText(mTitle);
        if (mDictBeans.size() != 0) {
            for (DictBean dictBean : mDictBeans) {

            }
        }
    }

    @Override
    public void setFormItem(RadioButtonFormItem baseFormItem) {
        isRequired = baseFormItem.isRequired();
        isViewOnly = baseFormItem.isReadOnly();
        mTitle = baseFormItem.getTitle();
        mDictBeans.addAll(baseFormItem.mRadioForm());
        initView();
    }

    @Override
    protected Object getValue() {
        return null;
    }
}