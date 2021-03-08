package com.shaonian.dynamic.form.verify;

/**
 * @author wk.
 * Date: 2020/12/25
 * 校验基础类
 */
public abstract class BaseVerify {
    /**
     * 校验，返回结果
     *
     * @param isRequired 是否是必填项
     * @param value      检查目标
     * @return 校验结果
     */
    public abstract VerifyResult onVerify(boolean isRequired, String value);
}
