package com.morpheus.coding.project.service.file;

import com.morpheus.coding.footstone.core.config.CodingConfig;
import com.morpheus.coding.footstone.core.core.domain.model.LoginUser;
import com.morpheus.coding.footstone.core.exception.ServiceException;
import com.morpheus.coding.footstone.core.utils.file.MimeTypeUtils;
import com.morpheus.coding.project.domain.Project;
import com.morpheus.coding.project.domain.vo.project.file.FileVO;
import com.morpheus.coding.project.mapper.ProjectMapper;
import com.morpheus.coding.project.utils.ProjectFileUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
@Service("uploadCoverFileExecutor")
@Slf4j
public class UploadCoverFileExecutor extends UploadAbstractExecutor {
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public FileVO upload(LoginUser user, MultipartFile file, String id) throws Exception {
        log.info("封面上传的项目id:{}", id);
        String coverPath = ProjectFileUtil.uploadProjectFile(CodingConfig.getProjectCoverPath(), file, MimeTypeUtils.DEFAULT_ALLOWED_EXTENSION);
        if (StringUtils.isBlank(coverPath)) {
            throw new ServiceException("上传文件异常，请联系管理员");
        }
        Project project = projectMapper.selectById(id);
        project.setCover(coverPath);
        projectMapper.updateById(project);
        FileVO fileVO = new FileVO();
        fileVO.setFileUrl(coverPath);
        fileVO.setFileName(file.getOriginalFilename());
        return fileVO;
    }
}
