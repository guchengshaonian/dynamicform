package com.shaonian.dynamic.form.bridge;

import com.shaonian.dynamic.form.formitem.BaseFormItem;
import com.shaonian.dynamic.form.verify.VerifyResult;

/**
 * @author wk.
 * Date: 2020/12/25
 * 连接多个item校验的桥梁类
 */
public abstract class BaseBridge {

    //TODO 采用常量池和队列的方式，来搜索相同的连接校验，如果item和type一致，则使用同一个
    protected BaseFormItem mSourceItem;
    protected BaseFormItem[] mTargetItems;

    protected BaseBridge(BaseFormItem sourceItem, BaseFormItem... targetItems) {
        mSourceItem = sourceItem;
        mTargetItems = targetItems;
    }

    /**
     * 获取连接类型
     *
     * @return 类型
     */
    protected abstract BridgeVerifyType getBridgeType();

    public VerifyResult onVerify() {
        BridgeVerifyType bridgeVerifyType = getBridgeType();
        if (bridgeVerifyType == null) {
            return VerifyResult.fail("请设置联合校验类型");
        }
        return onBridgeVerify(mSourceItem, mTargetItems);
    }

    /**
     * 表单组联合校验
     *
     * @param sourceItem  源目标
     * @param targetItems 比较对象目标
     * @return 校验结果
     */
    public abstract VerifyResult onBridgeVerify(BaseFormItem sourceItem, BaseFormItem... targetItems);

}
