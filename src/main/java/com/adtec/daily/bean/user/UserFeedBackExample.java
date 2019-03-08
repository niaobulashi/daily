package com.adtec.daily.bean.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserFeedBackExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserFeedBackExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andFdIdIsNull() {
            addCriterion("fd_id is null");
            return (Criteria) this;
        }

        public Criteria andFdIdIsNotNull() {
            addCriterion("fd_id is not null");
            return (Criteria) this;
        }

        public Criteria andFdIdEqualTo(Integer value) {
            addCriterion("fd_id =", value, "fdId");
            return (Criteria) this;
        }

        public Criteria andFdIdNotEqualTo(Integer value) {
            addCriterion("fd_id <>", value, "fdId");
            return (Criteria) this;
        }

        public Criteria andFdIdGreaterThan(Integer value) {
            addCriterion("fd_id >", value, "fdId");
            return (Criteria) this;
        }

        public Criteria andFdIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("fd_id >=", value, "fdId");
            return (Criteria) this;
        }

        public Criteria andFdIdLessThan(Integer value) {
            addCriterion("fd_id <", value, "fdId");
            return (Criteria) this;
        }

        public Criteria andFdIdLessThanOrEqualTo(Integer value) {
            addCriterion("fd_id <=", value, "fdId");
            return (Criteria) this;
        }

        public Criteria andFdIdIn(List<Integer> values) {
            addCriterion("fd_id in", values, "fdId");
            return (Criteria) this;
        }

        public Criteria andFdIdNotIn(List<Integer> values) {
            addCriterion("fd_id not in", values, "fdId");
            return (Criteria) this;
        }

        public Criteria andFdIdBetween(Integer value1, Integer value2) {
            addCriterion("fd_id between", value1, value2, "fdId");
            return (Criteria) this;
        }

        public Criteria andFdIdNotBetween(Integer value1, Integer value2) {
            addCriterion("fd_id not between", value1, value2, "fdId");
            return (Criteria) this;
        }

        public Criteria andFbTypeIsNull() {
            addCriterion("fb_type is null");
            return (Criteria) this;
        }

        public Criteria andFbTypeIsNotNull() {
            addCriterion("fb_type is not null");
            return (Criteria) this;
        }

        public Criteria andFbTypeEqualTo(String value) {
            addCriterion("fb_type =", value, "fbType");
            return (Criteria) this;
        }

        public Criteria andFbTypeNotEqualTo(String value) {
            addCriterion("fb_type <>", value, "fbType");
            return (Criteria) this;
        }

        public Criteria andFbTypeGreaterThan(String value) {
            addCriterion("fb_type >", value, "fbType");
            return (Criteria) this;
        }

        public Criteria andFbTypeGreaterThanOrEqualTo(String value) {
            addCriterion("fb_type >=", value, "fbType");
            return (Criteria) this;
        }

        public Criteria andFbTypeLessThan(String value) {
            addCriterion("fb_type <", value, "fbType");
            return (Criteria) this;
        }

        public Criteria andFbTypeLessThanOrEqualTo(String value) {
            addCriterion("fb_type <=", value, "fbType");
            return (Criteria) this;
        }

        public Criteria andFbTypeLike(String value) {
            addCriterion("fb_type like", value, "fbType");
            return (Criteria) this;
        }

        public Criteria andFbTypeNotLike(String value) {
            addCriterion("fb_type not like", value, "fbType");
            return (Criteria) this;
        }

        public Criteria andFbTypeIn(List<String> values) {
            addCriterion("fb_type in", values, "fbType");
            return (Criteria) this;
        }

        public Criteria andFbTypeNotIn(List<String> values) {
            addCriterion("fb_type not in", values, "fbType");
            return (Criteria) this;
        }

        public Criteria andFbTypeBetween(String value1, String value2) {
            addCriterion("fb_type between", value1, value2, "fbType");
            return (Criteria) this;
        }

        public Criteria andFbTypeNotBetween(String value1, String value2) {
            addCriterion("fb_type not between", value1, value2, "fbType");
            return (Criteria) this;
        }

        public Criteria andFbInfoIsNull() {
            addCriterion("fb_info is null");
            return (Criteria) this;
        }

        public Criteria andFbInfoIsNotNull() {
            addCriterion("fb_info is not null");
            return (Criteria) this;
        }

        public Criteria andFbInfoEqualTo(String value) {
            addCriterion("fb_info =", value, "fbInfo");
            return (Criteria) this;
        }

        public Criteria andFbInfoNotEqualTo(String value) {
            addCriterion("fb_info <>", value, "fbInfo");
            return (Criteria) this;
        }

        public Criteria andFbInfoGreaterThan(String value) {
            addCriterion("fb_info >", value, "fbInfo");
            return (Criteria) this;
        }

        public Criteria andFbInfoGreaterThanOrEqualTo(String value) {
            addCriterion("fb_info >=", value, "fbInfo");
            return (Criteria) this;
        }

        public Criteria andFbInfoLessThan(String value) {
            addCriterion("fb_info <", value, "fbInfo");
            return (Criteria) this;
        }

        public Criteria andFbInfoLessThanOrEqualTo(String value) {
            addCriterion("fb_info <=", value, "fbInfo");
            return (Criteria) this;
        }

        public Criteria andFbInfoLike(String value) {
            addCriterion("fb_info like", value, "fbInfo");
            return (Criteria) this;
        }

        public Criteria andFbInfoNotLike(String value) {
            addCriterion("fb_info not like", value, "fbInfo");
            return (Criteria) this;
        }

        public Criteria andFbInfoIn(List<String> values) {
            addCriterion("fb_info in", values, "fbInfo");
            return (Criteria) this;
        }

        public Criteria andFbInfoNotIn(List<String> values) {
            addCriterion("fb_info not in", values, "fbInfo");
            return (Criteria) this;
        }

        public Criteria andFbInfoBetween(String value1, String value2) {
            addCriterion("fb_info between", value1, value2, "fbInfo");
            return (Criteria) this;
        }

        public Criteria andFbInfoNotBetween(String value1, String value2) {
            addCriterion("fb_info not between", value1, value2, "fbInfo");
            return (Criteria) this;
        }

        public Criteria andFbUserIsNull() {
            addCriterion("fb_user is null");
            return (Criteria) this;
        }

        public Criteria andFbUserIsNotNull() {
            addCriterion("fb_user is not null");
            return (Criteria) this;
        }

        public Criteria andFbUserEqualTo(String value) {
            addCriterion("fb_user =", value, "fbUser");
            return (Criteria) this;
        }

        public Criteria andFbUserNotEqualTo(String value) {
            addCriterion("fb_user <>", value, "fbUser");
            return (Criteria) this;
        }

        public Criteria andFbUserGreaterThan(String value) {
            addCriterion("fb_user >", value, "fbUser");
            return (Criteria) this;
        }

        public Criteria andFbUserGreaterThanOrEqualTo(String value) {
            addCriterion("fb_user >=", value, "fbUser");
            return (Criteria) this;
        }

        public Criteria andFbUserLessThan(String value) {
            addCriterion("fb_user <", value, "fbUser");
            return (Criteria) this;
        }

        public Criteria andFbUserLessThanOrEqualTo(String value) {
            addCriterion("fb_user <=", value, "fbUser");
            return (Criteria) this;
        }

        public Criteria andFbUserLike(String value) {
            addCriterion("fb_user like", value, "fbUser");
            return (Criteria) this;
        }

        public Criteria andFbUserNotLike(String value) {
            addCriterion("fb_user not like", value, "fbUser");
            return (Criteria) this;
        }

        public Criteria andFbUserIn(List<String> values) {
            addCriterion("fb_user in", values, "fbUser");
            return (Criteria) this;
        }

        public Criteria andFbUserNotIn(List<String> values) {
            addCriterion("fb_user not in", values, "fbUser");
            return (Criteria) this;
        }

        public Criteria andFbUserBetween(String value1, String value2) {
            addCriterion("fb_user between", value1, value2, "fbUser");
            return (Criteria) this;
        }

        public Criteria andFbUserNotBetween(String value1, String value2) {
            addCriterion("fb_user not between", value1, value2, "fbUser");
            return (Criteria) this;
        }

        public Criteria andFbEmailIsNull() {
            addCriterion("fb_email is null");
            return (Criteria) this;
        }

        public Criteria andFbEmailIsNotNull() {
            addCriterion("fb_email is not null");
            return (Criteria) this;
        }

        public Criteria andFbEmailEqualTo(String value) {
            addCriterion("fb_email =", value, "fbEmail");
            return (Criteria) this;
        }

        public Criteria andFbEmailNotEqualTo(String value) {
            addCriterion("fb_email <>", value, "fbEmail");
            return (Criteria) this;
        }

        public Criteria andFbEmailGreaterThan(String value) {
            addCriterion("fb_email >", value, "fbEmail");
            return (Criteria) this;
        }

        public Criteria andFbEmailGreaterThanOrEqualTo(String value) {
            addCriterion("fb_email >=", value, "fbEmail");
            return (Criteria) this;
        }

        public Criteria andFbEmailLessThan(String value) {
            addCriterion("fb_email <", value, "fbEmail");
            return (Criteria) this;
        }

        public Criteria andFbEmailLessThanOrEqualTo(String value) {
            addCriterion("fb_email <=", value, "fbEmail");
            return (Criteria) this;
        }

        public Criteria andFbEmailLike(String value) {
            addCriterion("fb_email like", value, "fbEmail");
            return (Criteria) this;
        }

        public Criteria andFbEmailNotLike(String value) {
            addCriterion("fb_email not like", value, "fbEmail");
            return (Criteria) this;
        }

        public Criteria andFbEmailIn(List<String> values) {
            addCriterion("fb_email in", values, "fbEmail");
            return (Criteria) this;
        }

        public Criteria andFbEmailNotIn(List<String> values) {
            addCriterion("fb_email not in", values, "fbEmail");
            return (Criteria) this;
        }

        public Criteria andFbEmailBetween(String value1, String value2) {
            addCriterion("fb_email between", value1, value2, "fbEmail");
            return (Criteria) this;
        }

        public Criteria andFbEmailNotBetween(String value1, String value2) {
            addCriterion("fb_email not between", value1, value2, "fbEmail");
            return (Criteria) this;
        }

        public Criteria andSessionIdIsNull() {
            addCriterion("session_id is null");
            return (Criteria) this;
        }

        public Criteria andSessionIdIsNotNull() {
            addCriterion("session_id is not null");
            return (Criteria) this;
        }

        public Criteria andSessionIdEqualTo(String value) {
            addCriterion("session_id =", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdNotEqualTo(String value) {
            addCriterion("session_id <>", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdGreaterThan(String value) {
            addCriterion("session_id >", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdGreaterThanOrEqualTo(String value) {
            addCriterion("session_id >=", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdLessThan(String value) {
            addCriterion("session_id <", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdLessThanOrEqualTo(String value) {
            addCriterion("session_id <=", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdLike(String value) {
            addCriterion("session_id like", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdNotLike(String value) {
            addCriterion("session_id not like", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdIn(List<String> values) {
            addCriterion("session_id in", values, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdNotIn(List<String> values) {
            addCriterion("session_id not in", values, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdBetween(String value1, String value2) {
            addCriterion("session_id between", value1, value2, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdNotBetween(String value1, String value2) {
            addCriterion("session_id not between", value1, value2, "sessionId");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andResultFlagIsNull() {
            addCriterion("result_flag is null");
            return (Criteria) this;
        }

        public Criteria andResultFlagIsNotNull() {
            addCriterion("result_flag is not null");
            return (Criteria) this;
        }

        public Criteria andResultFlagEqualTo(String value) {
            addCriterion("result_flag =", value, "resultFlag");
            return (Criteria) this;
        }

        public Criteria andResultFlagNotEqualTo(String value) {
            addCriterion("result_flag <>", value, "resultFlag");
            return (Criteria) this;
        }

        public Criteria andResultFlagGreaterThan(String value) {
            addCriterion("result_flag >", value, "resultFlag");
            return (Criteria) this;
        }

        public Criteria andResultFlagGreaterThanOrEqualTo(String value) {
            addCriterion("result_flag >=", value, "resultFlag");
            return (Criteria) this;
        }

        public Criteria andResultFlagLessThan(String value) {
            addCriterion("result_flag <", value, "resultFlag");
            return (Criteria) this;
        }

        public Criteria andResultFlagLessThanOrEqualTo(String value) {
            addCriterion("result_flag <=", value, "resultFlag");
            return (Criteria) this;
        }

        public Criteria andResultFlagLike(String value) {
            addCriterion("result_flag like", value, "resultFlag");
            return (Criteria) this;
        }

        public Criteria andResultFlagNotLike(String value) {
            addCriterion("result_flag not like", value, "resultFlag");
            return (Criteria) this;
        }

        public Criteria andResultFlagIn(List<String> values) {
            addCriterion("result_flag in", values, "resultFlag");
            return (Criteria) this;
        }

        public Criteria andResultFlagNotIn(List<String> values) {
            addCriterion("result_flag not in", values, "resultFlag");
            return (Criteria) this;
        }

        public Criteria andResultFlagBetween(String value1, String value2) {
            addCriterion("result_flag between", value1, value2, "resultFlag");
            return (Criteria) this;
        }

        public Criteria andResultFlagNotBetween(String value1, String value2) {
            addCriterion("result_flag not between", value1, value2, "resultFlag");
            return (Criteria) this;
        }

        public Criteria andRemark1IsNull() {
            addCriterion("remark1 is null");
            return (Criteria) this;
        }

        public Criteria andRemark1IsNotNull() {
            addCriterion("remark1 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark1EqualTo(String value) {
            addCriterion("remark1 =", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotEqualTo(String value) {
            addCriterion("remark1 <>", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1GreaterThan(String value) {
            addCriterion("remark1 >", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1GreaterThanOrEqualTo(String value) {
            addCriterion("remark1 >=", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1LessThan(String value) {
            addCriterion("remark1 <", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1LessThanOrEqualTo(String value) {
            addCriterion("remark1 <=", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1Like(String value) {
            addCriterion("remark1 like", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotLike(String value) {
            addCriterion("remark1 not like", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1In(List<String> values) {
            addCriterion("remark1 in", values, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotIn(List<String> values) {
            addCriterion("remark1 not in", values, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1Between(String value1, String value2) {
            addCriterion("remark1 between", value1, value2, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotBetween(String value1, String value2) {
            addCriterion("remark1 not between", value1, value2, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark2IsNull() {
            addCriterion("remark2 is null");
            return (Criteria) this;
        }

        public Criteria andRemark2IsNotNull() {
            addCriterion("remark2 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark2EqualTo(String value) {
            addCriterion("remark2 =", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotEqualTo(String value) {
            addCriterion("remark2 <>", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2GreaterThan(String value) {
            addCriterion("remark2 >", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2GreaterThanOrEqualTo(String value) {
            addCriterion("remark2 >=", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2LessThan(String value) {
            addCriterion("remark2 <", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2LessThanOrEqualTo(String value) {
            addCriterion("remark2 <=", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2Like(String value) {
            addCriterion("remark2 like", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotLike(String value) {
            addCriterion("remark2 not like", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2In(List<String> values) {
            addCriterion("remark2 in", values, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotIn(List<String> values) {
            addCriterion("remark2 not in", values, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2Between(String value1, String value2) {
            addCriterion("remark2 between", value1, value2, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotBetween(String value1, String value2) {
            addCriterion("remark2 not between", value1, value2, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark3IsNull() {
            addCriterion("remark3 is null");
            return (Criteria) this;
        }

        public Criteria andRemark3IsNotNull() {
            addCriterion("remark3 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark3EqualTo(String value) {
            addCriterion("remark3 =", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotEqualTo(String value) {
            addCriterion("remark3 <>", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3GreaterThan(String value) {
            addCriterion("remark3 >", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3GreaterThanOrEqualTo(String value) {
            addCriterion("remark3 >=", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3LessThan(String value) {
            addCriterion("remark3 <", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3LessThanOrEqualTo(String value) {
            addCriterion("remark3 <=", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3Like(String value) {
            addCriterion("remark3 like", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotLike(String value) {
            addCriterion("remark3 not like", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3In(List<String> values) {
            addCriterion("remark3 in", values, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotIn(List<String> values) {
            addCriterion("remark3 not in", values, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3Between(String value1, String value2) {
            addCriterion("remark3 between", value1, value2, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotBetween(String value1, String value2) {
            addCriterion("remark3 not between", value1, value2, "remark3");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}