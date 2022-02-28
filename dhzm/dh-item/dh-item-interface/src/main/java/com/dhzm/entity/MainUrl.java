package com.dhzm.entity;

import java.util.Date;

/**
 * @author Remy~
 * @date 来自:2022年01月04日 11:00
 */
public class MainUrl {
    private Integer mainId;
    private Integer parentId;
    private String name;
    private String Url;
    private String perms;
    private Integer type;
    private String icon;
    private Integer orderNum;
    private Date createBy;
    private Date createTime;
    private Date lastUpdateBy;
    private Date lastUpdateTime;
    private Integer delFlag;
    private MainUrl children;


    public MainUrl() {
    }

    public MainUrl(Integer mainId, Integer parentId, String name, String url, String perms, Integer type, String icon, Integer orderNum, Date createBy, Date createTime, Date lastUpdateBy, Date lastUpdateTime, Integer delFlag, MainUrl children) {
        this.mainId = mainId;
        this.parentId = parentId;
        this.name = name;
        Url = url;
        this.perms = perms;
        this.type = type;
        this.icon = icon;
        this.orderNum = orderNum;
        this.createBy = createBy;
        this.createTime = createTime;
        this.lastUpdateBy = lastUpdateBy;
        this.lastUpdateTime = lastUpdateTime;
        this.delFlag = delFlag;
        this.children = children;
    }

    public Integer getMainId() {
        return mainId;
    }

    public void setMainId(Integer mainId) {
        this.mainId = mainId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Date getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Date createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(Date lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public MainUrl getChildren() {
        return children;
    }

    public void setChildren(MainUrl children) {
        this.children = children;
    }
}
