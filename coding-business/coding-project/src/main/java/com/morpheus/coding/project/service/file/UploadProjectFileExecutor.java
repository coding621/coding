package com.morpheus.coding.project.service.file;

import com.morpheus.coding.footstone.core.config.CodingConfig;
import com.morpheus.coding.footstone.core.core.domain.model.LoginUser;
import com.morpheus.coding.footstone.core.enums.LogTypeEnum;
import com.morpheus.coding.footstone.core.enums.ProjectStatusEnum;
import com.morpheus.coding.footstone.core.utils.file.MimeTypeUtils;
import com.morpheus.coding.footstone.security.utils.SecurityUtils;
import com.morpheus.coding.footstone.core.utils.file.FileUploadUtils;
import com.morpheus.coding.project.domain.ProjectFile;
import com.morpheus.coding.project.domain.vo.project.file.FileVO;
import com.morpheus.coding.project.domain.vo.project.log.LogVO;
import com.morpheus.coding.project.mapper.ProjectFileMapper;
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
@Service("uploadProjectFileExecutor")
@Slf4j
public class UploadProjectFileExecutor extends UploadAbstractExecutor {
    @Autowired
    private ProjectLogService projectLogService;
    @Autowired
    private ProjectFileMapper projectFileMapper;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public FileVO upload(LoginUser user, MultipartFile file, String id) throws Exception {
        log.info("项目文件上传的项目id:{}", id);
        String filePath = ProjectFileUtil.uploadProjectFile(CodingConfig.getProjectPath(), file, MimeTypeUtils.DEFAULT_ALLOWED_EXTENSION);
        String pathName = ProjectFileUtil.getPathName(CodingConfig.getProjectPath(), file);
        ProjectFile projectFile = new ProjectFile();
        projectFile.setProjectId(id);
        projectFile.setFileSize(new BigDecimal(String.valueOf(file.getSize())).divide(new BigDecimal("1024"), 2, RoundingMode.HALF_UP));
        projectFile.setFileName(file.getOriginalFilename());
        projectFile.setFileUrl(filePath);
        projectFile.setUserId(user.getUserId());
        projectFile.setCreatedBy(user.getUsername());
        projectFile.setCreatedTime(new Date());
        projectFile.setUpdatedBy(user.getUsername());
        projectFile.setUpdatedTime(new Date());
        projectFile.setType(ProjectStatusEnum.PROJECT.getStatusName());
        projectFile.setPtId(id);
        projectFile.setExtension(FileUploadUtils.getExtension(file));
        projectFile.setPathName(pathName);
        projectFileMapper.insert(projectFile);
        // 添加日志
        LogVO logVO = new LogVO();
        logVO.setLogType(LogTypeEnum.DELIVERABLE.getStatus());
        logVO.setOperateType("uploadProjectFile");
        logVO.setType(ProjectStatusEnum.PROJECT.getStatusName());
        logVO.setPtId(id);
        logVO.setProjectId(id);
        logVO.setUserId(SecurityUtils.getUserId());
        logVO.setContent(filePath);
        logVO.setCreatedBy(SecurityUtils.getUsername());
        logVO.setCreatedTime(new Date());
        logVO.setUpdatedBy(SecurityUtils.getUsername());
        logVO.setUpdatedTime(new Date());
        projectLogService.run(logVO);
        FileVO fileVO = new FileVO();
        fileVO.setProjectFileId(projectFile.getId());
        fileVO.setFileName(file.getOriginalFilename());
        fileVO.setFileUrl(filePath);
        return fileVO;
    }
}
