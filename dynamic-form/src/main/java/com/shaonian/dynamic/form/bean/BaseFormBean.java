package com.shaonian.dynamic.form.bean;

import java.util.List;

/**
 * @author wk.
 * Date: 2020/12/25
 * 用于解析生成的formbean类
 */
public class BaseFormBean {

    private String fromId;
    private String formDefaultValue;
    private String formType;
    private String dict;
    private String verify;
    private String bridge;
    private String bridgeVerify;
    private boolean isRequired;
    private boolean isViewOnly;
    private List<TriggerBean> triggerList;

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getFormDefaultValue() {
        return formDefaultValue;
    }

    public void setFormDefaultValue(String formDefaultValue) {
        this.formDefaultValue = formDefaultValue;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getDict() {
        return dict;
    }

    public void setDict(String dict) {
        this.dict = dict;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public String getBridge() {
        return bridge;
    }

    public void setBridge(String bridge) {
        this.bridge = bridge;
    }

    public String getBridgeVerify() {
        return bridgeVerify;
    }

    public void setBridgeVerify(String bridgeVerify) {
        this.bridgeVerify = bridgeVerify;
    }

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

    public List<TriggerBean> getTriggerList() {
        return triggerList;
    }

    public void setTriggerList(List<TriggerBean> triggerList) {
        this.triggerList = triggerList;
    }

    @Override
    public String toString() {
        return "BaseFormBean{" +
                "fromId='" + fromId + '\'' +
                ", formDefaultValue='" + formDefaultValue + '\'' +
                ", formType='" + formType + '\'' +
                ", dict='" + dict + '\'' +
                ", verify='" + verify + '\'' +
                ", bridge='" + bridge + '\'' +
                ", bridgeVerify='" + bridgeVerify + '\'' +
                ", isRequired=" + isRequired +
                ", isViewOnly=" + isViewOnly +
                ", triggerList=" + triggerList +
                '}';
    }
}