package com.morpheus.coding.project.service.task;

import com.alibaba.fastjson2.JSON;
import com.morpheus.coding.api.system.UserFeignService;
import com.morpheus.coding.api.system.domain.dto.SysUserDTO;
import com.morpheus.coding.footstone.core.constant.SecurityConstants;
import com.morpheus.coding.footstone.core.core.domain.R;
import com.morpheus.coding.footstone.core.core.domain.vo.SysUserVO;
import com.morpheus.coding.footstone.core.enums.LogTypeEnum;
import com.morpheus.coding.footstone.core.exception.ServiceException;
import com.morpheus.coding.project.domain.vo.project.log.LogContentVO;
import com.morpheus.coding.project.domain.vo.project.log.ProjectLogVO;
import com.morpheus.coding.project.mapper.ProjectLogMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
@Service("queryTrendsLogExecutor")
public class QueryTrendsLogExecutor extends QueryLogAbstractExecutor {
    @Autowired
    private ProjectLogMapper projectLogMapper;
    @Resource
    private UserFeignService userFeignService;

    @Override
    public List<ProjectLogVO> query(String taskId) {
        List<ProjectLogVO> list = projectLogMapper.queryTrendsLog(taskId);
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        // 拿到userids
        List<Long> userIds = list.stream().map(ProjectLogVO::getUserId)
                .distinct()
                .collect(Collectors.toList());
        SysUserDTO sysUserDTO = new SysUserDTO();
        sysUserDTO.setUserIds(userIds);
        R<List<SysUserVO>> userResult = userFeignService.listOfInner(sysUserDTO, SecurityConstants.INNER);

        if (Objects.isNull(userResult) || CollectionUtils.isEmpty(userResult.getData())) {
            throw new ServiceException("远程调用查询用户列表：" + userIds + " 失败");
        }
        List<SysUserVO> userVOList = userResult.getData();

        // 匹配设置值
        Map<Long, SysUserVO> userMap = userVOList.stream().collect(Collectors.toMap(SysUserVO::getUserId, a -> a));
        list.forEach(projectLogVO -> {
            List<LogContentVO> contentVOList = JSON.parseArray(projectLogVO.getContent().toString(), LogContentVO.class);
            projectLogVO.setContent(contentVOList);
            projectLogVO.setLogTypeName(LogTypeEnum.getStatusNameByStatus(projectLogVO.getLogType()));

            // 设置用户信息
            SysUserVO sysUserVO = userMap.get(projectLogVO.getUserId());
            if (Objects.nonNull(sysUserVO)) {
                projectLogVO.setUserName(sysUserVO.getUserName());
                projectLogVO.setNickName(sysUserVO.getNickName());
                projectLogVO.setAvatar(sysUserVO.getAvatar());
            }
        });
        return list;
    }
}
