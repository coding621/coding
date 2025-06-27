package com.morpheus.coding.system.controller;

import com.morpheus.coding.footstone.core.config.CodingConfig;
import com.morpheus.coding.footstone.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页
 *
 * @author morpheus
 */
@RestController("/system/dashboard")
public class SysIndexController {
    /**
     * 系统基础配置
     */
    @Autowired
    private CodingConfig CodingConfig;

    /**
     * 访问首页，提示语
     */
    @RequestMapping("/")
    public String index() {
        return StringUtils.format("欢迎使用 coding，当前版本：v{}，请通过前端地址访问。", CodingConfig.getName(), CodingConfig.getVersion());
    }
}
