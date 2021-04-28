package com.shaonian.dynamic.form.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.shaonian.dynamic.form.R;
import com.shaonian.dynamic.form.bean.DictBean;
import com.shaonian.dynamic.form.formitem.SingleSelectFormItem;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

/**
 * 单层单项选择itemView
 *
 * @author wk
 * @date 2021/04/28
 */

public class SingleSelectFormView extends BaseFormView<SingleSelectFormItem> {

    private int mMode;
    private List<DictBean> mSelectList = new ArrayList<>();

    public SingleSelectFormView(Context context) {
        super(context);
    }

    public SingleSelectFormView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SingleSelectFormView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected View getValueView(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.form_view_single_select, this, false);
    }

    @Override
    protected void initAttrs(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.SingleSelectFormView);
        isRequired = array.getBoolean(R.styleable.SingleSelectFormView_is_required, true);
        isViewOnly = array.getBoolean(R.styleable.SingleSelectFormView_is_view_only, false);
        mTitle = array.getString(R.styleable.SingleSelectFormView_item_title);
        mFormViewValue = array.getString(R.styleable.SingleSelectFormView_form_value);
        mMode = array.getInt(R.styleable.SingleSelectFormView_select_mode, 1);
        array.recycle();
    }

    @Override
    protected void initView() {

    }

    @Override
    public void setDifferenceAttribute(SingleSelectFormItem formItem) {
        mMode = formItem.getMode();
        mSelectList.addAll(formItem.getSelectFormList());
    }

    @Override
    protected Object getValue() {
        return null;
    }

    @Override
    public void setFormViewValue(String value) {

    }
}
