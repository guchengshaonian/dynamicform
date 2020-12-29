package com.shaonian.dynamic.form.verify;

/**
 * @author wk.
 * Date: 2020/12/25
 */
public class VerifyResult {

    private String message;
    private boolean isSuccess;

    public static VerifyResult success() {
        return new VerifyResult("", true);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public VerifyResult() {
    }

    public VerifyResult(String message, boolean isSuccess) {
        this.message = message;
        this.isSuccess = isSuccess;
    }
}
