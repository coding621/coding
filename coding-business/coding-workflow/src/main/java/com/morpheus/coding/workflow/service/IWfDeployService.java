package com.morpheus.coding.workflow.service;

import com.morpheus.coding.footstone.core.core.domain.PageQuery;
import com.morpheus.coding.footstone.core.core.page.Table2DataInfo;
import com.morpheus.coding.workflow.core.domain.ProcessQuery;
import com.morpheus.coding.workflow.domain.WfMaterialsScrappedProcess;
import com.morpheus.coding.footstone.core.core.domain.entity.WfTaskProcess;
import com.morpheus.coding.footstone.core.core.domain.dto.ApprovalSetDTO;
import com.morpheus.coding.workflow.domain.dto.MaterialsApprovalSetDTO;
import com.morpheus.coding.workflow.domain.vo.MaterialsApprovalSetVO;
import com.morpheus.coding.workflow.domain.vo.WfDeployVo;

import java.util.List;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
public interface IWfDeployService {

    Table2DataInfo<WfDeployVo> queryPageList(ProcessQuery processQuery, PageQuery pageQuery);

    Table2DataInfo<WfDeployVo> queryPublishList(String processKey, PageQuery pageQuery);

    void updateState(String definitionId, String stateCode);

    String queryBpmnXmlById(String definitionId);

    void deleteByIds(List<String> deployIds);

    void approvalSet(MaterialsApprovalSetDTO approvalSetDTO, String type);
    MaterialsApprovalSetVO queryApprovalSet(String type, String taskId);
    boolean updateApprovalSet(ApprovalSetDTO approvalSetDTO, String type);
    boolean updateApprovalSet2(ApprovalSetDTO approvalSetDTO, String type);
    boolean insertApprovalSet();
    WfTaskProcess insertWfTaskProcess(String extraId, String type, String approved, String definitionId, String deploymentId);
    boolean insertOrUpdateApprovalSet(String extraId, String type, String approved, String definitionId, String deploymentId);
    List<WfMaterialsScrappedProcess> insertScrappedProcess(List<String> ids, MaterialsApprovalSetVO materialsApprovalSetVO);
    List<WfTaskProcess> selectList(List<String> taskId);
    List<WfTaskProcess> selectWfTaskProcessList(List<String> extraId, String type);
    void updateProviderApproval(String providerId);
    List<WfMaterialsScrappedProcess> selectScrappedList(List<String> ids);
}
