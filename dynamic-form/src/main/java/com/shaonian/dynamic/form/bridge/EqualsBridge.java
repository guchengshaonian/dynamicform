package com.shaonian.dynamic.form.bridge;

import com.shaonian.dynamic.form.formitem.BaseFormItem;
import com.shaonian.dynamic.form.verify.VerifyResult;

/**
 * 相等比较的连接校验
 *
 * @author wk
 * @date 2021/05/21
 */

public class EqualsBridge extends BaseBridge {

    protected EqualsBridge(BaseFormItem sourceItem, BaseFormItem... targetItems) {
        super(sourceItem, targetItems);
    }

    @Override
    protected BridgeVerifyType getBridgeType() {
        return BridgeVerifyType.EQUALS;
    }

    @Override
    public VerifyResult onBridgeVerify(BaseFormItem sourceItem, BaseFormItem... targetItems) {

        return null;
    }
}
