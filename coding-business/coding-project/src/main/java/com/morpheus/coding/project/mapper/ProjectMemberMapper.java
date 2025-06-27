package com.morpheus.coding.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.morpheus.coding.project.domain.ProjectMember;
import com.morpheus.coding.project.domain.vo.project.member.ProjectMemberReqVO;
import com.morpheus.coding.project.domain.vo.project.member.ProjectMemberResVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
public interface ProjectMemberMapper extends BaseMapper<ProjectMember> {

    List<ProjectMemberResVO> searchMember(@Param("data") ProjectMemberReqVO projectMemberReqVO);

    List<ProjectMemberResVO> queryExecutorList(@Param("projectId") String projectId);
    List<ProjectMemberResVO> queryTaskUserList(@Param("taskId") String taskId);
}
