package com.morpheus.coding.project.service.file;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */

public enum UploadTypeEnum {

    PROJECT("project", "uploadProjectFileExecutor"),
    TASK("task", "uploadTaskFileExecutor"),
    COVER("cover", "uploadCoverFileExecutor"),
    TEMPLATE("template", "uploadTemplateFileExecutor");
    private final String type;
    private final String beanName;
    UploadTypeEnum(String type, String beanName) {
        this.type = type;
        this.beanName = beanName;
    }

    public String getType() {
        return type;
    }

    public String getBeanName() {
        return beanName;
    }
}
