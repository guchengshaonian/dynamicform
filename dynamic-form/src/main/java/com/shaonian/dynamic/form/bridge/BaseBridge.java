package com.shaonian.dynamic.form.bridge;

import com.blankj.utilcode.util.ArrayUtils;
import com.shaonian.dynamic.form.formitem.BaseFormItem;
import com.shaonian.dynamic.form.verify.VerifyResult;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import androidx.annotation.Nullable;

/**
 * @author wk.
 * Date: 2020/12/25
 * 连接多个item校验的桥梁类
 */
public abstract class BaseBridge {

    protected static final int ONE_TO_ONE = 1;
    protected static final int ONE_TO_MORE = 2;
    protected static final int MORE_TO_MORE = 3;
    protected int mMode;
    //TODO 采用常量池和消息队列的方式，来搜索相同的连接校验，如果item和type一致，则使用同一个
    protected List<BaseFormItem> mSourceItems;
    protected List<BaseFormItem> mTargetItems;
    protected BridgeType mBridgeType;
    protected BridgeVerifyType mBridgeVerifyType;

    protected BaseBridge(BaseFormItem sourceItem, BaseFormItem targetItem) {
        this(Collections.singletonList(sourceItem), Collections.singletonList(targetItem));
        mMode = ONE_TO_ONE;
    }

    protected BaseBridge(BaseFormItem sourceItem, BaseFormItem[] targetItems) {
        this(Collections.singletonList(sourceItem), Arrays.asList(targetItems));
        mMode = ONE_TO_MORE;
    }

    protected BaseBridge(BaseFormItem[] sourceItems, BaseFormItem[] targetItems) {
        this(Arrays.asList(sourceItems), Arrays.asList(targetItems));
        mMode = MORE_TO_MORE;
    }

    protected BaseBridge(BaseFormItem sourceItem, List<BaseFormItem> targetItems) {
        this(Collections.singletonList(sourceItem), targetItems);
        mMode = ONE_TO_MORE;
    }

    protected BaseBridge(List<BaseFormItem> sourceItems, List<BaseFormItem> targetItems) {
        this.mSourceItems = sourceItems;
        this.mTargetItems = targetItems;
        mMode = MORE_TO_MORE;
    }

    /**
     * 获取连接类型
     *
     * @return 类型
     */
    protected abstract BridgeVerifyType getBridgeVerifyType();

    /**
     * 获取比较类型
     *
     * @return 比较类型
     */
    @Nullable
    protected abstract BridgeType getBridgeType();

    public VerifyResult onVerify() {
        mBridgeVerifyType = getBridgeVerifyType();
        mBridgeType = getBridgeType();
        if (mBridgeVerifyType == null || mBridgeType == null) {
            return VerifyResult.fail("请设置正确校验类型");
        }
        if (ArrayUtils.isEmpty(mSourceItems) || ArrayUtils.isEmpty(mTargetItems)) {
            return VerifyResult.fail("请设置正确的数据");
        }
        return onBridgeVerify(mSourceItems, mTargetItems);
    }

    public void setBridgeType(BridgeType bridgeType) {
        mBridgeType = bridgeType;
    }

    /**
     * 表单组联合校验
     *
     * @param sourceItems 源目标
     * @param targetItems 比较对象目标
     * @return 校验结果
     */
    protected abstract VerifyResult onBridgeVerify(List<BaseFormItem> sourceItems, List<BaseFormItem> targetItems);

}
