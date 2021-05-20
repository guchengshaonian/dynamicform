package com.shaonian.dynamic.form.bridge;

import com.shaonian.dynamic.form.formitem.BaseFormItem;

/**
 * @author wk.
 * Date: 2020/12/25
 * 连接多个item校验的桥梁类
 */
public abstract class BaseBridge {

    /**
     * 表单组联合校验
     *
     * @param sourceItem  源目标
     * @param targetItems 比较对象目标
     */
    public abstract void onBridgeVerify(BaseFormItem sourceItem, BaseFormItem... targetItems);

}
