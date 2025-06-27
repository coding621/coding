package com.morpheus.coding.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.morpheus.coding.project.domain.vo.project.log.ProjectLogVO;
import com.morpheus.coding.project.domain.ProjectLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
public interface ProjectLogMapper extends BaseMapper<ProjectLog> {

    List<ProjectLogVO> queryLogList(@Param("projectId") String projectId);
    List<ProjectLogVO> queryAllLog(@Param("taskId") String taskId);
    List<ProjectLogVO> queryCommentLog(@Param("taskId") String taskId);
    List<ProjectLogVO> queryDeliverableLog(@Param("taskId") String taskId);
    List<ProjectLogVO> queryTrendsLog(@Param("taskId") String taskId);
}
