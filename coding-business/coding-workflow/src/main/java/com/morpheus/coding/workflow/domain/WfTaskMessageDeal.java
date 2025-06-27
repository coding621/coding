package com.morpheus.coding.workflow.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
@Data
@TableName("coding_task_message_deal")
public class WfTaskMessageDeal {
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    private String taskId;
    private String instanceId;
    private String assignee;
}
