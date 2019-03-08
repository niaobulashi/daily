package com.adtec.daily.bean.daily;

import com.adtec.daily.util.Constants;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OverWork {
    private Integer id;

    private String userId;

    private Date workDate;

    private BigDecimal overWork;

    private String approvalStatus;

    private List<String> approvalStatusList = new ArrayList<>();

    private String approvalStatusShow;

    private String approvalOpinion;

    private Date createTime;

    private String createUserId;

    private Date updateTime;

    private String updateUserId;

    private String remark1;

    private String remark2;

    private String remark3;

    private BigDecimal sumOverWork;

    private String userName;

    private String identityNo;

    private String projectCode;

    private String projectName;

    private String deptName;

    //节假日标识 0-工作日 1-周末 2-节假日
    private String holidayFlag;

    //加班费基数（每小时）
    private BigDecimal overtimePay;
    //节假日加班费系数
    private BigDecimal holidayOvertimeCoefficient;
    //周末加班费系数
    private BigDecimal weekendOvertimeCoefficient;
    //加班费
    private BigDecimal sumOvertimePay;

    private List<OverWork> overWorkList = new ArrayList<>();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public BigDecimal getSumOverWork() {
        return sumOverWork;
    }

    public void setSumOverWork(BigDecimal sumOverWork) {
        this.sumOverWork = sumOverWork;
    }

    public List<OverWork> getOverWorkList() {
        return overWorkList;
    }

    public void setOverWorkList(List<OverWork> overWorkList) {
        this.overWorkList = overWorkList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public BigDecimal getOverWork() {
        return overWork;
    }

    public void setOverWork(BigDecimal overWork) {
        this.overWork = overWork;
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

    public String getHolidayFlag() {
        return holidayFlag;
    }

    public void setHolidayFlag(String holidayFlag) {
        this.holidayFlag = holidayFlag;
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

    public BigDecimal getSumOvertimePay() {
        return sumOvertimePay;
    }

    public void setSumOvertimePay(BigDecimal sumOvertimePay) {
        this.sumOvertimePay = sumOvertimePay;
    }

    public BigDecimal getWeekendOvertimeCoefficient() {
        return weekendOvertimeCoefficient;
    }

    public void setWeekendOvertimeCoefficient(BigDecimal weekendOvertimeCoefficient) {
        this.weekendOvertimeCoefficient = weekendOvertimeCoefficient;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getApprovalOpinion() {
        return approvalOpinion;
    }

    public void setApprovalOpinion(String approvalOpinion) {
        this.approvalOpinion = approvalOpinion;
    }

    public String getApprovalStatusShow() {
        if(StringUtils.isNotEmpty(this.approvalStatus)){
            if(Constants.APPROVAL_STATUS_UNCHECK.equals(this.approvalStatus)){
                return "待审核";
            }else if(Constants.APPROVAL_STATUS_CHECK_PASS.equals(this.approvalStatus)){
                return "审核通过";
            }else if(Constants.APPROVAL_STATUS_CHECK_REJECT.equals(this.approvalStatus)){
                return "审核拒绝";
            }else{
                return approvalStatusShow;
            }
        }else{
            return approvalStatusShow;
        }
    }

    public void setApprovalStatusShow(String approvalStatusShow) {
        this.approvalStatusShow = approvalStatusShow;
    }

    public List<String> getApprovalStatusList() {
        return approvalStatusList;
    }

    public void setApprovalStatusList(List<String> approvalStatusList) {
        this.approvalStatusList = approvalStatusList;
    }
}