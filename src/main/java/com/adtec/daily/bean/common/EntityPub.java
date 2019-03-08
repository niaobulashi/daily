package com.adtec.daily.bean.common;

import java.io.Serializable;

/**
 * File: EntityPub
 *
 * @Author 王林柱
 * @Since 2018/8/21 20:37
 * @Ver 1.0
 */
public class EntityPub {

    private int page;
    private int limit;
    private String userId;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
