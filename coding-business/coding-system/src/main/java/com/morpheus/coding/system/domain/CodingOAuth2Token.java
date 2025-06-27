package com.morpheus.coding.system.domain;

import lombok.Data;

/**
 * OAuth2 用于客户端请求接口的token
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
@Data
public class CodingOAuth2Token {

    public CodingOAuth2Token(){
        this.token_type = "bearer";
        this.scope = "profile";
    }

    /**
     * token
     */
    String access_token;

    /**
     * token 类型
     */
    String token_type;

    /**
     * token 可用的范围
     */
    String scope;


}
