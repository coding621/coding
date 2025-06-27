package com.morpheus.coding.footstone.core.core.domain.vo;


import com.morpheus.coding.footstone.core.core.domain.entity.SysUser;
import com.morpheus.coding.footstone.core.annotation.Excel;

/**
 * 用户对象 sys_user
 *
 * @author morpheus
 */
public class SysUserVO extends SysUser {

    /**
     * 是否绑定企微
     */
    @Excel(name = "企微状态")
    private String userWxNameState;

    public String getUserWxNameState() {
        return userWxNameState;
    }

    public void setUserWxNameState(String userWxNameState) {
        this.userWxNameState = userWxNameState;
    }
}
