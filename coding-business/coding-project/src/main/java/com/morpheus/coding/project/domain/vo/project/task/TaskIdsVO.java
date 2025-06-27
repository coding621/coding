package com.morpheus.coding.project.domain.vo.project.task;


import java.util.List;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
public class TaskIdsVO {
    /**
     * 任务id
     */
    private List<String> taskIdList;

    public List<String> getTaskIdList() {
        return taskIdList;
    }

    public void setTaskIdList(List<String> taskIdList) {
        this.taskIdList = taskIdList;
    }
}
