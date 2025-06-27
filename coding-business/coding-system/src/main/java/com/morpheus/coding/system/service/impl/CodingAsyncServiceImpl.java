package com.morpheus.coding.system.service.impl;


import cn.hutool.core.util.ObjectUtil;
import cn.hutool.log.LogFactory;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.morpheus.coding.footstone.core.utils.file.FileUtils;
import com.morpheus.coding.system.domain.CodingAsync;
import com.morpheus.coding.system.mapper.CodingAsyncMapper;
import com.morpheus.coding.system.service.ICodingAsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

@Service
public class CodingAsyncServiceImpl implements ICodingAsyncService {

    @Autowired
    CodingAsyncMapper CodingAsyncMapper;

    /**
     * 创建异步任务记录
     *
     * @param asyncName 异步任务名
     * @param asyncType 异步任务类型
     * @param createBy  创建者
     */
    @Override
    public CodingAsync addAsyncJob(String asyncName, String asyncType, String createBy) {
        CodingAsync CodingAsync = new CodingAsync(asyncName,asyncType,createBy);
        CodingAsyncMapper.insert(CodingAsync);
        return CodingAsync;
    }

    /**
     * 更新任务状态
     *
     * @param CodingAsync 任务信息
     */
    @Override
    public void updateAsyncJob(CodingAsync CodingAsync) {
        CodingAsync.setUpdateTime(new Date());
        CodingAsyncMapper.updateById(CodingAsync);
    }

    /**
     * 查询异步任务信息
     *
     * @param CodingAsync
     * @return {@link List}<{@link CodingAsync}>
     */
    @Override
    public List<CodingAsync> list(CodingAsync CodingAsync) {
        CodingAsync.setAsyncLog(null);
        QueryWrapper<CodingAsync> queryWrapper = new QueryWrapper<>();
        // 如果 asyncName 字段不为空，则添加模糊查询条件
        if (CodingAsync.getAsyncName() != null && !CodingAsync.getAsyncName().isEmpty()) {
            // 添加模糊查询条件
            queryWrapper.like("async_name", "%"+ CodingAsync.getAsyncName()+"%");
        }
        if (CodingAsync.getAsyncType() != null && !CodingAsync.getAsyncType().isEmpty()) {
            // 添加精确查询条件
            queryWrapper.eq("async_type", CodingAsync.getAsyncType());
        }
        if (CodingAsync.getAsyncStatus() != null) {
            // 添加精确查询条件
            queryWrapper.eq("async_status", CodingAsync.getAsyncStatus());
        }
        if (CodingAsync.getCreateBy() != null && !CodingAsync.getCreateBy().isEmpty()) {
            // 添加精确查询条件
            queryWrapper.eq("create_by", CodingAsync.getCreateBy());
        }
        if (CodingAsync.getId() != null && !CodingAsync.getId().isEmpty()) {
            // 添加精确查询条件
            queryWrapper.eq("id", CodingAsync.getId());
        }
        queryWrapper.orderByDesc("update_time"); // 添加根据 updateTime 字段的倒序排序
        // 查询所有记录
        return CodingAsyncMapper.selectList(queryWrapper);
    }

    /**
     * 查询单条异步任务信息
     *
     * @param id id
     * @return {@link List}<{@link CodingAsync}>
     */
    @Override
    public CodingAsync load(String id) {
        CodingAsync CodingAsync = new CodingAsync();
        CodingAsync.setId(id);
        List<CodingAsync> CodingAsyncs = list(CodingAsync);
        if (!CodingAsyncs.isEmpty()){
            return CodingAsyncs.get(0);
        }else {
            return null;
        }
    }


    /**
     * 删除
     * @param ids ids
     */
    @Transactional
    @Override
    public void delete(String[] ids) {
        for (String id:ids){
            CodingAsync CodingAsync = new CodingAsync();
            CodingAsync.setId(id);
            delete(CodingAsync);
        }
    }

    /**
     * 下载附件
     *
     * @param id       任务id
     * @param response Http
     */
    @Override
    public void downloadFile(String id, String user, HttpServletResponse response) {
        CodingAsync CodingAsync = load(id);
        if (CodingAsync ==null){
            throw new RuntimeException("不存在的任务");
        }else if (CodingAsync.getFile()==null|| CodingAsync.getFile().isEmpty()){
            throw new RuntimeException("不存在的附件");
        }else if (!CodingAsync.getCreateBy().equals(user)){
            throw new RuntimeException("非法操作");
        }else {
            // 单文件下载
            try {
                FileUtils.setAttachmentResponseHeader(response, CodingAsync.getFile());
                FileUtils.writeBytes(CodingAsync.getFile(), response);
            } catch (UnsupportedEncodingException e) {
                LogFactory.get().error(e);
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void delete(CodingAsync CodingAsync) {
        CodingAsync = CodingAsyncMapper.selectById(CodingAsync.getId());

        if (CodingAsync ==null){
            return;
        }

        if (CodingAsync.getAsyncStatus()==0){
            throw new RuntimeException("任务进行中禁止删除");
        }

        // 文件路径
        String filePath = CodingAsync.getFile();
        if (ObjectUtil.isNotEmpty(filePath)){
            // 删除文件
            boolean result = new File(filePath).delete();

            if (result) {
                LogFactory.get().info("任务["+ CodingAsync.getId()+"]文件已被成功删除");
            } else {
                LogFactory.get().warn("任务["+ CodingAsync.getId()+"]文件删除失败，可能文件不存在或无法删除");
            }
        }
        CodingAsyncMapper.deleteById(CodingAsync);
    }

}
