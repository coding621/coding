package com.morpheus.coding.project.service.project;

import com.alibaba.fastjson2.JSON;
import com.morpheus.coding.footstone.security.utils.SecurityUtils;
import com.morpheus.coding.project.domain.vo.project.ProjectReqVO;
import com.morpheus.coding.project.domain.vo.project.ProjectResVO;
import com.morpheus.coding.project.mapper.ProjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
@Slf4j
@Service("queryMyCollectProjectExecutor")
public class QueryMyCollectProjectExecutor extends QueryAbstractExecutor {
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<ProjectResVO> query(ProjectReqVO projectReqVO) {
        log.info("查询我收藏的项目入参:{}", JSON.toJSONString(projectReqVO));
        return projectMapper.selectMyCollectProjectList(projectReqVO, SecurityUtils.getUserId());
    }
}
