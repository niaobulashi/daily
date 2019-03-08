package com.adtec.daily.bean.demand;

import java.math.BigDecimal;
import java.util.Date;

public class DemandDetail extends DemandDetailKey {
    private String demandName;

    private String demandDes;

    private BigDecimal workLoad;

    private String demandRespoId;

    private Integer demandPercent;

    private Date planDate;

    private Date doneDate;

    private Date createTime;

    private String createUserId;

    private Date updateTime;

    private String updateUserId;

    private String remark1;

    private String remark2;

    private String remark3;

    private String demandIds;

    private String demandNames;

    public String getDemandName() {
        return demandName;
    }

    public void setDemandName(String demandName) {
        this.demandName = demandName == null ? null : demandName.trim();
    }

    public String getDemandDes() {
        return demandDes;
    }

    public void setDemandDes(String demandDes) {
        this.demandDes = demandDes == null ? null : demandDes.trim();
    }

    public BigDecimal getWorkLoad() {
        return workLoad;
    }

    public void setWorkLoad(BigDecimal workLoad) {
        this.workLoad = workLoad;
    }

    public String getDemandRespoId() {
        return demandRespoId;
    }

    public void setDemandRespoId(String demandRespoId) {
        this.demandRespoId = demandRespoId == null ? null : demandRespoId.trim();
    }

    public Integer getDemandPercent() {
        return demandPercent;
    }

    public void setDemandPercent(Integer demandPercent) {
        this.demandPercent = demandPercent;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public Date getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(Date doneDate) {
        this.doneDate = doneDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId == null ? null : updateUserId.trim();
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1 == null ? null : remark1.trim();
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }

    public String getDemandIds() {
        return demandIds;
    }

    public void setDemandIds(String demandIds) {
        this.demandIds = demandIds;
    }

    public String getDemandNames() {
        return demandNames;
    }

    public void setDemandNames(String demandNames) {
        this.demandNames = demandNames;
    }
}