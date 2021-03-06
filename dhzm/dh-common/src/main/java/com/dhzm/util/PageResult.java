package com.dhzm.util;

import java.util.List;

public class PageResult<T> {

    private Long total;// 总条数
    private Integer totalPage;// 总页数
    private List<T> items;// 当前页数据


    public PageResult() {
    }

    public PageResult(Long total, Integer totalPages, List<T> items) {
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "total=" + total +
                ", totalPage=" + totalPage +
                ", items=" + items +
                '}';
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
