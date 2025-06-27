package com.morpheus.coding.footstone.notice.domain.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
@Data
public class MessageDataDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String msgCode;
    private Long msgTime;
    private String wxUserName;
}
