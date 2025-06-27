package com.morpheus.coding.workflow.domain.bo;

import com.morpheus.coding.footstone.core.core.validate.AddGroup;
import com.morpheus.coding.footstone.core.core.validate.EditGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 流程设计业务对象
 *
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
@Data
public class WfDesignerBo {

    /**
     * 流程名称
     */
    @NotNull(message = "流程名称", groups = { AddGroup.class, EditGroup.class })
    private String name;

    /**
     * 流程分类
     */
    @NotBlank(message = "流程分类", groups = { AddGroup.class, EditGroup.class })
    private String category;

    /**
     * XML字符串
     */
    @NotBlank(message = "XML字符串", groups = { AddGroup.class, EditGroup.class })
    private String xml;
}
