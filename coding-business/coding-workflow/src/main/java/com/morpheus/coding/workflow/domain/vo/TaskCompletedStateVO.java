package com.morpheus.coding.workflow.domain.vo;

import com.morpheus.coding.workflow.enums.TaskCompletedStateEnum;

/**
 * 任务状态
 * @author morpheus
 */
public class TaskCompletedStateVO {

    /**
     * 处理结果类型
     * */
    String taskType;

    /**
     * 处理结果类型desc
     * */
    String taskTypeDesc;

    /**
     * 任务处理意见
     * */
    String taskMessage;

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskTypeDesc() {
        return TaskCompletedStateEnum.getTaskCompletedStateEnum(Integer.parseInt(taskType)).toString();
    }

    public void setTaskTypeDesc(String taskTypeDesc) {
        this.taskTypeDesc = taskTypeDesc;
    }

    public String getTaskMessage() {
        return taskMessage;
    }

    public void setTaskMessage(String taskMessage) {
        this.taskMessage = taskMessage;
    }
}
