package com.morpheus.coding.project.domain.vo.project.log;


/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */

public class LogContentVO {
    /**
     * 文件id
     */
    private String field;
    /**
     * 文件名
     */
    private String fieldName;
    /**
     * 旧值
     */
    private String oldValue;
    /**
     * 新值
     */
    private String newValue;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }
}
