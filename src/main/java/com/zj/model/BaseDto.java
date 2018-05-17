package com.zj.model;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.apache.commons.lang3.StringUtils;

public class BaseDto {
    private Integer page;
    private Integer pageSize;
    private String sort;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public PageBounds buildPageBounds(){
        if(this.page == null||this.page<1){
            this.page = 1;
        }
        if(this.pageSize==null||this.pageSize<1){
            this.pageSize = 2;
        }
        PageBounds pageBounds = new PageBounds(this.page,this.pageSize);
        if (StringUtils.isNotBlank(this.sort)) {
            pageBounds.setOrders(Order.formString(this.sort));
        }
        return pageBounds;
    }
}
