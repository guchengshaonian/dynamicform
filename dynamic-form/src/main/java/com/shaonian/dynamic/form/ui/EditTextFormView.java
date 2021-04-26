package com.shaonian.dynamic.form.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.shaonian.dynamic.form.R;
import com.shaonian.dynamic.form.formitem.EditTextFormItem;

import androidx.annotation.Nullable;

/**
 * @author wk.
 * Date: 2021/3/10
 * Time: 22:38
 * 文本框View
 */
public class EditTextFormView extends BaseFormView<EditTextFormItem> implements TextWatcher {

    private String mHintText;
    private EditText mInputText;

    public EditTextFormView(Context context) {
        super(context);
    }

    public EditTextFormView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EditTextFormView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected View getValueView(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.form_view_edit_view, this, false);
    }

    @Override
    protected void initAttrs(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.EditTextFormView);
        isRequired = array.getBoolean(R.styleable.EditTextFormView_is_required, true);
        isViewOnly = array.getBoolean(R.styleable.EditTextFormView_is_view_only, false);
        mTitle = array.getString(R.styleable.EditTextFormView_item_title);
        mHintText = array.getString(R.styleable.EditTextFormView_title_hint);
        mVerify = array.getInt(R.styleable.EditTextFormView_verify, 5);
        mFormViewValue = array.getString(R.styleable.EditTextFormView_text_content);
        array.recycle();
    }

    @Override
    protected void initView() {
        mInputText = mContainerLayout.findViewById(R.id.et_input);
        mRequireView.setVisibility(isRequired ? VISIBLE : GONE);
        mInputText.setText(mFormViewValue);
        mInputText.setHint(mHintText);
        mInputText.setEnabled(isViewOnly);
        if (!TextUtils.isEmpty(mBaseFormItem.getDigits())) {
            mInputText.setKeyListener(DigitsKeyListener.getInstance(mBaseFormItem.getDigits()));
        }
        mInputText.addTextChangedListener(this);
    }

    @Override
    public void setFormItem(EditTextFormItem formItem) {
        mBaseFormItem = formItem;
        isRequired = formItem.isRequired();
        isViewOnly = formItem.isReadOnly();
        mTitle = formItem.getTitle();
        mBaseVerify = formItem.getVerify();
        mHintText = formItem.getHintText();
        mFormViewValue = formItem.getFormValue();
        initView();
    }

    @Override
    protected Object getValue() {
        return mInputText.getText().toString();
    }

    @Override
    public void setFormViewValue(String value) {
        mInputText.setText(value);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (mBaseFormItem != null) {
            mBaseFormItem.setValue(s.toString());
        }
    }
}
