package com.shaonian.dynamic.form.formitem;

import com.shaonian.dynamic.form.bean.DictBean;
import com.shaonian.dynamic.form.verify.BaseVerify;
import com.shaonian.dynamic.form.verify.RequiredVerify;

import java.util.ArrayList;
import java.util.List;

/**
 * 下拉框选择item
 *
 * @author wk
 * @date 2021/04/28
 */

public class PullSelectFormItem extends BaseFormItem {

    /**
     * 单选
     */
    public static final int SINGLE_SELECT = 1;
    /**
     * 多选
     */
    public static final int MULTIPLE_SELECT = 2;
    /**
     * 多级联动单选
     */
    public static final int LINKED_SINGLE_SELECT = 3;
    /**
     * 多级联动多选
     */
    public static final int LINKED_MULTIPLE_SELECT = 4;

    private int mMode = SINGLE_SELECT;

    private final List<DictBean> mSelectFormList = new ArrayList<>();

    protected PullSelectFormItem(String title, String formId, Object value) {
        this(title, formId, value, false);
    }

    protected PullSelectFormItem(String title, String formId, Object value, boolean isRequired) {
        this(title, formId, value, isRequired, false);
    }

    protected PullSelectFormItem(String title, String formId, Object value, boolean isRequired, boolean isReadOnly) {
        this(title, formId, value, isRequired, isReadOnly, new RequiredVerify());
    }

    protected PullSelectFormItem(String title, String formId, Object value, boolean isRequired, boolean isReadOnly, BaseVerify verify) {
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
