package com.shaonian.dynamic.form.formitem;

import com.shaonian.dynamic.form.bean.DictBean;
import com.shaonian.dynamic.form.verify.BaseVerify;
import com.shaonian.dynamic.form.verify.RequiredVerify;

import java.util.ArrayList;
import java.util.List;

/**
 * 弹窗选择Item
 *
 * @author wk
 * @date 2021/05/11
 */

public class SelectFormItem extends BaseFormItem {

    private final List<DictBean> mDictBeanList;

    protected SelectFormItem(String title, String formId, Object value, List<DictBean> dictBeans) {
        this(title, formId, value, false, dictBeans);
    }

    protected SelectFormItem(String title, String formId, Object value, boolean isRequired, List<DictBean> dictBeans) {
        this(title, formId, value, isRequired, false, dictBeans);
    }

    protected SelectFormItem(String title, String formId, Object value, boolean isRequired, boolean isReadOnly, List<DictBean> dictBeans) {
        this(title, formId, value, isRequired, isReadOnly, new RequiredVerify(), dictBeans);
    }

    protected SelectFormItem(String title, String formId, Object value, boolean isRequired, boolean isReadOnly, BaseVerify verify, List<DictBean> dictBeans) {
        super(title, formId, value, isRequired, isReadOnly, verify);
        if (dictBeans != null) {
            mDictBeanList = dictBeans;
        } else {
            mDictBeanList = new ArrayList<>();
        }
    }

    public List<DictBean> getDictBeanList() {
        return mDictBeanList;
    }

    public void setData(List<DictBean> data) {
        this.mDictBeanList.clear();
        this.mDictBeanList.addAll(data);
    }
}
