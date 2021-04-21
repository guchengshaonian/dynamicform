package com.shaonian.dynamic.form.bean;

import java.util.List;

/**
 * 字典类
 *
 * @author wk
 * @date 2021/04/21
 */

public class DictBean {

    private String name;
    private String value;
    private List<DictBean> subDict;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<DictBean> getSubDict() {
        return subDict;
    }

    public void setSubDict(List<DictBean> subDict) {
        this.subDict = subDict;
    }

    public DictBean(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
