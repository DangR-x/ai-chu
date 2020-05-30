package com.aichu.dao.autogeneration.object;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AcUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AcUserExample() {
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

        public Criteria andAcUidIsNull() {
            addCriterion("ac_uid is null");
            return (Criteria) this;
        }

        public Criteria andAcUidIsNotNull() {
            addCriterion("ac_uid is not null");
            return (Criteria) this;
        }

        public Criteria andAcUidEqualTo(String value) {
            addCriterion("ac_uid =", value, "acUid");
            return (Criteria) this;
        }

        public Criteria andAcUidNotEqualTo(String value) {
            addCriterion("ac_uid <>", value, "acUid");
            return (Criteria) this;
        }

        public Criteria andAcUidGreaterThan(String value) {
            addCriterion("ac_uid >", value, "acUid");
            return (Criteria) this;
        }

        public Criteria andAcUidGreaterThanOrEqualTo(String value) {
            addCriterion("ac_uid >=", value, "acUid");
            return (Criteria) this;
        }

        public Criteria andAcUidLessThan(String value) {
            addCriterion("ac_uid <", value, "acUid");
            return (Criteria) this;
        }

        public Criteria andAcUidLessThanOrEqualTo(String value) {
            addCriterion("ac_uid <=", value, "acUid");
            return (Criteria) this;
        }

        public Criteria andAcUidLike(String value) {
            addCriterion("ac_uid like", value, "acUid");
            return (Criteria) this;
        }

        public Criteria andAcUidNotLike(String value) {
            addCriterion("ac_uid not like", value, "acUid");
            return (Criteria) this;
        }

        public Criteria andAcUidIn(List<String> values) {
            addCriterion("ac_uid in", values, "acUid");
            return (Criteria) this;
        }

        public Criteria andAcUidNotIn(List<String> values) {
            addCriterion("ac_uid not in", values, "acUid");
            return (Criteria) this;
        }

        public Criteria andAcUidBetween(String value1, String value2) {
            addCriterion("ac_uid between", value1, value2, "acUid");
            return (Criteria) this;
        }

        public Criteria andAcUidNotBetween(String value1, String value2) {
            addCriterion("ac_uid not between", value1, value2, "acUid");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNull() {
            addCriterion("nick_name is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("nick_name =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("nick_name <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("nick_name >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("nick_name >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("nick_name <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("nick_name <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("nick_name like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("nick_name not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("nick_name in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("nick_name not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("nick_name between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("nick_name not between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andHeadImgIsNull() {
            addCriterion("head_img is null");
            return (Criteria) this;
        }

        public Criteria andHeadImgIsNotNull() {
            addCriterion("head_img is not null");
            return (Criteria) this;
        }

        public Criteria andHeadImgEqualTo(String value) {
            addCriterion("head_img =", value, "headImg");
            return (Criteria) this;
        }

        public Criteria andHeadImgNotEqualTo(String value) {
            addCriterion("head_img <>", value, "headImg");
            return (Criteria) this;
        }

        public Criteria andHeadImgGreaterThan(String value) {
            addCriterion("head_img >", value, "headImg");
            return (Criteria) this;
        }

        public Criteria andHeadImgGreaterThanOrEqualTo(String value) {
            addCriterion("head_img >=", value, "headImg");
            return (Criteria) this;
        }

        public Criteria andHeadImgLessThan(String value) {
            addCriterion("head_img <", value, "headImg");
            return (Criteria) this;
        }

        public Criteria andHeadImgLessThanOrEqualTo(String value) {
            addCriterion("head_img <=", value, "headImg");
            return (Criteria) this;
        }

        public Criteria andHeadImgLike(String value) {
            addCriterion("head_img like", value, "headImg");
            return (Criteria) this;
        }

        public Criteria andHeadImgNotLike(String value) {
            addCriterion("head_img not like", value, "headImg");
            return (Criteria) this;
        }

        public Criteria andHeadImgIn(List<String> values) {
            addCriterion("head_img in", values, "headImg");
            return (Criteria) this;
        }

        public Criteria andHeadImgNotIn(List<String> values) {
            addCriterion("head_img not in", values, "headImg");
            return (Criteria) this;
        }

        public Criteria andHeadImgBetween(String value1, String value2) {
            addCriterion("head_img between", value1, value2, "headImg");
            return (Criteria) this;
        }

        public Criteria andHeadImgNotBetween(String value1, String value2) {
            addCriterion("head_img not between", value1, value2, "headImg");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andCoinIsNull() {
            addCriterion("coin is null");
            return (Criteria) this;
        }

        public Criteria andCoinIsNotNull() {
            addCriterion("coin is not null");
            return (Criteria) this;
        }

        public Criteria andCoinEqualTo(Integer value) {
            addCriterion("coin =", value, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinNotEqualTo(Integer value) {
            addCriterion("coin <>", value, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinGreaterThan(Integer value) {
            addCriterion("coin >", value, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinGreaterThanOrEqualTo(Integer value) {
            addCriterion("coin >=", value, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinLessThan(Integer value) {
            addCriterion("coin <", value, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinLessThanOrEqualTo(Integer value) {
            addCriterion("coin <=", value, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinIn(List<Integer> values) {
            addCriterion("coin in", values, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinNotIn(List<Integer> values) {
            addCriterion("coin not in", values, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinBetween(Integer value1, Integer value2) {
            addCriterion("coin between", value1, value2, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinNotBetween(Integer value1, Integer value2) {
            addCriterion("coin not between", value1, value2, "coin");
            return (Criteria) this;
        }

        public Criteria andImTokenIsNull() {
            addCriterion("im_token is null");
            return (Criteria) this;
        }

        public Criteria andImTokenIsNotNull() {
            addCriterion("im_token is not null");
            return (Criteria) this;
        }

        public Criteria andImTokenEqualTo(String value) {
            addCriterion("im_token =", value, "imToken");
            return (Criteria) this;
        }

        public Criteria andImTokenNotEqualTo(String value) {
            addCriterion("im_token <>", value, "imToken");
            return (Criteria) this;
        }

        public Criteria andImTokenGreaterThan(String value) {
            addCriterion("im_token >", value, "imToken");
            return (Criteria) this;
        }

        public Criteria andImTokenGreaterThanOrEqualTo(String value) {
            addCriterion("im_token >=", value, "imToken");
            return (Criteria) this;
        }

        public Criteria andImTokenLessThan(String value) {
            addCriterion("im_token <", value, "imToken");
            return (Criteria) this;
        }

        public Criteria andImTokenLessThanOrEqualTo(String value) {
            addCriterion("im_token <=", value, "imToken");
            return (Criteria) this;
        }

        public Criteria andImTokenLike(String value) {
            addCriterion("im_token like", value, "imToken");
            return (Criteria) this;
        }

        public Criteria andImTokenNotLike(String value) {
            addCriterion("im_token not like", value, "imToken");
            return (Criteria) this;
        }

        public Criteria andImTokenIn(List<String> values) {
            addCriterion("im_token in", values, "imToken");
            return (Criteria) this;
        }

        public Criteria andImTokenNotIn(List<String> values) {
            addCriterion("im_token not in", values, "imToken");
            return (Criteria) this;
        }

        public Criteria andImTokenBetween(String value1, String value2) {
            addCriterion("im_token between", value1, value2, "imToken");
            return (Criteria) this;
        }

        public Criteria andImTokenNotBetween(String value1, String value2) {
            addCriterion("im_token not between", value1, value2, "imToken");
            return (Criteria) this;
        }

        public Criteria andChartCostIsNull() {
            addCriterion("chart_cost is null");
            return (Criteria) this;
        }

        public Criteria andChartCostIsNotNull() {
            addCriterion("chart_cost is not null");
            return (Criteria) this;
        }

        public Criteria andChartCostEqualTo(Integer value) {
            addCriterion("chart_cost =", value, "chartCost");
            return (Criteria) this;
        }

        public Criteria andChartCostNotEqualTo(Integer value) {
            addCriterion("chart_cost <>", value, "chartCost");
            return (Criteria) this;
        }

        public Criteria andChartCostGreaterThan(Integer value) {
            addCriterion("chart_cost >", value, "chartCost");
            return (Criteria) this;
        }

        public Criteria andChartCostGreaterThanOrEqualTo(Integer value) {
            addCriterion("chart_cost >=", value, "chartCost");
            return (Criteria) this;
        }

        public Criteria andChartCostLessThan(Integer value) {
            addCriterion("chart_cost <", value, "chartCost");
            return (Criteria) this;
        }

        public Criteria andChartCostLessThanOrEqualTo(Integer value) {
            addCriterion("chart_cost <=", value, "chartCost");
            return (Criteria) this;
        }

        public Criteria andChartCostIn(List<Integer> values) {
            addCriterion("chart_cost in", values, "chartCost");
            return (Criteria) this;
        }

        public Criteria andChartCostNotIn(List<Integer> values) {
            addCriterion("chart_cost not in", values, "chartCost");
            return (Criteria) this;
        }

        public Criteria andChartCostBetween(Integer value1, Integer value2) {
            addCriterion("chart_cost between", value1, value2, "chartCost");
            return (Criteria) this;
        }

        public Criteria andChartCostNotBetween(Integer value1, Integer value2) {
            addCriterion("chart_cost not between", value1, value2, "chartCost");
            return (Criteria) this;
        }

        public Criteria andBirthDateIsNull() {
            addCriterion("birth_date is null");
            return (Criteria) this;
        }

        public Criteria andBirthDateIsNotNull() {
            addCriterion("birth_date is not null");
            return (Criteria) this;
        }

        public Criteria andBirthDateEqualTo(String value) {
            addCriterion("birth_date =", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotEqualTo(String value) {
            addCriterion("birth_date <>", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateGreaterThan(String value) {
            addCriterion("birth_date >", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateGreaterThanOrEqualTo(String value) {
            addCriterion("birth_date >=", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLessThan(String value) {
            addCriterion("birth_date <", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLessThanOrEqualTo(String value) {
            addCriterion("birth_date <=", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLike(String value) {
            addCriterion("birth_date like", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotLike(String value) {
            addCriterion("birth_date not like", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateIn(List<String> values) {
            addCriterion("birth_date in", values, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotIn(List<String> values) {
            addCriterion("birth_date not in", values, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateBetween(String value1, String value2) {
            addCriterion("birth_date between", value1, value2, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotBetween(String value1, String value2) {
            addCriterion("birth_date not between", value1, value2, "birthDate");
            return (Criteria) this;
        }

        public Criteria andHeightLabelIdIsNull() {
            addCriterion("height_label_id is null");
            return (Criteria) this;
        }

        public Criteria andHeightLabelIdIsNotNull() {
            addCriterion("height_label_id is not null");
            return (Criteria) this;
        }

        public Criteria andHeightLabelIdEqualTo(Integer value) {
            addCriterion("height_label_id =", value, "heightLabelId");
            return (Criteria) this;
        }

        public Criteria andHeightLabelIdNotEqualTo(Integer value) {
            addCriterion("height_label_id <>", value, "heightLabelId");
            return (Criteria) this;
        }

        public Criteria andHeightLabelIdGreaterThan(Integer value) {
            addCriterion("height_label_id >", value, "heightLabelId");
            return (Criteria) this;
        }

        public Criteria andHeightLabelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("height_label_id >=", value, "heightLabelId");
            return (Criteria) this;
        }

        public Criteria andHeightLabelIdLessThan(Integer value) {
            addCriterion("height_label_id <", value, "heightLabelId");
            return (Criteria) this;
        }

        public Criteria andHeightLabelIdLessThanOrEqualTo(Integer value) {
            addCriterion("height_label_id <=", value, "heightLabelId");
            return (Criteria) this;
        }

        public Criteria andHeightLabelIdIn(List<Integer> values) {
            addCriterion("height_label_id in", values, "heightLabelId");
            return (Criteria) this;
        }

        public Criteria andHeightLabelIdNotIn(List<Integer> values) {
            addCriterion("height_label_id not in", values, "heightLabelId");
            return (Criteria) this;
        }

        public Criteria andHeightLabelIdBetween(Integer value1, Integer value2) {
            addCriterion("height_label_id between", value1, value2, "heightLabelId");
            return (Criteria) this;
        }

        public Criteria andHeightLabelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("height_label_id not between", value1, value2, "heightLabelId");
            return (Criteria) this;
        }

        public Criteria andWeightLabelIdIsNull() {
            addCriterion("weight_label_id is null");
            return (Criteria) this;
        }

        public Criteria andWeightLabelIdIsNotNull() {
            addCriterion("weight_label_id is not null");
            return (Criteria) this;
        }

        public Criteria andWeightLabelIdEqualTo(Integer value) {
            addCriterion("weight_label_id =", value, "weightLabelId");
            return (Criteria) this;
        }

        public Criteria andWeightLabelIdNotEqualTo(Integer value) {
            addCriterion("weight_label_id <>", value, "weightLabelId");
            return (Criteria) this;
        }

        public Criteria andWeightLabelIdGreaterThan(Integer value) {
            addCriterion("weight_label_id >", value, "weightLabelId");
            return (Criteria) this;
        }

        public Criteria andWeightLabelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("weight_label_id >=", value, "weightLabelId");
            return (Criteria) this;
        }

        public Criteria andWeightLabelIdLessThan(Integer value) {
            addCriterion("weight_label_id <", value, "weightLabelId");
            return (Criteria) this;
        }

        public Criteria andWeightLabelIdLessThanOrEqualTo(Integer value) {
            addCriterion("weight_label_id <=", value, "weightLabelId");
            return (Criteria) this;
        }

        public Criteria andWeightLabelIdIn(List<Integer> values) {
            addCriterion("weight_label_id in", values, "weightLabelId");
            return (Criteria) this;
        }

        public Criteria andWeightLabelIdNotIn(List<Integer> values) {
            addCriterion("weight_label_id not in", values, "weightLabelId");
            return (Criteria) this;
        }

        public Criteria andWeightLabelIdBetween(Integer value1, Integer value2) {
            addCriterion("weight_label_id between", value1, value2, "weightLabelId");
            return (Criteria) this;
        }

        public Criteria andWeightLabelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("weight_label_id not between", value1, value2, "weightLabelId");
            return (Criteria) this;
        }

        public Criteria andOccupationLabelIdIsNull() {
            addCriterion("occupation_label_id is null");
            return (Criteria) this;
        }

        public Criteria andOccupationLabelIdIsNotNull() {
            addCriterion("occupation_label_id is not null");
            return (Criteria) this;
        }

        public Criteria andOccupationLabelIdEqualTo(Integer value) {
            addCriterion("occupation_label_id =", value, "occupationLabelId");
            return (Criteria) this;
        }

        public Criteria andOccupationLabelIdNotEqualTo(Integer value) {
            addCriterion("occupation_label_id <>", value, "occupationLabelId");
            return (Criteria) this;
        }

        public Criteria andOccupationLabelIdGreaterThan(Integer value) {
            addCriterion("occupation_label_id >", value, "occupationLabelId");
            return (Criteria) this;
        }

        public Criteria andOccupationLabelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("occupation_label_id >=", value, "occupationLabelId");
            return (Criteria) this;
        }

        public Criteria andOccupationLabelIdLessThan(Integer value) {
            addCriterion("occupation_label_id <", value, "occupationLabelId");
            return (Criteria) this;
        }

        public Criteria andOccupationLabelIdLessThanOrEqualTo(Integer value) {
            addCriterion("occupation_label_id <=", value, "occupationLabelId");
            return (Criteria) this;
        }

        public Criteria andOccupationLabelIdIn(List<Integer> values) {
            addCriterion("occupation_label_id in", values, "occupationLabelId");
            return (Criteria) this;
        }

        public Criteria andOccupationLabelIdNotIn(List<Integer> values) {
            addCriterion("occupation_label_id not in", values, "occupationLabelId");
            return (Criteria) this;
        }

        public Criteria andOccupationLabelIdBetween(Integer value1, Integer value2) {
            addCriterion("occupation_label_id between", value1, value2, "occupationLabelId");
            return (Criteria) this;
        }

        public Criteria andOccupationLabelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("occupation_label_id not between", value1, value2, "occupationLabelId");
            return (Criteria) this;
        }

        public Criteria andConstellationLabelIdIsNull() {
            addCriterion("constellation_label_id is null");
            return (Criteria) this;
        }

        public Criteria andConstellationLabelIdIsNotNull() {
            addCriterion("constellation_label_id is not null");
            return (Criteria) this;
        }

        public Criteria andConstellationLabelIdEqualTo(Integer value) {
            addCriterion("constellation_label_id =", value, "constellationLabelId");
            return (Criteria) this;
        }

        public Criteria andConstellationLabelIdNotEqualTo(Integer value) {
            addCriterion("constellation_label_id <>", value, "constellationLabelId");
            return (Criteria) this;
        }

        public Criteria andConstellationLabelIdGreaterThan(Integer value) {
            addCriterion("constellation_label_id >", value, "constellationLabelId");
            return (Criteria) this;
        }

        public Criteria andConstellationLabelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("constellation_label_id >=", value, "constellationLabelId");
            return (Criteria) this;
        }

        public Criteria andConstellationLabelIdLessThan(Integer value) {
            addCriterion("constellation_label_id <", value, "constellationLabelId");
            return (Criteria) this;
        }

        public Criteria andConstellationLabelIdLessThanOrEqualTo(Integer value) {
            addCriterion("constellation_label_id <=", value, "constellationLabelId");
            return (Criteria) this;
        }

        public Criteria andConstellationLabelIdIn(List<Integer> values) {
            addCriterion("constellation_label_id in", values, "constellationLabelId");
            return (Criteria) this;
        }

        public Criteria andConstellationLabelIdNotIn(List<Integer> values) {
            addCriterion("constellation_label_id not in", values, "constellationLabelId");
            return (Criteria) this;
        }

        public Criteria andConstellationLabelIdBetween(Integer value1, Integer value2) {
            addCriterion("constellation_label_id between", value1, value2, "constellationLabelId");
            return (Criteria) this;
        }

        public Criteria andConstellationLabelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("constellation_label_id not between", value1, value2, "constellationLabelId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNull() {
            addCriterion("province_id is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNotNull() {
            addCriterion("province_id is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdEqualTo(Integer value) {
            addCriterion("province_id =", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotEqualTo(Integer value) {
            addCriterion("province_id <>", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThan(Integer value) {
            addCriterion("province_id >", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("province_id >=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThan(Integer value) {
            addCriterion("province_id <", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThanOrEqualTo(Integer value) {
            addCriterion("province_id <=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIn(List<Integer> values) {
            addCriterion("province_id in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotIn(List<Integer> values) {
            addCriterion("province_id not in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdBetween(Integer value1, Integer value2) {
            addCriterion("province_id between", value1, value2, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("province_id not between", value1, value2, "provinceId");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNull() {
            addCriterion("city_id is null");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNotNull() {
            addCriterion("city_id is not null");
            return (Criteria) this;
        }

        public Criteria andCityIdEqualTo(Integer value) {
            addCriterion("city_id =", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotEqualTo(Integer value) {
            addCriterion("city_id <>", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThan(Integer value) {
            addCriterion("city_id >", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("city_id >=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThan(Integer value) {
            addCriterion("city_id <", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThanOrEqualTo(Integer value) {
            addCriterion("city_id <=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdIn(List<Integer> values) {
            addCriterion("city_id in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotIn(List<Integer> values) {
            addCriterion("city_id not in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdBetween(Integer value1, Integer value2) {
            addCriterion("city_id between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("city_id not between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNull() {
            addCriterion("area_id is null");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("area_id is not null");
            return (Criteria) this;
        }

        public Criteria andAreaIdEqualTo(Integer value) {
            addCriterion("area_id =", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotEqualTo(Integer value) {
            addCriterion("area_id <>", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThan(Integer value) {
            addCriterion("area_id >", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("area_id >=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThan(Integer value) {
            addCriterion("area_id <", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(Integer value) {
            addCriterion("area_id <=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIn(List<Integer> values) {
            addCriterion("area_id in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotIn(List<Integer> values) {
            addCriterion("area_id not in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdBetween(Integer value1, Integer value2) {
            addCriterion("area_id between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("area_id not between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(Double value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(Double value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(Double value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(Double value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(Double value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<Double> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<Double> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(Double value1, Double value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(Double value1, Double value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(Double value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(Double value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(Double value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(Double value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(Double value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<Double> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<Double> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(Double value1, Double value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(Double value1, Double value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andImpressionLabelIdIsNull() {
            addCriterion("impression_label_id is null");
            return (Criteria) this;
        }

        public Criteria andImpressionLabelIdIsNotNull() {
            addCriterion("impression_label_id is not null");
            return (Criteria) this;
        }

        public Criteria andImpressionLabelIdEqualTo(String value) {
            addCriterion("impression_label_id =", value, "impressionLabelId");
            return (Criteria) this;
        }

        public Criteria andImpressionLabelIdNotEqualTo(String value) {
            addCriterion("impression_label_id <>", value, "impressionLabelId");
            return (Criteria) this;
        }

        public Criteria andImpressionLabelIdGreaterThan(String value) {
            addCriterion("impression_label_id >", value, "impressionLabelId");
            return (Criteria) this;
        }

        public Criteria andImpressionLabelIdGreaterThanOrEqualTo(String value) {
            addCriterion("impression_label_id >=", value, "impressionLabelId");
            return (Criteria) this;
        }

        public Criteria andImpressionLabelIdLessThan(String value) {
            addCriterion("impression_label_id <", value, "impressionLabelId");
            return (Criteria) this;
        }

        public Criteria andImpressionLabelIdLessThanOrEqualTo(String value) {
            addCriterion("impression_label_id <=", value, "impressionLabelId");
            return (Criteria) this;
        }

        public Criteria andImpressionLabelIdLike(String value) {
            addCriterion("impression_label_id like", value, "impressionLabelId");
            return (Criteria) this;
        }

        public Criteria andImpressionLabelIdNotLike(String value) {
            addCriterion("impression_label_id not like", value, "impressionLabelId");
            return (Criteria) this;
        }

        public Criteria andImpressionLabelIdIn(List<String> values) {
            addCriterion("impression_label_id in", values, "impressionLabelId");
            return (Criteria) this;
        }

        public Criteria andImpressionLabelIdNotIn(List<String> values) {
            addCriterion("impression_label_id not in", values, "impressionLabelId");
            return (Criteria) this;
        }

        public Criteria andImpressionLabelIdBetween(String value1, String value2) {
            addCriterion("impression_label_id between", value1, value2, "impressionLabelId");
            return (Criteria) this;
        }

        public Criteria andImpressionLabelIdNotBetween(String value1, String value2) {
            addCriterion("impression_label_id not between", value1, value2, "impressionLabelId");
            return (Criteria) this;
        }

        public Criteria andSignatureIsNull() {
            addCriterion("signature is null");
            return (Criteria) this;
        }

        public Criteria andSignatureIsNotNull() {
            addCriterion("signature is not null");
            return (Criteria) this;
        }

        public Criteria andSignatureEqualTo(String value) {
            addCriterion("signature =", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotEqualTo(String value) {
            addCriterion("signature <>", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureGreaterThan(String value) {
            addCriterion("signature >", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureGreaterThanOrEqualTo(String value) {
            addCriterion("signature >=", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLessThan(String value) {
            addCriterion("signature <", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLessThanOrEqualTo(String value) {
            addCriterion("signature <=", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLike(String value) {
            addCriterion("signature like", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotLike(String value) {
            addCriterion("signature not like", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureIn(List<String> values) {
            addCriterion("signature in", values, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotIn(List<String> values) {
            addCriterion("signature not in", values, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureBetween(String value1, String value2) {
            addCriterion("signature between", value1, value2, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotBetween(String value1, String value2) {
            addCriterion("signature not between", value1, value2, "signature");
            return (Criteria) this;
        }

        public Criteria andAgentLevelIsNull() {
            addCriterion("agent_level is null");
            return (Criteria) this;
        }

        public Criteria andAgentLevelIsNotNull() {
            addCriterion("agent_level is not null");
            return (Criteria) this;
        }

        public Criteria andAgentLevelEqualTo(Integer value) {
            addCriterion("agent_level =", value, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelNotEqualTo(Integer value) {
            addCriterion("agent_level <>", value, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelGreaterThan(Integer value) {
            addCriterion("agent_level >", value, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("agent_level >=", value, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelLessThan(Integer value) {
            addCriterion("agent_level <", value, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelLessThanOrEqualTo(Integer value) {
            addCriterion("agent_level <=", value, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelIn(List<Integer> values) {
            addCriterion("agent_level in", values, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelNotIn(List<Integer> values) {
            addCriterion("agent_level not in", values, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelBetween(Integer value1, Integer value2) {
            addCriterion("agent_level between", value1, value2, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("agent_level not between", value1, value2, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andIsAgencyIsNull() {
            addCriterion("is_agency is null");
            return (Criteria) this;
        }

        public Criteria andIsAgencyIsNotNull() {
            addCriterion("is_agency is not null");
            return (Criteria) this;
        }

        public Criteria andIsAgencyEqualTo(Integer value) {
            addCriterion("is_agency =", value, "isAgency");
            return (Criteria) this;
        }

        public Criteria andIsAgencyNotEqualTo(Integer value) {
            addCriterion("is_agency <>", value, "isAgency");
            return (Criteria) this;
        }

        public Criteria andIsAgencyGreaterThan(Integer value) {
            addCriterion("is_agency >", value, "isAgency");
            return (Criteria) this;
        }

        public Criteria andIsAgencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_agency >=", value, "isAgency");
            return (Criteria) this;
        }

        public Criteria andIsAgencyLessThan(Integer value) {
            addCriterion("is_agency <", value, "isAgency");
            return (Criteria) this;
        }

        public Criteria andIsAgencyLessThanOrEqualTo(Integer value) {
            addCriterion("is_agency <=", value, "isAgency");
            return (Criteria) this;
        }

        public Criteria andIsAgencyIn(List<Integer> values) {
            addCriterion("is_agency in", values, "isAgency");
            return (Criteria) this;
        }

        public Criteria andIsAgencyNotIn(List<Integer> values) {
            addCriterion("is_agency not in", values, "isAgency");
            return (Criteria) this;
        }

        public Criteria andIsAgencyBetween(Integer value1, Integer value2) {
            addCriterion("is_agency between", value1, value2, "isAgency");
            return (Criteria) this;
        }

        public Criteria andIsAgencyNotBetween(Integer value1, Integer value2) {
            addCriterion("is_agency not between", value1, value2, "isAgency");
            return (Criteria) this;
        }

        public Criteria andIsAnchorIsNull() {
            addCriterion("is_anchor is null");
            return (Criteria) this;
        }

        public Criteria andIsAnchorIsNotNull() {
            addCriterion("is_anchor is not null");
            return (Criteria) this;
        }

        public Criteria andIsAnchorEqualTo(Integer value) {
            addCriterion("is_anchor =", value, "isAnchor");
            return (Criteria) this;
        }

        public Criteria andIsAnchorNotEqualTo(Integer value) {
            addCriterion("is_anchor <>", value, "isAnchor");
            return (Criteria) this;
        }

        public Criteria andIsAnchorGreaterThan(Integer value) {
            addCriterion("is_anchor >", value, "isAnchor");
            return (Criteria) this;
        }

        public Criteria andIsAnchorGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_anchor >=", value, "isAnchor");
            return (Criteria) this;
        }

        public Criteria andIsAnchorLessThan(Integer value) {
            addCriterion("is_anchor <", value, "isAnchor");
            return (Criteria) this;
        }

        public Criteria andIsAnchorLessThanOrEqualTo(Integer value) {
            addCriterion("is_anchor <=", value, "isAnchor");
            return (Criteria) this;
        }

        public Criteria andIsAnchorIn(List<Integer> values) {
            addCriterion("is_anchor in", values, "isAnchor");
            return (Criteria) this;
        }

        public Criteria andIsAnchorNotIn(List<Integer> values) {
            addCriterion("is_anchor not in", values, "isAnchor");
            return (Criteria) this;
        }

        public Criteria andIsAnchorBetween(Integer value1, Integer value2) {
            addCriterion("is_anchor between", value1, value2, "isAnchor");
            return (Criteria) this;
        }

        public Criteria andIsAnchorNotBetween(Integer value1, Integer value2) {
            addCriterion("is_anchor not between", value1, value2, "isAnchor");
            return (Criteria) this;
        }

        public Criteria andIsBlackListIsNull() {
            addCriterion("is_black_list is null");
            return (Criteria) this;
        }

        public Criteria andIsBlackListIsNotNull() {
            addCriterion("is_black_list is not null");
            return (Criteria) this;
        }

        public Criteria andIsBlackListEqualTo(Integer value) {
            addCriterion("is_black_list =", value, "isBlackList");
            return (Criteria) this;
        }

        public Criteria andIsBlackListNotEqualTo(Integer value) {
            addCriterion("is_black_list <>", value, "isBlackList");
            return (Criteria) this;
        }

        public Criteria andIsBlackListGreaterThan(Integer value) {
            addCriterion("is_black_list >", value, "isBlackList");
            return (Criteria) this;
        }

        public Criteria andIsBlackListGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_black_list >=", value, "isBlackList");
            return (Criteria) this;
        }

        public Criteria andIsBlackListLessThan(Integer value) {
            addCriterion("is_black_list <", value, "isBlackList");
            return (Criteria) this;
        }

        public Criteria andIsBlackListLessThanOrEqualTo(Integer value) {
            addCriterion("is_black_list <=", value, "isBlackList");
            return (Criteria) this;
        }

        public Criteria andIsBlackListIn(List<Integer> values) {
            addCriterion("is_black_list in", values, "isBlackList");
            return (Criteria) this;
        }

        public Criteria andIsBlackListNotIn(List<Integer> values) {
            addCriterion("is_black_list not in", values, "isBlackList");
            return (Criteria) this;
        }

        public Criteria andIsBlackListBetween(Integer value1, Integer value2) {
            addCriterion("is_black_list between", value1, value2, "isBlackList");
            return (Criteria) this;
        }

        public Criteria andIsBlackListNotBetween(Integer value1, Integer value2) {
            addCriterion("is_black_list not between", value1, value2, "isBlackList");
            return (Criteria) this;
        }

        public Criteria andIsFreezeIsNull() {
            addCriterion("is_freeze is null");
            return (Criteria) this;
        }

        public Criteria andIsFreezeIsNotNull() {
            addCriterion("is_freeze is not null");
            return (Criteria) this;
        }

        public Criteria andIsFreezeEqualTo(Integer value) {
            addCriterion("is_freeze =", value, "isFreeze");
            return (Criteria) this;
        }

        public Criteria andIsFreezeNotEqualTo(Integer value) {
            addCriterion("is_freeze <>", value, "isFreeze");
            return (Criteria) this;
        }

        public Criteria andIsFreezeGreaterThan(Integer value) {
            addCriterion("is_freeze >", value, "isFreeze");
            return (Criteria) this;
        }

        public Criteria andIsFreezeGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_freeze >=", value, "isFreeze");
            return (Criteria) this;
        }

        public Criteria andIsFreezeLessThan(Integer value) {
            addCriterion("is_freeze <", value, "isFreeze");
            return (Criteria) this;
        }

        public Criteria andIsFreezeLessThanOrEqualTo(Integer value) {
            addCriterion("is_freeze <=", value, "isFreeze");
            return (Criteria) this;
        }

        public Criteria andIsFreezeIn(List<Integer> values) {
            addCriterion("is_freeze in", values, "isFreeze");
            return (Criteria) this;
        }

        public Criteria andIsFreezeNotIn(List<Integer> values) {
            addCriterion("is_freeze not in", values, "isFreeze");
            return (Criteria) this;
        }

        public Criteria andIsFreezeBetween(Integer value1, Integer value2) {
            addCriterion("is_freeze between", value1, value2, "isFreeze");
            return (Criteria) this;
        }

        public Criteria andIsFreezeNotBetween(Integer value1, Integer value2) {
            addCriterion("is_freeze not between", value1, value2, "isFreeze");
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