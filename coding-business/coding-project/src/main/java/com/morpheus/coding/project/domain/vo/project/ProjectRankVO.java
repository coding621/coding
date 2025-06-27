package com.morpheus.coding.project.domain.vo.project;

import java.math.BigDecimal;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
public class ProjectRankVO extends ProjectVO {
    /**
     * 进度
     */
    private BigDecimal process;
    /**
     * 账号
     */
    private String userName;
    /**
     * 昵称
     */
    private String nickName;

    public BigDecimal getProcess() {
        return process;
    }

    public void setProcess(BigDecimal process) {
        this.process = process;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
