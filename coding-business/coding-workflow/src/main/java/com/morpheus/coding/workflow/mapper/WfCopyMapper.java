package com.morpheus.coding.workflow.mapper;

import com.morpheus.coding.footstone.core.core.domain.entity.SysDept;
import com.morpheus.coding.footstone.core.core.domain.entity.SysRole;
import com.morpheus.coding.footstone.core.core.domain.entity.SysUser;
import com.morpheus.coding.footstone.core.mapper.BaseMapperPlus;
import com.morpheus.coding.workflow.domain.WfCopy;
import com.morpheus.coding.workflow.domain.vo.WfCopyVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 流程抄送Mapper接口
 *
 * @author morpheus
 * @date 2022-05-19
 */
@Mapper
public interface WfCopyMapper extends BaseMapperPlus<WfCopyMapper, WfCopy, WfCopyVo> {

    SysUser selectUserById(@Param("userId") Long userId);
    SysRole selectRoleById(@Param("roleId") Long roleId);
    SysDept selectDeptById(@Param("deptId") Long deptId);
    List<Long> selectUserIdsByRoleId(@Param("roleId") Long roleId);
    List<Long> selectUserIds(@Param("deptIds") List<String> deptIds);

}
