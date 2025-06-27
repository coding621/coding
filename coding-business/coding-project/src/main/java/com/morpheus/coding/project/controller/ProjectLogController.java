package com.morpheus.coding.project.controller;

import com.morpheus.coding.footstone.core.core.domain.AjaxResult;
import com.morpheus.coding.footstone.security.annotation.RequiresPermissions;
import com.morpheus.coding.project.domain.vo.project.ProjectVO;
import com.morpheus.coding.project.service.ProjectLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */

@RestController
@RequestMapping("/project/log")
public class ProjectLogController {

    @Autowired
    private ProjectLogService projectLogService;

    /**
     * 项目动态
     * @param projectVO
     * @return
     */
    @PostMapping("/list")
    @RequiresPermissions("project:log:list")
    public AjaxResult list(@RequestBody ProjectVO projectVO) {
        return AjaxResult.success(projectLogService.list(projectVO));
    }

}
