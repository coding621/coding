package com.morpheus.coding.workflow.domain.bo;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 流程任务业务对象
 *
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
@Data
public class WfTaskBo {
    /**
     * 任务Id
     */
    private String taskId;
    /**
     * 任务名称
     */
    private String taskName;
    /**
     * 用户Id
     */
    private String userId;
    /**
     * 任务意见
     */
    private String comment;
    /**
     * 流程实例Id
     */
    private String procInsId;
    /**
     * 节点
     */
    private String targetKey;
    /**
     * 流程变量信息
     */
    private Map<String, Object> variables;
    /**
     * 审批人
     */
    private String assignee;
    /**
     * 候选人
     */
    private List<String> candidateUsers;
    /**
     * 审批组
     */
    private List<String> candidateGroups;
    /**
     * 抄送用户Id
     */
    private String copyUserIds;
    /**
     * 下一节点审批人
     */
    private String nextUserIds;
}
