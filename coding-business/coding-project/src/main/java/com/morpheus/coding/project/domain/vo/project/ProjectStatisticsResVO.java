package com.morpheus.coding.project.domain.vo.project;

import com.morpheus.coding.project.domain.vo.project.task.TaskStatisticsVO;

import java.util.List;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
public class ProjectStatisticsResVO {
    /**
     * 项目数
     */
    private Long projectNum;
    /**
     * 任务数
     */
    private Long taskNum;
    /**
     * 今日任务数
     */
    private Long todayTaskNum;
    /**
     * 逾期任务数
     */
    private Long overdueTaskNum;
    /**
     * 项目排行
     */
    private List<ProjectRankVO> projectRankVOList;
    /**
     * 任务统计
     */
    private List<TaskStatisticsVO> taskStatisticsVOList;

    public Long getProjectNum() {
        return projectNum;
    }

    public void setProjectNum(Long projectNum) {
        this.projectNum = projectNum;
    }

    public Long getTaskNum() {
        return taskNum;
    }

    public void setTaskNum(Long taskNum) {
        this.taskNum = taskNum;
    }

    public Long getTodayTaskNum() {
        return todayTaskNum;
    }

    public void setTodayTaskNum(Long todayTaskNum) {
        this.todayTaskNum = todayTaskNum;
    }

    public Long getOverdueTaskNum() {
        return overdueTaskNum;
    }

    public void setOverdueTaskNum(Long overdueTaskNum) {
        this.overdueTaskNum = overdueTaskNum;
    }

    public List<ProjectRankVO> getProjectRankVOList() {
        return projectRankVOList;
    }

    public void setProjectRankVOList(List<ProjectRankVO> projectRankVOList) {
        this.projectRankVOList = projectRankVOList;
    }

    public List<TaskStatisticsVO> getTaskStatisticsVOList() {
        return taskStatisticsVOList;
    }

    public void setTaskStatisticsVOList(List<TaskStatisticsVO> taskStatisticsVOList) {
        this.taskStatisticsVOList = taskStatisticsVOList;
    }
}
