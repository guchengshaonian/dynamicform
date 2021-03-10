package com.shaonian.dynamic.form.formitem;

import android.text.TextUtils;

import com.shaonian.dynamic.form.verify.BaseVerify;
import com.shaonian.dynamic.form.verify.RequiredVerify;
import com.shaonian.dynamic.form.verify.VerifyResult;

import java.lang.reflect.Field;

/**
 * @author wk.
 * Date: 2020/12/25
 * 基础的formitem类
 */
public abstract class BaseFormItem {

    protected String mTitle;
    protected String mFormId;
    protected Object mValue;
    protected String mFormValue;
    protected boolean isRequired;
    protected boolean isReadOnly;
    protected BaseVerify mVerify;

    protected BaseFormItem(String title, String formId, Object value) {
        this(title, formId, value, true);
    }

    protected BaseFormItem(String title, String formId, Object value, boolean isRequired) {
        this(title, formId, value, isRequired, false);
    }

    protected BaseFormItem(String title, String formId, Object value, boolean isRequired, boolean isReadOnly) {
        this(title, formId, value, isRequired, isReadOnly, new RequiredVerify());
    }

    protected BaseFormItem(String title, String formId, Object value, boolean isRequired, boolean isReadOnly, BaseVerify verify) {
        this.mTitle = title;
        this.mFormId = formId;
        this.mValue = value;
        this.isReadOnly = isReadOnly;
        this.isRequired = isRequired;
        this.mVerify = verify;
        setFormValue();
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getFormId() {
        return mFormId;
    }

    public void setFormId(String formId) {
        mFormId = formId;
    }

    public Object getValue() {
        return mValue;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean required) {
        isRequired = required;
    }

    public void setValue(Object value) {
        mValue = value;
        setFormValue();
    }

    public void setFormValue(String formValue) {
        mFormValue = formValue;
    }

    public boolean isReadOnly() {
        return isReadOnly;
    }

    public void setReadOnly(boolean readOnly) {
        isReadOnly = readOnly;
    }

    public BaseVerify getVerify() {
        return mVerify;
    }

    public void setVerify(BaseVerify verify) {
        mVerify = verify;
    }

    public VerifyResult getVerifyResult() {
        return mVerify.onVerify(isRequired, getFormValue());
    }

    /**
     * 获取表单的内容
     *
     * @return 表单的显示内容
     */
    public String getFormValue() {
        return mFormValue;
    }

    /**
     * 根据不同参数类型，设置成统一的输出
     */
    protected void setFormValue() {
        Class<?> entityClass = mValue.getClass();
        if (entityClass.equals(String.class)) {
            mFormValue = (String) mValue;
        } else if (entityClass.isPrimitive()) {
            mFormValue = String.valueOf(mValue);
        } else {
            try {
                Field field = entityClass.getDeclaredField(mFormId);
                field.setAccessible(true);
                Object value = field.get(mValue);
                if (field.getType().isPrimitive()) {
                    mFormValue = String.valueOf(value);
                } else if (field.getType().equals(String.class)) {
                    mFormValue = (String) value;
                    if (TextUtils.isEmpty(mFormValue)) {
                        mFormValue = "";
                    }
                } else {
                    mFormValue = "";
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
                mFormValue = "";
            }
        }
    }
}
