package com.shaonian.dynamic.form.bridge;

/**
 * 连接比较类型的枚举类
 *
 * @author wk
 * @date 2021/05/21
 */

public enum BridgeVerifyType {
    /**
     * 相等或者相加相等
     */
    EQUALS("相等"),
    /**
     * 大于或者相加大于
     */
    GREATER_THAN("大于"),
    /**
     * 大于等于或者相加大于等于
     */
    EQUALS_OR_GREATER_THAN("大于等于"),
    /**
     * 小于或相加小于
     */
    LESS_THAN("小于"),
    /**
     * 小于等于或者相加小于等于
     */
    EQUALS_OR_LESS_THAN("小于等于"),
    /**
     * 在特殊值的情况下，不能选择部分选项
     */
    SPECIAL_VALUE("在%s情况下不能选择%s"),
    /**
     * 自定义校验
     */
    CUSTOM("%s");

    private final String mTitle;

    /**
     * 构造函数
     *
     * @param title 内容描述
     */
    BridgeVerifyType(String title) {
        this.mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }
}
