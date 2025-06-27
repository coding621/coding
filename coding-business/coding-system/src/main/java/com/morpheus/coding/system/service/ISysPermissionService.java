package com.morpheus.coding.system.service;

import com.morpheus.coding.footstone.core.core.domain.entity.SysUser;

import java.util.Set;

/**
 * @author morpheus
 * @description 权限信息-服务层
 * @date 2025年6月27日21:38:59
 */
public interface ISysPermissionService {

    /**
     * 获取角色数据权限
     *
     * @param user 用户信息
     * @return 角色权限信息
     */
    Set<String> getRolePermission(SysUser user);


    /**
     * 获取菜单数据权限
     *
     * @param user 用户信息
     * @return 菜单权限信息
     */
    Set<String> getMenuPermission(SysUser user);

}
