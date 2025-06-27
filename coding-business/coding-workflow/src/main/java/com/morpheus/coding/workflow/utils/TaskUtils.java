package com.morpheus.coding.workflow.utils;

import cn.hutool.core.util.ObjectUtil;
import com.morpheus.coding.footstone.core.core.domain.model.LoginUser;
import com.morpheus.coding.footstone.security.utils.SecurityUtils;
import com.morpheus.coding.workflow.common.constant.TaskConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * 工作流任务工具类
 *
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
public class TaskUtils {

    public static String getUserId() {
        return String.valueOf(SecurityUtils.getUserId());
    }

    /**
     * 获取用户组信息
     *
     * @return candidateGroup
     */
    public static List<String> getCandidateGroup() {
        List<String> list = new ArrayList<>();
        LoginUser user = SecurityUtils.getLoginUser();
        if (ObjectUtil.isNotNull(user)) {
            if (ObjectUtil.isNotEmpty(user.getUser().getRoles())) {
                user.getUser().getRoles().forEach(role -> list.add(TaskConstants.ROLE_GROUP_PREFIX + role.getRoleId()));
            }
            if (ObjectUtil.isNotNull(user.getDeptId())) {
                list.add(TaskConstants.DEPT_GROUP_PREFIX + user.getDeptId());
            }
        }
        return list;
    }

    // TODO: 2024.04.25 注释oa模块 
//    public static String createSsoUrl(String taskId){
//        return SsoUrlUtils.ssoCreate(appid,agentid, host+path+"/coding-project/my-task/info?taskId="+ taskId);
//    }
}
