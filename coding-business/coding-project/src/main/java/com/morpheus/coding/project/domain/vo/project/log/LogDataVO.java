package com.morpheus.coding.project.domain.vo.project.log;

import java.util.List;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
public class LogDataVO {
    /**
     * 备注
     */
    private String remark;
    /**
     * 日志内容
     */
    private List<LogContentVO> logContentVOList;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<LogContentVO> getLogContentVOList() {
        return logContentVOList;
    }

    public void setLogContentVOList(List<LogContentVO> logContentVOList) {
        this.logContentVOList = logContentVOList;
    }
}
