package com.shaonian.dynamic.form.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.shaonian.dynamic.form.R;
import com.shaonian.dynamic.form.bean.DictBean;
import com.shaonian.dynamic.form.formitem.SelectFormItem;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

/**
 * 弹窗选择View
 *
 * @author wk
 * @date 2021/05/11
 */

public class SelectFormView extends BaseFormView<SelectFormItem> {

    private TextView mSelectView;
    private final List<DictBean> mDictBeans = new ArrayList<>();

    public SelectFormView(Context context) {
        super(context);
    }

    public SelectFormView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SelectFormView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected View getValueView(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.form_view_select, this, false);
    }

    @Override
    protected void initAttrs(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.SelectFormView);
        isRequired = array.getBoolean(R.styleable.SelectFormView_is_required, true);
        isViewOnly = array.getBoolean(R.styleable.SelectFormView_is_view_only, false);
        mTitle = array.getString(R.styleable.SelectFormView_item_title);
        mFormViewValue = array.getString(R.styleable.SelectFormView_form_value);
        array.recycle();
    }

    @Override
    protected void initView() {
        mSelectView = mContainerLayout.findViewById(R.id.tv_select);
        mRequireView.setVisibility(isRequired ? VISIBLE : GONE);
        mTitleView.setText(mTitle);
        if (!isViewOnly) {
            mSelectView.setOnClickListener(this::onSelect);
        } else {
            mSelectView.setOnClickListener(null);
        }
        mSelectView.setText(mFormViewValue);
    }

    /**
     * 弹窗展示选择
     */
    private void onSelect(View view) {
        //TODO 弹窗选择
    }

    @Override
    public void setDifferenceAttribute(SelectFormItem formItem) {
        mDictBeans.clear();
        mDictBeans.addAll(formItem.getDictBeanList());
    }

    @Override
    protected Object getValue() {
        return mFormViewValue;
    }

    @Override
    public void setFormViewValue(String value) {
        // TODO 递归找到对应的ID和value
        mSelectView.setText(value);
    }
}
