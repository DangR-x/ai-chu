package com.aichu.dao.autogeneration.object;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AcSysBannerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AcSysBannerExample() {
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

        public Criteria andBannerUrlIsNull() {
            addCriterion("banner_url is null");
            return (Criteria) this;
        }

        public Criteria andBannerUrlIsNotNull() {
            addCriterion("banner_url is not null");
            return (Criteria) this;
        }

        public Criteria andBannerUrlEqualTo(String value) {
            addCriterion("banner_url =", value, "bannerUrl");
            return (Criteria) this;
        }

        public Criteria andBannerUrlNotEqualTo(String value) {
            addCriterion("banner_url <>", value, "bannerUrl");
            return (Criteria) this;
        }

        public Criteria andBannerUrlGreaterThan(String value) {
            addCriterion("banner_url >", value, "bannerUrl");
            return (Criteria) this;
        }

        public Criteria andBannerUrlGreaterThanOrEqualTo(String value) {
            addCriterion("banner_url >=", value, "bannerUrl");
            return (Criteria) this;
        }

        public Criteria andBannerUrlLessThan(String value) {
            addCriterion("banner_url <", value, "bannerUrl");
            return (Criteria) this;
        }

        public Criteria andBannerUrlLessThanOrEqualTo(String value) {
            addCriterion("banner_url <=", value, "bannerUrl");
            return (Criteria) this;
        }

        public Criteria andBannerUrlLike(String value) {
            addCriterion("banner_url like", value, "bannerUrl");
            return (Criteria) this;
        }

        public Criteria andBannerUrlNotLike(String value) {
            addCriterion("banner_url not like", value, "bannerUrl");
            return (Criteria) this;
        }

        public Criteria andBannerUrlIn(List<String> values) {
            addCriterion("banner_url in", values, "bannerUrl");
            return (Criteria) this;
        }

        public Criteria andBannerUrlNotIn(List<String> values) {
            addCriterion("banner_url not in", values, "bannerUrl");
            return (Criteria) this;
        }

        public Criteria andBannerUrlBetween(String value1, String value2) {
            addCriterion("banner_url between", value1, value2, "bannerUrl");
            return (Criteria) this;
        }

        public Criteria andBannerUrlNotBetween(String value1, String value2) {
            addCriterion("banner_url not between", value1, value2, "bannerUrl");
            return (Criteria) this;
        }

        public Criteria andBannerTypeIsNull() {
            addCriterion("banner_type is null");
            return (Criteria) this;
        }

        public Criteria andBannerTypeIsNotNull() {
            addCriterion("banner_type is not null");
            return (Criteria) this;
        }

        public Criteria andBannerTypeEqualTo(Integer value) {
            addCriterion("banner_type =", value, "bannerType");
            return (Criteria) this;
        }

        public Criteria andBannerTypeNotEqualTo(Integer value) {
            addCriterion("banner_type <>", value, "bannerType");
            return (Criteria) this;
        }

        public Criteria andBannerTypeGreaterThan(Integer value) {
            addCriterion("banner_type >", value, "bannerType");
            return (Criteria) this;
        }

        public Criteria andBannerTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("banner_type >=", value, "bannerType");
            return (Criteria) this;
        }

        public Criteria andBannerTypeLessThan(Integer value) {
            addCriterion("banner_type <", value, "bannerType");
            return (Criteria) this;
        }

        public Criteria andBannerTypeLessThanOrEqualTo(Integer value) {
            addCriterion("banner_type <=", value, "bannerType");
            return (Criteria) this;
        }

        public Criteria andBannerTypeIn(List<Integer> values) {
            addCriterion("banner_type in", values, "bannerType");
            return (Criteria) this;
        }

        public Criteria andBannerTypeNotIn(List<Integer> values) {
            addCriterion("banner_type not in", values, "bannerType");
            return (Criteria) this;
        }

        public Criteria andBannerTypeBetween(Integer value1, Integer value2) {
            addCriterion("banner_type between", value1, value2, "bannerType");
            return (Criteria) this;
        }

        public Criteria andBannerTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("banner_type not between", value1, value2, "bannerType");
            return (Criteria) this;
        }

        public Criteria andBannerTypeCodeIsNull() {
            addCriterion("banner_type_code is null");
            return (Criteria) this;
        }

        public Criteria andBannerTypeCodeIsNotNull() {
            addCriterion("banner_type_code is not null");
            return (Criteria) this;
        }

        public Criteria andBannerTypeCodeEqualTo(String value) {
            addCriterion("banner_type_code =", value, "bannerTypeCode");
            return (Criteria) this;
        }

        public Criteria andBannerTypeCodeNotEqualTo(String value) {
            addCriterion("banner_type_code <>", value, "bannerTypeCode");
            return (Criteria) this;
        }

        public Criteria andBannerTypeCodeGreaterThan(String value) {
            addCriterion("banner_type_code >", value, "bannerTypeCode");
            return (Criteria) this;
        }

        public Criteria andBannerTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("banner_type_code >=", value, "bannerTypeCode");
            return (Criteria) this;
        }

        public Criteria andBannerTypeCodeLessThan(String value) {
            addCriterion("banner_type_code <", value, "bannerTypeCode");
            return (Criteria) this;
        }

        public Criteria andBannerTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("banner_type_code <=", value, "bannerTypeCode");
            return (Criteria) this;
        }

        public Criteria andBannerTypeCodeLike(String value) {
            addCriterion("banner_type_code like", value, "bannerTypeCode");
            return (Criteria) this;
        }

        public Criteria andBannerTypeCodeNotLike(String value) {
            addCriterion("banner_type_code not like", value, "bannerTypeCode");
            return (Criteria) this;
        }

        public Criteria andBannerTypeCodeIn(List<String> values) {
            addCriterion("banner_type_code in", values, "bannerTypeCode");
            return (Criteria) this;
        }

        public Criteria andBannerTypeCodeNotIn(List<String> values) {
            addCriterion("banner_type_code not in", values, "bannerTypeCode");
            return (Criteria) this;
        }

        public Criteria andBannerTypeCodeBetween(String value1, String value2) {
            addCriterion("banner_type_code between", value1, value2, "bannerTypeCode");
            return (Criteria) this;
        }

        public Criteria andBannerTypeCodeNotBetween(String value1, String value2) {
            addCriterion("banner_type_code not between", value1, value2, "bannerTypeCode");
            return (Criteria) this;
        }

        public Criteria andBannerDescIsNull() {
            addCriterion("banner_desc is null");
            return (Criteria) this;
        }

        public Criteria andBannerDescIsNotNull() {
            addCriterion("banner_desc is not null");
            return (Criteria) this;
        }

        public Criteria andBannerDescEqualTo(String value) {
            addCriterion("banner_desc =", value, "bannerDesc");
            return (Criteria) this;
        }

        public Criteria andBannerDescNotEqualTo(String value) {
            addCriterion("banner_desc <>", value, "bannerDesc");
            return (Criteria) this;
        }

        public Criteria andBannerDescGreaterThan(String value) {
            addCriterion("banner_desc >", value, "bannerDesc");
            return (Criteria) this;
        }

        public Criteria andBannerDescGreaterThanOrEqualTo(String value) {
            addCriterion("banner_desc >=", value, "bannerDesc");
            return (Criteria) this;
        }

        public Criteria andBannerDescLessThan(String value) {
            addCriterion("banner_desc <", value, "bannerDesc");
            return (Criteria) this;
        }

        public Criteria andBannerDescLessThanOrEqualTo(String value) {
            addCriterion("banner_desc <=", value, "bannerDesc");
            return (Criteria) this;
        }

        public Criteria andBannerDescLike(String value) {
            addCriterion("banner_desc like", value, "bannerDesc");
            return (Criteria) this;
        }

        public Criteria andBannerDescNotLike(String value) {
            addCriterion("banner_desc not like", value, "bannerDesc");
            return (Criteria) this;
        }

        public Criteria andBannerDescIn(List<String> values) {
            addCriterion("banner_desc in", values, "bannerDesc");
            return (Criteria) this;
        }

        public Criteria andBannerDescNotIn(List<String> values) {
            addCriterion("banner_desc not in", values, "bannerDesc");
            return (Criteria) this;
        }

        public Criteria andBannerDescBetween(String value1, String value2) {
            addCriterion("banner_desc between", value1, value2, "bannerDesc");
            return (Criteria) this;
        }

        public Criteria andBannerDescNotBetween(String value1, String value2) {
            addCriterion("banner_desc not between", value1, value2, "bannerDesc");
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