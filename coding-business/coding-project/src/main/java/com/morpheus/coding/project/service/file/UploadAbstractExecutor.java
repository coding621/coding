package com.morpheus.coding.project.service.file;

import com.morpheus.coding.footstone.core.core.domain.model.LoginUser;
import com.morpheus.coding.project.domain.vo.project.file.FileVO;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
public abstract class UploadAbstractExecutor {
    public abstract FileVO upload(LoginUser user, MultipartFile file, String id) throws Exception;
}
