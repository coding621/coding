package com.morpheus.coding.project.domain.vo.project.file;

import java.util.List;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
public class ProjectFileIdsVO {
    /**
     * 项目id
     */
    private String projectId;
    /**
     * 下载内容
     */
    private List<FileVO> fileVOList;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public List<FileVO> getFileVOList() {
        return fileVOList;
    }

    public void setFileVOList(List<FileVO> fileVOList) {
        this.fileVOList = fileVOList;
    }
}
