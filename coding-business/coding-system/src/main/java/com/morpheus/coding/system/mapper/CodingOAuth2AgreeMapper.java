package com.morpheus.coding.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.morpheus.coding.system.domain.CodingOAuth2Agree;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户授权登录 数据层
 *
 * @author morpheus
 */
@Mapper
public interface CodingOAuth2AgreeMapper extends BaseMapper<CodingOAuth2Agree> {

}
