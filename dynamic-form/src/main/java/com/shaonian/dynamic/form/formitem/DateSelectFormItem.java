package com.shaonian.dynamic.form.formitem;

import com.shaonian.dynamic.form.verify.BaseVerify;
import com.shaonian.dynamic.form.verify.RequiredVerify;

/**
 * 时间选择的formItem
 *
 * @author wk
 * @date 2021/04/26
 */

public class DateSelectFormItem extends BaseFormItem {

    /**
     * 只精确到年月日
     */
    public static final String DATA_FORMAT_NYR = "yyyy-MM-dd";
    /**
     * 精确到年月日，时分秒
     */
    public static final String DATA_FORMAT_SFM = "yyyy-MM-dd hh:mm:ss";
    private String mDateFormat;

    protected DateSelectFormItem(String title, String formId, Object value) {
        this(title, formId, value, false, DATA_FORMAT_NYR);
    }

    protected DateSelectFormItem(String title, String formId, Object value, String dataFormat) {
        this(title, formId, value, false, dataFormat);
    }

    protected DateSelectFormItem(String title, String formId, Object value, boolean isRequired, String dataFormat) {
        this(title, formId, value, isRequired, false, dataFormat);
    }

    protected DateSelectFormItem(String title, String formId, Object value, boolean isRequired, boolean isReadOnly, String dataFormat) {
        this(title, formId, value, isRequired, isReadOnly, new RequiredVerify(), dataFormat);
    }

    protected DateSelectFormItem(String title, String formId, Object value, boolean isRequired, boolean isReadOnly, BaseVerify verify, String dataFormat) {
        super(title, formId, value, isRequired, isReadOnly, verify);
        setDateFormat(dataFormat);
    }

    public String getDateFormat() {
        return mDateFormat;
    }

    public void setDateFormat(String dateFormat) {
        mDateFormat = dateFormat;
    }
}
