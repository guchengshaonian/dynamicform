package com.shaonian.dynamic.form.bean;

import java.util.List;

/**
 * 表单项特定值的关联事件
 *
 * @author wk
 * @date 2021/05/21
 */

public class TriggerBean {

    private String triggerValue;
    private List<String> formIds;

    public String getTriggerValue() {
        return triggerValue;
    }

    public void setTriggerValue(String triggerValue) {
        this.triggerValue = triggerValue;
    }

    public List<String> getFormIds() {
        return formIds;
    }

    public void setFormIds(List<String> formIds) {
        this.formIds = formIds;
    }

    @Override
    public String toString() {
        return "TriggerBean{" +
                "triggerValue='" + triggerValue + '\'' +
                ", formIds=" + formIds +
                '}';
    }
}
