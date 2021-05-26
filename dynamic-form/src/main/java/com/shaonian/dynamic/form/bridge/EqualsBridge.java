package com.shaonian.dynamic.form.bridge;

import com.shaonian.dynamic.form.formitem.BaseFormItem;
import com.shaonian.dynamic.form.util.ParserUtil;
import com.shaonian.dynamic.form.verify.VerifyResult;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * 相等比较的连接校验
 *
 * @author wk
 * @date 2021/05/21
 */

public class EqualsBridge extends BaseBridge {

    protected EqualsBridge(BaseFormItem sourceItem, BaseFormItem targetItem) {
        super(sourceItem, targetItem);
    }

    protected EqualsBridge(BaseFormItem sourceItem, BaseFormItem[] targetItems) {
        super(sourceItem, targetItems);
    }

    protected EqualsBridge(BaseFormItem[] sourceItems, BaseFormItem[] targetItems) {
        super(sourceItems, targetItems);
    }

    protected EqualsBridge(BaseFormItem sourceItem, List<BaseFormItem> targetItems) {
        super(sourceItem, targetItems);
    }

    protected EqualsBridge(List<BaseFormItem> sourceItems, List<BaseFormItem> targetItems) {
        super(sourceItems, targetItems);
    }

    @Override
    @Nullable
    protected BridgeVerifyType getBridgeVerifyType() {
        return BridgeVerifyType.EQUALS;
    }

    @Override
    @Nullable
    protected BridgeType getBridgeType() {
        return BridgeType.NUMBER;
    }

    @Override
    protected VerifyResult onBridgeVerify(List<BaseFormItem> sourceItems, List<BaseFormItem> targetItems) {
        switch (mBridgeType) {
            case NUMBER:
                return checkNumber(sourceItems, targetItems);
            case DATE:
            case TEXT:
                if (mMode == ONE_TO_ONE) {
                    if (sourceItems.get(0).getFormValue().equals(targetItems.get(0).getFormValue())) {
                        return VerifyResult.success();
                    } else {
                        return VerifyResult.fail(sourceItems.get(0).getTitle() + "必须" + mBridgeVerifyType.getTitle() + targetItems.get(0).getTitle()
                        );
                    }
                } else {
                    return VerifyResult.fail("一对多或者多对多不允许文本形式组合相等校验");
                }
            default:
                return VerifyResult.fail("校验失败");
        }
    }

    private VerifyResult checkNumber(List<BaseFormItem> sourceItems, List<BaseFormItem> targetItems) {
        switch (mMode) {
            case ONE_TO_ONE:
                Number number = ParserUtil.parseNumber(sourceItems.get(0).getValue());
                if (number != null && number.equals(targetItems.get(0).getValue())) {
                    return VerifyResult.success();
                } else {
                    return VerifyResult.fail(sourceItems.get(0).getTitle() + "必须" +
                            mBridgeVerifyType.getTitle() + targetItems.get(0).getTitle());
                }
            case ONE_TO_MORE:
                return VerifyResult.fail("校验失败");
            case MORE_TO_MORE:
                return VerifyResult.fail("校验失败");
            default:
                return VerifyResult.fail("校验失败");
        }
    }
}
