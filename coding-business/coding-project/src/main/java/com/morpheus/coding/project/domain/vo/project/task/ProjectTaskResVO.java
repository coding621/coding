package com.morpheus.coding.project.domain.vo.project.task;

import com.morpheus.coding.project.domain.vo.project.ProjectRankVO;

import java.util.List;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
public class ProjectTaskResVO {
    /**
     * 项目排行
     */
    private List<ProjectRankVO> projectRankList;
    /**
     * 任务统计
     */
    private List<TaskStatisticsVO> taskStatisticsList;

    public List<ProjectRankVO> getProjectRankList() {
        return projectRankList;
    }

    public void setProjectRankList(List<ProjectRankVO> projectRankList) {
        this.projectRankList = projectRankList;
    }

    public List<TaskStatisticsVO> getTaskStatisticsList() {
        return taskStatisticsList;
    }

    public void setTaskStatisticsList(List<TaskStatisticsVO> taskStatisticsList) {
        this.taskStatisticsList = taskStatisticsList;
    }
}
