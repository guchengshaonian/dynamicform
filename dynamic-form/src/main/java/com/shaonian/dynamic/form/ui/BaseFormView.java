package com.shaonian.dynamic.form.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.shaonian.dynamic.form.formitem.BaseFormItem;

import androidx.annotation.Nullable;

/**
 * @author wk.
 * Date: 2020/12/25
 * 表单的自定义View基类，根据布局的不同而变化
 */
public abstract class BaseFormView<T extends BaseFormItem> extends View {

    protected T mBaseFormItem;

    public BaseFormView(Context context) {
        super(context);
    }

    public BaseFormView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseFormView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 设置item
     *
     * @param baseFormItem item
     */
    protected void setBaseFormItem(T baseFormItem) {
        this.mBaseFormItem = baseFormItem;
        setViewData();
    }

    /**
     * 根据item绘制布局
     */
    protected abstract void setViewData();

    /**
     * 布局的设置值
     *
     * @return 值
     */
    protected abstract String getValue();

}