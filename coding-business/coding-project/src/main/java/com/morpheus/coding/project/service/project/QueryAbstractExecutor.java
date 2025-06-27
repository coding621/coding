package com.morpheus.coding.project.service.project;

import com.morpheus.coding.project.domain.vo.project.ProjectReqVO;
import com.morpheus.coding.project.domain.vo.project.ProjectResVO;

import java.util.List;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
public abstract class QueryAbstractExecutor {
    public abstract List<ProjectResVO> query(ProjectReqVO projectReqVO);
}
