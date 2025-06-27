package com.morpheus.coding.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * OAuth2 client
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
@Data
@TableName("coding_oauth2_client")
public class CodingOAuth2Client {

    String id;

    /**
     * 客户端名称
     */
    String clientName;

    /**
     * 客户端id
     */
    String clientId;

    /**
     * 客户端授权Secret
     */
    String clientSecret;

    /**
     * 客户端图标
     */
    String img;

}
