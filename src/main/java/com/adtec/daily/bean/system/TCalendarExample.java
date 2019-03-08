package com.adtec.daily.bean.system;

import java.util.ArrayList;
import java.util.List;

public class TCalendarExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TCalendarExample() {
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

        public Criteria andDDateIsNull() {
            addCriterion("d_date is null");
            return (Criteria) this;
        }

        public Criteria andDDateIsNotNull() {
            addCriterion("d_date is not null");
            return (Criteria) this;
        }

        public Criteria andDDateEqualTo(String value) {
            addCriterion("d_date =", value, "dDate");
            return (Criteria) this;
        }

        public Criteria andDDateNotEqualTo(String value) {
            addCriterion("d_date <>", value, "dDate");
            return (Criteria) this;
        }

        public Criteria andDDateGreaterThan(String value) {
            addCriterion("d_date >", value, "dDate");
            return (Criteria) this;
        }

        public Criteria andDDateGreaterThanOrEqualTo(String value) {
            addCriterion("d_date >=", value, "dDate");
            return (Criteria) this;
        }

        public Criteria andDDateLessThan(String value) {
            addCriterion("d_date <", value, "dDate");
            return (Criteria) this;
        }

        public Criteria andDDateLessThanOrEqualTo(String value) {
            addCriterion("d_date <=", value, "dDate");
            return (Criteria) this;
        }

        public Criteria andDDateLike(String value) {
            addCriterion("d_date like", value, "dDate");
            return (Criteria) this;
        }

        public Criteria andDDateNotLike(String value) {
            addCriterion("d_date not like", value, "dDate");
            return (Criteria) this;
        }

        public Criteria andDDateIn(List<String> values) {
            addCriterion("d_date in", values, "dDate");
            return (Criteria) this;
        }

        public Criteria andDDateNotIn(List<String> values) {
            addCriterion("d_date not in", values, "dDate");
            return (Criteria) this;
        }

        public Criteria andDDateBetween(String value1, String value2) {
            addCriterion("d_date between", value1, value2, "dDate");
            return (Criteria) this;
        }

        public Criteria andDDateNotBetween(String value1, String value2) {
            addCriterion("d_date not between", value1, value2, "dDate");
            return (Criteria) this;
        }

        public Criteria andCTypeIsNull() {
            addCriterion("c_type is null");
            return (Criteria) this;
        }

        public Criteria andCTypeIsNotNull() {
            addCriterion("c_type is not null");
            return (Criteria) this;
        }

        public Criteria andCTypeEqualTo(String value) {
            addCriterion("c_type =", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeNotEqualTo(String value) {
            addCriterion("c_type <>", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeGreaterThan(String value) {
            addCriterion("c_type >", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeGreaterThanOrEqualTo(String value) {
            addCriterion("c_type >=", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeLessThan(String value) {
            addCriterion("c_type <", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeLessThanOrEqualTo(String value) {
            addCriterion("c_type <=", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeLike(String value) {
            addCriterion("c_type like", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeNotLike(String value) {
            addCriterion("c_type not like", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeIn(List<String> values) {
            addCriterion("c_type in", values, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeNotIn(List<String> values) {
            addCriterion("c_type not in", values, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeBetween(String value1, String value2) {
            addCriterion("c_type between", value1, value2, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeNotBetween(String value1, String value2) {
            addCriterion("c_type not between", value1, value2, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypenameIsNull() {
            addCriterion("c_typename is null");
            return (Criteria) this;
        }

        public Criteria andCTypenameIsNotNull() {
            addCriterion("c_typename is not null");
            return (Criteria) this;
        }

        public Criteria andCTypenameEqualTo(String value) {
            addCriterion("c_typename =", value, "cTypename");
            return (Criteria) this;
        }

        public Criteria andCTypenameNotEqualTo(String value) {
            addCriterion("c_typename <>", value, "cTypename");
            return (Criteria) this;
        }

        public Criteria andCTypenameGreaterThan(String value) {
            addCriterion("c_typename >", value, "cTypename");
            return (Criteria) this;
        }

        public Criteria andCTypenameGreaterThanOrEqualTo(String value) {
            addCriterion("c_typename >=", value, "cTypename");
            return (Criteria) this;
        }

        public Criteria andCTypenameLessThan(String value) {
            addCriterion("c_typename <", value, "cTypename");
            return (Criteria) this;
        }

        public Criteria andCTypenameLessThanOrEqualTo(String value) {
            addCriterion("c_typename <=", value, "cTypename");
            return (Criteria) this;
        }

        public Criteria andCTypenameLike(String value) {
            addCriterion("c_typename like", value, "cTypename");
            return (Criteria) this;
        }

        public Criteria andCTypenameNotLike(String value) {
            addCriterion("c_typename not like", value, "cTypename");
            return (Criteria) this;
        }

        public Criteria andCTypenameIn(List<String> values) {
            addCriterion("c_typename in", values, "cTypename");
            return (Criteria) this;
        }

        public Criteria andCTypenameNotIn(List<String> values) {
            addCriterion("c_typename not in", values, "cTypename");
            return (Criteria) this;
        }

        public Criteria andCTypenameBetween(String value1, String value2) {
            addCriterion("c_typename between", value1, value2, "cTypename");
            return (Criteria) this;
        }

        public Criteria andCTypenameNotBetween(String value1, String value2) {
            addCriterion("c_typename not between", value1, value2, "cTypename");
            return (Criteria) this;
        }

        public Criteria andCYearnameIsNull() {
            addCriterion("c_yearname is null");
            return (Criteria) this;
        }

        public Criteria andCYearnameIsNotNull() {
            addCriterion("c_yearname is not null");
            return (Criteria) this;
        }

        public Criteria andCYearnameEqualTo(String value) {
            addCriterion("c_yearname =", value, "cYearname");
            return (Criteria) this;
        }

        public Criteria andCYearnameNotEqualTo(String value) {
            addCriterion("c_yearname <>", value, "cYearname");
            return (Criteria) this;
        }

        public Criteria andCYearnameGreaterThan(String value) {
            addCriterion("c_yearname >", value, "cYearname");
            return (Criteria) this;
        }

        public Criteria andCYearnameGreaterThanOrEqualTo(String value) {
            addCriterion("c_yearname >=", value, "cYearname");
            return (Criteria) this;
        }

        public Criteria andCYearnameLessThan(String value) {
            addCriterion("c_yearname <", value, "cYearname");
            return (Criteria) this;
        }

        public Criteria andCYearnameLessThanOrEqualTo(String value) {
            addCriterion("c_yearname <=", value, "cYearname");
            return (Criteria) this;
        }

        public Criteria andCYearnameLike(String value) {
            addCriterion("c_yearname like", value, "cYearname");
            return (Criteria) this;
        }

        public Criteria andCYearnameNotLike(String value) {
            addCriterion("c_yearname not like", value, "cYearname");
            return (Criteria) this;
        }

        public Criteria andCYearnameIn(List<String> values) {
            addCriterion("c_yearname in", values, "cYearname");
            return (Criteria) this;
        }

        public Criteria andCYearnameNotIn(List<String> values) {
            addCriterion("c_yearname not in", values, "cYearname");
            return (Criteria) this;
        }

        public Criteria andCYearnameBetween(String value1, String value2) {
            addCriterion("c_yearname between", value1, value2, "cYearname");
            return (Criteria) this;
        }

        public Criteria andCYearnameNotBetween(String value1, String value2) {
            addCriterion("c_yearname not between", value1, value2, "cYearname");
            return (Criteria) this;
        }

        public Criteria andCNonglicnIsNull() {
            addCriterion("c_nonglicn is null");
            return (Criteria) this;
        }

        public Criteria andCNonglicnIsNotNull() {
            addCriterion("c_nonglicn is not null");
            return (Criteria) this;
        }

        public Criteria andCNonglicnEqualTo(String value) {
            addCriterion("c_nonglicn =", value, "cNonglicn");
            return (Criteria) this;
        }

        public Criteria andCNonglicnNotEqualTo(String value) {
            addCriterion("c_nonglicn <>", value, "cNonglicn");
            return (Criteria) this;
        }

        public Criteria andCNonglicnGreaterThan(String value) {
            addCriterion("c_nonglicn >", value, "cNonglicn");
            return (Criteria) this;
        }

        public Criteria andCNonglicnGreaterThanOrEqualTo(String value) {
            addCriterion("c_nonglicn >=", value, "cNonglicn");
            return (Criteria) this;
        }

        public Criteria andCNonglicnLessThan(String value) {
            addCriterion("c_nonglicn <", value, "cNonglicn");
            return (Criteria) this;
        }

        public Criteria andCNonglicnLessThanOrEqualTo(String value) {
            addCriterion("c_nonglicn <=", value, "cNonglicn");
            return (Criteria) this;
        }

        public Criteria andCNonglicnLike(String value) {
            addCriterion("c_nonglicn like", value, "cNonglicn");
            return (Criteria) this;
        }

        public Criteria andCNonglicnNotLike(String value) {
            addCriterion("c_nonglicn not like", value, "cNonglicn");
            return (Criteria) this;
        }

        public Criteria andCNonglicnIn(List<String> values) {
            addCriterion("c_nonglicn in", values, "cNonglicn");
            return (Criteria) this;
        }

        public Criteria andCNonglicnNotIn(List<String> values) {
            addCriterion("c_nonglicn not in", values, "cNonglicn");
            return (Criteria) this;
        }

        public Criteria andCNonglicnBetween(String value1, String value2) {
            addCriterion("c_nonglicn between", value1, value2, "cNonglicn");
            return (Criteria) this;
        }

        public Criteria andCNonglicnNotBetween(String value1, String value2) {
            addCriterion("c_nonglicn not between", value1, value2, "cNonglicn");
            return (Criteria) this;
        }

        public Criteria andCNongliIsNull() {
            addCriterion("c_nongli is null");
            return (Criteria) this;
        }

        public Criteria andCNongliIsNotNull() {
            addCriterion("c_nongli is not null");
            return (Criteria) this;
        }

        public Criteria andCNongliEqualTo(String value) {
            addCriterion("c_nongli =", value, "cNongli");
            return (Criteria) this;
        }

        public Criteria andCNongliNotEqualTo(String value) {
            addCriterion("c_nongli <>", value, "cNongli");
            return (Criteria) this;
        }

        public Criteria andCNongliGreaterThan(String value) {
            addCriterion("c_nongli >", value, "cNongli");
            return (Criteria) this;
        }

        public Criteria andCNongliGreaterThanOrEqualTo(String value) {
            addCriterion("c_nongli >=", value, "cNongli");
            return (Criteria) this;
        }

        public Criteria andCNongliLessThan(String value) {
            addCriterion("c_nongli <", value, "cNongli");
            return (Criteria) this;
        }

        public Criteria andCNongliLessThanOrEqualTo(String value) {
            addCriterion("c_nongli <=", value, "cNongli");
            return (Criteria) this;
        }

        public Criteria andCNongliLike(String value) {
            addCriterion("c_nongli like", value, "cNongli");
            return (Criteria) this;
        }

        public Criteria andCNongliNotLike(String value) {
            addCriterion("c_nongli not like", value, "cNongli");
            return (Criteria) this;
        }

        public Criteria andCNongliIn(List<String> values) {
            addCriterion("c_nongli in", values, "cNongli");
            return (Criteria) this;
        }

        public Criteria andCNongliNotIn(List<String> values) {
            addCriterion("c_nongli not in", values, "cNongli");
            return (Criteria) this;
        }

        public Criteria andCNongliBetween(String value1, String value2) {
            addCriterion("c_nongli between", value1, value2, "cNongli");
            return (Criteria) this;
        }

        public Criteria andCNongliNotBetween(String value1, String value2) {
            addCriterion("c_nongli not between", value1, value2, "cNongli");
            return (Criteria) this;
        }

        public Criteria andCAnimalsYearIsNull() {
            addCriterion("c_animals_year is null");
            return (Criteria) this;
        }

        public Criteria andCAnimalsYearIsNotNull() {
            addCriterion("c_animals_year is not null");
            return (Criteria) this;
        }

        public Criteria andCAnimalsYearEqualTo(String value) {
            addCriterion("c_animals_year =", value, "cAnimalsYear");
            return (Criteria) this;
        }

        public Criteria andCAnimalsYearNotEqualTo(String value) {
            addCriterion("c_animals_year <>", value, "cAnimalsYear");
            return (Criteria) this;
        }

        public Criteria andCAnimalsYearGreaterThan(String value) {
            addCriterion("c_animals_year >", value, "cAnimalsYear");
            return (Criteria) this;
        }

        public Criteria andCAnimalsYearGreaterThanOrEqualTo(String value) {
            addCriterion("c_animals_year >=", value, "cAnimalsYear");
            return (Criteria) this;
        }

        public Criteria andCAnimalsYearLessThan(String value) {
            addCriterion("c_animals_year <", value, "cAnimalsYear");
            return (Criteria) this;
        }

        public Criteria andCAnimalsYearLessThanOrEqualTo(String value) {
            addCriterion("c_animals_year <=", value, "cAnimalsYear");
            return (Criteria) this;
        }

        public Criteria andCAnimalsYearLike(String value) {
            addCriterion("c_animals_year like", value, "cAnimalsYear");
            return (Criteria) this;
        }

        public Criteria andCAnimalsYearNotLike(String value) {
            addCriterion("c_animals_year not like", value, "cAnimalsYear");
            return (Criteria) this;
        }

        public Criteria andCAnimalsYearIn(List<String> values) {
            addCriterion("c_animals_year in", values, "cAnimalsYear");
            return (Criteria) this;
        }

        public Criteria andCAnimalsYearNotIn(List<String> values) {
            addCriterion("c_animals_year not in", values, "cAnimalsYear");
            return (Criteria) this;
        }

        public Criteria andCAnimalsYearBetween(String value1, String value2) {
            addCriterion("c_animals_year between", value1, value2, "cAnimalsYear");
            return (Criteria) this;
        }

        public Criteria andCAnimalsYearNotBetween(String value1, String value2) {
            addCriterion("c_animals_year not between", value1, value2, "cAnimalsYear");
            return (Criteria) this;
        }

        public Criteria andCThrottleIsNull() {
            addCriterion("c_throttle is null");
            return (Criteria) this;
        }

        public Criteria andCThrottleIsNotNull() {
            addCriterion("c_throttle is not null");
            return (Criteria) this;
        }

        public Criteria andCThrottleEqualTo(String value) {
            addCriterion("c_throttle =", value, "cThrottle");
            return (Criteria) this;
        }

        public Criteria andCThrottleNotEqualTo(String value) {
            addCriterion("c_throttle <>", value, "cThrottle");
            return (Criteria) this;
        }

        public Criteria andCThrottleGreaterThan(String value) {
            addCriterion("c_throttle >", value, "cThrottle");
            return (Criteria) this;
        }

        public Criteria andCThrottleGreaterThanOrEqualTo(String value) {
            addCriterion("c_throttle >=", value, "cThrottle");
            return (Criteria) this;
        }

        public Criteria andCThrottleLessThan(String value) {
            addCriterion("c_throttle <", value, "cThrottle");
            return (Criteria) this;
        }

        public Criteria andCThrottleLessThanOrEqualTo(String value) {
            addCriterion("c_throttle <=", value, "cThrottle");
            return (Criteria) this;
        }

        public Criteria andCThrottleLike(String value) {
            addCriterion("c_throttle like", value, "cThrottle");
            return (Criteria) this;
        }

        public Criteria andCThrottleNotLike(String value) {
            addCriterion("c_throttle not like", value, "cThrottle");
            return (Criteria) this;
        }

        public Criteria andCThrottleIn(List<String> values) {
            addCriterion("c_throttle in", values, "cThrottle");
            return (Criteria) this;
        }

        public Criteria andCThrottleNotIn(List<String> values) {
            addCriterion("c_throttle not in", values, "cThrottle");
            return (Criteria) this;
        }

        public Criteria andCThrottleBetween(String value1, String value2) {
            addCriterion("c_throttle between", value1, value2, "cThrottle");
            return (Criteria) this;
        }

        public Criteria andCThrottleNotBetween(String value1, String value2) {
            addCriterion("c_throttle not between", value1, value2, "cThrottle");
            return (Criteria) this;
        }

        public Criteria andCWeekcnIsNull() {
            addCriterion("c_weekcn is null");
            return (Criteria) this;
        }

        public Criteria andCWeekcnIsNotNull() {
            addCriterion("c_weekcn is not null");
            return (Criteria) this;
        }

        public Criteria andCWeekcnEqualTo(String value) {
            addCriterion("c_weekcn =", value, "cWeekcn");
            return (Criteria) this;
        }

        public Criteria andCWeekcnNotEqualTo(String value) {
            addCriterion("c_weekcn <>", value, "cWeekcn");
            return (Criteria) this;
        }

        public Criteria andCWeekcnGreaterThan(String value) {
            addCriterion("c_weekcn >", value, "cWeekcn");
            return (Criteria) this;
        }

        public Criteria andCWeekcnGreaterThanOrEqualTo(String value) {
            addCriterion("c_weekcn >=", value, "cWeekcn");
            return (Criteria) this;
        }

        public Criteria andCWeekcnLessThan(String value) {
            addCriterion("c_weekcn <", value, "cWeekcn");
            return (Criteria) this;
        }

        public Criteria andCWeekcnLessThanOrEqualTo(String value) {
            addCriterion("c_weekcn <=", value, "cWeekcn");
            return (Criteria) this;
        }

        public Criteria andCWeekcnLike(String value) {
            addCriterion("c_weekcn like", value, "cWeekcn");
            return (Criteria) this;
        }

        public Criteria andCWeekcnNotLike(String value) {
            addCriterion("c_weekcn not like", value, "cWeekcn");
            return (Criteria) this;
        }

        public Criteria andCWeekcnIn(List<String> values) {
            addCriterion("c_weekcn in", values, "cWeekcn");
            return (Criteria) this;
        }

        public Criteria andCWeekcnNotIn(List<String> values) {
            addCriterion("c_weekcn not in", values, "cWeekcn");
            return (Criteria) this;
        }

        public Criteria andCWeekcnBetween(String value1, String value2) {
            addCriterion("c_weekcn between", value1, value2, "cWeekcn");
            return (Criteria) this;
        }

        public Criteria andCWeekcnNotBetween(String value1, String value2) {
            addCriterion("c_weekcn not between", value1, value2, "cWeekcn");
            return (Criteria) this;
        }

        public Criteria andCWeek1IsNull() {
            addCriterion("c_week1 is null");
            return (Criteria) this;
        }

        public Criteria andCWeek1IsNotNull() {
            addCriterion("c_week1 is not null");
            return (Criteria) this;
        }

        public Criteria andCWeek1EqualTo(String value) {
            addCriterion("c_week1 =", value, "cWeek1");
            return (Criteria) this;
        }

        public Criteria andCWeek1NotEqualTo(String value) {
            addCriterion("c_week1 <>", value, "cWeek1");
            return (Criteria) this;
        }

        public Criteria andCWeek1GreaterThan(String value) {
            addCriterion("c_week1 >", value, "cWeek1");
            return (Criteria) this;
        }

        public Criteria andCWeek1GreaterThanOrEqualTo(String value) {
            addCriterion("c_week1 >=", value, "cWeek1");
            return (Criteria) this;
        }

        public Criteria andCWeek1LessThan(String value) {
            addCriterion("c_week1 <", value, "cWeek1");
            return (Criteria) this;
        }

        public Criteria andCWeek1LessThanOrEqualTo(String value) {
            addCriterion("c_week1 <=", value, "cWeek1");
            return (Criteria) this;
        }

        public Criteria andCWeek1Like(String value) {
            addCriterion("c_week1 like", value, "cWeek1");
            return (Criteria) this;
        }

        public Criteria andCWeek1NotLike(String value) {
            addCriterion("c_week1 not like", value, "cWeek1");
            return (Criteria) this;
        }

        public Criteria andCWeek1In(List<String> values) {
            addCriterion("c_week1 in", values, "cWeek1");
            return (Criteria) this;
        }

        public Criteria andCWeek1NotIn(List<String> values) {
            addCriterion("c_week1 not in", values, "cWeek1");
            return (Criteria) this;
        }

        public Criteria andCWeek1Between(String value1, String value2) {
            addCriterion("c_week1 between", value1, value2, "cWeek1");
            return (Criteria) this;
        }

        public Criteria andCWeek1NotBetween(String value1, String value2) {
            addCriterion("c_week1 not between", value1, value2, "cWeek1");
            return (Criteria) this;
        }

        public Criteria andCWeek2IsNull() {
            addCriterion("c_week2 is null");
            return (Criteria) this;
        }

        public Criteria andCWeek2IsNotNull() {
            addCriterion("c_week2 is not null");
            return (Criteria) this;
        }

        public Criteria andCWeek2EqualTo(String value) {
            addCriterion("c_week2 =", value, "cWeek2");
            return (Criteria) this;
        }

        public Criteria andCWeek2NotEqualTo(String value) {
            addCriterion("c_week2 <>", value, "cWeek2");
            return (Criteria) this;
        }

        public Criteria andCWeek2GreaterThan(String value) {
            addCriterion("c_week2 >", value, "cWeek2");
            return (Criteria) this;
        }

        public Criteria andCWeek2GreaterThanOrEqualTo(String value) {
            addCriterion("c_week2 >=", value, "cWeek2");
            return (Criteria) this;
        }

        public Criteria andCWeek2LessThan(String value) {
            addCriterion("c_week2 <", value, "cWeek2");
            return (Criteria) this;
        }

        public Criteria andCWeek2LessThanOrEqualTo(String value) {
            addCriterion("c_week2 <=", value, "cWeek2");
            return (Criteria) this;
        }

        public Criteria andCWeek2Like(String value) {
            addCriterion("c_week2 like", value, "cWeek2");
            return (Criteria) this;
        }

        public Criteria andCWeek2NotLike(String value) {
            addCriterion("c_week2 not like", value, "cWeek2");
            return (Criteria) this;
        }

        public Criteria andCWeek2In(List<String> values) {
            addCriterion("c_week2 in", values, "cWeek2");
            return (Criteria) this;
        }

        public Criteria andCWeek2NotIn(List<String> values) {
            addCriterion("c_week2 not in", values, "cWeek2");
            return (Criteria) this;
        }

        public Criteria andCWeek2Between(String value1, String value2) {
            addCriterion("c_week2 between", value1, value2, "cWeek2");
            return (Criteria) this;
        }

        public Criteria andCWeek2NotBetween(String value1, String value2) {
            addCriterion("c_week2 not between", value1, value2, "cWeek2");
            return (Criteria) this;
        }

        public Criteria andCWeek3IsNull() {
            addCriterion("c_week3 is null");
            return (Criteria) this;
        }

        public Criteria andCWeek3IsNotNull() {
            addCriterion("c_week3 is not null");
            return (Criteria) this;
        }

        public Criteria andCWeek3EqualTo(String value) {
            addCriterion("c_week3 =", value, "cWeek3");
            return (Criteria) this;
        }

        public Criteria andCWeek3NotEqualTo(String value) {
            addCriterion("c_week3 <>", value, "cWeek3");
            return (Criteria) this;
        }

        public Criteria andCWeek3GreaterThan(String value) {
            addCriterion("c_week3 >", value, "cWeek3");
            return (Criteria) this;
        }

        public Criteria andCWeek3GreaterThanOrEqualTo(String value) {
            addCriterion("c_week3 >=", value, "cWeek3");
            return (Criteria) this;
        }

        public Criteria andCWeek3LessThan(String value) {
            addCriterion("c_week3 <", value, "cWeek3");
            return (Criteria) this;
        }

        public Criteria andCWeek3LessThanOrEqualTo(String value) {
            addCriterion("c_week3 <=", value, "cWeek3");
            return (Criteria) this;
        }

        public Criteria andCWeek3Like(String value) {
            addCriterion("c_week3 like", value, "cWeek3");
            return (Criteria) this;
        }

        public Criteria andCWeek3NotLike(String value) {
            addCriterion("c_week3 not like", value, "cWeek3");
            return (Criteria) this;
        }

        public Criteria andCWeek3In(List<String> values) {
            addCriterion("c_week3 in", values, "cWeek3");
            return (Criteria) this;
        }

        public Criteria andCWeek3NotIn(List<String> values) {
            addCriterion("c_week3 not in", values, "cWeek3");
            return (Criteria) this;
        }

        public Criteria andCWeek3Between(String value1, String value2) {
            addCriterion("c_week3 between", value1, value2, "cWeek3");
            return (Criteria) this;
        }

        public Criteria andCWeek3NotBetween(String value1, String value2) {
            addCriterion("c_week3 not between", value1, value2, "cWeek3");
            return (Criteria) this;
        }

        public Criteria andCDaynumIsNull() {
            addCriterion("c_daynum is null");
            return (Criteria) this;
        }

        public Criteria andCDaynumIsNotNull() {
            addCriterion("c_daynum is not null");
            return (Criteria) this;
        }

        public Criteria andCDaynumEqualTo(String value) {
            addCriterion("c_daynum =", value, "cDaynum");
            return (Criteria) this;
        }

        public Criteria andCDaynumNotEqualTo(String value) {
            addCriterion("c_daynum <>", value, "cDaynum");
            return (Criteria) this;
        }

        public Criteria andCDaynumGreaterThan(String value) {
            addCriterion("c_daynum >", value, "cDaynum");
            return (Criteria) this;
        }

        public Criteria andCDaynumGreaterThanOrEqualTo(String value) {
            addCriterion("c_daynum >=", value, "cDaynum");
            return (Criteria) this;
        }

        public Criteria andCDaynumLessThan(String value) {
            addCriterion("c_daynum <", value, "cDaynum");
            return (Criteria) this;
        }

        public Criteria andCDaynumLessThanOrEqualTo(String value) {
            addCriterion("c_daynum <=", value, "cDaynum");
            return (Criteria) this;
        }

        public Criteria andCDaynumLike(String value) {
            addCriterion("c_daynum like", value, "cDaynum");
            return (Criteria) this;
        }

        public Criteria andCDaynumNotLike(String value) {
            addCriterion("c_daynum not like", value, "cDaynum");
            return (Criteria) this;
        }

        public Criteria andCDaynumIn(List<String> values) {
            addCriterion("c_daynum in", values, "cDaynum");
            return (Criteria) this;
        }

        public Criteria andCDaynumNotIn(List<String> values) {
            addCriterion("c_daynum not in", values, "cDaynum");
            return (Criteria) this;
        }

        public Criteria andCDaynumBetween(String value1, String value2) {
            addCriterion("c_daynum between", value1, value2, "cDaynum");
            return (Criteria) this;
        }

        public Criteria andCDaynumNotBetween(String value1, String value2) {
            addCriterion("c_daynum not between", value1, value2, "cDaynum");
            return (Criteria) this;
        }

        public Criteria andCWeeknumIsNull() {
            addCriterion("c_weeknum is null");
            return (Criteria) this;
        }

        public Criteria andCWeeknumIsNotNull() {
            addCriterion("c_weeknum is not null");
            return (Criteria) this;
        }

        public Criteria andCWeeknumEqualTo(String value) {
            addCriterion("c_weeknum =", value, "cWeeknum");
            return (Criteria) this;
        }

        public Criteria andCWeeknumNotEqualTo(String value) {
            addCriterion("c_weeknum <>", value, "cWeeknum");
            return (Criteria) this;
        }

        public Criteria andCWeeknumGreaterThan(String value) {
            addCriterion("c_weeknum >", value, "cWeeknum");
            return (Criteria) this;
        }

        public Criteria andCWeeknumGreaterThanOrEqualTo(String value) {
            addCriterion("c_weeknum >=", value, "cWeeknum");
            return (Criteria) this;
        }

        public Criteria andCWeeknumLessThan(String value) {
            addCriterion("c_weeknum <", value, "cWeeknum");
            return (Criteria) this;
        }

        public Criteria andCWeeknumLessThanOrEqualTo(String value) {
            addCriterion("c_weeknum <=", value, "cWeeknum");
            return (Criteria) this;
        }

        public Criteria andCWeeknumLike(String value) {
            addCriterion("c_weeknum like", value, "cWeeknum");
            return (Criteria) this;
        }

        public Criteria andCWeeknumNotLike(String value) {
            addCriterion("c_weeknum not like", value, "cWeeknum");
            return (Criteria) this;
        }

        public Criteria andCWeeknumIn(List<String> values) {
            addCriterion("c_weeknum in", values, "cWeeknum");
            return (Criteria) this;
        }

        public Criteria andCWeeknumNotIn(List<String> values) {
            addCriterion("c_weeknum not in", values, "cWeeknum");
            return (Criteria) this;
        }

        public Criteria andCWeeknumBetween(String value1, String value2) {
            addCriterion("c_weeknum between", value1, value2, "cWeeknum");
            return (Criteria) this;
        }

        public Criteria andCWeeknumNotBetween(String value1, String value2) {
            addCriterion("c_weeknum not between", value1, value2, "cWeeknum");
            return (Criteria) this;
        }

        public Criteria andCSuitIsNull() {
            addCriterion("c_suit is null");
            return (Criteria) this;
        }

        public Criteria andCSuitIsNotNull() {
            addCriterion("c_suit is not null");
            return (Criteria) this;
        }

        public Criteria andCSuitEqualTo(String value) {
            addCriterion("c_suit =", value, "cSuit");
            return (Criteria) this;
        }

        public Criteria andCSuitNotEqualTo(String value) {
            addCriterion("c_suit <>", value, "cSuit");
            return (Criteria) this;
        }

        public Criteria andCSuitGreaterThan(String value) {
            addCriterion("c_suit >", value, "cSuit");
            return (Criteria) this;
        }

        public Criteria andCSuitGreaterThanOrEqualTo(String value) {
            addCriterion("c_suit >=", value, "cSuit");
            return (Criteria) this;
        }

        public Criteria andCSuitLessThan(String value) {
            addCriterion("c_suit <", value, "cSuit");
            return (Criteria) this;
        }

        public Criteria andCSuitLessThanOrEqualTo(String value) {
            addCriterion("c_suit <=", value, "cSuit");
            return (Criteria) this;
        }

        public Criteria andCSuitLike(String value) {
            addCriterion("c_suit like", value, "cSuit");
            return (Criteria) this;
        }

        public Criteria andCSuitNotLike(String value) {
            addCriterion("c_suit not like", value, "cSuit");
            return (Criteria) this;
        }

        public Criteria andCSuitIn(List<String> values) {
            addCriterion("c_suit in", values, "cSuit");
            return (Criteria) this;
        }

        public Criteria andCSuitNotIn(List<String> values) {
            addCriterion("c_suit not in", values, "cSuit");
            return (Criteria) this;
        }

        public Criteria andCSuitBetween(String value1, String value2) {
            addCriterion("c_suit between", value1, value2, "cSuit");
            return (Criteria) this;
        }

        public Criteria andCSuitNotBetween(String value1, String value2) {
            addCriterion("c_suit not between", value1, value2, "cSuit");
            return (Criteria) this;
        }

        public Criteria andCAvoidIsNull() {
            addCriterion("c_avoid is null");
            return (Criteria) this;
        }

        public Criteria andCAvoidIsNotNull() {
            addCriterion("c_avoid is not null");
            return (Criteria) this;
        }

        public Criteria andCAvoidEqualTo(String value) {
            addCriterion("c_avoid =", value, "cAvoid");
            return (Criteria) this;
        }

        public Criteria andCAvoidNotEqualTo(String value) {
            addCriterion("c_avoid <>", value, "cAvoid");
            return (Criteria) this;
        }

        public Criteria andCAvoidGreaterThan(String value) {
            addCriterion("c_avoid >", value, "cAvoid");
            return (Criteria) this;
        }

        public Criteria andCAvoidGreaterThanOrEqualTo(String value) {
            addCriterion("c_avoid >=", value, "cAvoid");
            return (Criteria) this;
        }

        public Criteria andCAvoidLessThan(String value) {
            addCriterion("c_avoid <", value, "cAvoid");
            return (Criteria) this;
        }

        public Criteria andCAvoidLessThanOrEqualTo(String value) {
            addCriterion("c_avoid <=", value, "cAvoid");
            return (Criteria) this;
        }

        public Criteria andCAvoidLike(String value) {
            addCriterion("c_avoid like", value, "cAvoid");
            return (Criteria) this;
        }

        public Criteria andCAvoidNotLike(String value) {
            addCriterion("c_avoid not like", value, "cAvoid");
            return (Criteria) this;
        }

        public Criteria andCAvoidIn(List<String> values) {
            addCriterion("c_avoid in", values, "cAvoid");
            return (Criteria) this;
        }

        public Criteria andCAvoidNotIn(List<String> values) {
            addCriterion("c_avoid not in", values, "cAvoid");
            return (Criteria) this;
        }

        public Criteria andCAvoidBetween(String value1, String value2) {
            addCriterion("c_avoid between", value1, value2, "cAvoid");
            return (Criteria) this;
        }

        public Criteria andCAvoidNotBetween(String value1, String value2) {
            addCriterion("c_avoid not between", value1, value2, "cAvoid");
            return (Criteria) this;
        }

        public Criteria andCDescIsNull() {
            addCriterion("c_desc is null");
            return (Criteria) this;
        }

        public Criteria andCDescIsNotNull() {
            addCriterion("c_desc is not null");
            return (Criteria) this;
        }

        public Criteria andCDescEqualTo(String value) {
            addCriterion("c_desc =", value, "cDesc");
            return (Criteria) this;
        }

        public Criteria andCDescNotEqualTo(String value) {
            addCriterion("c_desc <>", value, "cDesc");
            return (Criteria) this;
        }

        public Criteria andCDescGreaterThan(String value) {
            addCriterion("c_desc >", value, "cDesc");
            return (Criteria) this;
        }

        public Criteria andCDescGreaterThanOrEqualTo(String value) {
            addCriterion("c_desc >=", value, "cDesc");
            return (Criteria) this;
        }

        public Criteria andCDescLessThan(String value) {
            addCriterion("c_desc <", value, "cDesc");
            return (Criteria) this;
        }

        public Criteria andCDescLessThanOrEqualTo(String value) {
            addCriterion("c_desc <=", value, "cDesc");
            return (Criteria) this;
        }

        public Criteria andCDescLike(String value) {
            addCriterion("c_desc like", value, "cDesc");
            return (Criteria) this;
        }

        public Criteria andCDescNotLike(String value) {
            addCriterion("c_desc not like", value, "cDesc");
            return (Criteria) this;
        }

        public Criteria andCDescIn(List<String> values) {
            addCriterion("c_desc in", values, "cDesc");
            return (Criteria) this;
        }

        public Criteria andCDescNotIn(List<String> values) {
            addCriterion("c_desc not in", values, "cDesc");
            return (Criteria) this;
        }

        public Criteria andCDescBetween(String value1, String value2) {
            addCriterion("c_desc between", value1, value2, "cDesc");
            return (Criteria) this;
        }

        public Criteria andCDescNotBetween(String value1, String value2) {
            addCriterion("c_desc not between", value1, value2, "cDesc");
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