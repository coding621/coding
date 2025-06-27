package com.morpheus.coding.project.service.task;

import com.morpheus.coding.project.domain.vo.project.log.ProjectLogVO;

import java.util.List;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
public abstract class QueryLogAbstractExecutor {

    public abstract List<ProjectLogVO> query(String taskId);
}
