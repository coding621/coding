package com.morpheus.coding.workflow.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.morpheus.coding.footstone.core.core.domain.entity.WfTaskProcess;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
@Mapper
public interface WfTaskProcessMapper extends BaseMapper<WfTaskProcess> {
    Integer selectStatusByTaskId(@Param("taskId") String taskId);
    Integer selectStatusByTaskId2(@Param("taskId") String taskId);
    int updateTaskStatus(@Param("taskId") String taskId);
    int updateTaskStatus2(@Param("taskId") String taskId);
    int updateTaskStatus3(@Param("taskId") String taskId);
    int updateProcessState(@Param("dataId") String dataId);
    int updateProcessState2(@Param("dataId") String dataId);
    int updateProviderStatus(@Param("providerId") String providerId);
    String selectLinkRecordsId(@Param("materialId") String materialId);

}
