package com.morpheus.coding.system.service;

import com.morpheus.coding.system.domain.CodingAsync;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 异步任务管理 服务层
 *
 * @author morpheus
 */
public interface ICodingAsyncService {

    /**
     * 创建异步任务记录
     *
     * @param asyncName 异步任务名
     * @param asyncType 异步任务类型
     * @param createBy  创建者
     * @return id
     */
    CodingAsync addAsyncJob(String asyncName, String asyncType, String createBy);

    /**
     * 更新任务状态
     * @param CodingAsync 任务信息
     */
    void updateAsyncJob(CodingAsync CodingAsync);


    /**
     * 查询异步任务信息
     * @param CodingAsync
     * @return {@link List}<{@link CodingAsync}>
     */
    List<CodingAsync> list(CodingAsync CodingAsync);

    /**
     * 查询单条异步任务信息
     * @param id id
     * @return {@link List}<{@link CodingAsync}>
     */
    CodingAsync load(String id);

    /**
     * 删除
     * @param ids ids
     */
    void delete(String[] ids);



    void downloadFile(String id, String user, HttpServletResponse response);
}
