package com.shaonian.dynamic.form.formitem;

import com.shaonian.dynamic.form.verify.BaseVerify;
import com.shaonian.dynamic.form.verify.RequiredVerify;

/**
 * 时间选择的formItem
 *
 * @author wk
 * @date 2021/04/26
 */

public class DataSelectFormItem extends BaseFormItem {

    protected DataSelectFormItem(String title, String formId, Object value) {
        this(title, formId, value, false);
    }

    protected DataSelectFormItem(String title, String formId, Object value, boolean isRequired) {
        this(title, formId, value, isRequired, false);
    }

    protected DataSelectFormItem(String title, String formId, Object value, boolean isRequired, boolean isReadOnly) {
        this(title, formId, value, isRequired, isReadOnly, new RequiredVerify());
    }

    protected DataSelectFormItem(String title, String formId, Object value, boolean isRequired, boolean isReadOnly, BaseVerify verify) {
        super(title, formId, value, isRequired, isReadOnly, verify);
    }
}
