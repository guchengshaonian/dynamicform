package com.shaonian.dynamic.form.verify;

import android.text.TextUtils;

import com.blankj.utilcode.util.RegexUtils;

/**
 * @author Adminis.
 * Date: 2021/3/8
 * Time: 22:45
 * 身份证号码校验
 */
public class IdCardVerify extends BaseVerify {
    @Override
    public VerifyResult onVerify(boolean isRequired, String value) {
        VerifyResult result;
        if (isRequired && TextUtils.isEmpty(value)) {
            result = VerifyResult.fail("必填字段不能为空");
        } else {
            boolean isIdCard = RegexUtils.isIDCard18Exact(value);
            if (isIdCard) {
                result = VerifyResult.success();
            } else {
                result = VerifyResult.fail("身份证号码输入不正确");
            }
        }
        return result;
    }
}
