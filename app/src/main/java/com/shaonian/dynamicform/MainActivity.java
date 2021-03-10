package com.shaonian.dynamicform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.shaonian.dynamic.form.formitem.EditTextFormItem;

/**
 * @author wk.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        EditTextFormItem editTextFormItem = new EditTextFormItem("a", "b", "123");
        Log.i("abdcf", editTextFormItem.getFormValue());
        TestBean testBean = new TestBean();
        EditTextFormItem textFormItem = new EditTextFormItem("b", "index", testBean);
        Log.i("abdcf", textFormItem.getFormValue());
        EditTextFormItem textFormItem2 = new EditTextFormItem("c", "value", testBean);
        Log.i("abdcf", textFormItem2.getFormValue());
    }
}