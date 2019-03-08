package com.adtec.daily.bean.daily;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DailyDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DailyDetailExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andDailyDetailIdIsNull() {
            addCriterion("daily_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andDailyDetailIdIsNotNull() {
            addCriterion("daily_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andDailyDetailIdEqualTo(String value) {
            addCriterion("daily_detail_id =", value, "dailyDetailId");
            return (Criteria) this;
        }

        public Criteria andDailyDetailIdNotEqualTo(String value) {
            addCriterion("daily_detail_id <>", value, "dailyDetailId");
            return (Criteria) this;
        }

        public Criteria andDailyDetailIdGreaterThan(String value) {
            addCriterion("daily_detail_id >", value, "dailyDetailId");
            return (Criteria) this;
        }

        public Criteria andDailyDetailIdGreaterThanOrEqualTo(String value) {
            addCriterion("daily_detail_id >=", value, "dailyDetailId");
            return (Criteria) this;
        }

        public Criteria andDailyDetailIdLessThan(String value) {
            addCriterion("daily_detail_id <", value, "dailyDetailId");
            return (Criteria) this;
        }

        public Criteria andDailyDetailIdLessThanOrEqualTo(String value) {
            addCriterion("daily_detail_id <=", value, "dailyDetailId");
            return (Criteria) this;
        }

        public Criteria andDailyDetailIdLike(String value) {
            addCriterion("daily_detail_id like", value, "dailyDetailId");
            return (Criteria) this;
        }

        public Criteria andDailyDetailIdNotLike(String value) {
            addCriterion("daily_detail_id not like", value, "dailyDetailId");
            return (Criteria) this;
        }

        public Criteria andDailyDetailIdIn(List<String> values) {
            addCriterion("daily_detail_id in", values, "dailyDetailId");
            return (Criteria) this;
        }

        public Criteria andDailyDetailIdNotIn(List<String> values) {
            addCriterion("daily_detail_id not in", values, "dailyDetailId");
            return (Criteria) this;
        }

        public Criteria andDailyDetailIdBetween(String value1, String value2) {
            addCriterion("daily_detail_id between", value1, value2, "dailyDetailId");
            return (Criteria) this;
        }

        public Criteria andDailyDetailIdNotBetween(String value1, String value2) {
            addCriterion("daily_detail_id not between", value1, value2, "dailyDetailId");
            return (Criteria) this;
        }

        public Criteria andDailyIdIsNull() {
            addCriterion("daily_id is null");
            return (Criteria) this;
        }

        public Criteria andDailyIdIsNotNull() {
            addCriterion("daily_id is not null");
            return (Criteria) this;
        }

        public Criteria andDailyIdEqualTo(String value) {
            addCriterion("daily_id =", value, "dailyId");
            return (Criteria) this;
        }

        public Criteria andDailyIdNotEqualTo(String value) {
            addCriterion("daily_id <>", value, "dailyId");
            return (Criteria) this;
        }

        public Criteria andDailyIdGreaterThan(String value) {
            addCriterion("daily_id >", value, "dailyId");
            return (Criteria) this;
        }

        public Criteria andDailyIdGreaterThanOrEqualTo(String value) {
            addCriterion("daily_id >=", value, "dailyId");
            return (Criteria) this;
        }

        public Criteria andDailyIdLessThan(String value) {
            addCriterion("daily_id <", value, "dailyId");
            return (Criteria) this;
        }

        public Criteria andDailyIdLessThanOrEqualTo(String value) {
            addCriterion("daily_id <=", value, "dailyId");
            return (Criteria) this;
        }

        public Criteria andDailyIdLike(String value) {
            addCriterion("daily_id like", value, "dailyId");
            return (Criteria) this;
        }

        public Criteria andDailyIdNotLike(String value) {
            addCriterion("daily_id not like", value, "dailyId");
            return (Criteria) this;
        }

        public Criteria andDailyIdIn(List<String> values) {
            addCriterion("daily_id in", values, "dailyId");
            return (Criteria) this;
        }

        public Criteria andDailyIdNotIn(List<String> values) {
            addCriterion("daily_id not in", values, "dailyId");
            return (Criteria) this;
        }

        public Criteria andDailyIdBetween(String value1, String value2) {
            addCriterion("daily_id between", value1, value2, "dailyId");
            return (Criteria) this;
        }

        public Criteria andDailyIdNotBetween(String value1, String value2) {
            addCriterion("daily_id not between", value1, value2, "dailyId");
            return (Criteria) this;
        }

        public Criteria andDailyNoIsNull() {
            addCriterion("daily_no is null");
            return (Criteria) this;
        }

        public Criteria andDailyNoIsNotNull() {
            addCriterion("daily_no is not null");
            return (Criteria) this;
        }

        public Criteria andDailyNoEqualTo(Integer value) {
            addCriterion("daily_no =", value, "dailyNo");
            return (Criteria) this;
        }

        public Criteria andDailyNoNotEqualTo(Integer value) {
            addCriterion("daily_no <>", value, "dailyNo");
            return (Criteria) this;
        }

        public Criteria andDailyNoGreaterThan(Integer value) {
            addCriterion("daily_no >", value, "dailyNo");
            return (Criteria) this;
        }

        public Criteria andDailyNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("daily_no >=", value, "dailyNo");
            return (Criteria) this;
        }

        public Criteria andDailyNoLessThan(Integer value) {
            addCriterion("daily_no <", value, "dailyNo");
            return (Criteria) this;
        }

        public Criteria andDailyNoLessThanOrEqualTo(Integer value) {
            addCriterion("daily_no <=", value, "dailyNo");
            return (Criteria) this;
        }

        public Criteria andDailyNoIn(List<Integer> values) {
            addCriterion("daily_no in", values, "dailyNo");
            return (Criteria) this;
        }

        public Criteria andDailyNoNotIn(List<Integer> values) {
            addCriterion("daily_no not in", values, "dailyNo");
            return (Criteria) this;
        }

        public Criteria andDailyNoBetween(Integer value1, Integer value2) {
            addCriterion("daily_no between", value1, value2, "dailyNo");
            return (Criteria) this;
        }

        public Criteria andDailyNoNotBetween(Integer value1, Integer value2) {
            addCriterion("daily_no not between", value1, value2, "dailyNo");
            return (Criteria) this;
        }

        public Criteria andDailyContentIsNull() {
            addCriterion("daily_content is null");
            return (Criteria) this;
        }

        public Criteria andDailyContentIsNotNull() {
            addCriterion("daily_content is not null");
            return (Criteria) this;
        }

        public Criteria andDailyContentEqualTo(String value) {
            addCriterion("daily_content =", value, "dailyContent");
            return (Criteria) this;
        }

        public Criteria andDailyContentNotEqualTo(String value) {
            addCriterion("daily_content <>", value, "dailyContent");
            return (Criteria) this;
        }

        public Criteria andDailyContentGreaterThan(String value) {
            addCriterion("daily_content >", value, "dailyContent");
            return (Criteria) this;
        }

        public Criteria andDailyContentGreaterThanOrEqualTo(String value) {
            addCriterion("daily_content >=", value, "dailyContent");
            return (Criteria) this;
        }

        public Criteria andDailyContentLessThan(String value) {
            addCriterion("daily_content <", value, "dailyContent");
            return (Criteria) this;
        }

        public Criteria andDailyContentLessThanOrEqualTo(String value) {
            addCriterion("daily_content <=", value, "dailyContent");
            return (Criteria) this;
        }

        public Criteria andDailyContentLike(String value) {
            addCriterion("daily_content like", value, "dailyContent");
            return (Criteria) this;
        }

        public Criteria andDailyContentNotLike(String value) {
            addCriterion("daily_content not like", value, "dailyContent");
            return (Criteria) this;
        }

        public Criteria andDailyContentIn(List<String> values) {
            addCriterion("daily_content in", values, "dailyContent");
            return (Criteria) this;
        }

        public Criteria andDailyContentNotIn(List<String> values) {
            addCriterion("daily_content not in", values, "dailyContent");
            return (Criteria) this;
        }

        public Criteria andDailyContentBetween(String value1, String value2) {
            addCriterion("daily_content between", value1, value2, "dailyContent");
            return (Criteria) this;
        }

        public Criteria andDailyContentNotBetween(String value1, String value2) {
            addCriterion("daily_content not between", value1, value2, "dailyContent");
            return (Criteria) this;
        }

        public Criteria andDailyPercentIsNull() {
            addCriterion("daily_percent is null");
            return (Criteria) this;
        }

        public Criteria andDailyPercentIsNotNull() {
            addCriterion("daily_percent is not null");
            return (Criteria) this;
        }

        public Criteria andDailyPercentEqualTo(Integer value) {
            addCriterion("daily_percent =", value, "dailyPercent");
            return (Criteria) this;
        }

        public Criteria andDailyPercentNotEqualTo(Integer value) {
            addCriterion("daily_percent <>", value, "dailyPercent");
            return (Criteria) this;
        }

        public Criteria andDailyPercentGreaterThan(Integer value) {
            addCriterion("daily_percent >", value, "dailyPercent");
            return (Criteria) this;
        }

        public Criteria andDailyPercentGreaterThanOrEqualTo(Integer value) {
            addCriterion("daily_percent >=", value, "dailyPercent");
            return (Criteria) this;
        }

        public Criteria andDailyPercentLessThan(Integer value) {
            addCriterion("daily_percent <", value, "dailyPercent");
            return (Criteria) this;
        }

        public Criteria andDailyPercentLessThanOrEqualTo(Integer value) {
            addCriterion("daily_percent <=", value, "dailyPercent");
            return (Criteria) this;
        }

        public Criteria andDailyPercentIn(List<Integer> values) {
            addCriterion("daily_percent in", values, "dailyPercent");
            return (Criteria) this;
        }

        public Criteria andDailyPercentNotIn(List<Integer> values) {
            addCriterion("daily_percent not in", values, "dailyPercent");
            return (Criteria) this;
        }

        public Criteria andDailyPercentBetween(Integer value1, Integer value2) {
            addCriterion("daily_percent between", value1, value2, "dailyPercent");
            return (Criteria) this;
        }

        public Criteria andDailyPercentNotBetween(Integer value1, Integer value2) {
            addCriterion("daily_percent not between", value1, value2, "dailyPercent");
            return (Criteria) this;
        }

        public Criteria andDoneDateIsNull() {
            addCriterion("done_date is null");
            return (Criteria) this;
        }

        public Criteria andDoneDateIsNotNull() {
            addCriterion("done_date is not null");
            return (Criteria) this;
        }

        public Criteria andDoneDateEqualTo(Date value) {
            addCriterionForJDBCDate("done_date =", value, "doneDate");
            return (Criteria) this;
        }

        public Criteria andDoneDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("done_date <>", value, "doneDate");
            return (Criteria) this;
        }

        public Criteria andDoneDateGreaterThan(Date value) {
            addCriterionForJDBCDate("done_date >", value, "doneDate");
            return (Criteria) this;
        }

        public Criteria andDoneDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("done_date >=", value, "doneDate");
            return (Criteria) this;
        }

        public Criteria andDoneDateLessThan(Date value) {
            addCriterionForJDBCDate("done_date <", value, "doneDate");
            return (Criteria) this;
        }

        public Criteria andDoneDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("done_date <=", value, "doneDate");
            return (Criteria) this;
        }

        public Criteria andDoneDateIn(List<Date> values) {
            addCriterionForJDBCDate("done_date in", values, "doneDate");
            return (Criteria) this;
        }

        public Criteria andDoneDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("done_date not in", values, "doneDate");
            return (Criteria) this;
        }

        public Criteria andDoneDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("done_date between", value1, value2, "doneDate");
            return (Criteria) this;
        }

        public Criteria andDoneDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("done_date not between", value1, value2, "doneDate");
            return (Criteria) this;
        }

        public Criteria andProblemIsNull() {
            addCriterion("problem is null");
            return (Criteria) this;
        }

        public Criteria andProblemIsNotNull() {
            addCriterion("problem is not null");
            return (Criteria) this;
        }

        public Criteria andProblemEqualTo(String value) {
            addCriterion("problem =", value, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemNotEqualTo(String value) {
            addCriterion("problem <>", value, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemGreaterThan(String value) {
            addCriterion("problem >", value, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemGreaterThanOrEqualTo(String value) {
            addCriterion("problem >=", value, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemLessThan(String value) {
            addCriterion("problem <", value, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemLessThanOrEqualTo(String value) {
            addCriterion("problem <=", value, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemLike(String value) {
            addCriterion("problem like", value, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemNotLike(String value) {
            addCriterion("problem not like", value, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemIn(List<String> values) {
            addCriterion("problem in", values, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemNotIn(List<String> values) {
            addCriterion("problem not in", values, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemBetween(String value1, String value2) {
            addCriterion("problem between", value1, value2, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemNotBetween(String value1, String value2) {
            addCriterion("problem not between", value1, value2, "problem");
            return (Criteria) this;
        }

        public Criteria andNextWorkPlanIsNull() {
            addCriterion("next_work_plan is null");
            return (Criteria) this;
        }

        public Criteria andNextWorkPlanIsNotNull() {
            addCriterion("next_work_plan is not null");
            return (Criteria) this;
        }

        public Criteria andNextWorkPlanEqualTo(String value) {
            addCriterion("next_work_plan =", value, "nextWorkPlan");
            return (Criteria) this;
        }

        public Criteria andNextWorkPlanNotEqualTo(String value) {
            addCriterion("next_work_plan <>", value, "nextWorkPlan");
            return (Criteria) this;
        }

        public Criteria andNextWorkPlanGreaterThan(String value) {
            addCriterion("next_work_plan >", value, "nextWorkPlan");
            return (Criteria) this;
        }

        public Criteria andNextWorkPlanGreaterThanOrEqualTo(String value) {
            addCriterion("next_work_plan >=", value, "nextWorkPlan");
            return (Criteria) this;
        }

        public Criteria andNextWorkPlanLessThan(String value) {
            addCriterion("next_work_plan <", value, "nextWorkPlan");
            return (Criteria) this;
        }

        public Criteria andNextWorkPlanLessThanOrEqualTo(String value) {
            addCriterion("next_work_plan <=", value, "nextWorkPlan");
            return (Criteria) this;
        }

        public Criteria andNextWorkPlanLike(String value) {
            addCriterion("next_work_plan like", value, "nextWorkPlan");
            return (Criteria) this;
        }

        public Criteria andNextWorkPlanNotLike(String value) {
            addCriterion("next_work_plan not like", value, "nextWorkPlan");
            return (Criteria) this;
        }

        public Criteria andNextWorkPlanIn(List<String> values) {
            addCriterion("next_work_plan in", values, "nextWorkPlan");
            return (Criteria) this;
        }

        public Criteria andNextWorkPlanNotIn(List<String> values) {
            addCriterion("next_work_plan not in", values, "nextWorkPlan");
            return (Criteria) this;
        }

        public Criteria andNextWorkPlanBetween(String value1, String value2) {
            addCriterion("next_work_plan between", value1, value2, "nextWorkPlan");
            return (Criteria) this;
        }

        public Criteria andNextWorkPlanNotBetween(String value1, String value2) {
            addCriterion("next_work_plan not between", value1, value2, "nextWorkPlan");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIsNull() {
            addCriterion("work_type is null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIsNotNull() {
            addCriterion("work_type is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeEqualTo(String value) {
            addCriterion("work_type =", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotEqualTo(String value) {
            addCriterion("work_type <>", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeGreaterThan(String value) {
            addCriterion("work_type >", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeGreaterThanOrEqualTo(String value) {
            addCriterion("work_type >=", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLessThan(String value) {
            addCriterion("work_type <", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLessThanOrEqualTo(String value) {
            addCriterion("work_type <=", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLike(String value) {
            addCriterion("work_type like", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotLike(String value) {
            addCriterion("work_type not like", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIn(List<String> values) {
            addCriterion("work_type in", values, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotIn(List<String> values) {
            addCriterion("work_type not in", values, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeBetween(String value1, String value2) {
            addCriterion("work_type between", value1, value2, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotBetween(String value1, String value2) {
            addCriterion("work_type not between", value1, value2, "workType");
            return (Criteria) this;
        }

        public Criteria andExecutionIsNull() {
            addCriterion("execution is null");
            return (Criteria) this;
        }

        public Criteria andExecutionIsNotNull() {
            addCriterion("execution is not null");
            return (Criteria) this;
        }

        public Criteria andExecutionEqualTo(String value) {
            addCriterion("execution =", value, "execution");
            return (Criteria) this;
        }

        public Criteria andExecutionNotEqualTo(String value) {
            addCriterion("execution <>", value, "execution");
            return (Criteria) this;
        }

        public Criteria andExecutionGreaterThan(String value) {
            addCriterion("execution >", value, "execution");
            return (Criteria) this;
        }

        public Criteria andExecutionGreaterThanOrEqualTo(String value) {
            addCriterion("execution >=", value, "execution");
            return (Criteria) this;
        }

        public Criteria andExecutionLessThan(String value) {
            addCriterion("execution <", value, "execution");
            return (Criteria) this;
        }

        public Criteria andExecutionLessThanOrEqualTo(String value) {
            addCriterion("execution <=", value, "execution");
            return (Criteria) this;
        }

        public Criteria andExecutionLike(String value) {
            addCriterion("execution like", value, "execution");
            return (Criteria) this;
        }

        public Criteria andExecutionNotLike(String value) {
            addCriterion("execution not like", value, "execution");
            return (Criteria) this;
        }

        public Criteria andExecutionIn(List<String> values) {
            addCriterion("execution in", values, "execution");
            return (Criteria) this;
        }

        public Criteria andExecutionNotIn(List<String> values) {
            addCriterion("execution not in", values, "execution");
            return (Criteria) this;
        }

        public Criteria andExecutionBetween(String value1, String value2) {
            addCriterion("execution between", value1, value2, "execution");
            return (Criteria) this;
        }

        public Criteria andExecutionNotBetween(String value1, String value2) {
            addCriterion("execution not between", value1, value2, "execution");
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