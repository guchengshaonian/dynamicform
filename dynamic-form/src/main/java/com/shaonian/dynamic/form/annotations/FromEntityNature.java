package com.shaonian.dynamic.form.annotations;

import com.shaonian.dynamic.form.bridge.BaseBridge;
import com.shaonian.dynamic.form.verify.BaseVerify;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

/**
 * 表单的属性配置，直接配置在JavaBean中，根据属性完成各式属性配置
 * <p>
 * 类型，展示方式，校验，关联校验，默认值，字典值，触发事件的值和对象
 *
 * @author wk
 * @date 2021/05/14
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FromEntityNature {
    /**
     * 表单唯一ID
     *
     * @return 唯一ID
     */
    String formId() default "";

    /**
     * 校验方式
     *
     * @return 校验方式
     */
    Class<? extends BaseVerify> verify() default BaseVerify.class;

    /**
     * 关联校验
     *
     * @return 关联校验方式
     */
    Class<? extends BaseBridge> bridgeVerify() default BaseBridge.class;

    /**
     * 关联校验的表单ID组
     *
     * @return ID组
     */
    String[] bridgeName() default {};

    /**
     * 默认值
     *
     * @return 默认值
     */
    String defaultValue() default "";

    /**
     * 是否必填
     *
     * @return 是否必填
     */
    boolean isRequired() default false;

    /**
     * 是否仅展示
     *
     * @return 是否仅展示
     */
    boolean isViewOnly() default false;

    /**
     * 字典值所属
     *
     * @return 字典值
     */
    String dict() default "";

    /**
     * 触发事件的值，样例：["true: sfss，aaa"]//冒号前为值，冒号后为影响的对应字段，可以多个，用”，”区分
     * @return 值
     */
    String[] triggerValue() default {};
}