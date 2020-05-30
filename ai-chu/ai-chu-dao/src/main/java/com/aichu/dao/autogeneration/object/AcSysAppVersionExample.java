package com.aichu.dao.autogeneration.object;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AcSysAppVersionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AcSysAppVersionExample() {
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

        public Criteria andAppNameIsNull() {
            addCriterion("app_name is null");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNotNull() {
            addCriterion("app_name is not null");
            return (Criteria) this;
        }

        public Criteria andAppNameEqualTo(String value) {
            addCriterion("app_name =", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotEqualTo(String value) {
            addCriterion("app_name <>", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThan(String value) {
            addCriterion("app_name >", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThanOrEqualTo(String value) {
            addCriterion("app_name >=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThan(String value) {
            addCriterion("app_name <", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThanOrEqualTo(String value) {
            addCriterion("app_name <=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLike(String value) {
            addCriterion("app_name like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotLike(String value) {
            addCriterion("app_name not like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameIn(List<String> values) {
            addCriterion("app_name in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotIn(List<String> values) {
            addCriterion("app_name not in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameBetween(String value1, String value2) {
            addCriterion("app_name between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotBetween(String value1, String value2) {
            addCriterion("app_name not between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andInVersionIsNull() {
            addCriterion("in_version is null");
            return (Criteria) this;
        }

        public Criteria andInVersionIsNotNull() {
            addCriterion("in_version is not null");
            return (Criteria) this;
        }

        public Criteria andInVersionEqualTo(Integer value) {
            addCriterion("in_version =", value, "inVersion");
            return (Criteria) this;
        }

        public Criteria andInVersionNotEqualTo(Integer value) {
            addCriterion("in_version <>", value, "inVersion");
            return (Criteria) this;
        }

        public Criteria andInVersionGreaterThan(Integer value) {
            addCriterion("in_version >", value, "inVersion");
            return (Criteria) this;
        }

        public Criteria andInVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("in_version >=", value, "inVersion");
            return (Criteria) this;
        }

        public Criteria andInVersionLessThan(Integer value) {
            addCriterion("in_version <", value, "inVersion");
            return (Criteria) this;
        }

        public Criteria andInVersionLessThanOrEqualTo(Integer value) {
            addCriterion("in_version <=", value, "inVersion");
            return (Criteria) this;
        }

        public Criteria andInVersionIn(List<Integer> values) {
            addCriterion("in_version in", values, "inVersion");
            return (Criteria) this;
        }

        public Criteria andInVersionNotIn(List<Integer> values) {
            addCriterion("in_version not in", values, "inVersion");
            return (Criteria) this;
        }

        public Criteria andInVersionBetween(Integer value1, Integer value2) {
            addCriterion("in_version between", value1, value2, "inVersion");
            return (Criteria) this;
        }

        public Criteria andInVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("in_version not between", value1, value2, "inVersion");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionUrlIsNull() {
            addCriterion("version_url is null");
            return (Criteria) this;
        }

        public Criteria andVersionUrlIsNotNull() {
            addCriterion("version_url is not null");
            return (Criteria) this;
        }

        public Criteria andVersionUrlEqualTo(String value) {
            addCriterion("version_url =", value, "versionUrl");
            return (Criteria) this;
        }

        public Criteria andVersionUrlNotEqualTo(String value) {
            addCriterion("version_url <>", value, "versionUrl");
            return (Criteria) this;
        }

        public Criteria andVersionUrlGreaterThan(String value) {
            addCriterion("version_url >", value, "versionUrl");
            return (Criteria) this;
        }

        public Criteria andVersionUrlGreaterThanOrEqualTo(String value) {
            addCriterion("version_url >=", value, "versionUrl");
            return (Criteria) this;
        }

        public Criteria andVersionUrlLessThan(String value) {
            addCriterion("version_url <", value, "versionUrl");
            return (Criteria) this;
        }

        public Criteria andVersionUrlLessThanOrEqualTo(String value) {
            addCriterion("version_url <=", value, "versionUrl");
            return (Criteria) this;
        }

        public Criteria andVersionUrlLike(String value) {
            addCriterion("version_url like", value, "versionUrl");
            return (Criteria) this;
        }

        public Criteria andVersionUrlNotLike(String value) {
            addCriterion("version_url not like", value, "versionUrl");
            return (Criteria) this;
        }

        public Criteria andVersionUrlIn(List<String> values) {
            addCriterion("version_url in", values, "versionUrl");
            return (Criteria) this;
        }

        public Criteria andVersionUrlNotIn(List<String> values) {
            addCriterion("version_url not in", values, "versionUrl");
            return (Criteria) this;
        }

        public Criteria andVersionUrlBetween(String value1, String value2) {
            addCriterion("version_url between", value1, value2, "versionUrl");
            return (Criteria) this;
        }

        public Criteria andVersionUrlNotBetween(String value1, String value2) {
            addCriterion("version_url not between", value1, value2, "versionUrl");
            return (Criteria) this;
        }

        public Criteria andVersionDescIsNull() {
            addCriterion("version_desc is null");
            return (Criteria) this;
        }

        public Criteria andVersionDescIsNotNull() {
            addCriterion("version_desc is not null");
            return (Criteria) this;
        }

        public Criteria andVersionDescEqualTo(String value) {
            addCriterion("version_desc =", value, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescNotEqualTo(String value) {
            addCriterion("version_desc <>", value, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescGreaterThan(String value) {
            addCriterion("version_desc >", value, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescGreaterThanOrEqualTo(String value) {
            addCriterion("version_desc >=", value, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescLessThan(String value) {
            addCriterion("version_desc <", value, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescLessThanOrEqualTo(String value) {
            addCriterion("version_desc <=", value, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescLike(String value) {
            addCriterion("version_desc like", value, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescNotLike(String value) {
            addCriterion("version_desc not like", value, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescIn(List<String> values) {
            addCriterion("version_desc in", values, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescNotIn(List<String> values) {
            addCriterion("version_desc not in", values, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescBetween(String value1, String value2) {
            addCriterion("version_desc between", value1, value2, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescNotBetween(String value1, String value2) {
            addCriterion("version_desc not between", value1, value2, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andIsCompelUpdateIsNull() {
            addCriterion("is_compel_update is null");
            return (Criteria) this;
        }

        public Criteria andIsCompelUpdateIsNotNull() {
            addCriterion("is_compel_update is not null");
            return (Criteria) this;
        }

        public Criteria andIsCompelUpdateEqualTo(Integer value) {
            addCriterion("is_compel_update =", value, "isCompelUpdate");
            return (Criteria) this;
        }

        public Criteria andIsCompelUpdateNotEqualTo(Integer value) {
            addCriterion("is_compel_update <>", value, "isCompelUpdate");
            return (Criteria) this;
        }

        public Criteria andIsCompelUpdateGreaterThan(Integer value) {
            addCriterion("is_compel_update >", value, "isCompelUpdate");
            return (Criteria) this;
        }

        public Criteria andIsCompelUpdateGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_compel_update >=", value, "isCompelUpdate");
            return (Criteria) this;
        }

        public Criteria andIsCompelUpdateLessThan(Integer value) {
            addCriterion("is_compel_update <", value, "isCompelUpdate");
            return (Criteria) this;
        }

        public Criteria andIsCompelUpdateLessThanOrEqualTo(Integer value) {
            addCriterion("is_compel_update <=", value, "isCompelUpdate");
            return (Criteria) this;
        }

        public Criteria andIsCompelUpdateIn(List<Integer> values) {
            addCriterion("is_compel_update in", values, "isCompelUpdate");
            return (Criteria) this;
        }

        public Criteria andIsCompelUpdateNotIn(List<Integer> values) {
            addCriterion("is_compel_update not in", values, "isCompelUpdate");
            return (Criteria) this;
        }

        public Criteria andIsCompelUpdateBetween(Integer value1, Integer value2) {
            addCriterion("is_compel_update between", value1, value2, "isCompelUpdate");
            return (Criteria) this;
        }

        public Criteria andIsCompelUpdateNotBetween(Integer value1, Integer value2) {
            addCriterion("is_compel_update not between", value1, value2, "isCompelUpdate");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
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