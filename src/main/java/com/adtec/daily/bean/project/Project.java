package com.adtec.daily.bean.project;

import java.math.BigDecimal;
import java.util.Date;

public class Project {
    private Integer id;

    private String projectCode;

    private String projectName;

    private String projectUserId;

    private String serviceObjectId;

    private String dailyModuleId;

    private Date workStartTime;

    private String workStartTimeStr;

    private Date morningEndTime;

    private String morningEndTimeStr;

    private Date afterStartTime;

    private String afterStartTimeStr;

    private Date workEndTime;

    private String workEndTimeStr;

    private Date overworkStartTime;

    private String overworkStartTimeStr;

    private BigDecimal overtimePay;

    private BigDecimal holidayOvertimeCoefficient;

    private BigDecimal weekendOvertimeCoefficient;

    private Date createTime;

    private String createUserId;

    private Date updateTime;

    private String updateUserId;

    private String remark1;

    private String remark2;

    private String remark3;

    // 项目负责人名称
    private String userName;

    // 用户编号
    private String userId;

    // 日报ID
    private String dailyId;

    // 日报日期
    private Date dailyDate;

    // 邮箱
    private String email;

    // 当前用户名称
    private String currentUserName;

    // 当前用户邮箱
    private String currentUserEmail;

    public String getCurrentUserName() { return currentUserName; }

    public void setCurrentUserName(String currentUserName) { this.currentUserName = currentUserName; }

    public String getCurrentUserEmail() { return currentUserEmail; }

    public void setCurrentUserEmail(String currentUserEmail) { this.currentUserEmail = currentUserEmail; }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode == null ? null : projectCode.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectUserId() {
        return projectUserId;
    }

    public void setProjectUserId(String projectUserId) {
        this.projectUserId = projectUserId == null ? null : projectUserId.trim();
    }

    public String getServiceObjectId() {
        return serviceObjectId;
    }

    public void setServiceObjectId(String serviceObjectId) {
        this.serviceObjectId = serviceObjectId == null ? null : serviceObjectId.trim();
    }

    public String getDailyModuleId() {
        return dailyModuleId;
    }

    public void setDailyModuleId(String dailyModuleId) {
        this.dailyModuleId = dailyModuleId == null ? null : dailyModuleId.trim();
    }

    public Date getWorkStartTime() {
        return workStartTime;
    }

    public void setWorkStartTime(Date workStartTime) {
        this.workStartTime = workStartTime;
    }

    public Date getMorningEndTime() {
        return morningEndTime;
    }

    public void setMorningEndTime(Date morningEndTime) {
        this.morningEndTime = morningEndTime;
    }

    public Date getAfterStartTime() {
        return afterStartTime;
    }

    public void setAfterStartTime(Date afterStartTime) {
        this.afterStartTime = afterStartTime;
    }

    public Date getWorkEndTime() {
        return workEndTime;
    }

    public void setWorkEndTime(Date workEndTime) {
        this.workEndTime = workEndTime;
    }

    public Date getOverworkStartTime() {
        return overworkStartTime;
    }

    public void setOverworkStartTime(Date overworkStartTime) {
        this.overworkStartTime = overworkStartTime;
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

    public String getWorkStartTimeStr() {
        return workStartTimeStr;
    }

    public void setWorkStartTimeStr(String workStartTimeStr) {
        this.workStartTimeStr = workStartTimeStr;
    }

    public String getWorkEndTimeStr() {
        return workEndTimeStr;
    }

    public void setWorkEndTimeStr(String workEndTimeStr) {
        this.workEndTimeStr = workEndTimeStr;
    }

    public String getOverworkStartTimeStr() {
        return overworkStartTimeStr;
    }

    public void setOverworkStartTimeStr(String overworkStartTimeStr) {
        this.overworkStartTimeStr = overworkStartTimeStr;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDailyId() {
        return dailyId;
    }

    public void setDailyId(String dailyId) {
        this.dailyId = dailyId;
    }

    public Date getDailyDate() {
        return dailyDate;
    }

    public void setDailyDate(Date dailyDate) {
        this.dailyDate = dailyDate;
    }

    public BigDecimal getOvertimePay() {
        return overtimePay;
    }

    public void setOvertimePay(BigDecimal overtimePay) {
        this.overtimePay = overtimePay;
    }

    public BigDecimal getHolidayOvertimeCoefficient() {
        return holidayOvertimeCoefficient;
    }

    public void setHolidayOvertimeCoefficient(BigDecimal holidayOvertimeCoefficient) {
        this.holidayOvertimeCoefficient = holidayOvertimeCoefficient;
    }

    public BigDecimal getWeekendOvertimeCoefficient() {
        return weekendOvertimeCoefficient;
    }

    public void setWeekendOvertimeCoefficient(BigDecimal weekendOvertimeCoefficient) {
        this.weekendOvertimeCoefficient = weekendOvertimeCoefficient;
    }

    public String getMorningEndTimeStr() {
        return morningEndTimeStr;
    }

    public void setMorningEndTimeStr(String morningEndTimeStr) {
        this.morningEndTimeStr = morningEndTimeStr;
    }

    public String getAfterStartTimeStr() {
        return afterStartTimeStr;
    }

    public void setAfterStartTimeStr(String afterStartTimeStr) {
        this.afterStartTimeStr = afterStartTimeStr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
