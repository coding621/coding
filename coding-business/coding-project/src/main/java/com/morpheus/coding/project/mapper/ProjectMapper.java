package com.morpheus.coding.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.morpheus.coding.project.domain.vo.project.ProjectReqVO;
import com.morpheus.coding.project.domain.vo.project.ProjectResVO;
import com.morpheus.coding.project.domain.vo.project.ProjectVO;
import com.morpheus.coding.project.domain.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
public interface ProjectMapper extends BaseMapper<Project> {

    List<ProjectVO> queryMyProjectList(@Param("userId") Long userId);

    List<ProjectResVO> recycleProjectList();
    ProjectResVO detail(@Param("projectId") String projectId);

    List<ProjectResVO> selectMyProjectList(@Param("data") ProjectReqVO projectReqVO, @Param("userId") Long userId);
    List<ProjectResVO> selectMyCollectProjectList(@Param("data") ProjectReqVO projectReqVO, @Param("userId") Long userId);
}
