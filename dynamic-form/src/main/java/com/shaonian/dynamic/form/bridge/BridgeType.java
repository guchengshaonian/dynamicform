package com.shaonian.dynamic.form.bridge;

/**
 * 连接比较参数的类型
 * 数字比较，时间比较，定值比较,文本类型，自定义比较
 *
 * @author wk
 * @date 2021/05/21
 */
public enum BridgeType {
    /**
     * 数字类型
     */
    NUMBER,
    /**
     * 时间类型
     */
    DATE,
    /**
     * 固定值类型
     */
    FIXED_VALUE,
    /**
     * 文本类型
     */
    TEXT,
    /**
     * 自定义类型
     */
    CUSTOM,
}