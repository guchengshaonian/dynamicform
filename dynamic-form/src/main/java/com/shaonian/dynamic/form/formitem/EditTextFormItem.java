package com.shaonian.dynamic.form.formitem;

import android.text.InputType;
import android.text.TextUtils;
import android.widget.EditText;

import com.blankj.utilcode.util.RegexUtils;
import com.shaonian.dynamic.form.verify.BaseVerify;
import com.shaonian.dynamic.form.verify.IdCardVerify;
import com.shaonian.dynamic.form.verify.PhoneVerify;
import com.shaonian.dynamic.form.verify.RequiredVerify;

/**
 * @author wk.
 * Date: 2020/12/25
 * 文本框item
 */
public class EditTextFormItem extends BaseFormItem {

    private int mEditInputType = InputType.TYPE_NULL;
    /**
     * 限制输入字符
     */
    private String mDigits = "";

    private String hintText;

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
        /**
         * 密码
         */
        Password
    }

    public EditTextFormItem(String title, String formId, Object value) {
        this(title, formId, value, EditTextType.Normal);
    }

    public EditTextFormItem(String title, String formId, Object value, EditTextType textType) {
        this(title, formId, value, textType, true);
    }

    public EditTextFormItem(String title, String formId, Object value, EditTextType textType, boolean isRequired) {
        this(title, formId, value, textType, isRequired, false);
    }

    public EditTextFormItem(String title, String formId, Object value, EditTextType textType, boolean isRequired, boolean isReadOnly) {
        this(title, formId, value, textType, isRequired, isReadOnly, new RequiredVerify());
    }

    public EditTextFormItem(String title, String formId, Object value, EditTextType textType, boolean isRequired, boolean isReadOnly, BaseVerify verify) {
        super(title, formId, value, isRequired, isReadOnly, verify);
        setTextType(textType);
    }

    public int getEditInputType() {
        return mEditInputType;
    }

    public void setEditInputType(int editInputType) {
        mEditInputType = editInputType;
    }

    public String getDigits() {
        return mDigits;
    }

    public void setDigits(String digits) {
        mDigits = digits;
    }

    public String getHintText() {
        if (TextUtils.isEmpty(hintText)) {
            return "请输入" + getTitle();
        }
        return hintText;
    }

    public void setHintText(String hintText) {
        this.hintText = hintText;
    }

    /**
     * 根据不同的输入类型，设置不同的限制条件以及校验规则
     *
     * @param textType 输入类型
     */
    private void setTextType(EditTextType textType) {
        switch (textType) {
            case Tel:
                mVerify = new PhoneVerify();
                mEditInputType = InputType.TYPE_CLASS_PHONE;
                break;
            case Number:
                mEditInputType = InputType.TYPE_CLASS_NUMBER;
                break;
            case IDCard:
                mVerify = new IdCardVerify();
                mEditInputType = InputType.TYPE_NUMBER_FLAG_SIGNED;
                mDigits = "0123456789X";
                break;
            case Password:
                mEditInputType = InputType.TYPE_TEXT_VARIATION_PASSWORD;
                break;
            case Normal:
            default:
                break;
        }
    }
}