package com.morpheus.coding.workflow.domain.dto;

import com.morpheus.coding.footstone.core.core.domain.entity.SysRole;
import com.morpheus.coding.footstone.core.core.domain.entity.SysUser;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 动态人员、组
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
@Data
public class WfNextDto implements Serializable {

    private String type;

    private String vars;

    private List<SysUser> userList;

    private List<SysRole> roleList;
}
