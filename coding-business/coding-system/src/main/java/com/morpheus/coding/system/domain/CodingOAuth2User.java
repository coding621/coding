package com.morpheus.coding.system.domain;

import lombok.Data;

/**
 * OAuth2 拿到的用户信息
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
@Data
public class CodingOAuth2User {

    public CodingOAuth2User(){
        this.locale = "zh_CN";
    }

    /**
     * 用户的唯一标识符
     */
    String sub;

    /**
     * 用户的全名
     */
    String name;

    /**
     * 用户的名
     */
    String given_name;

    /**
     * 用户的姓
     */
    String family_name;

    /**
     * 用户的首选用户名
     */
    String preferred_username;

    /**
     * 用户的电子邮箱地址
     */
    String email;

    /**
     * 用户的头像图片的URL
     */
    String avatar;

    /**
     * 用户的头像图片的URL
     */
    String picture;

    /**
     * 用户的区域设置或语言偏好
     */
    String locale;

    /**
     * 用户资料最后更新的时间戳
     */
    String updated_at;

}
