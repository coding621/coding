package com.morpheus.coding.project.controller;

import com.morpheus.coding.footstone.core.core.domain.AjaxResult;
import com.morpheus.coding.footstone.security.annotation.RequiresPermissions;
import com.morpheus.coding.project.domain.vo.project.ProjectVO;
import com.morpheus.coding.project.service.ProjectCollectionService;
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
@RequestMapping("/project")
public class ProjectCollectionController {

    @Autowired
    private ProjectCollectionService projectCollectionService;

    /**
     * 收藏项目
     * @param projectVO
     * @return
     */
    @RequiresPermissions("project:manage:collect")
    @PostMapping("/collect")
    public AjaxResult collectProject(@RequestBody ProjectVO projectVO) {

        return AjaxResult.success(projectCollectionService.collectProject(projectVO));
    }

    /**
     * 取消收藏项目
     * @param projectVO
     * @return
     */
    @RequiresPermissions("project:manage:cancelCollect")
    @PostMapping("/cancelCollect")
    public AjaxResult cancelCollectProject(@RequestBody ProjectVO projectVO) {

        return AjaxResult.success(projectCollectionService.cancelCollectProject(projectVO));
    }
}
