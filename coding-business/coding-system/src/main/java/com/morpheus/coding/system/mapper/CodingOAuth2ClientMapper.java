package com.morpheus.coding.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.morpheus.coding.system.domain.CodingOAuth2Client;
import org.apache.ibatis.annotations.Mapper;

/**
 * OAuth2客户端 数据层
 *
 * @author morpheus
 */
@Mapper
public interface CodingOAuth2ClientMapper extends BaseMapper<CodingOAuth2Client> {

}
