package com.morpheus.coding.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.morpheus.coding.project.domain.vo.project.ProjectVO;
import com.morpheus.coding.project.domain.ProjectCollection;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
public interface ProjectCollectionService extends IService<ProjectCollection> {

    /**
     * 收藏项目
     * @param projectVO
     * @return
     */
    int collectProject(ProjectVO projectVO);
    /**
     * 取消收藏项目
     * @param projectVO
     * @return
     */
    int cancelCollectProject(ProjectVO projectVO);

}
