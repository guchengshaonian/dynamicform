package com.shaonian.dynamic.form.formitem;

import com.shaonian.dynamic.form.bean.DictBean;
import com.shaonian.dynamic.form.verify.BaseVerify;
import com.shaonian.dynamic.form.verify.RequiredVerify;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wk.
 * Date: 2021/3/10
 * Time: 22:07
 * 单选框（针对数量较少的选择）
 */
public class RadioButtonFormItem extends BaseFormItem {

    private final List<DictBean> mRadioSelectList = new ArrayList<>();

    protected RadioButtonFormItem(String title, String formId, Object value) {
        this(title, formId, value, false);
    }

    protected RadioButtonFormItem(String title, String formId, Object value, boolean isRequired) {
        this(title, formId, value, isRequired, false);
    }

    protected RadioButtonFormItem(String title, String formId, Object value, boolean isRequired, boolean isReadOnly) {
        this(title, formId, value, isRequired, isReadOnly, new RequiredVerify());
    }

    protected RadioButtonFormItem(String title, String formId, Object value, boolean isRequired, boolean isReadOnly, BaseVerify verify) {
        super(title, formId, value, isRequired, isReadOnly, verify);

    }

    /**
     * 传入字符串
     *
     * @param values 字符串
     */
    public void setChooseData(String[] values) {
        for (String value : values) {
            mRadioSelectList.add(new DictBean(value, value));
        }
    }

    /**
     * 传入字典对象
     *
     * @param dictBeans 选择内容
     */
    public void setChooseData(List<DictBean> dictBeans) {
        mRadioSelectList.addAll(dictBeans);
    }

    public List<DictBean> getRadioSelectList() {
        return mRadioSelectList;
    }
}