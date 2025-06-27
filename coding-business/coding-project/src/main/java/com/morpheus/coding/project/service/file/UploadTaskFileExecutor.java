package com.morpheus.coding.project.service.file;

import com.morpheus.coding.footstone.core.config.CodingConfig;
import com.morpheus.coding.footstone.core.core.domain.model.LoginUser;
import com.morpheus.coding.footstone.core.enums.LogTypeEnum;
import com.morpheus.coding.footstone.core.enums.ProjectStatusEnum;
import com.morpheus.coding.footstone.core.utils.file.FileUploadUtils;
import com.morpheus.coding.footstone.core.utils.file.MimeTypeUtils;
import com.morpheus.coding.footstone.security.utils.SecurityUtils;
import com.morpheus.coding.project.domain.ProjectFile;
import com.morpheus.coding.project.domain.vo.project.file.FileVO;
import com.morpheus.coding.project.domain.vo.project.log.LogVO;
import com.morpheus.coding.project.mapper.ProjectFileMapper;
import com.morpheus.coding.project.mapper.ProjectTaskMapper;
import com.morpheus.coding.project.service.ProjectLogService;
import com.morpheus.coding.project.utils.ProjectFileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
@Service("uploadTaskFileExecutor")
@Slf4j
public class UploadTaskFileExecutor extends UploadAbstractExecutor {

    @Autowired
    private ProjectTaskMapper projectTaskMapper;
    @Autowired
    private ProjectFileMapper projectFileMapper;
    @Autowired
    private ProjectLogService projectLogService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public FileVO upload(LoginUser user, MultipartFile file, String id) throws Exception {
        log.info("任务文件上传的任务id:{}", id);
        String taskPath = ProjectFileUtil.uploadTaskFile(CodingConfig.getTaskPath(), file, MimeTypeUtils.DEFAULT_ALLOWED_EXTENSION);
        String pn = ProjectFileUtil.getPathName(CodingConfig.getTaskPath(), file);
        String projectId = projectTaskMapper.selectById(id).getProjectId();
        ProjectFile projectFile = new ProjectFile();
        projectFile.setFileSize(new BigDecimal(String.valueOf(file.getSize())).divide(new BigDecimal("1024"), 2, RoundingMode.HALF_UP));
        projectFile.setFileName(file.getOriginalFilename());
        projectFile.setFileUrl(taskPath);
        projectFile.setUserId(user.getUserId());
        projectFile.setCreatedBy(user.getUsername());
        projectFile.setCreatedTime(new Date());
        projectFile.setUpdatedBy(user.getUsername());
        projectFile.setUpdatedTime(new Date());
        projectFile.setType(ProjectStatusEnum.TASK.getStatusName());
        projectFile.setPtId(id);
        projectFile.setExtension(FileUploadUtils.getExtension(file));
        projectFile.setProjectId(projectId);
        projectFile.setPathName(pn);
        projectFileMapper.insert(projectFile);
        // 添加日志
        LogVO logVO = new LogVO();
        logVO.setLogType(LogTypeEnum.DELIVERABLE.getStatus());
        logVO.setOperateType("uploadTaskFile");
        logVO.setType(ProjectStatusEnum.TASK.getStatusName());
        logVO.setPtId(id);
        logVO.setUserId(SecurityUtils.getUserId());
        logVO.setProjectId(projectId);
        logVO.setContent(taskPath);
        logVO.setCreatedBy(SecurityUtils.getUsername());
        logVO.setCreatedTime(new Date());
        logVO.setUpdatedBy(SecurityUtils.getUsername());
        logVO.setUpdatedTime(new Date());
        projectLogService.run(logVO);
        FileVO fileVO = new FileVO();
        fileVO.setProjectFileId(projectFile.getId());
        fileVO.setFileName(file.getOriginalFilename());
        fileVO.setFileUrl(taskPath);
        return fileVO;
    }
}
