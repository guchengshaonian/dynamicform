package com.shaonian.dynamic.form.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.shaonian.dynamic.form.R;
import com.shaonian.dynamic.form.formitem.EditTextFormItem;

import androidx.annotation.Nullable;

/**
 * @author Adminis.
 * Date: 2021/3/10
 * Time: 22:38
 * 文本框View
 */
public class EditTextFormView extends BaseFormView<EditTextFormItem> {

    private String mHintText;

    public EditTextFormView(Context context) {
        super(context);
    }

    public EditTextFormView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EditTextFormView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected View getValueView(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.form_view_edit_view,this,false);
    }

    @Override
    protected void initAttrs(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.EditTextFormView);
        isRequired = array.getBoolean(R.styleable.EditTextFormView_is_required, true);
        isViewOnly = array.getBoolean(R.styleable.EditTextFormView_is_view_only, false);
        mTitle = array.getString(R.styleable.EditTextFormView_item_title);
        mHintText = array.getString(R.styleable.EditTextFormView_title_hint);
        mVerify = array.getInt(R.styleable.EditTextFormView_verify, 5);
        array.recycle();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setFormItem(EditTextFormItem baseFormItem) {

    }

    @Override
    protected Object getValue() {
        return null;
    }
}
