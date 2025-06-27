package com.morpheus.coding.workflow.domain.dto;

import lombok.Data;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
@Data
public class WfMetaInfoDto {

    /**
     * 创建者（username）
     */
    private String createUser;

    /**
     * 流程描述
     */
    private String description;
    /**
     * 表单类型
     */
    private Integer formType;
    /**
     * 表单编号
     */
    private Long formId;

}
