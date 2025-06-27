package com.morpheus.coding.system.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.morpheus.coding.footstone.core.config.redis.RedisService;
import com.morpheus.coding.footstone.core.core.domain.entity.SysUser;
import com.morpheus.coding.system.domain.CodingOAuth2Agree;
import com.morpheus.coding.system.domain.CodingOAuth2Client;
import com.morpheus.coding.system.domain.CodingOAuth2User;
import com.morpheus.coding.system.mapper.CodingOAuth2AgreeMapper;
import com.morpheus.coding.system.mapper.CodingOAuth2ClientMapper;
import com.morpheus.coding.system.service.IOAuth2Service;
import com.morpheus.coding.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class OAuth2ServiceImpl implements IOAuth2Service {

    @Autowired
    private CodingOAuth2AgreeMapper CodingOAuth2AgreeMapper;

    @Autowired
    private CodingOAuth2ClientMapper CodingOAuth2ClientMapper;

    @Autowired
    private RedisService redisService;

    @Autowired
    private ISysUserService iSysUserService;

    /**
     * redis中code作为key的前缀
     */
    private static final String CODE_TITLE = "auth2_code:";

    /**
     * redis中token作为key的前缀
     */
    private static final String TOKEN_TITLE = "auth2_token:";


    /**
     * 是否已被用户授权登录
     *
     * @param userId   用户id
     * @param clientId 客户端id
     * @return {@link Boolean}
     */
    @Override
    public Boolean isAgree(Long userId, String clientId) {

        QueryWrapper<CodingOAuth2Agree> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.eq("client_id", clientId);

        // 数据库中如果有这个授权就返回true
        long count = CodingOAuth2AgreeMapper.selectCount(queryWrapper);
        return count > 0;
    }

    /**
     * 允许授权登录
     *
     * @param userId   用户id
     * @param clientId 客户端id
     */
    @Override
    public void agree(Long userId, String clientId) {
        if (ObjectUtil.isNotEmpty(clientId)){
            CodingOAuth2Agree CodingOAuth2Agree = new CodingOAuth2Agree();
            CodingOAuth2Agree.setId(IdUtil.fastUUID());

            CodingOAuth2Agree.setClientId(clientId);
            CodingOAuth2Agree.setUserId(userId);

            CodingOAuth2AgreeMapper.insert(CodingOAuth2Agree);
        }else {
            throw new RuntimeException("ClientID can not null!");
        }
    }

    /**
     * 创建用于授权的用户code
     *
     * @param userId 用户id
     * @return {@link String}
     */
    @Override
    public String createCode(Long userId) {
        String code = IdUtil.simpleUUID();
        // 授权码1分钟过期
        redisService.setCacheObject(CODE_TITLE+code,userId,1, TimeUnit.MINUTES);
        return code;
    }

    /**
     * 创建用于授权的用户token
     *
     * @param code 用户code
     * @return {@link String}
     */
    @Override
    public String createToken(String code) {
        Long userId = redisService.getCacheObject(CODE_TITLE+code);
        // 清除code
        redisService.deleteObject(CODE_TITLE+code);
        if (ObjectUtil.isNotEmpty(userId)){
            String token = IdUtil.randomUUID();
            // token 15分钟过期
            redisService.setCacheObject(TOKEN_TITLE+token,userId,15, TimeUnit.MINUTES);
            return token;
        }else {
            return null;
        }
    }

    /**
     * 更加token获取用户信息
     * @param token token
     * @return {@link CodingOAuth2User}
     */
    @Override
    public CodingOAuth2User getUser(String token){
        Long userId = redisService.getCacheObject(TOKEN_TITLE+token);
        if (ObjectUtil.isNotEmpty(userId)){
            SysUser sysUser = iSysUserService.selectUserById(userId);
            CodingOAuth2User CodingOAuth2User = new CodingOAuth2User();
            CodingOAuth2User.setSub(sysUser.getUserName());
            CodingOAuth2User.setName(sysUser.getNickName());
            CodingOAuth2User.setPreferred_username(sysUser.getUserName());
            CodingOAuth2User.setEmail(sysUser.getEmail());
            CodingOAuth2User.setUpdated_at(sysUser.getCreateTime().toString());
            return CodingOAuth2User;
        }else {
            return null;
        }
    }

    /**
     * 获取客户端logo
     *
     * @param clientId clientId
     * @return {@link CodingOAuth2User}
     */
    @Override
    public CodingOAuth2Client getClientInfo(String clientId) {

        QueryWrapper<CodingOAuth2Client> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("client_id", clientId);
        CodingOAuth2Client CodingOAuth2Client =  CodingOAuth2ClientMapper.selectOne(queryWrapper);
        if (ObjectUtil.isNotEmpty(CodingOAuth2Client)){
            CodingOAuth2Client.setClientSecret(null);
        }
        return CodingOAuth2Client;
    }

    /**
     * 验证客户端的Secret
     *
     * @param clientId
     * @param clientSecret
     * @return {@link Boolean}
     */
    @Override
    public Boolean checkClientSecret(String clientId, String clientSecret) {

        QueryWrapper<CodingOAuth2Client> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("client_id", clientId);
        return CodingOAuth2ClientMapper.selectOne(queryWrapper).getClientSecret().equals(clientSecret);

    }
}
