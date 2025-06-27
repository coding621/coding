package com.morpheus.coding.footstone.core.core.domain.dto;

import java.io.Serializable;
import java.util.Map;

/**
 * @author morpheus
 * @description ProjectProcessDTO
 * @date 2025年6月27日21:38:59
 */
public class ProjectProcessDTO implements Serializable {
    private String projectId;
    private String procDefId;
    private String url;
    private Map<String, Object> variables;

    // 构造函数
    public ProjectProcessDTO(String projectId, String procDefId, String url, Map<String, Object> variables) {
        this.projectId = projectId;
        this.procDefId = procDefId;
        this.url = url;
        this.variables = variables;
    }

    // Getters 和 Setters
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProcDefId() {
        return procDefId;
    }

    public void setProcDefId(String procDefId) {
        this.procDefId = procDefId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }
}
