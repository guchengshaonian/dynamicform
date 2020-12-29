package com.shaonian.dynamic.form.verify;

import android.text.TextUtils;

/**
 * @author wk.
 * Date: 2020/12/25
 */
public class RequiredVerify extends BaseVerify {

    @Override
    public VerifyResult onVerify(String value) {
        VerifyResult result;
        if (TextUtils.isEmpty(value)) {
            result = new VerifyResult();
            result.setSuccess(false);
            result.setMessage("必填字段不能为空");
        } else {
            result = VerifyResult.success();
        }
        return result;
    }
}
