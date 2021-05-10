package com.shaonian.dynamic.form.bean;

/**
 * 给adaper记录选择的bean
 *
 * @author wk
 * @date 2021/05/10
 */

public class AdapterChooseBean<T> {
    private boolean isChoose;
    private T bean;

    public boolean isChoose() {
        return isChoose;
    }

    public void setChoose(boolean choose) {
        isChoose = choose;
    }

    public T getBean() {
        return bean;
    }

    public void setBean(T bean) {
        this.bean = bean;
    }

    public AdapterChooseBean(T bean) {
        this.bean = bean;
    }
}
