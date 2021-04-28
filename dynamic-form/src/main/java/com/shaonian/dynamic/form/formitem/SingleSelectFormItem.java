package com.shaonian.dynamic.form.formitem;

import com.shaonian.dynamic.form.bean.DictBean;
import com.shaonian.dynamic.form.verify.BaseVerify;
import com.shaonian.dynamic.form.verify.RequiredVerify;

import java.util.ArrayList;
import java.util.List;

/**
 * 单层单项选择item
 *
 * @author wk
 * @date 2021/04/28
 */

public class SingleSelectFormItem extends BaseFormItem {

    /**
     * 下拉框方式展示
     */
    public static final int PULL_DOWN_LIST = 1;
    /**
     * 弹窗展示
     */
    public static final int WINDOW_DIALOG = 2;

    private int mMode = PULL_DOWN_LIST;

    private final List<DictBean> mSelectFormList = new ArrayList<>();

    protected SingleSelectFormItem(String title, String formId, Object value) {
        this(title, formId, value, false);
    }

    protected SingleSelectFormItem(String title, String formId, Object value, boolean isRequired) {
        this(title, formId, value, isRequired, false);
    }

    protected SingleSelectFormItem(String title, String formId, Object value, boolean isRequired, boolean isReadOnly) {
        this(title, formId, value, isRequired, isReadOnly, new RequiredVerify());
    }

    protected SingleSelectFormItem(String title, String formId, Object value, boolean isRequired, boolean isReadOnly, BaseVerify verify) {
        super(title, formId, value, isRequired, isReadOnly, verify);
    }

    /**
     * 传入字符串
     *
     * @param values 字符串
     */
    public void setChooseData(String[] values) {
        for (String value : values) {
            mSelectFormList.add(new DictBean(value, value));
        }
    }

    /**
     * 传入字典对象
     *
     * @param dictBeans 选择内容
     */
    public void setChooseData(List<DictBean> dictBeans) {
        mSelectFormList.addAll(dictBeans);
    }

    public List<DictBean> getSelectFormList() {
        return mSelectFormList;
    }

    public int getMode() {
        return mMode;
    }

    public void setMode(int mode) {
        mMode = mode;
    }
}
