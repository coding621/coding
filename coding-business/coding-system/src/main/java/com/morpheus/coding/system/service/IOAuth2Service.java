package com.morpheus.coding.system.service;

import com.morpheus.coding.system.domain.CodingOAuth2Client;
import com.morpheus.coding.system.domain.CodingOAuth2User;

/**
 * OAuth2 服务器
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
public interface IOAuth2Service {

    /**
     * 是否已被用户授权登录
     * @param userId 用户id
     * @param clientId 客户端id
     * @return {@link Boolean} 是否已授权
     */
    Boolean isAgree (Long userId,String clientId);


    /**
     * 允许授权登录
     * @param userId 用户id
     * @param clientId 客户端id
     */
    void agree (Long userId,String clientId);

    /**
     * 创建用于授权的用户code
     * @param userId 用户id
     * @return {@link String}
     */
    String createCode(Long userId);

    /**
     * 创建用于授权的用户token
     * @param code 用户code
     * @return {@link String}
     */
    String createToken(String code);


    /**
     * 更加token获取用户信息
     * @param token token
     * @return {@link CodingOAuth2User}
     */
    public CodingOAuth2User getUser(String token);


    /**
     * 获取客户端logo
     * @param clientId clientId
     * @return {@link CodingOAuth2User}
     */
    public CodingOAuth2Client getClientInfo(String clientId);


    /**
     * 验证客户端的Secret
     *
     * @param clientId
     * @param clientSecret
     * @return {@link Boolean}
     */
    public Boolean checkClientSecret(String clientId,String clientSecret);

}
