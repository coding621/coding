package com.morpheus.coding.project.domain.vo.project.task;


/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */

public class TaskStatisticsByDateVO {
    /**
     * 时间
     */
    private String date;
    /**
     * 总数
     */
    private Integer total;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
