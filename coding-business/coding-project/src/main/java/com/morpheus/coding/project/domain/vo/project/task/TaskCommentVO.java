package com.morpheus.coding.project.domain.vo.project.task;


import java.util.List;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
public class TaskCommentVO {
    /**
     * 项目id
     */
    private String projectId;
    /**
     * 任务id
     */
    private String taskId;
    /**
     * 评论
     */
    private String comment;
    /**
     * 用户id
     */
    private List<Long> userIdList;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Long> getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(List<Long> userIdList) {
        this.userIdList = userIdList;
    }
}
