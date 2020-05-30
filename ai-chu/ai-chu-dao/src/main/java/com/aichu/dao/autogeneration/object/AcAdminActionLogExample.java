package com.aichu.dao.autogeneration.object;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AcAdminActionLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AcAdminActionLogExample() {
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

        public Criteria andAdminUserIdIsNull() {
            addCriterion("admin_user_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminUserIdIsNotNull() {
            addCriterion("admin_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminUserIdEqualTo(Integer value) {
            addCriterion("admin_user_id =", value, "adminUserId");
            return (Criteria) this;
        }

        public Criteria andAdminUserIdNotEqualTo(Integer value) {
            addCriterion("admin_user_id <>", value, "adminUserId");
            return (Criteria) this;
        }

        public Criteria andAdminUserIdGreaterThan(Integer value) {
            addCriterion("admin_user_id >", value, "adminUserId");
            return (Criteria) this;
        }

        public Criteria andAdminUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_user_id >=", value, "adminUserId");
            return (Criteria) this;
        }

        public Criteria andAdminUserIdLessThan(Integer value) {
            addCriterion("admin_user_id <", value, "adminUserId");
            return (Criteria) this;
        }

        public Criteria andAdminUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("admin_user_id <=", value, "adminUserId");
            return (Criteria) this;
        }

        public Criteria andAdminUserIdIn(List<Integer> values) {
            addCriterion("admin_user_id in", values, "adminUserId");
            return (Criteria) this;
        }

        public Criteria andAdminUserIdNotIn(List<Integer> values) {
            addCriterion("admin_user_id not in", values, "adminUserId");
            return (Criteria) this;
        }

        public Criteria andAdminUserIdBetween(Integer value1, Integer value2) {
            addCriterion("admin_user_id between", value1, value2, "adminUserId");
            return (Criteria) this;
        }

        public Criteria andAdminUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_user_id not between", value1, value2, "adminUserId");
            return (Criteria) this;
        }

        public Criteria andActionIpIsNull() {
            addCriterion("action_ip is null");
            return (Criteria) this;
        }

        public Criteria andActionIpIsNotNull() {
            addCriterion("action_ip is not null");
            return (Criteria) this;
        }

        public Criteria andActionIpEqualTo(String value) {
            addCriterion("action_ip =", value, "actionIp");
            return (Criteria) this;
        }

        public Criteria andActionIpNotEqualTo(String value) {
            addCriterion("action_ip <>", value, "actionIp");
            return (Criteria) this;
        }

        public Criteria andActionIpGreaterThan(String value) {
            addCriterion("action_ip >", value, "actionIp");
            return (Criteria) this;
        }

        public Criteria andActionIpGreaterThanOrEqualTo(String value) {
            addCriterion("action_ip >=", value, "actionIp");
            return (Criteria) this;
        }

        public Criteria andActionIpLessThan(String value) {
            addCriterion("action_ip <", value, "actionIp");
            return (Criteria) this;
        }

        public Criteria andActionIpLessThanOrEqualTo(String value) {
            addCriterion("action_ip <=", value, "actionIp");
            return (Criteria) this;
        }

        public Criteria andActionIpLike(String value) {
            addCriterion("action_ip like", value, "actionIp");
            return (Criteria) this;
        }

        public Criteria andActionIpNotLike(String value) {
            addCriterion("action_ip not like", value, "actionIp");
            return (Criteria) this;
        }

        public Criteria andActionIpIn(List<String> values) {
            addCriterion("action_ip in", values, "actionIp");
            return (Criteria) this;
        }

        public Criteria andActionIpNotIn(List<String> values) {
            addCriterion("action_ip not in", values, "actionIp");
            return (Criteria) this;
        }

        public Criteria andActionIpBetween(String value1, String value2) {
            addCriterion("action_ip between", value1, value2, "actionIp");
            return (Criteria) this;
        }

        public Criteria andActionIpNotBetween(String value1, String value2) {
            addCriterion("action_ip not between", value1, value2, "actionIp");
            return (Criteria) this;
        }

        public Criteria andActionModelIsNull() {
            addCriterion("action_model is null");
            return (Criteria) this;
        }

        public Criteria andActionModelIsNotNull() {
            addCriterion("action_model is not null");
            return (Criteria) this;
        }

        public Criteria andActionModelEqualTo(String value) {
            addCriterion("action_model =", value, "actionModel");
            return (Criteria) this;
        }

        public Criteria andActionModelNotEqualTo(String value) {
            addCriterion("action_model <>", value, "actionModel");
            return (Criteria) this;
        }

        public Criteria andActionModelGreaterThan(String value) {
            addCriterion("action_model >", value, "actionModel");
            return (Criteria) this;
        }

        public Criteria andActionModelGreaterThanOrEqualTo(String value) {
            addCriterion("action_model >=", value, "actionModel");
            return (Criteria) this;
        }

        public Criteria andActionModelLessThan(String value) {
            addCriterion("action_model <", value, "actionModel");
            return (Criteria) this;
        }

        public Criteria andActionModelLessThanOrEqualTo(String value) {
            addCriterion("action_model <=", value, "actionModel");
            return (Criteria) this;
        }

        public Criteria andActionModelLike(String value) {
            addCriterion("action_model like", value, "actionModel");
            return (Criteria) this;
        }

        public Criteria andActionModelNotLike(String value) {
            addCriterion("action_model not like", value, "actionModel");
            return (Criteria) this;
        }

        public Criteria andActionModelIn(List<String> values) {
            addCriterion("action_model in", values, "actionModel");
            return (Criteria) this;
        }

        public Criteria andActionModelNotIn(List<String> values) {
            addCriterion("action_model not in", values, "actionModel");
            return (Criteria) this;
        }

        public Criteria andActionModelBetween(String value1, String value2) {
            addCriterion("action_model between", value1, value2, "actionModel");
            return (Criteria) this;
        }

        public Criteria andActionModelNotBetween(String value1, String value2) {
            addCriterion("action_model not between", value1, value2, "actionModel");
            return (Criteria) this;
        }

        public Criteria andActionLogIsNull() {
            addCriterion("action_log is null");
            return (Criteria) this;
        }

        public Criteria andActionLogIsNotNull() {
            addCriterion("action_log is not null");
            return (Criteria) this;
        }

        public Criteria andActionLogEqualTo(String value) {
            addCriterion("action_log =", value, "actionLog");
            return (Criteria) this;
        }

        public Criteria andActionLogNotEqualTo(String value) {
            addCriterion("action_log <>", value, "actionLog");
            return (Criteria) this;
        }

        public Criteria andActionLogGreaterThan(String value) {
            addCriterion("action_log >", value, "actionLog");
            return (Criteria) this;
        }

        public Criteria andActionLogGreaterThanOrEqualTo(String value) {
            addCriterion("action_log >=", value, "actionLog");
            return (Criteria) this;
        }

        public Criteria andActionLogLessThan(String value) {
            addCriterion("action_log <", value, "actionLog");
            return (Criteria) this;
        }

        public Criteria andActionLogLessThanOrEqualTo(String value) {
            addCriterion("action_log <=", value, "actionLog");
            return (Criteria) this;
        }

        public Criteria andActionLogLike(String value) {
            addCriterion("action_log like", value, "actionLog");
            return (Criteria) this;
        }

        public Criteria andActionLogNotLike(String value) {
            addCriterion("action_log not like", value, "actionLog");
            return (Criteria) this;
        }

        public Criteria andActionLogIn(List<String> values) {
            addCriterion("action_log in", values, "actionLog");
            return (Criteria) this;
        }

        public Criteria andActionLogNotIn(List<String> values) {
            addCriterion("action_log not in", values, "actionLog");
            return (Criteria) this;
        }

        public Criteria andActionLogBetween(String value1, String value2) {
            addCriterion("action_log between", value1, value2, "actionLog");
            return (Criteria) this;
        }

        public Criteria andActionLogNotBetween(String value1, String value2) {
            addCriterion("action_log not between", value1, value2, "actionLog");
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