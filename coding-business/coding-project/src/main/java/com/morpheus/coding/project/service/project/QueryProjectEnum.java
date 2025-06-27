package com.morpheus.coding.project.service.project;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
public enum QueryProjectEnum {

    MY("my", "queryMyProjectExecutor"),
    COLLECT("collect", "queryMyCollectProjectExecutor"),
    RECYCLE("recycle", "queryRecycleProjectExecutor");
    private final String type;
    private final String beanName;

    QueryProjectEnum(String type, String beanName) {
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
