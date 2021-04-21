package com.shaonian.dynamic.form.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shaonian.dynamic.form.R;
import com.shaonian.dynamic.form.formitem.BaseFormItem;
import com.shaonian.dynamic.form.verify.BaseVerify;

import androidx.annotation.Nullable;

/**
 * @author wk.
 * Date: 2020/12/25
 * 表单的自定义View基类，根据布局的不同而变化
 */
public abstract class BaseFormView<T extends BaseFormItem> extends LinearLayout {

    protected T mBaseFormItem;
    protected TextView mTitleView;
    protected ImageView mRequireView;
    protected boolean isRequired;
    protected boolean isViewOnly;
    protected String mTitle;
    protected int mVerify;
    protected BaseVerify mBaseVerify;
    protected FrameLayout mContainerLayout;

    public BaseFormView(Context context) {
        super(context);
        init(context);
    }

    public BaseFormView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public BaseFormView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context) {
        init(context, null);
    }

    private void init(Context context, AttributeSet attrs) {
        View root = LayoutInflater.from(context).inflate(R.layout.form_view_base, this, false);
        addView(root);
        mTitleView = root.findViewById(R.id.tv_title);
        mRequireView = root.findViewById(R.id.iv_required);
        mContainerLayout = root.findViewById(R.id.fl_container);
        mContainerLayout.addView(getValueView(context));
        if (attrs != null) {
            initAttrs(context, attrs);
        }
        initView();
    }

    /**
     * 根据不同的表单项展示不同的view
     *
     * @param context 上下文
     * @return 子view
     */
    protected abstract View getValueView(Context context);

    /**
     * 初始化自定属性
     *
     * @param context 上下文
     * @param attrs   属性
     */
    protected abstract void initAttrs(Context context, AttributeSet attrs);

    /**
     * 初始化View
     */
    protected abstract void initView();

    /**
     * 根据item绘制布局
     *
     * @param baseFormItem 对应的formItem
     */
    public abstract void setFormItem(T baseFormItem);

    /**
     * 布局的设置值
     *
     * @return 值
     */
    protected abstract Object getValue();

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean required) {
        isRequired = required;
    }

    public boolean isViewOnly() {
        return isViewOnly;
    }

    public void setViewOnly(boolean viewOnly) {
        isViewOnly = viewOnly;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public int getVerify() {
        return mVerify;
    }

    public void setVerify(int verify) {
        mVerify = verify;
    }

    public BaseVerify getBaseVerify() {
        return mBaseVerify;
    }

    public void setBaseVerify(BaseVerify baseVerify) {
        mBaseVerify = baseVerify;
    }

    public T getBaseFormItem() {
        return mBaseFormItem;
    }
}