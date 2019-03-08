package com.adtec.daily.bean.user;

import com.adtec.daily.bean.common.EntityPub;
import java.util.Date;

public class UserFeedBack extends EntityPub {
    private Integer fdId;

    private String fbType;

    private String fbInfo;

    private String fbUser;

    private String fbEmail;

    private String sessionId;

    private Date createDate;

    private String resultFlag;

    private String remark1;

    private String remark2;

    private String remark3;

    public Integer getFdId() {
        return fdId;
    }

    public void setFdId(Integer fdId) {
        this.fdId = fdId;
    }

    public String getFbType() {
        return fbType;
    }

    public void setFbType(String fbType) {
        this.fbType = fbType == null ? null : fbType.trim();
    }

    public String getFbInfo() {
        return fbInfo;
    }

    public void setFbInfo(String fbInfo) {
        this.fbInfo = fbInfo == null ? null : fbInfo.trim();
    }

    public String getFbUser() {
        return fbUser;
    }

    public void setFbUser(String fbUser) {
        this.fbUser = fbUser == null ? null : fbUser.trim();
    }

    public String getFbEmail() {
        return fbEmail;
    }

    public void setFbEmail(String fbEmail) {
        this.fbEmail = fbEmail == null ? null : fbEmail.trim();
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId == null ? null : sessionId.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getResultFlag() {
        return resultFlag;
    }

    public void setResultFlag(String resultFlag) {
        this.resultFlag = resultFlag == null ? null : resultFlag.trim();
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
}