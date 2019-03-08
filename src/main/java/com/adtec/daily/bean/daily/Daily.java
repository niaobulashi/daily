package com.adtec.daily.bean.daily;

import com.adtec.daily.util.Constants;
import com.adtec.daily.util.DateUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

public class Daily {
    private String dailyId;

    private Date dailyDate;

    private String userId;

    private String userName;

    private Integer projectId;

    private Date createTime;

    private String createUserId;

    private Date updateTime;

    private String updateUserId;

    private String remark1;

    private String remark2;

    private String remark3;

    private Integer dailyNo;

    private String dailyContent;

    private Integer dailyPercent;

    private Date doneDate;

    private String problem;

    private String nextWorkPlan;

    private Integer planDailyPercent;

    private String workType;

    private String workTypeShow;

    private String execution;

    //完成情况中文显示
    private String executionShow;

    //完成情况拼接
    private String executionJoint;

    private Date offDutyTime;

    //日报所占行数
    private int lineNumber;

    //计划所占行数
    private int planLineNumber;

    //项目表中的项目编号
    private String projectCode;

    //项目表中的项目名称
    private String projectName;

    private int pn;

    //星期
    private String week;

    private String dailyDateStr;

    // 月份日期
    private String dailyDateDay;

    // 工作时长
    private String workHour;

    // 加班时长
    private String overWork;

    // 月份的日期序列
    private String monthDate;

    // 月份序号
    private String monthNo;

    // 工作时长月份总和
    private String workTimeSum;

    // 加班时长月份总和
    private String overWorkSum;

    // 年份-月份
    private String yearMonth;

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public Integer getDailyNo() {
        return dailyNo;
    }

    public void setDailyNo(Integer dailyNo) {
        this.dailyNo = dailyNo;
    }

    public String getDailyContent() {
        return dailyContent;
    }

    public void setDailyContent(String dailyContent) {
        this.dailyContent = dailyContent;
    }

    public Integer getDailyPercent() {
        return dailyPercent;
    }

    public void setDailyPercent(Integer dailyPercent) {
        this.dailyPercent = dailyPercent;
    }

    public Date getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(Date doneDate) {
        this.doneDate = doneDate;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getNextWorkPlan() {
        return nextWorkPlan;
    }

    public void setNextWorkPlan(String nextWorkPlan) {
        this.nextWorkPlan = nextWorkPlan;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getExecution() {
        return execution;
    }

    public void setExecution(String execution) {
        this.execution = execution;
    }

    public String getDailyId() {
        return dailyId;
    }

    public void setDailyId(String dailyId) {
        this.dailyId = dailyId == null ? null : dailyId.trim();
    }

    public Date getDailyDate() {
        return dailyDate;
    }

    public Date setDailyDate(Date dailyDate) {
        this.dailyDate = dailyDate;
        return dailyDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getPn() {
        return pn;
    }

    public void setPn(int pn) {
        this.pn = pn;
    }

    public String getWeek() {
        if(this.dailyDate!=null){
            return DateUtil.getWeek(this.dailyDate);
        }else{
            return week;
        }
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getDailyDateStr() {
        return dailyDateStr;
    }

    public void setDailyDateStr(String dailyDateStr) {
        this.dailyDateStr = dailyDateStr;
    }

    public Date getOffDutyTime() {
        return offDutyTime;
    }

    public void setOffDutyTime(Date offDutyTime) {
        this.offDutyTime = offDutyTime;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public int getPlanLineNumber() {
        return planLineNumber;
    }

    public void setPlanLineNumber(int planLineNumber) {
        this.planLineNumber = planLineNumber;
    }

    public String getExecutionShow() {
        if(StringUtils.isNotEmpty(this.execution)){
            if(Constants.EXECUTION_NOT_STARTED.equals(this.execution)){
                return "未开始";
            }else if(Constants.EXECUTION_IN_PROGRESS.equals(this.execution)){
                return "正在进行";
            }else if(Constants.EXECUTION_COMPLETED.equals(this.execution)){
                return "已完成";
            }else{
                return executionShow;
            }
        }else{
            return executionShow;
        }
    }

    public void setExecutionShow(String executionShow) {
        this.executionShow = executionShow;
    }

    public String getWorkTypeShow() {
        if(StringUtils.isNotEmpty(this.workType)){
            if(Constants.WORK_TYPE_ANALYSIS.equals(this.workType)){
                return "需求分析";
            }else if(Constants.WORK_TYPE_DESIGN.equals(this.workType)){
                return "设计";
            }else if(Constants.WORK_TYPE_DEVELOPMENT.equals(this.workType)){
                return "开发";
            }else if(Constants.WORK_TYPE_TEST.equals(this.workType)){
                return "测试";
            }else if(Constants.WORK_TYPE_VERSION.equals(this.workType)){
                return "版本发布";
            }else if(Constants.WORK_TYPE_OPERATION.equals(this.workType)){
                return "运维支持";
            }else if(Constants.WORK_TYPE_MEETING.equals(this.workType)){
                return "会议";
            }else if(Constants.WORK_TYPE_OTHER.equals(this.workType)){
                return "其他";
            }else{
                return workTypeShow;
            }
        }else{
            return workTypeShow;
        }
    }

    public void setWorkTypeShow(String workTypeShow) {
        this.workTypeShow = workTypeShow;
    }

    public String getExecutionJoint() {
        return executionJoint;
    }

    public void setExecutionJoint(String executionJoint) {
        this.executionJoint = executionJoint;
    }

    public Integer getPlanDailyPercent() {
        return planDailyPercent;
    }

    public void setPlanDailyPercent(Integer planDailyPercent) {
        this.planDailyPercent = planDailyPercent;
    }

    public String getOverWork() {
        return overWork;
    }

    public void setOverWork(String overWork) {
        this.overWork = overWork;
    }

    public String getWorkHour() {
        return workHour;
    }

    public void setWorkHour(String workHour) {
        this.workHour = workHour;
    }

    public String getDailyDateDay() {
        return dailyDateDay;
    }

    public void setDailyDateDay(String dailyDateDay) {
        this.dailyDateDay = dailyDateDay;
    }

    public String getMonthDate() {
        return monthDate;
    }

    public void setMonthDate(String monthDate) {
        this.monthDate = monthDate;
    }

    public String getMonthNo() {
        return monthNo;
    }

    public void setMonthNo(String monthNo) {
        this.monthNo = monthNo;
    }

    public String getWorkTimeSum() {
        return workTimeSum;
    }

    public void setWorkTimeSum(String workTimeSum) {
        this.workTimeSum = workTimeSum;
    }

    public String getOverWorkSum() {
        return overWorkSum;
    }

    public void setOverWorkSum(String overWorkSum) {
        this.overWorkSum = overWorkSum;
    }

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }
}