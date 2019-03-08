package com.adtec.daily.bean.project;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectExample() {
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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProjectCodeIsNull() {
            addCriterion("project_code is null");
            return (Criteria) this;
        }

        public Criteria andProjectCodeIsNotNull() {
            addCriterion("project_code is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCodeEqualTo(String value) {
            addCriterion("project_code =", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotEqualTo(String value) {
            addCriterion("project_code <>", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeGreaterThan(String value) {
            addCriterion("project_code >", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeGreaterThanOrEqualTo(String value) {
            addCriterion("project_code >=", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeLessThan(String value) {
            addCriterion("project_code <", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeLessThanOrEqualTo(String value) {
            addCriterion("project_code <=", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeLike(String value) {
            addCriterion("project_code like", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotLike(String value) {
            addCriterion("project_code not like", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeIn(List<String> values) {
            addCriterion("project_code in", values, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotIn(List<String> values) {
            addCriterion("project_code not in", values, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeBetween(String value1, String value2) {
            addCriterion("project_code between", value1, value2, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotBetween(String value1, String value2) {
            addCriterion("project_code not between", value1, value2, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectUserIdIsNull() {
            addCriterion("project_user_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectUserIdIsNotNull() {
            addCriterion("project_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectUserIdEqualTo(String value) {
            addCriterion("project_user_id =", value, "projectUserId");
            return (Criteria) this;
        }

        public Criteria andProjectUserIdNotEqualTo(String value) {
            addCriterion("project_user_id <>", value, "projectUserId");
            return (Criteria) this;
        }

        public Criteria andProjectUserIdGreaterThan(String value) {
            addCriterion("project_user_id >", value, "projectUserId");
            return (Criteria) this;
        }

        public Criteria andProjectUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("project_user_id >=", value, "projectUserId");
            return (Criteria) this;
        }

        public Criteria andProjectUserIdLessThan(String value) {
            addCriterion("project_user_id <", value, "projectUserId");
            return (Criteria) this;
        }

        public Criteria andProjectUserIdLessThanOrEqualTo(String value) {
            addCriterion("project_user_id <=", value, "projectUserId");
            return (Criteria) this;
        }

        public Criteria andProjectUserIdLike(String value) {
            addCriterion("project_user_id like", value, "projectUserId");
            return (Criteria) this;
        }

        public Criteria andProjectUserIdNotLike(String value) {
            addCriterion("project_user_id not like", value, "projectUserId");
            return (Criteria) this;
        }

        public Criteria andProjectUserIdIn(List<String> values) {
            addCriterion("project_user_id in", values, "projectUserId");
            return (Criteria) this;
        }

        public Criteria andProjectUserIdNotIn(List<String> values) {
            addCriterion("project_user_id not in", values, "projectUserId");
            return (Criteria) this;
        }

        public Criteria andProjectUserIdBetween(String value1, String value2) {
            addCriterion("project_user_id between", value1, value2, "projectUserId");
            return (Criteria) this;
        }

        public Criteria andProjectUserIdNotBetween(String value1, String value2) {
            addCriterion("project_user_id not between", value1, value2, "projectUserId");
            return (Criteria) this;
        }

        public Criteria andServiceObjectIdIsNull() {
            addCriterion("service_object_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceObjectIdIsNotNull() {
            addCriterion("service_object_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceObjectIdEqualTo(String value) {
            addCriterion("service_object_id =", value, "serviceObjectId");
            return (Criteria) this;
        }

        public Criteria andServiceObjectIdNotEqualTo(String value) {
            addCriterion("service_object_id <>", value, "serviceObjectId");
            return (Criteria) this;
        }

        public Criteria andServiceObjectIdGreaterThan(String value) {
            addCriterion("service_object_id >", value, "serviceObjectId");
            return (Criteria) this;
        }

        public Criteria andServiceObjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("service_object_id >=", value, "serviceObjectId");
            return (Criteria) this;
        }

        public Criteria andServiceObjectIdLessThan(String value) {
            addCriterion("service_object_id <", value, "serviceObjectId");
            return (Criteria) this;
        }

        public Criteria andServiceObjectIdLessThanOrEqualTo(String value) {
            addCriterion("service_object_id <=", value, "serviceObjectId");
            return (Criteria) this;
        }

        public Criteria andServiceObjectIdLike(String value) {
            addCriterion("service_object_id like", value, "serviceObjectId");
            return (Criteria) this;
        }

        public Criteria andServiceObjectIdNotLike(String value) {
            addCriterion("service_object_id not like", value, "serviceObjectId");
            return (Criteria) this;
        }

        public Criteria andServiceObjectIdIn(List<String> values) {
            addCriterion("service_object_id in", values, "serviceObjectId");
            return (Criteria) this;
        }

        public Criteria andServiceObjectIdNotIn(List<String> values) {
            addCriterion("service_object_id not in", values, "serviceObjectId");
            return (Criteria) this;
        }

        public Criteria andServiceObjectIdBetween(String value1, String value2) {
            addCriterion("service_object_id between", value1, value2, "serviceObjectId");
            return (Criteria) this;
        }

        public Criteria andServiceObjectIdNotBetween(String value1, String value2) {
            addCriterion("service_object_id not between", value1, value2, "serviceObjectId");
            return (Criteria) this;
        }

        public Criteria andDailyModuleIdIsNull() {
            addCriterion("daily_module_id is null");
            return (Criteria) this;
        }

        public Criteria andDailyModuleIdIsNotNull() {
            addCriterion("daily_module_id is not null");
            return (Criteria) this;
        }

        public Criteria andDailyModuleIdEqualTo(String value) {
            addCriterion("daily_module_id =", value, "dailyModuleId");
            return (Criteria) this;
        }

        public Criteria andDailyModuleIdNotEqualTo(String value) {
            addCriterion("daily_module_id <>", value, "dailyModuleId");
            return (Criteria) this;
        }

        public Criteria andDailyModuleIdGreaterThan(String value) {
            addCriterion("daily_module_id >", value, "dailyModuleId");
            return (Criteria) this;
        }

        public Criteria andDailyModuleIdGreaterThanOrEqualTo(String value) {
            addCriterion("daily_module_id >=", value, "dailyModuleId");
            return (Criteria) this;
        }

        public Criteria andDailyModuleIdLessThan(String value) {
            addCriterion("daily_module_id <", value, "dailyModuleId");
            return (Criteria) this;
        }

        public Criteria andDailyModuleIdLessThanOrEqualTo(String value) {
            addCriterion("daily_module_id <=", value, "dailyModuleId");
            return (Criteria) this;
        }

        public Criteria andDailyModuleIdLike(String value) {
            addCriterion("daily_module_id like", value, "dailyModuleId");
            return (Criteria) this;
        }

        public Criteria andDailyModuleIdNotLike(String value) {
            addCriterion("daily_module_id not like", value, "dailyModuleId");
            return (Criteria) this;
        }

        public Criteria andDailyModuleIdIn(List<String> values) {
            addCriterion("daily_module_id in", values, "dailyModuleId");
            return (Criteria) this;
        }

        public Criteria andDailyModuleIdNotIn(List<String> values) {
            addCriterion("daily_module_id not in", values, "dailyModuleId");
            return (Criteria) this;
        }

        public Criteria andDailyModuleIdBetween(String value1, String value2) {
            addCriterion("daily_module_id between", value1, value2, "dailyModuleId");
            return (Criteria) this;
        }

        public Criteria andDailyModuleIdNotBetween(String value1, String value2) {
            addCriterion("daily_module_id not between", value1, value2, "dailyModuleId");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeIsNull() {
            addCriterion("work_start_time is null");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeIsNotNull() {
            addCriterion("work_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeEqualTo(Date value) {
            addCriterionForJDBCTime("work_start_time =", value, "workStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("work_start_time <>", value, "workStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("work_start_time >", value, "workStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("work_start_time >=", value, "workStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeLessThan(Date value) {
            addCriterionForJDBCTime("work_start_time <", value, "workStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("work_start_time <=", value, "workStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeIn(List<Date> values) {
            addCriterionForJDBCTime("work_start_time in", values, "workStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("work_start_time not in", values, "workStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("work_start_time between", value1, value2, "workStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("work_start_time not between", value1, value2, "workStartTime");
            return (Criteria) this;
        }

        public Criteria andMorningEndTimeIsNull() {
            addCriterion("morning_end_time is null");
            return (Criteria) this;
        }

        public Criteria andMorningEndTimeIsNotNull() {
            addCriterion("morning_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andMorningEndTimeEqualTo(Date value) {
            addCriterionForJDBCTime("morning_end_time =", value, "morningEndTime");
            return (Criteria) this;
        }

        public Criteria andMorningEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("morning_end_time <>", value, "morningEndTime");
            return (Criteria) this;
        }

        public Criteria andMorningEndTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("morning_end_time >", value, "morningEndTime");
            return (Criteria) this;
        }

        public Criteria andMorningEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("morning_end_time >=", value, "morningEndTime");
            return (Criteria) this;
        }

        public Criteria andMorningEndTimeLessThan(Date value) {
            addCriterionForJDBCTime("morning_end_time <", value, "morningEndTime");
            return (Criteria) this;
        }

        public Criteria andMorningEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("morning_end_time <=", value, "morningEndTime");
            return (Criteria) this;
        }

        public Criteria andMorningEndTimeIn(List<Date> values) {
            addCriterionForJDBCTime("morning_end_time in", values, "morningEndTime");
            return (Criteria) this;
        }

        public Criteria andMorningEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("morning_end_time not in", values, "morningEndTime");
            return (Criteria) this;
        }

        public Criteria andMorningEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("morning_end_time between", value1, value2, "morningEndTime");
            return (Criteria) this;
        }

        public Criteria andMorningEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("morning_end_time not between", value1, value2, "morningEndTime");
            return (Criteria) this;
        }

        public Criteria andAfterStartTimeIsNull() {
            addCriterion("after_start_time is null");
            return (Criteria) this;
        }

        public Criteria andAfterStartTimeIsNotNull() {
            addCriterion("after_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andAfterStartTimeEqualTo(Date value) {
            addCriterionForJDBCTime("after_start_time =", value, "afterStartTime");
            return (Criteria) this;
        }

        public Criteria andAfterStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("after_start_time <>", value, "afterStartTime");
            return (Criteria) this;
        }

        public Criteria andAfterStartTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("after_start_time >", value, "afterStartTime");
            return (Criteria) this;
        }

        public Criteria andAfterStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("after_start_time >=", value, "afterStartTime");
            return (Criteria) this;
        }

        public Criteria andAfterStartTimeLessThan(Date value) {
            addCriterionForJDBCTime("after_start_time <", value, "afterStartTime");
            return (Criteria) this;
        }

        public Criteria andAfterStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("after_start_time <=", value, "afterStartTime");
            return (Criteria) this;
        }

        public Criteria andAfterStartTimeIn(List<Date> values) {
            addCriterionForJDBCTime("after_start_time in", values, "afterStartTime");
            return (Criteria) this;
        }

        public Criteria andAfterStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("after_start_time not in", values, "afterStartTime");
            return (Criteria) this;
        }

        public Criteria andAfterStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("after_start_time between", value1, value2, "afterStartTime");
            return (Criteria) this;
        }

        public Criteria andAfterStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("after_start_time not between", value1, value2, "afterStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeIsNull() {
            addCriterion("work_end_time is null");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeIsNotNull() {
            addCriterion("work_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeEqualTo(Date value) {
            addCriterionForJDBCTime("work_end_time =", value, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("work_end_time <>", value, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("work_end_time >", value, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("work_end_time >=", value, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeLessThan(Date value) {
            addCriterionForJDBCTime("work_end_time <", value, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("work_end_time <=", value, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeIn(List<Date> values) {
            addCriterionForJDBCTime("work_end_time in", values, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("work_end_time not in", values, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("work_end_time between", value1, value2, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("work_end_time not between", value1, value2, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andOverworkStartTimeIsNull() {
            addCriterion("overwork_start_time is null");
            return (Criteria) this;
        }

        public Criteria andOverworkStartTimeIsNotNull() {
            addCriterion("overwork_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andOverworkStartTimeEqualTo(Date value) {
            addCriterionForJDBCTime("overwork_start_time =", value, "overworkStartTime");
            return (Criteria) this;
        }

        public Criteria andOverworkStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("overwork_start_time <>", value, "overworkStartTime");
            return (Criteria) this;
        }

        public Criteria andOverworkStartTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("overwork_start_time >", value, "overworkStartTime");
            return (Criteria) this;
        }

        public Criteria andOverworkStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("overwork_start_time >=", value, "overworkStartTime");
            return (Criteria) this;
        }

        public Criteria andOverworkStartTimeLessThan(Date value) {
            addCriterionForJDBCTime("overwork_start_time <", value, "overworkStartTime");
            return (Criteria) this;
        }

        public Criteria andOverworkStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("overwork_start_time <=", value, "overworkStartTime");
            return (Criteria) this;
        }

        public Criteria andOverworkStartTimeIn(List<Date> values) {
            addCriterionForJDBCTime("overwork_start_time in", values, "overworkStartTime");
            return (Criteria) this;
        }

        public Criteria andOverworkStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("overwork_start_time not in", values, "overworkStartTime");
            return (Criteria) this;
        }

        public Criteria andOverworkStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("overwork_start_time between", value1, value2, "overworkStartTime");
            return (Criteria) this;
        }

        public Criteria andOverworkStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("overwork_start_time not between", value1, value2, "overworkStartTime");
            return (Criteria) this;
        }

        public Criteria andOvertimePayIsNull() {
            addCriterion("overtime_pay is null");
            return (Criteria) this;
        }

        public Criteria andOvertimePayIsNotNull() {
            addCriterion("overtime_pay is not null");
            return (Criteria) this;
        }

        public Criteria andOvertimePayEqualTo(BigDecimal value) {
            addCriterion("overtime_pay =", value, "overtimePay");
            return (Criteria) this;
        }

        public Criteria andOvertimePayNotEqualTo(BigDecimal value) {
            addCriterion("overtime_pay <>", value, "overtimePay");
            return (Criteria) this;
        }

        public Criteria andOvertimePayGreaterThan(BigDecimal value) {
            addCriterion("overtime_pay >", value, "overtimePay");
            return (Criteria) this;
        }

        public Criteria andOvertimePayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("overtime_pay >=", value, "overtimePay");
            return (Criteria) this;
        }

        public Criteria andOvertimePayLessThan(BigDecimal value) {
            addCriterion("overtime_pay <", value, "overtimePay");
            return (Criteria) this;
        }

        public Criteria andOvertimePayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("overtime_pay <=", value, "overtimePay");
            return (Criteria) this;
        }

        public Criteria andOvertimePayIn(List<BigDecimal> values) {
            addCriterion("overtime_pay in", values, "overtimePay");
            return (Criteria) this;
        }

        public Criteria andOvertimePayNotIn(List<BigDecimal> values) {
            addCriterion("overtime_pay not in", values, "overtimePay");
            return (Criteria) this;
        }

        public Criteria andOvertimePayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("overtime_pay between", value1, value2, "overtimePay");
            return (Criteria) this;
        }

        public Criteria andOvertimePayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("overtime_pay not between", value1, value2, "overtimePay");
            return (Criteria) this;
        }

        public Criteria andHolidayOvertimeCoefficientIsNull() {
            addCriterion("holiday_overtime_coefficient is null");
            return (Criteria) this;
        }

        public Criteria andHolidayOvertimeCoefficientIsNotNull() {
            addCriterion("holiday_overtime_coefficient is not null");
            return (Criteria) this;
        }

        public Criteria andHolidayOvertimeCoefficientEqualTo(BigDecimal value) {
            addCriterion("holiday_overtime_coefficient =", value, "holidayOvertimeCoefficient");
            return (Criteria) this;
        }

        public Criteria andHolidayOvertimeCoefficientNotEqualTo(BigDecimal value) {
            addCriterion("holiday_overtime_coefficient <>", value, "holidayOvertimeCoefficient");
            return (Criteria) this;
        }

        public Criteria andHolidayOvertimeCoefficientGreaterThan(BigDecimal value) {
            addCriterion("holiday_overtime_coefficient >", value, "holidayOvertimeCoefficient");
            return (Criteria) this;
        }

        public Criteria andHolidayOvertimeCoefficientGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("holiday_overtime_coefficient >=", value, "holidayOvertimeCoefficient");
            return (Criteria) this;
        }

        public Criteria andHolidayOvertimeCoefficientLessThan(BigDecimal value) {
            addCriterion("holiday_overtime_coefficient <", value, "holidayOvertimeCoefficient");
            return (Criteria) this;
        }

        public Criteria andHolidayOvertimeCoefficientLessThanOrEqualTo(BigDecimal value) {
            addCriterion("holiday_overtime_coefficient <=", value, "holidayOvertimeCoefficient");
            return (Criteria) this;
        }

        public Criteria andHolidayOvertimeCoefficientIn(List<BigDecimal> values) {
            addCriterion("holiday_overtime_coefficient in", values, "holidayOvertimeCoefficient");
            return (Criteria) this;
        }

        public Criteria andHolidayOvertimeCoefficientNotIn(List<BigDecimal> values) {
            addCriterion("holiday_overtime_coefficient not in", values, "holidayOvertimeCoefficient");
            return (Criteria) this;
        }

        public Criteria andHolidayOvertimeCoefficientBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("holiday_overtime_coefficient between", value1, value2, "holidayOvertimeCoefficient");
            return (Criteria) this;
        }

        public Criteria andHolidayOvertimeCoefficientNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("holiday_overtime_coefficient not between", value1, value2, "holidayOvertimeCoefficient");
            return (Criteria) this;
        }

        public Criteria andWeekendOvertimeCoefficientIsNull() {
            addCriterion("weekend_overtime_coefficient is null");
            return (Criteria) this;
        }

        public Criteria andWeekendOvertimeCoefficientIsNotNull() {
            addCriterion("weekend_overtime_coefficient is not null");
            return (Criteria) this;
        }

        public Criteria andWeekendOvertimeCoefficientEqualTo(BigDecimal value) {
            addCriterion("weekend_overtime_coefficient =", value, "weekendOvertimeCoefficient");
            return (Criteria) this;
        }

        public Criteria andWeekendOvertimeCoefficientNotEqualTo(BigDecimal value) {
            addCriterion("weekend_overtime_coefficient <>", value, "weekendOvertimeCoefficient");
            return (Criteria) this;
        }

        public Criteria andWeekendOvertimeCoefficientGreaterThan(BigDecimal value) {
            addCriterion("weekend_overtime_coefficient >", value, "weekendOvertimeCoefficient");
            return (Criteria) this;
        }

        public Criteria andWeekendOvertimeCoefficientGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weekend_overtime_coefficient >=", value, "weekendOvertimeCoefficient");
            return (Criteria) this;
        }

        public Criteria andWeekendOvertimeCoefficientLessThan(BigDecimal value) {
            addCriterion("weekend_overtime_coefficient <", value, "weekendOvertimeCoefficient");
            return (Criteria) this;
        }

        public Criteria andWeekendOvertimeCoefficientLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weekend_overtime_coefficient <=", value, "weekendOvertimeCoefficient");
            return (Criteria) this;
        }

        public Criteria andWeekendOvertimeCoefficientIn(List<BigDecimal> values) {
            addCriterion("weekend_overtime_coefficient in", values, "weekendOvertimeCoefficient");
            return (Criteria) this;
        }

        public Criteria andWeekendOvertimeCoefficientNotIn(List<BigDecimal> values) {
            addCriterion("weekend_overtime_coefficient not in", values, "weekendOvertimeCoefficient");
            return (Criteria) this;
        }

        public Criteria andWeekendOvertimeCoefficientBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weekend_overtime_coefficient between", value1, value2, "weekendOvertimeCoefficient");
            return (Criteria) this;
        }

        public Criteria andWeekendOvertimeCoefficientNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weekend_overtime_coefficient not between", value1, value2, "weekendOvertimeCoefficient");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(String value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(String value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(String value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(String value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(String value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLike(String value) {
            addCriterion("create_user_id like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotLike(String value) {
            addCriterion("create_user_id not like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<String> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<String> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(String value1, String value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(String value1, String value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNull() {
            addCriterion("update_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNotNull() {
            addCriterion("update_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdEqualTo(String value) {
            addCriterion("update_user_id =", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotEqualTo(String value) {
            addCriterion("update_user_id <>", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThan(String value) {
            addCriterion("update_user_id >", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("update_user_id >=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThan(String value) {
            addCriterion("update_user_id <", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThanOrEqualTo(String value) {
            addCriterion("update_user_id <=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLike(String value) {
            addCriterion("update_user_id like", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotLike(String value) {
            addCriterion("update_user_id not like", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIn(List<String> values) {
            addCriterion("update_user_id in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotIn(List<String> values) {
            addCriterion("update_user_id not in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdBetween(String value1, String value2) {
            addCriterion("update_user_id between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotBetween(String value1, String value2) {
            addCriterion("update_user_id not between", value1, value2, "updateUserId");
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