package com.morpheus.coding.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.morpheus.coding.project.domain.vo.project.ProjectVO;
import com.morpheus.coding.project.domain.ProjectMember;
import com.morpheus.coding.project.domain.vo.project.member.ProjectMemberReqVO;
import com.morpheus.coding.project.domain.vo.project.member.ProjectMemberResVO;

import java.util.List;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
public interface ProjectMemberService extends IService<ProjectMember> {
    /**
     * 批量添加成员
     */
    void inviteMemberList(ProjectVO projectVO);
    /**
     * 批量移除成员
     */
    void removeMemberList(ProjectVO projectVO);

    PageInfo<ProjectMemberResVO> searchMember(ProjectMemberReqVO projectMemberReqVO);
    /**
     * 后面拆分微服务需要将该方法移出去
     * @param keyword
     * @return
     */
    List<ProjectMemberResVO> queryUserList(String projectId, String keyword);

    List<ProjectMemberResVO> queryUserListById(String projectId);
}
