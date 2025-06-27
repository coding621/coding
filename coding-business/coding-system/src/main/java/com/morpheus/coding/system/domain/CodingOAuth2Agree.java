package com.morpheus.coding.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * OAuth2 用户已统一登陆客户端
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
@Data
@TableName("coding_oauth2_agree")
public class CodingOAuth2Agree {

    String id;

    /**
     * 客户端名称
     */
    Long userId;

    /**
     * 客户端id
     */
    String clientId;

}
