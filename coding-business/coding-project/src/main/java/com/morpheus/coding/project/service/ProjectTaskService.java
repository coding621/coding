package com.morpheus.coding.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.morpheus.coding.project.domain.ProjectTaskProcess;
import com.morpheus.coding.project.domain.vo.project.ProjectVO;
import com.morpheus.coding.project.domain.vo.project.log.LogReqVO;
import com.morpheus.coding.project.domain.vo.project.log.ProjectLogVO;
import com.morpheus.coding.project.domain.Project;
import com.morpheus.coding.project.domain.ProjectTask;
import com.morpheus.coding.project.domain.vo.project.member.ProjectMemberResVO;
import com.morpheus.coding.project.domain.vo.project.task.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
public interface ProjectTaskService extends IService<ProjectTask> {
    /**
     * 今日任务数
     * @return
     */
    Long queryTodayTaskNum();

    /**
     * 逾期任务数
     * @return
     */
    Long queryOverdueTaskNum();

    /**
     * 任务状态统计
     * @return
     */
    List<TaskStatisticsVO> queryTaskStatisticsList();

    PageInfo<TaskResVO> queryMyTaskList(TaskReqVO taskReqVO);
    TaskStatusStatsVO queryTaskStatusStats(ProjectVO projectVO);

    void deleteTask(TaskIdsVO taskIdsVO);

    TaskResVO detail(TaskReqVO taskReqVO);

    List<ProjectMemberResVO> queryExecutorList(TaskReqVO taskReqVO);

    PageInfo<TaskResVO> list(TaskReqVO taskReqVO);

    String add(TaskReqVO taskReqVO);

    void edit(TaskReqVO taskReqVO);

    List<TaskResVO> queryChildTask(TaskReqVO taskReqVO);

    List<BurnDownChartVO> burnDownChart(ProjectVO projectVO);

    List<ProjectMemberResVO> queryUserList(ProjectTaskReqVO projectTaskReqVO);

    void addComment(TaskCommentVO taskCommentVO);


    List<ProjectLogVO> queryTaskLogList(LogReqVO logReqVO);

    void downloadTemplate(String taskId, HttpServletResponse response) throws IOException;

    List<TaskExportVO> exportAll();
    List<TaskExportVO> export(String taskIds);

    void importTask(List<TaskExcelVO> taskList);

    void downloadTaskTemplate(HttpServletResponse response) throws IOException;

    PageInfo<TaskResVO> taskList(TaskReqVO taskReqVO);

    Long countTaskNum();

    List<Project> queryProjectsStatus(List<String> projectIds);

    List<ProjectTaskProcess> taskProcessList(List<String> taskIds);

}
