package com.morpheus.coding.workflow.domain.vo;

import lombok.Data;

/**
 * 部署实例和表单关联视图对象
 *
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
@Data
public class WfDeployFormVo {

    private static final long serialVersionUID = 1L;

    /**
     * 流程部署主键
     */
    private String deployId;

    /**
     * 表单Key
     */
    private String formKey;

    /**
     * 节点Key
     */
    private String nodeKey;

    /**
     * 表单名称
     */
    private String formName;

    /**
     * 节点名称
     */
    private String nodeName;

    /**
     * 表单内容
     */
    private String content;
}
