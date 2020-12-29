package com.shaonian.dynamic.form.formitem;

import com.shaonian.dynamic.form.verify.BaseVerify;
import com.shaonian.dynamic.form.verify.RequiredVerify;

import java.lang.reflect.Field;

/**
 * @author wk.
 * Date: 2020/12/25
 */
public class EditTextFormItem<T> extends BaseFormItem<T> {

    public EditTextFormItem(String title, String formId, T value) {
        this(title, formId, value, true);
    }

    public EditTextFormItem(String title, String formId, T value, boolean isRequired) {
        this(title, formId, value, isRequired, false);
    }

    public EditTextFormItem(String title, String formId, T value, boolean isRequired, boolean isReadOnly) {
        this(title, formId, value, isRequired, isReadOnly, new RequiredVerify());
    }

    public EditTextFormItem(String title, String formId, T value, boolean isRequired, boolean isReadOnly, BaseVerify verify) {
        super(title, formId, value, isRequired, isReadOnly, verify);
        setFormValue();
    }
}
