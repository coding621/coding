package com.morpheus.coding.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.morpheus.coding.project.domain.ProjectFile;
import com.morpheus.coding.project.domain.vo.project.file.ProjectFileIdsVO;
import com.morpheus.coding.project.domain.vo.project.file.ProjectFileReqVO;
import com.morpheus.coding.project.domain.vo.project.file.ProjectFileResVO;

import java.io.IOException;
import java.util.List;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
public interface ProjectFileService extends IService<ProjectFile> {

    PageInfo<ProjectFileResVO> queryFileList(ProjectFileReqVO projectFileReqVO);

    void deleteFileList(ProjectFileIdsVO projectFileIdsVO);

    void rename(ProjectFileReqVO projectFileReqVO);

    void batchDownload(String totalZip, List<String> paths) throws IOException;
}
