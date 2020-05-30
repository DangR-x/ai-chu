package com.aichu.dao.autogeneration.object;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AcSysAgentConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AcSysAgentConfigExample() {
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

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andMinUserNumIsNull() {
            addCriterion("min_user_num is null");
            return (Criteria) this;
        }

        public Criteria andMinUserNumIsNotNull() {
            addCriterion("min_user_num is not null");
            return (Criteria) this;
        }

        public Criteria andMinUserNumEqualTo(Integer value) {
            addCriterion("min_user_num =", value, "minUserNum");
            return (Criteria) this;
        }

        public Criteria andMinUserNumNotEqualTo(Integer value) {
            addCriterion("min_user_num <>", value, "minUserNum");
            return (Criteria) this;
        }

        public Criteria andMinUserNumGreaterThan(Integer value) {
            addCriterion("min_user_num >", value, "minUserNum");
            return (Criteria) this;
        }

        public Criteria andMinUserNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("min_user_num >=", value, "minUserNum");
            return (Criteria) this;
        }

        public Criteria andMinUserNumLessThan(Integer value) {
            addCriterion("min_user_num <", value, "minUserNum");
            return (Criteria) this;
        }

        public Criteria andMinUserNumLessThanOrEqualTo(Integer value) {
            addCriterion("min_user_num <=", value, "minUserNum");
            return (Criteria) this;
        }

        public Criteria andMinUserNumIn(List<Integer> values) {
            addCriterion("min_user_num in", values, "minUserNum");
            return (Criteria) this;
        }

        public Criteria andMinUserNumNotIn(List<Integer> values) {
            addCriterion("min_user_num not in", values, "minUserNum");
            return (Criteria) this;
        }

        public Criteria andMinUserNumBetween(Integer value1, Integer value2) {
            addCriterion("min_user_num between", value1, value2, "minUserNum");
            return (Criteria) this;
        }

        public Criteria andMinUserNumNotBetween(Integer value1, Integer value2) {
            addCriterion("min_user_num not between", value1, value2, "minUserNum");
            return (Criteria) this;
        }

        public Criteria andMaxUserNumIsNull() {
            addCriterion("max_user_num is null");
            return (Criteria) this;
        }

        public Criteria andMaxUserNumIsNotNull() {
            addCriterion("max_user_num is not null");
            return (Criteria) this;
        }

        public Criteria andMaxUserNumEqualTo(Integer value) {
            addCriterion("max_user_num =", value, "maxUserNum");
            return (Criteria) this;
        }

        public Criteria andMaxUserNumNotEqualTo(Integer value) {
            addCriterion("max_user_num <>", value, "maxUserNum");
            return (Criteria) this;
        }

        public Criteria andMaxUserNumGreaterThan(Integer value) {
            addCriterion("max_user_num >", value, "maxUserNum");
            return (Criteria) this;
        }

        public Criteria andMaxUserNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_user_num >=", value, "maxUserNum");
            return (Criteria) this;
        }

        public Criteria andMaxUserNumLessThan(Integer value) {
            addCriterion("max_user_num <", value, "maxUserNum");
            return (Criteria) this;
        }

        public Criteria andMaxUserNumLessThanOrEqualTo(Integer value) {
            addCriterion("max_user_num <=", value, "maxUserNum");
            return (Criteria) this;
        }

        public Criteria andMaxUserNumIn(List<Integer> values) {
            addCriterion("max_user_num in", values, "maxUserNum");
            return (Criteria) this;
        }

        public Criteria andMaxUserNumNotIn(List<Integer> values) {
            addCriterion("max_user_num not in", values, "maxUserNum");
            return (Criteria) this;
        }

        public Criteria andMaxUserNumBetween(Integer value1, Integer value2) {
            addCriterion("max_user_num between", value1, value2, "maxUserNum");
            return (Criteria) this;
        }

        public Criteria andMaxUserNumNotBetween(Integer value1, Integer value2) {
            addCriterion("max_user_num not between", value1, value2, "maxUserNum");
            return (Criteria) this;
        }

        public Criteria andDeductRateIsNull() {
            addCriterion("deduct_rate is null");
            return (Criteria) this;
        }

        public Criteria andDeductRateIsNotNull() {
            addCriterion("deduct_rate is not null");
            return (Criteria) this;
        }

        public Criteria andDeductRateEqualTo(Integer value) {
            addCriterion("deduct_rate =", value, "deductRate");
            return (Criteria) this;
        }

        public Criteria andDeductRateNotEqualTo(Integer value) {
            addCriterion("deduct_rate <>", value, "deductRate");
            return (Criteria) this;
        }

        public Criteria andDeductRateGreaterThan(Integer value) {
            addCriterion("deduct_rate >", value, "deductRate");
            return (Criteria) this;
        }

        public Criteria andDeductRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("deduct_rate >=", value, "deductRate");
            return (Criteria) this;
        }

        public Criteria andDeductRateLessThan(Integer value) {
            addCriterion("deduct_rate <", value, "deductRate");
            return (Criteria) this;
        }

        public Criteria andDeductRateLessThanOrEqualTo(Integer value) {
            addCriterion("deduct_rate <=", value, "deductRate");
            return (Criteria) this;
        }

        public Criteria andDeductRateIn(List<Integer> values) {
            addCriterion("deduct_rate in", values, "deductRate");
            return (Criteria) this;
        }

        public Criteria andDeductRateNotIn(List<Integer> values) {
            addCriterion("deduct_rate not in", values, "deductRate");
            return (Criteria) this;
        }

        public Criteria andDeductRateBetween(Integer value1, Integer value2) {
            addCriterion("deduct_rate between", value1, value2, "deductRate");
            return (Criteria) this;
        }

        public Criteria andDeductRateNotBetween(Integer value1, Integer value2) {
            addCriterion("deduct_rate not between", value1, value2, "deductRate");
            return (Criteria) this;
        }

        public Criteria andRiseEarningsIsNull() {
            addCriterion("rise_earnings is null");
            return (Criteria) this;
        }

        public Criteria andRiseEarningsIsNotNull() {
            addCriterion("rise_earnings is not null");
            return (Criteria) this;
        }

        public Criteria andRiseEarningsEqualTo(Integer value) {
            addCriterion("rise_earnings =", value, "riseEarnings");
            return (Criteria) this;
        }

        public Criteria andRiseEarningsNotEqualTo(Integer value) {
            addCriterion("rise_earnings <>", value, "riseEarnings");
            return (Criteria) this;
        }

        public Criteria andRiseEarningsGreaterThan(Integer value) {
            addCriterion("rise_earnings >", value, "riseEarnings");
            return (Criteria) this;
        }

        public Criteria andRiseEarningsGreaterThanOrEqualTo(Integer value) {
            addCriterion("rise_earnings >=", value, "riseEarnings");
            return (Criteria) this;
        }

        public Criteria andRiseEarningsLessThan(Integer value) {
            addCriterion("rise_earnings <", value, "riseEarnings");
            return (Criteria) this;
        }

        public Criteria andRiseEarningsLessThanOrEqualTo(Integer value) {
            addCriterion("rise_earnings <=", value, "riseEarnings");
            return (Criteria) this;
        }

        public Criteria andRiseEarningsIn(List<Integer> values) {
            addCriterion("rise_earnings in", values, "riseEarnings");
            return (Criteria) this;
        }

        public Criteria andRiseEarningsNotIn(List<Integer> values) {
            addCriterion("rise_earnings not in", values, "riseEarnings");
            return (Criteria) this;
        }

        public Criteria andRiseEarningsBetween(Integer value1, Integer value2) {
            addCriterion("rise_earnings between", value1, value2, "riseEarnings");
            return (Criteria) this;
        }

        public Criteria andRiseEarningsNotBetween(Integer value1, Integer value2) {
            addCriterion("rise_earnings not between", value1, value2, "riseEarnings");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
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