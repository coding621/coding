package com.morpheus.coding.gateway.service;


import com.morpheus.coding.footstone.core.core.domain.AjaxResult;
import com.morpheus.coding.footstone.core.exception.user.CaptchaException;

import java.io.IOException;

/**
 * 验证码处理
 *
 * @author morpheus
 */
public interface ValidateCodeService
{
    /**
     * 生成验证码
     */
    public AjaxResult createCaptcha() throws IOException, CaptchaException;

    /**
     * 校验验证码
     */
    public void checkCaptcha(String key, String value) throws CaptchaException;
}
