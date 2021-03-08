package com.shaonian.dynamic.form.verify;

import android.text.TextUtils;

/**
 * @author wk.
 * Date: 2020/12/25
 * 必填字段检验
 */
public class RequiredVerify extends BaseVerify {

    @Override
    public VerifyResult onVerify(boolean isRequired, String value) {
        VerifyResult result;
        if (isRequired && TextUtils.isEmpty(value)) {
            result = VerifyResult.fail("必填字段不能为空");
        } else {
            result = VerifyResult.success();
        }
        return result;
    }
}
