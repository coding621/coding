package com.morpheus.coding.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.morpheus.coding.project.domain.vo.project.ProjectVO;
import com.morpheus.coding.project.domain.vo.project.log.LogVO;
import com.morpheus.coding.project.domain.vo.project.log.ProjectLogVO;
import com.morpheus.coding.project.domain.ProjectLog;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
public interface ProjectLogService extends IService<ProjectLog> {
    void run(LogVO logVO);

    PageInfo<ProjectLogVO> list(ProjectVO projectVO);
}
