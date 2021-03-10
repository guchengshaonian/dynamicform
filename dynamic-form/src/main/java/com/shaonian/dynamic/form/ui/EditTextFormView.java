package com.shaonian.dynamic.form.ui;

import android.content.Context;
import android.util.AttributeSet;

import com.shaonian.dynamic.form.formitem.EditTextFormItem;

import androidx.annotation.Nullable;

/**
 * @author Adminis.
 * Date: 2021/3/10
 * Time: 22:38
 * 文本框View
 */
public class EditTextFormView extends BaseFormView<EditTextFormItem> {

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
    protected void setViewData() {

    }

    @Override
    protected String getValue() {
        return null;
    }
}
