package com.shaonian.dynamic.form.formitem;

import com.shaonian.dynamic.form.verify.BaseVerify;
import com.shaonian.dynamic.form.verify.RequiredVerify;

/**
 * @author wk.
 * Date: 2020/12/25
 */
public class EditTextFormItem<T> extends BaseFormItem<T> {

    public enum EditTextType {
        /**
         * 一般类型
         */
        Normal,
        /**
         * 电话号码
         */
        Tel,
        /**
         * 身份证号
         */
        IDCard,
        /**
         * 数字类型
         */
        Number,
    }

    public EditTextFormItem(String title, String formId, T value) {
        this(title, formId, value, EditTextType.Normal);
    }

    public EditTextFormItem(String title, String formId, T value, EditTextType textType) {
        this(title, formId, value, textType, true);
    }

    public EditTextFormItem(String title, String formId, T value, EditTextType textType, boolean isRequired) {
        this(title, formId, value, textType, isRequired, false);
    }

    public EditTextFormItem(String title, String formId, T value, EditTextType textType, boolean isRequired, boolean isReadOnly) {
        this(title, formId, value, textType, isRequired, isReadOnly, new RequiredVerify());
    }

    public EditTextFormItem(String title, String formId, T value, EditTextType textType, boolean isRequired, boolean isReadOnly, BaseVerify verify) {
        super(title, formId, value, isRequired, isReadOnly, verify);
        setTextType(textType);
    }

    /**
     * 根据不同的输入类型，设置不同的限制条件以及校验规则
     *
     * @param textType 输入类型
     */
    private void setTextType(EditTextType textType) {
        switch (textType) {
            case Tel:
                break;
            case Number:
                break;
            case IDCard:
                break;
            case Normal:
            default:
                break;
        }
    }
}