package com.shaonian.dynamic.form.formitem;

import com.shaonian.dynamic.form.verify.BaseVerify;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Adminis.
 * Date: 2021/3/10
 * Time: 22:07
 * 单选框（针对数量较少的选择）
 */
public class CheckBoxFormItem extends BaseFormItem {

    private final Map<String, String> mCheckMap = new LinkedHashMap<>();

    protected CheckBoxFormItem(String title, String formId, Object value) {
        super(title, formId, value);
    }

    protected CheckBoxFormItem(String title, String formId, Object value, boolean isRequired) {
        super(title, formId, value, isRequired);
    }

    protected CheckBoxFormItem(String title, String formId, Object value, boolean isRequired, boolean isReadOnly) {
        super(title, formId, value, isRequired, isReadOnly);
    }

    protected CheckBoxFormItem(String title, String formId, Object value, boolean isRequired, boolean isReadOnly, BaseVerify verify) {
        super(title, formId, value, isRequired, isReadOnly, verify);
    }

    /**
     * 传入字符串
     *
     * @param values 字符串
     */
    public void setCheckData(String[] values) {
        for (String value : values) {
            mCheckMap.put(value, value);
        }
    }

    /**
     * 传入字符串
     *
     * @param values 键值对
     */
    public void setCheckData(Map<String, String> values) {
        for (Map.Entry<String, String> entry : values.entrySet()) {
            mCheckMap.put(entry.getKey(), entry.getValue());
        }
    }

    public Map<String, String> getCheckMap() {
        return mCheckMap;
    }
}