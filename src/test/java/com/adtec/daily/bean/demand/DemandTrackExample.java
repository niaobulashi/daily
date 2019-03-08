package com.adtec.daily.bean.demand;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DemandTrackExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DemandTrackExample() {
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

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(String value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(String value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(String value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(String value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(String value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLike(String value) {
            addCriterion("project_id like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotLike(String value) {
            addCriterion("project_id not like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<String> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<String> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(String value1, String value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(String value1, String value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andDemandIdIsNull() {
            addCriterion("demand_id is null");
            return (Criteria) this;
        }

        public Criteria andDemandIdIsNotNull() {
            addCriterion("demand_id is not null");
            return (Criteria) this;
        }

        public Criteria andDemandIdEqualTo(String value) {
            addCriterion("demand_id =", value, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdNotEqualTo(String value) {
            addCriterion("demand_id <>", value, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdGreaterThan(String value) {
            addCriterion("demand_id >", value, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdGreaterThanOrEqualTo(String value) {
            addCriterion("demand_id >=", value, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdLessThan(String value) {
            addCriterion("demand_id <", value, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdLessThanOrEqualTo(String value) {
            addCriterion("demand_id <=", value, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdLike(String value) {
            addCriterion("demand_id like", value, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdNotLike(String value) {
            addCriterion("demand_id not like", value, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdIn(List<String> values) {
            addCriterion("demand_id in", values, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdNotIn(List<String> values) {
            addCriterion("demand_id not in", values, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdBetween(String value1, String value2) {
            addCriterion("demand_id between", value1, value2, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdNotBetween(String value1, String value2) {
            addCriterion("demand_id not between", value1, value2, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandDepartmantIsNull() {
            addCriterion("demand_departmant is null");
            return (Criteria) this;
        }

        public Criteria andDemandDepartmantIsNotNull() {
            addCriterion("demand_departmant is not null");
            return (Criteria) this;
        }

        public Criteria andDemandDepartmantEqualTo(String value) {
            addCriterion("demand_departmant =", value, "demandDepartmant");
            return (Criteria) this;
        }

        public Criteria andDemandDepartmantNotEqualTo(String value) {
            addCriterion("demand_departmant <>", value, "demandDepartmant");
            return (Criteria) this;
        }

        public Criteria andDemandDepartmantGreaterThan(String value) {
            addCriterion("demand_departmant >", value, "demandDepartmant");
            return (Criteria) this;
        }

        public Criteria andDemandDepartmantGreaterThanOrEqualTo(String value) {
            addCriterion("demand_departmant >=", value, "demandDepartmant");
            return (Criteria) this;
        }

        public Criteria andDemandDepartmantLessThan(String value) {
            addCriterion("demand_departmant <", value, "demandDepartmant");
            return (Criteria) this;
        }

        public Criteria andDemandDepartmantLessThanOrEqualTo(String value) {
            addCriterion("demand_departmant <=", value, "demandDepartmant");
            return (Criteria) this;
        }

        public Criteria andDemandDepartmantLike(String value) {
            addCriterion("demand_departmant like", value, "demandDepartmant");
            return (Criteria) this;
        }

        public Criteria andDemandDepartmantNotLike(String value) {
            addCriterion("demand_departmant not like", value, "demandDepartmant");
            return (Criteria) this;
        }

        public Criteria andDemandDepartmantIn(List<String> values) {
            addCriterion("demand_departmant in", values, "demandDepartmant");
            return (Criteria) this;
        }

        public Criteria andDemandDepartmantNotIn(List<String> values) {
            addCriterion("demand_departmant not in", values, "demandDepartmant");
            return (Criteria) this;
        }

        public Criteria andDemandDepartmantBetween(String value1, String value2) {
            addCriterion("demand_departmant between", value1, value2, "demandDepartmant");
            return (Criteria) this;
        }

        public Criteria andDemandDepartmantNotBetween(String value1, String value2) {
            addCriterion("demand_departmant not between", value1, value2, "demandDepartmant");
            return (Criteria) this;
        }

        public Criteria andDemandMakerIsNull() {
            addCriterion("demand_maker is null");
            return (Criteria) this;
        }

        public Criteria andDemandMakerIsNotNull() {
            addCriterion("demand_maker is not null");
            return (Criteria) this;
        }

        public Criteria andDemandMakerEqualTo(String value) {
            addCriterion("demand_maker =", value, "demandMaker");
            return (Criteria) this;
        }

        public Criteria andDemandMakerNotEqualTo(String value) {
            addCriterion("demand_maker <>", value, "demandMaker");
            return (Criteria) this;
        }

        public Criteria andDemandMakerGreaterThan(String value) {
            addCriterion("demand_maker >", value, "demandMaker");
            return (Criteria) this;
        }

        public Criteria andDemandMakerGreaterThanOrEqualTo(String value) {
            addCriterion("demand_maker >=", value, "demandMaker");
            return (Criteria) this;
        }

        public Criteria andDemandMakerLessThan(String value) {
            addCriterion("demand_maker <", value, "demandMaker");
            return (Criteria) this;
        }

        public Criteria andDemandMakerLessThanOrEqualTo(String value) {
            addCriterion("demand_maker <=", value, "demandMaker");
            return (Criteria) this;
        }

        public Criteria andDemandMakerLike(String value) {
            addCriterion("demand_maker like", value, "demandMaker");
            return (Criteria) this;
        }

        public Criteria andDemandMakerNotLike(String value) {
            addCriterion("demand_maker not like", value, "demandMaker");
            return (Criteria) this;
        }

        public Criteria andDemandMakerIn(List<String> values) {
            addCriterion("demand_maker in", values, "demandMaker");
            return (Criteria) this;
        }

        public Criteria andDemandMakerNotIn(List<String> values) {
            addCriterion("demand_maker not in", values, "demandMaker");
            return (Criteria) this;
        }

        public Criteria andDemandMakerBetween(String value1, String value2) {
            addCriterion("demand_maker between", value1, value2, "demandMaker");
            return (Criteria) this;
        }

        public Criteria andDemandMakerNotBetween(String value1, String value2) {
            addCriterion("demand_maker not between", value1, value2, "demandMaker");
            return (Criteria) this;
        }

        public Criteria andDemandDateIsNull() {
            addCriterion("demand_date is null");
            return (Criteria) this;
        }

        public Criteria andDemandDateIsNotNull() {
            addCriterion("demand_date is not null");
            return (Criteria) this;
        }

        public Criteria andDemandDateEqualTo(Date value) {
            addCriterionForJDBCDate("demand_date =", value, "demandDate");
            return (Criteria) this;
        }

        public Criteria andDemandDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("demand_date <>", value, "demandDate");
            return (Criteria) this;
        }

        public Criteria andDemandDateGreaterThan(Date value) {
            addCriterionForJDBCDate("demand_date >", value, "demandDate");
            return (Criteria) this;
        }

        public Criteria andDemandDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("demand_date >=", value, "demandDate");
            return (Criteria) this;
        }

        public Criteria andDemandDateLessThan(Date value) {
            addCriterionForJDBCDate("demand_date <", value, "demandDate");
            return (Criteria) this;
        }

        public Criteria andDemandDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("demand_date <=", value, "demandDate");
            return (Criteria) this;
        }

        public Criteria andDemandDateIn(List<Date> values) {
            addCriterionForJDBCDate("demand_date in", values, "demandDate");
            return (Criteria) this;
        }

        public Criteria andDemandDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("demand_date not in", values, "demandDate");
            return (Criteria) this;
        }

        public Criteria andDemandDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("demand_date between", value1, value2, "demandDate");
            return (Criteria) this;
        }

        public Criteria andDemandDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("demand_date not between", value1, value2, "demandDate");
            return (Criteria) this;
        }

        public Criteria andDemandAuditorIsNull() {
            addCriterion("demand_auditor is null");
            return (Criteria) this;
        }

        public Criteria andDemandAuditorIsNotNull() {
            addCriterion("demand_auditor is not null");
            return (Criteria) this;
        }

        public Criteria andDemandAuditorEqualTo(String value) {
            addCriterion("demand_auditor =", value, "demandAuditor");
            return (Criteria) this;
        }

        public Criteria andDemandAuditorNotEqualTo(String value) {
            addCriterion("demand_auditor <>", value, "demandAuditor");
            return (Criteria) this;
        }

        public Criteria andDemandAuditorGreaterThan(String value) {
            addCriterion("demand_auditor >", value, "demandAuditor");
            return (Criteria) this;
        }

        public Criteria andDemandAuditorGreaterThanOrEqualTo(String value) {
            addCriterion("demand_auditor >=", value, "demandAuditor");
            return (Criteria) this;
        }

        public Criteria andDemandAuditorLessThan(String value) {
            addCriterion("demand_auditor <", value, "demandAuditor");
            return (Criteria) this;
        }

        public Criteria andDemandAuditorLessThanOrEqualTo(String value) {
            addCriterion("demand_auditor <=", value, "demandAuditor");
            return (Criteria) this;
        }

        public Criteria andDemandAuditorLike(String value) {
            addCriterion("demand_auditor like", value, "demandAuditor");
            return (Criteria) this;
        }

        public Criteria andDemandAuditorNotLike(String value) {
            addCriterion("demand_auditor not like", value, "demandAuditor");
            return (Criteria) this;
        }

        public Criteria andDemandAuditorIn(List<String> values) {
            addCriterion("demand_auditor in", values, "demandAuditor");
            return (Criteria) this;
        }

        public Criteria andDemandAuditorNotIn(List<String> values) {
            addCriterion("demand_auditor not in", values, "demandAuditor");
            return (Criteria) this;
        }

        public Criteria andDemandAuditorBetween(String value1, String value2) {
            addCriterion("demand_auditor between", value1, value2, "demandAuditor");
            return (Criteria) this;
        }

        public Criteria andDemandAuditorNotBetween(String value1, String value2) {
            addCriterion("demand_auditor not between", value1, value2, "demandAuditor");
            return (Criteria) this;
        }

        public Criteria andDemandSystemIsNull() {
            addCriterion("demand_system is null");
            return (Criteria) this;
        }

        public Criteria andDemandSystemIsNotNull() {
            addCriterion("demand_system is not null");
            return (Criteria) this;
        }

        public Criteria andDemandSystemEqualTo(String value) {
            addCriterion("demand_system =", value, "demandSystem");
            return (Criteria) this;
        }

        public Criteria andDemandSystemNotEqualTo(String value) {
            addCriterion("demand_system <>", value, "demandSystem");
            return (Criteria) this;
        }

        public Criteria andDemandSystemGreaterThan(String value) {
            addCriterion("demand_system >", value, "demandSystem");
            return (Criteria) this;
        }

        public Criteria andDemandSystemGreaterThanOrEqualTo(String value) {
            addCriterion("demand_system >=", value, "demandSystem");
            return (Criteria) this;
        }

        public Criteria andDemandSystemLessThan(String value) {
            addCriterion("demand_system <", value, "demandSystem");
            return (Criteria) this;
        }

        public Criteria andDemandSystemLessThanOrEqualTo(String value) {
            addCriterion("demand_system <=", value, "demandSystem");
            return (Criteria) this;
        }

        public Criteria andDemandSystemLike(String value) {
            addCriterion("demand_system like", value, "demandSystem");
            return (Criteria) this;
        }

        public Criteria andDemandSystemNotLike(String value) {
            addCriterion("demand_system not like", value, "demandSystem");
            return (Criteria) this;
        }

        public Criteria andDemandSystemIn(List<String> values) {
            addCriterion("demand_system in", values, "demandSystem");
            return (Criteria) this;
        }

        public Criteria andDemandSystemNotIn(List<String> values) {
            addCriterion("demand_system not in", values, "demandSystem");
            return (Criteria) this;
        }

        public Criteria andDemandSystemBetween(String value1, String value2) {
            addCriterion("demand_system between", value1, value2, "demandSystem");
            return (Criteria) this;
        }

        public Criteria andDemandSystemNotBetween(String value1, String value2) {
            addCriterion("demand_system not between", value1, value2, "demandSystem");
            return (Criteria) this;
        }

        public Criteria andDemandModuleIsNull() {
            addCriterion("demand_module is null");
            return (Criteria) this;
        }

        public Criteria andDemandModuleIsNotNull() {
            addCriterion("demand_module is not null");
            return (Criteria) this;
        }

        public Criteria andDemandModuleEqualTo(String value) {
            addCriterion("demand_module =", value, "demandModule");
            return (Criteria) this;
        }

        public Criteria andDemandModuleNotEqualTo(String value) {
            addCriterion("demand_module <>", value, "demandModule");
            return (Criteria) this;
        }

        public Criteria andDemandModuleGreaterThan(String value) {
            addCriterion("demand_module >", value, "demandModule");
            return (Criteria) this;
        }

        public Criteria andDemandModuleGreaterThanOrEqualTo(String value) {
            addCriterion("demand_module >=", value, "demandModule");
            return (Criteria) this;
        }

        public Criteria andDemandModuleLessThan(String value) {
            addCriterion("demand_module <", value, "demandModule");
            return (Criteria) this;
        }

        public Criteria andDemandModuleLessThanOrEqualTo(String value) {
            addCriterion("demand_module <=", value, "demandModule");
            return (Criteria) this;
        }

        public Criteria andDemandModuleLike(String value) {
            addCriterion("demand_module like", value, "demandModule");
            return (Criteria) this;
        }

        public Criteria andDemandModuleNotLike(String value) {
            addCriterion("demand_module not like", value, "demandModule");
            return (Criteria) this;
        }

        public Criteria andDemandModuleIn(List<String> values) {
            addCriterion("demand_module in", values, "demandModule");
            return (Criteria) this;
        }

        public Criteria andDemandModuleNotIn(List<String> values) {
            addCriterion("demand_module not in", values, "demandModule");
            return (Criteria) this;
        }

        public Criteria andDemandModuleBetween(String value1, String value2) {
            addCriterion("demand_module between", value1, value2, "demandModule");
            return (Criteria) this;
        }

        public Criteria andDemandModuleNotBetween(String value1, String value2) {
            addCriterion("demand_module not between", value1, value2, "demandModule");
            return (Criteria) this;
        }

        public Criteria andDemandProgressIsNull() {
            addCriterion("demand_progress is null");
            return (Criteria) this;
        }

        public Criteria andDemandProgressIsNotNull() {
            addCriterion("demand_progress is not null");
            return (Criteria) this;
        }

        public Criteria andDemandProgressEqualTo(String value) {
            addCriterion("demand_progress =", value, "demandProgress");
            return (Criteria) this;
        }

        public Criteria andDemandProgressNotEqualTo(String value) {
            addCriterion("demand_progress <>", value, "demandProgress");
            return (Criteria) this;
        }

        public Criteria andDemandProgressGreaterThan(String value) {
            addCriterion("demand_progress >", value, "demandProgress");
            return (Criteria) this;
        }

        public Criteria andDemandProgressGreaterThanOrEqualTo(String value) {
            addCriterion("demand_progress >=", value, "demandProgress");
            return (Criteria) this;
        }

        public Criteria andDemandProgressLessThan(String value) {
            addCriterion("demand_progress <", value, "demandProgress");
            return (Criteria) this;
        }

        public Criteria andDemandProgressLessThanOrEqualTo(String value) {
            addCriterion("demand_progress <=", value, "demandProgress");
            return (Criteria) this;
        }

        public Criteria andDemandProgressLike(String value) {
            addCriterion("demand_progress like", value, "demandProgress");
            return (Criteria) this;
        }

        public Criteria andDemandProgressNotLike(String value) {
            addCriterion("demand_progress not like", value, "demandProgress");
            return (Criteria) this;
        }

        public Criteria andDemandProgressIn(List<String> values) {
            addCriterion("demand_progress in", values, "demandProgress");
            return (Criteria) this;
        }

        public Criteria andDemandProgressNotIn(List<String> values) {
            addCriterion("demand_progress not in", values, "demandProgress");
            return (Criteria) this;
        }

        public Criteria andDemandProgressBetween(String value1, String value2) {
            addCriterion("demand_progress between", value1, value2, "demandProgress");
            return (Criteria) this;
        }

        public Criteria andDemandProgressNotBetween(String value1, String value2) {
            addCriterion("demand_progress not between", value1, value2, "demandProgress");
            return (Criteria) this;
        }

        public Criteria andVersionNumIsNull() {
            addCriterion("version_num is null");
            return (Criteria) this;
        }

        public Criteria andVersionNumIsNotNull() {
            addCriterion("version_num is not null");
            return (Criteria) this;
        }

        public Criteria andVersionNumEqualTo(String value) {
            addCriterion("version_num =", value, "versionNum");
            return (Criteria) this;
        }

        public Criteria andVersionNumNotEqualTo(String value) {
            addCriterion("version_num <>", value, "versionNum");
            return (Criteria) this;
        }

        public Criteria andVersionNumGreaterThan(String value) {
            addCriterion("version_num >", value, "versionNum");
            return (Criteria) this;
        }

        public Criteria andVersionNumGreaterThanOrEqualTo(String value) {
            addCriterion("version_num >=", value, "versionNum");
            return (Criteria) this;
        }

        public Criteria andVersionNumLessThan(String value) {
            addCriterion("version_num <", value, "versionNum");
            return (Criteria) this;
        }

        public Criteria andVersionNumLessThanOrEqualTo(String value) {
            addCriterion("version_num <=", value, "versionNum");
            return (Criteria) this;
        }

        public Criteria andVersionNumLike(String value) {
            addCriterion("version_num like", value, "versionNum");
            return (Criteria) this;
        }

        public Criteria andVersionNumNotLike(String value) {
            addCriterion("version_num not like", value, "versionNum");
            return (Criteria) this;
        }

        public Criteria andVersionNumIn(List<String> values) {
            addCriterion("version_num in", values, "versionNum");
            return (Criteria) this;
        }

        public Criteria andVersionNumNotIn(List<String> values) {
            addCriterion("version_num not in", values, "versionNum");
            return (Criteria) this;
        }

        public Criteria andVersionNumBetween(String value1, String value2) {
            addCriterion("version_num between", value1, value2, "versionNum");
            return (Criteria) this;
        }

        public Criteria andVersionNumNotBetween(String value1, String value2) {
            addCriterion("version_num not between", value1, value2, "versionNum");
            return (Criteria) this;
        }

        public Criteria andDemandRespoIdIsNull() {
            addCriterion("demand_respo_id is null");
            return (Criteria) this;
        }

        public Criteria andDemandRespoIdIsNotNull() {
            addCriterion("demand_respo_id is not null");
            return (Criteria) this;
        }

        public Criteria andDemandRespoIdEqualTo(String value) {
            addCriterion("demand_respo_id =", value, "demandRespoId");
            return (Criteria) this;
        }

        public Criteria andDemandRespoIdNotEqualTo(String value) {
            addCriterion("demand_respo_id <>", value, "demandRespoId");
            return (Criteria) this;
        }

        public Criteria andDemandRespoIdGreaterThan(String value) {
            addCriterion("demand_respo_id >", value, "demandRespoId");
            return (Criteria) this;
        }

        public Criteria andDemandRespoIdGreaterThanOrEqualTo(String value) {
            addCriterion("demand_respo_id >=", value, "demandRespoId");
            return (Criteria) this;
        }

        public Criteria andDemandRespoIdLessThan(String value) {
            addCriterion("demand_respo_id <", value, "demandRespoId");
            return (Criteria) this;
        }

        public Criteria andDemandRespoIdLessThanOrEqualTo(String value) {
            addCriterion("demand_respo_id <=", value, "demandRespoId");
            return (Criteria) this;
        }

        public Criteria andDemandRespoIdLike(String value) {
            addCriterion("demand_respo_id like", value, "demandRespoId");
            return (Criteria) this;
        }

        public Criteria andDemandRespoIdNotLike(String value) {
            addCriterion("demand_respo_id not like", value, "demandRespoId");
            return (Criteria) this;
        }

        public Criteria andDemandRespoIdIn(List<String> values) {
            addCriterion("demand_respo_id in", values, "demandRespoId");
            return (Criteria) this;
        }

        public Criteria andDemandRespoIdNotIn(List<String> values) {
            addCriterion("demand_respo_id not in", values, "demandRespoId");
            return (Criteria) this;
        }

        public Criteria andDemandRespoIdBetween(String value1, String value2) {
            addCriterion("demand_respo_id between", value1, value2, "demandRespoId");
            return (Criteria) this;
        }

        public Criteria andDemandRespoIdNotBetween(String value1, String value2) {
            addCriterion("demand_respo_id not between", value1, value2, "demandRespoId");
            return (Criteria) this;
        }

        public Criteria andDemandNameIsNull() {
            addCriterion("demand_name is null");
            return (Criteria) this;
        }

        public Criteria andDemandNameIsNotNull() {
            addCriterion("demand_name is not null");
            return (Criteria) this;
        }

        public Criteria andDemandNameEqualTo(String value) {
            addCriterion("demand_name =", value, "demandName");
            return (Criteria) this;
        }

        public Criteria andDemandNameNotEqualTo(String value) {
            addCriterion("demand_name <>", value, "demandName");
            return (Criteria) this;
        }

        public Criteria andDemandNameGreaterThan(String value) {
            addCriterion("demand_name >", value, "demandName");
            return (Criteria) this;
        }

        public Criteria andDemandNameGreaterThanOrEqualTo(String value) {
            addCriterion("demand_name >=", value, "demandName");
            return (Criteria) this;
        }

        public Criteria andDemandNameLessThan(String value) {
            addCriterion("demand_name <", value, "demandName");
            return (Criteria) this;
        }

        public Criteria andDemandNameLessThanOrEqualTo(String value) {
            addCriterion("demand_name <=", value, "demandName");
            return (Criteria) this;
        }

        public Criteria andDemandNameLike(String value) {
            addCriterion("demand_name like", value, "demandName");
            return (Criteria) this;
        }

        public Criteria andDemandNameNotLike(String value) {
            addCriterion("demand_name not like", value, "demandName");
            return (Criteria) this;
        }

        public Criteria andDemandNameIn(List<String> values) {
            addCriterion("demand_name in", values, "demandName");
            return (Criteria) this;
        }

        public Criteria andDemandNameNotIn(List<String> values) {
            addCriterion("demand_name not in", values, "demandName");
            return (Criteria) this;
        }

        public Criteria andDemandNameBetween(String value1, String value2) {
            addCriterion("demand_name between", value1, value2, "demandName");
            return (Criteria) this;
        }

        public Criteria andDemandNameNotBetween(String value1, String value2) {
            addCriterion("demand_name not between", value1, value2, "demandName");
            return (Criteria) this;
        }

        public Criteria andDemandDesIsNull() {
            addCriterion("demand_des is null");
            return (Criteria) this;
        }

        public Criteria andDemandDesIsNotNull() {
            addCriterion("demand_des is not null");
            return (Criteria) this;
        }

        public Criteria andDemandDesEqualTo(String value) {
            addCriterion("demand_des =", value, "demandDes");
            return (Criteria) this;
        }

        public Criteria andDemandDesNotEqualTo(String value) {
            addCriterion("demand_des <>", value, "demandDes");
            return (Criteria) this;
        }

        public Criteria andDemandDesGreaterThan(String value) {
            addCriterion("demand_des >", value, "demandDes");
            return (Criteria) this;
        }

        public Criteria andDemandDesGreaterThanOrEqualTo(String value) {
            addCriterion("demand_des >=", value, "demandDes");
            return (Criteria) this;
        }

        public Criteria andDemandDesLessThan(String value) {
            addCriterion("demand_des <", value, "demandDes");
            return (Criteria) this;
        }

        public Criteria andDemandDesLessThanOrEqualTo(String value) {
            addCriterion("demand_des <=", value, "demandDes");
            return (Criteria) this;
        }

        public Criteria andDemandDesLike(String value) {
            addCriterion("demand_des like", value, "demandDes");
            return (Criteria) this;
        }

        public Criteria andDemandDesNotLike(String value) {
            addCriterion("demand_des not like", value, "demandDes");
            return (Criteria) this;
        }

        public Criteria andDemandDesIn(List<String> values) {
            addCriterion("demand_des in", values, "demandDes");
            return (Criteria) this;
        }

        public Criteria andDemandDesNotIn(List<String> values) {
            addCriterion("demand_des not in", values, "demandDes");
            return (Criteria) this;
        }

        public Criteria andDemandDesBetween(String value1, String value2) {
            addCriterion("demand_des between", value1, value2, "demandDes");
            return (Criteria) this;
        }

        public Criteria andDemandDesNotBetween(String value1, String value2) {
            addCriterion("demand_des not between", value1, value2, "demandDes");
            return (Criteria) this;
        }

        public Criteria andDemandStatIsNull() {
            addCriterion("demand_stat is null");
            return (Criteria) this;
        }

        public Criteria andDemandStatIsNotNull() {
            addCriterion("demand_stat is not null");
            return (Criteria) this;
        }

        public Criteria andDemandStatEqualTo(String value) {
            addCriterion("demand_stat =", value, "demandStat");
            return (Criteria) this;
        }

        public Criteria andDemandStatNotEqualTo(String value) {
            addCriterion("demand_stat <>", value, "demandStat");
            return (Criteria) this;
        }

        public Criteria andDemandStatGreaterThan(String value) {
            addCriterion("demand_stat >", value, "demandStat");
            return (Criteria) this;
        }

        public Criteria andDemandStatGreaterThanOrEqualTo(String value) {
            addCriterion("demand_stat >=", value, "demandStat");
            return (Criteria) this;
        }

        public Criteria andDemandStatLessThan(String value) {
            addCriterion("demand_stat <", value, "demandStat");
            return (Criteria) this;
        }

        public Criteria andDemandStatLessThanOrEqualTo(String value) {
            addCriterion("demand_stat <=", value, "demandStat");
            return (Criteria) this;
        }

        public Criteria andDemandStatLike(String value) {
            addCriterion("demand_stat like", value, "demandStat");
            return (Criteria) this;
        }

        public Criteria andDemandStatNotLike(String value) {
            addCriterion("demand_stat not like", value, "demandStat");
            return (Criteria) this;
        }

        public Criteria andDemandStatIn(List<String> values) {
            addCriterion("demand_stat in", values, "demandStat");
            return (Criteria) this;
        }

        public Criteria andDemandStatNotIn(List<String> values) {
            addCriterion("demand_stat not in", values, "demandStat");
            return (Criteria) this;
        }

        public Criteria andDemandStatBetween(String value1, String value2) {
            addCriterion("demand_stat between", value1, value2, "demandStat");
            return (Criteria) this;
        }

        public Criteria andDemandStatNotBetween(String value1, String value2) {
            addCriterion("demand_stat not between", value1, value2, "demandStat");
            return (Criteria) this;
        }

        public Criteria andLeadDateIsNull() {
            addCriterion("lead_date is null");
            return (Criteria) this;
        }

        public Criteria andLeadDateIsNotNull() {
            addCriterion("lead_date is not null");
            return (Criteria) this;
        }

        public Criteria andLeadDateEqualTo(Date value) {
            addCriterionForJDBCDate("lead_date =", value, "leadDate");
            return (Criteria) this;
        }

        public Criteria andLeadDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("lead_date <>", value, "leadDate");
            return (Criteria) this;
        }

        public Criteria andLeadDateGreaterThan(Date value) {
            addCriterionForJDBCDate("lead_date >", value, "leadDate");
            return (Criteria) this;
        }

        public Criteria andLeadDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("lead_date >=", value, "leadDate");
            return (Criteria) this;
        }

        public Criteria andLeadDateLessThan(Date value) {
            addCriterionForJDBCDate("lead_date <", value, "leadDate");
            return (Criteria) this;
        }

        public Criteria andLeadDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("lead_date <=", value, "leadDate");
            return (Criteria) this;
        }

        public Criteria andLeadDateIn(List<Date> values) {
            addCriterionForJDBCDate("lead_date in", values, "leadDate");
            return (Criteria) this;
        }

        public Criteria andLeadDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("lead_date not in", values, "leadDate");
            return (Criteria) this;
        }

        public Criteria andLeadDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("lead_date between", value1, value2, "leadDate");
            return (Criteria) this;
        }

        public Criteria andLeadDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("lead_date not between", value1, value2, "leadDate");
            return (Criteria) this;
        }

        public Criteria andPlannedFinishDateIsNull() {
            addCriterion("planned_finish_date is null");
            return (Criteria) this;
        }

        public Criteria andPlannedFinishDateIsNotNull() {
            addCriterion("planned_finish_date is not null");
            return (Criteria) this;
        }

        public Criteria andPlannedFinishDateEqualTo(Date value) {
            addCriterionForJDBCDate("planned_finish_date =", value, "plannedFinishDate");
            return (Criteria) this;
        }

        public Criteria andPlannedFinishDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("planned_finish_date <>", value, "plannedFinishDate");
            return (Criteria) this;
        }

        public Criteria andPlannedFinishDateGreaterThan(Date value) {
            addCriterionForJDBCDate("planned_finish_date >", value, "plannedFinishDate");
            return (Criteria) this;
        }

        public Criteria andPlannedFinishDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("planned_finish_date >=", value, "plannedFinishDate");
            return (Criteria) this;
        }

        public Criteria andPlannedFinishDateLessThan(Date value) {
            addCriterionForJDBCDate("planned_finish_date <", value, "plannedFinishDate");
            return (Criteria) this;
        }

        public Criteria andPlannedFinishDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("planned_finish_date <=", value, "plannedFinishDate");
            return (Criteria) this;
        }

        public Criteria andPlannedFinishDateIn(List<Date> values) {
            addCriterionForJDBCDate("planned_finish_date in", values, "plannedFinishDate");
            return (Criteria) this;
        }

        public Criteria andPlannedFinishDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("planned_finish_date not in", values, "plannedFinishDate");
            return (Criteria) this;
        }

        public Criteria andPlannedFinishDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("planned_finish_date between", value1, value2, "plannedFinishDate");
            return (Criteria) this;
        }

        public Criteria andPlannedFinishDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("planned_finish_date not between", value1, value2, "plannedFinishDate");
            return (Criteria) this;
        }

        public Criteria andActualFinishDateIsNull() {
            addCriterion("actual_finish_date is null");
            return (Criteria) this;
        }

        public Criteria andActualFinishDateIsNotNull() {
            addCriterion("actual_finish_date is not null");
            return (Criteria) this;
        }

        public Criteria andActualFinishDateEqualTo(Date value) {
            addCriterionForJDBCDate("actual_finish_date =", value, "actualFinishDate");
            return (Criteria) this;
        }

        public Criteria andActualFinishDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("actual_finish_date <>", value, "actualFinishDate");
            return (Criteria) this;
        }

        public Criteria andActualFinishDateGreaterThan(Date value) {
            addCriterionForJDBCDate("actual_finish_date >", value, "actualFinishDate");
            return (Criteria) this;
        }

        public Criteria andActualFinishDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("actual_finish_date >=", value, "actualFinishDate");
            return (Criteria) this;
        }

        public Criteria andActualFinishDateLessThan(Date value) {
            addCriterionForJDBCDate("actual_finish_date <", value, "actualFinishDate");
            return (Criteria) this;
        }

        public Criteria andActualFinishDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("actual_finish_date <=", value, "actualFinishDate");
            return (Criteria) this;
        }

        public Criteria andActualFinishDateIn(List<Date> values) {
            addCriterionForJDBCDate("actual_finish_date in", values, "actualFinishDate");
            return (Criteria) this;
        }

        public Criteria andActualFinishDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("actual_finish_date not in", values, "actualFinishDate");
            return (Criteria) this;
        }

        public Criteria andActualFinishDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("actual_finish_date between", value1, value2, "actualFinishDate");
            return (Criteria) this;
        }

        public Criteria andActualFinishDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("actual_finish_date not between", value1, value2, "actualFinishDate");
            return (Criteria) this;
        }

        public Criteria andPlannedOnlineDateIsNull() {
            addCriterion("planned_online_date is null");
            return (Criteria) this;
        }

        public Criteria andPlannedOnlineDateIsNotNull() {
            addCriterion("planned_online_date is not null");
            return (Criteria) this;
        }

        public Criteria andPlannedOnlineDateEqualTo(Date value) {
            addCriterionForJDBCDate("planned_online_date =", value, "plannedOnlineDate");
            return (Criteria) this;
        }

        public Criteria andPlannedOnlineDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("planned_online_date <>", value, "plannedOnlineDate");
            return (Criteria) this;
        }

        public Criteria andPlannedOnlineDateGreaterThan(Date value) {
            addCriterionForJDBCDate("planned_online_date >", value, "plannedOnlineDate");
            return (Criteria) this;
        }

        public Criteria andPlannedOnlineDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("planned_online_date >=", value, "plannedOnlineDate");
            return (Criteria) this;
        }

        public Criteria andPlannedOnlineDateLessThan(Date value) {
            addCriterionForJDBCDate("planned_online_date <", value, "plannedOnlineDate");
            return (Criteria) this;
        }

        public Criteria andPlannedOnlineDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("planned_online_date <=", value, "plannedOnlineDate");
            return (Criteria) this;
        }

        public Criteria andPlannedOnlineDateIn(List<Date> values) {
            addCriterionForJDBCDate("planned_online_date in", values, "plannedOnlineDate");
            return (Criteria) this;
        }

        public Criteria andPlannedOnlineDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("planned_online_date not in", values, "plannedOnlineDate");
            return (Criteria) this;
        }

        public Criteria andPlannedOnlineDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("planned_online_date between", value1, value2, "plannedOnlineDate");
            return (Criteria) this;
        }

        public Criteria andPlannedOnlineDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("planned_online_date not between", value1, value2, "plannedOnlineDate");
            return (Criteria) this;
        }

        public Criteria andActualOnlineDateIsNull() {
            addCriterion("actual_online_date is null");
            return (Criteria) this;
        }

        public Criteria andActualOnlineDateIsNotNull() {
            addCriterion("actual_online_date is not null");
            return (Criteria) this;
        }

        public Criteria andActualOnlineDateEqualTo(Date value) {
            addCriterionForJDBCDate("actual_online_date =", value, "actualOnlineDate");
            return (Criteria) this;
        }

        public Criteria andActualOnlineDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("actual_online_date <>", value, "actualOnlineDate");
            return (Criteria) this;
        }

        public Criteria andActualOnlineDateGreaterThan(Date value) {
            addCriterionForJDBCDate("actual_online_date >", value, "actualOnlineDate");
            return (Criteria) this;
        }

        public Criteria andActualOnlineDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("actual_online_date >=", value, "actualOnlineDate");
            return (Criteria) this;
        }

        public Criteria andActualOnlineDateLessThan(Date value) {
            addCriterionForJDBCDate("actual_online_date <", value, "actualOnlineDate");
            return (Criteria) this;
        }

        public Criteria andActualOnlineDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("actual_online_date <=", value, "actualOnlineDate");
            return (Criteria) this;
        }

        public Criteria andActualOnlineDateIn(List<Date> values) {
            addCriterionForJDBCDate("actual_online_date in", values, "actualOnlineDate");
            return (Criteria) this;
        }

        public Criteria andActualOnlineDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("actual_online_date not in", values, "actualOnlineDate");
            return (Criteria) this;
        }

        public Criteria andActualOnlineDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("actual_online_date between", value1, value2, "actualOnlineDate");
            return (Criteria) this;
        }

        public Criteria andActualOnlineDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("actual_online_date not between", value1, value2, "actualOnlineDate");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNull() {
            addCriterion("priority is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("priority is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(String value) {
            addCriterion("priority =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(String value) {
            addCriterion("priority <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(String value) {
            addCriterion("priority >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(String value) {
            addCriterion("priority >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(String value) {
            addCriterion("priority <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(String value) {
            addCriterion("priority <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLike(String value) {
            addCriterion("priority like", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotLike(String value) {
            addCriterion("priority not like", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<String> values) {
            addCriterion("priority in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<String> values) {
            addCriterion("priority not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(String value1, String value2) {
            addCriterion("priority between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(String value1, String value2) {
            addCriterion("priority not between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andWorkloadIsNull() {
            addCriterion("workload is null");
            return (Criteria) this;
        }

        public Criteria andWorkloadIsNotNull() {
            addCriterion("workload is not null");
            return (Criteria) this;
        }

        public Criteria andWorkloadEqualTo(String value) {
            addCriterion("workload =", value, "workload");
            return (Criteria) this;
        }

        public Criteria andWorkloadNotEqualTo(String value) {
            addCriterion("workload <>", value, "workload");
            return (Criteria) this;
        }

        public Criteria andWorkloadGreaterThan(String value) {
            addCriterion("workload >", value, "workload");
            return (Criteria) this;
        }

        public Criteria andWorkloadGreaterThanOrEqualTo(String value) {
            addCriterion("workload >=", value, "workload");
            return (Criteria) this;
        }

        public Criteria andWorkloadLessThan(String value) {
            addCriterion("workload <", value, "workload");
            return (Criteria) this;
        }

        public Criteria andWorkloadLessThanOrEqualTo(String value) {
            addCriterion("workload <=", value, "workload");
            return (Criteria) this;
        }

        public Criteria andWorkloadLike(String value) {
            addCriterion("workload like", value, "workload");
            return (Criteria) this;
        }

        public Criteria andWorkloadNotLike(String value) {
            addCriterion("workload not like", value, "workload");
            return (Criteria) this;
        }

        public Criteria andWorkloadIn(List<String> values) {
            addCriterion("workload in", values, "workload");
            return (Criteria) this;
        }

        public Criteria andWorkloadNotIn(List<String> values) {
            addCriterion("workload not in", values, "workload");
            return (Criteria) this;
        }

        public Criteria andWorkloadBetween(String value1, String value2) {
            addCriterion("workload between", value1, value2, "workload");
            return (Criteria) this;
        }

        public Criteria andWorkloadNotBetween(String value1, String value2) {
            addCriterion("workload not between", value1, value2, "workload");
            return (Criteria) this;
        }

        public Criteria andWorkloadConfirmIsNull() {
            addCriterion("workload_confirm is null");
            return (Criteria) this;
        }

        public Criteria andWorkloadConfirmIsNotNull() {
            addCriterion("workload_confirm is not null");
            return (Criteria) this;
        }

        public Criteria andWorkloadConfirmEqualTo(String value) {
            addCriterion("workload_confirm =", value, "workloadConfirm");
            return (Criteria) this;
        }

        public Criteria andWorkloadConfirmNotEqualTo(String value) {
            addCriterion("workload_confirm <>", value, "workloadConfirm");
            return (Criteria) this;
        }

        public Criteria andWorkloadConfirmGreaterThan(String value) {
            addCriterion("workload_confirm >", value, "workloadConfirm");
            return (Criteria) this;
        }

        public Criteria andWorkloadConfirmGreaterThanOrEqualTo(String value) {
            addCriterion("workload_confirm >=", value, "workloadConfirm");
            return (Criteria) this;
        }

        public Criteria andWorkloadConfirmLessThan(String value) {
            addCriterion("workload_confirm <", value, "workloadConfirm");
            return (Criteria) this;
        }

        public Criteria andWorkloadConfirmLessThanOrEqualTo(String value) {
            addCriterion("workload_confirm <=", value, "workloadConfirm");
            return (Criteria) this;
        }

        public Criteria andWorkloadConfirmLike(String value) {
            addCriterion("workload_confirm like", value, "workloadConfirm");
            return (Criteria) this;
        }

        public Criteria andWorkloadConfirmNotLike(String value) {
            addCriterion("workload_confirm not like", value, "workloadConfirm");
            return (Criteria) this;
        }

        public Criteria andWorkloadConfirmIn(List<String> values) {
            addCriterion("workload_confirm in", values, "workloadConfirm");
            return (Criteria) this;
        }

        public Criteria andWorkloadConfirmNotIn(List<String> values) {
            addCriterion("workload_confirm not in", values, "workloadConfirm");
            return (Criteria) this;
        }

        public Criteria andWorkloadConfirmBetween(String value1, String value2) {
            addCriterion("workload_confirm between", value1, value2, "workloadConfirm");
            return (Criteria) this;
        }

        public Criteria andWorkloadConfirmNotBetween(String value1, String value2) {
            addCriterion("workload_confirm not between", value1, value2, "workloadConfirm");
            return (Criteria) this;
        }

        public Criteria andSettlementSituationIsNull() {
            addCriterion("settlement_situation is null");
            return (Criteria) this;
        }

        public Criteria andSettlementSituationIsNotNull() {
            addCriterion("settlement_situation is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementSituationEqualTo(String value) {
            addCriterion("settlement_situation =", value, "settlementSituation");
            return (Criteria) this;
        }

        public Criteria andSettlementSituationNotEqualTo(String value) {
            addCriterion("settlement_situation <>", value, "settlementSituation");
            return (Criteria) this;
        }

        public Criteria andSettlementSituationGreaterThan(String value) {
            addCriterion("settlement_situation >", value, "settlementSituation");
            return (Criteria) this;
        }

        public Criteria andSettlementSituationGreaterThanOrEqualTo(String value) {
            addCriterion("settlement_situation >=", value, "settlementSituation");
            return (Criteria) this;
        }

        public Criteria andSettlementSituationLessThan(String value) {
            addCriterion("settlement_situation <", value, "settlementSituation");
            return (Criteria) this;
        }

        public Criteria andSettlementSituationLessThanOrEqualTo(String value) {
            addCriterion("settlement_situation <=", value, "settlementSituation");
            return (Criteria) this;
        }

        public Criteria andSettlementSituationLike(String value) {
            addCriterion("settlement_situation like", value, "settlementSituation");
            return (Criteria) this;
        }

        public Criteria andSettlementSituationNotLike(String value) {
            addCriterion("settlement_situation not like", value, "settlementSituation");
            return (Criteria) this;
        }

        public Criteria andSettlementSituationIn(List<String> values) {
            addCriterion("settlement_situation in", values, "settlementSituation");
            return (Criteria) this;
        }

        public Criteria andSettlementSituationNotIn(List<String> values) {
            addCriterion("settlement_situation not in", values, "settlementSituation");
            return (Criteria) this;
        }

        public Criteria andSettlementSituationBetween(String value1, String value2) {
            addCriterion("settlement_situation between", value1, value2, "settlementSituation");
            return (Criteria) this;
        }

        public Criteria andSettlementSituationNotBetween(String value1, String value2) {
            addCriterion("settlement_situation not between", value1, value2, "settlementSituation");
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