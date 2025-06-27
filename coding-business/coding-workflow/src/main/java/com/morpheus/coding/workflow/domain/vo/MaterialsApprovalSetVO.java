package com.morpheus.coding.workflow.domain.vo;

import lombok.Data;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
@Data
public class MaterialsApprovalSetVO {

    private String type;
    private String approved;
    private String definitionId;
    private String deploymentId;
}
