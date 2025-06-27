package com.morpheus.coding.workflow.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
@Getter
@AllArgsConstructor
public enum FormType {

    /**
     * 流程表单
     */
    PROCESS(0),

    /**
     * 外置表单
     */
    EXTERNAL(1),

    /**
     * 节点独立表单
     */
    INDEPENDENT(2);

    /**
     * 表单类型
     */
    private final Integer type;
}
