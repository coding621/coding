package com.morpheus.coding.api.workflow;

import com.morpheus.coding.api.workflow.factory.ProcessFeignFallbackFactory;
import com.morpheus.coding.footstone.core.constant.SecurityConstants;
import com.morpheus.coding.footstone.core.constant.ServiceNameConstants;
import com.morpheus.coding.footstone.core.core.domain.R;
import com.morpheus.coding.footstone.core.core.domain.dto.ProjectProcessDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author morpheus
 * @description 流程设计服务
 * @date 2025年6月27日21:38:59
 */
@FeignClient(contextId = "processFeignService", value = ServiceNameConstants.WORKFLOW_SERVICE, fallbackFactory = ProcessFeignFallbackFactory.class)
public interface ProcessFeignService {

    /**
     * 启动项目发布流程实例
     * @return
     */
    @PostMapping("/workflow/process/startProjectProcess")
    R<Integer> startProjectProcess(@RequestBody ProjectProcessDTO request, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    /**
     * 根据流程定义id启动流程实例
     *
     * @param request 流程定义
     */
    @PostMapping("/workflow/startTaskProcessByDefId")
    R<Void> startTaskProcessByDefId(@RequestBody ProjectProcessDTO request,@RequestHeader(SecurityConstants.FROM_SOURCE) String source);
}
