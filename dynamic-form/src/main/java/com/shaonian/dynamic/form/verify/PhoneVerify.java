package com.shaonian.dynamic.form.verify;

import android.text.TextUtils;

import com.blankj.utilcode.util.RegexUtils;

/**
 * @author Adminis.
 * Date: 2021/3/8
 * Time: 22:31
 * 电话的校验
 */
public class PhoneVerify extends BaseVerify {

    @Override
    public VerifyResult onVerify(boolean isRequired, String value) {
        VerifyResult result;
        if (isRequired && TextUtils.isEmpty(value)) {
            result = VerifyResult.fail("必填字段不能为空");
        } else {
            boolean isTel = RegexUtils.isTel(value);
            boolean isPhone = RegexUtils.isMobileExact(value);
            if (isTel || isPhone) {
                result = VerifyResult.success();
            } else {
                result = VerifyResult.fail("不是正确的电话号码格式");
            }
        }
        return result;
    }
}
