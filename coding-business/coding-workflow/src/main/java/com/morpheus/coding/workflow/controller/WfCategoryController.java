package com.morpheus.coding.workflow.controller;

import com.morpheus.coding.footstone.core.annotation.Log;
import com.morpheus.coding.footstone.core.annotation.RepeatSubmit;
import com.morpheus.coding.footstone.core.constant.UserConstants;
import com.morpheus.coding.footstone.core.core.controller.BaseController;
import com.morpheus.coding.footstone.core.core.domain.PageQuery;
import com.morpheus.coding.footstone.core.core.domain.R;
import com.morpheus.coding.footstone.core.core.page.Table2DataInfo;
import com.morpheus.coding.footstone.core.core.validate.AddGroup;
import com.morpheus.coding.footstone.core.core.validate.EditGroup;
import com.morpheus.coding.footstone.core.core.validate.QueryGroup;
import com.morpheus.coding.footstone.core.enums.BusinessType;
import com.morpheus.coding.footstone.core.utils.poi.ExcelUtil;
import com.morpheus.coding.footstone.security.annotation.RequiresPermissions;
import com.morpheus.coding.workflow.domain.bo.WfCategoryBo;
import com.morpheus.coding.workflow.domain.vo.WfCategoryVo;
import com.morpheus.coding.workflow.service.IWfCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

/**
 * 流程分类Controller
 *
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/workflow/category")
public class WfCategoryController extends BaseController {

    private final IWfCategoryService categoryService;

    /**
     * 查询流程分类列表
     */
    @RequiresPermissions("workflow:category:list")
    @GetMapping("/list")
    public Table2DataInfo<WfCategoryVo> list(@Validated(QueryGroup.class) WfCategoryBo bo, PageQuery pageQuery) {
        return categoryService.queryPageList(bo, pageQuery);
    }

    /**
     * 查询全部的流程分类列表
     */
    @RequiresPermissions("workflow:category:listAll")
    @GetMapping("/listAll")
    public R<List<WfCategoryVo>> listAll(@Validated(QueryGroup.class) WfCategoryBo bo) {
        return R.ok(categoryService.queryList(bo));
    }

    /**
     * 导出流程分类列表
     */
    @RequiresPermissions("workflow:category:export")
    @Log(title = "流程分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(@Validated WfCategoryBo bo, HttpServletResponse response) {
        List<WfCategoryVo> list = categoryService.queryList(bo);
        ExcelUtil.exportExcel2(list, "流程分类", WfCategoryVo.class, response);
    }

    /**
     * 获取流程分类详细信息
     * @param categoryId 分类主键
     */
    @RequiresPermissions("workflow:category:query")
    @GetMapping("/{categoryId}")
    public R<WfCategoryVo> getInfo(@NotNull(message = "主键不能为空") @PathVariable("categoryId") Long categoryId) {
        return R.ok(categoryService.queryById(categoryId));
    }

    /**
     * 新增流程分类
     */
    @RequiresPermissions("workflow:category:add")
    @Log(title = "流程分类", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody WfCategoryBo categoryBo) {
        if (UserConstants.NOT_UNIQUE.equals(categoryService.checkCategoryCodeUnique(categoryBo.getCode()))) {
            return R.fail("新增流程分类'" + categoryBo.getCategoryName() + "'失败，流程编码已存在");
        }
        return toAjax2(categoryService.insertCategory(categoryBo));
    }

    /**
     * 修改流程分类
     */
    @RequiresPermissions("workflow:category:edit")
    @Log(title = "流程分类", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody WfCategoryBo categoryBo) {
        if (UserConstants.NOT_UNIQUE.equals(categoryService.checkCategoryCodeUnique(categoryBo.getCode()))) {
            return R.fail("修改流程分类'" + categoryBo.getCategoryName() + "'失败，流程编码已存在");
        }
        return toAjax2(categoryService.updateCategory(categoryBo));
    }

    /**
     * 删除流程分类
     * @param categoryIds 分类主键串
     */
    @RequiresPermissions("orkflow:category:remove")
    @Log(title = "流程分类" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{categoryIds}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空") @PathVariable Long[] categoryIds) {
        return toAjax2(categoryService.deleteWithValidByIds(Arrays.asList(categoryIds), true));
    }
}
