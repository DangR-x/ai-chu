package com.aichu.dao.autogeneration.object;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AcPreferentialCardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AcPreferentialCardExample() {
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

        public Criteria andCardNameIsNull() {
            addCriterion("card_name is null");
            return (Criteria) this;
        }

        public Criteria andCardNameIsNotNull() {
            addCriterion("card_name is not null");
            return (Criteria) this;
        }

        public Criteria andCardNameEqualTo(String value) {
            addCriterion("card_name =", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameNotEqualTo(String value) {
            addCriterion("card_name <>", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameGreaterThan(String value) {
            addCriterion("card_name >", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameGreaterThanOrEqualTo(String value) {
            addCriterion("card_name >=", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameLessThan(String value) {
            addCriterion("card_name <", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameLessThanOrEqualTo(String value) {
            addCriterion("card_name <=", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameLike(String value) {
            addCriterion("card_name like", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameNotLike(String value) {
            addCriterion("card_name not like", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameIn(List<String> values) {
            addCriterion("card_name in", values, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameNotIn(List<String> values) {
            addCriterion("card_name not in", values, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameBetween(String value1, String value2) {
            addCriterion("card_name between", value1, value2, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameNotBetween(String value1, String value2) {
            addCriterion("card_name not between", value1, value2, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardOriginalPriceIsNull() {
            addCriterion("card_original_price is null");
            return (Criteria) this;
        }

        public Criteria andCardOriginalPriceIsNotNull() {
            addCriterion("card_original_price is not null");
            return (Criteria) this;
        }

        public Criteria andCardOriginalPriceEqualTo(Integer value) {
            addCriterion("card_original_price =", value, "cardOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andCardOriginalPriceNotEqualTo(Integer value) {
            addCriterion("card_original_price <>", value, "cardOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andCardOriginalPriceGreaterThan(Integer value) {
            addCriterion("card_original_price >", value, "cardOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andCardOriginalPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("card_original_price >=", value, "cardOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andCardOriginalPriceLessThan(Integer value) {
            addCriterion("card_original_price <", value, "cardOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andCardOriginalPriceLessThanOrEqualTo(Integer value) {
            addCriterion("card_original_price <=", value, "cardOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andCardOriginalPriceIn(List<Integer> values) {
            addCriterion("card_original_price in", values, "cardOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andCardOriginalPriceNotIn(List<Integer> values) {
            addCriterion("card_original_price not in", values, "cardOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andCardOriginalPriceBetween(Integer value1, Integer value2) {
            addCriterion("card_original_price between", value1, value2, "cardOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andCardOriginalPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("card_original_price not between", value1, value2, "cardOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andCardSalePriceIsNull() {
            addCriterion("card_sale_price is null");
            return (Criteria) this;
        }

        public Criteria andCardSalePriceIsNotNull() {
            addCriterion("card_sale_price is not null");
            return (Criteria) this;
        }

        public Criteria andCardSalePriceEqualTo(Integer value) {
            addCriterion("card_sale_price =", value, "cardSalePrice");
            return (Criteria) this;
        }

        public Criteria andCardSalePriceNotEqualTo(Integer value) {
            addCriterion("card_sale_price <>", value, "cardSalePrice");
            return (Criteria) this;
        }

        public Criteria andCardSalePriceGreaterThan(Integer value) {
            addCriterion("card_sale_price >", value, "cardSalePrice");
            return (Criteria) this;
        }

        public Criteria andCardSalePriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("card_sale_price >=", value, "cardSalePrice");
            return (Criteria) this;
        }

        public Criteria andCardSalePriceLessThan(Integer value) {
            addCriterion("card_sale_price <", value, "cardSalePrice");
            return (Criteria) this;
        }

        public Criteria andCardSalePriceLessThanOrEqualTo(Integer value) {
            addCriterion("card_sale_price <=", value, "cardSalePrice");
            return (Criteria) this;
        }

        public Criteria andCardSalePriceIn(List<Integer> values) {
            addCriterion("card_sale_price in", values, "cardSalePrice");
            return (Criteria) this;
        }

        public Criteria andCardSalePriceNotIn(List<Integer> values) {
            addCriterion("card_sale_price not in", values, "cardSalePrice");
            return (Criteria) this;
        }

        public Criteria andCardSalePriceBetween(Integer value1, Integer value2) {
            addCriterion("card_sale_price between", value1, value2, "cardSalePrice");
            return (Criteria) this;
        }

        public Criteria andCardSalePriceNotBetween(Integer value1, Integer value2) {
            addCriterion("card_sale_price not between", value1, value2, "cardSalePrice");
            return (Criteria) this;
        }

        public Criteria andCardDetailIsNull() {
            addCriterion("card_detail is null");
            return (Criteria) this;
        }

        public Criteria andCardDetailIsNotNull() {
            addCriterion("card_detail is not null");
            return (Criteria) this;
        }

        public Criteria andCardDetailEqualTo(String value) {
            addCriterion("card_detail =", value, "cardDetail");
            return (Criteria) this;
        }

        public Criteria andCardDetailNotEqualTo(String value) {
            addCriterion("card_detail <>", value, "cardDetail");
            return (Criteria) this;
        }

        public Criteria andCardDetailGreaterThan(String value) {
            addCriterion("card_detail >", value, "cardDetail");
            return (Criteria) this;
        }

        public Criteria andCardDetailGreaterThanOrEqualTo(String value) {
            addCriterion("card_detail >=", value, "cardDetail");
            return (Criteria) this;
        }

        public Criteria andCardDetailLessThan(String value) {
            addCriterion("card_detail <", value, "cardDetail");
            return (Criteria) this;
        }

        public Criteria andCardDetailLessThanOrEqualTo(String value) {
            addCriterion("card_detail <=", value, "cardDetail");
            return (Criteria) this;
        }

        public Criteria andCardDetailLike(String value) {
            addCriterion("card_detail like", value, "cardDetail");
            return (Criteria) this;
        }

        public Criteria andCardDetailNotLike(String value) {
            addCriterion("card_detail not like", value, "cardDetail");
            return (Criteria) this;
        }

        public Criteria andCardDetailIn(List<String> values) {
            addCriterion("card_detail in", values, "cardDetail");
            return (Criteria) this;
        }

        public Criteria andCardDetailNotIn(List<String> values) {
            addCriterion("card_detail not in", values, "cardDetail");
            return (Criteria) this;
        }

        public Criteria andCardDetailBetween(String value1, String value2) {
            addCriterion("card_detail between", value1, value2, "cardDetail");
            return (Criteria) this;
        }

        public Criteria andCardDetailNotBetween(String value1, String value2) {
            addCriterion("card_detail not between", value1, value2, "cardDetail");
            return (Criteria) this;
        }

        public Criteria andEveryDayFreeCoinIsNull() {
            addCriterion("every_day_free_coin is null");
            return (Criteria) this;
        }

        public Criteria andEveryDayFreeCoinIsNotNull() {
            addCriterion("every_day_free_coin is not null");
            return (Criteria) this;
        }

        public Criteria andEveryDayFreeCoinEqualTo(Integer value) {
            addCriterion("every_day_free_coin =", value, "everyDayFreeCoin");
            return (Criteria) this;
        }

        public Criteria andEveryDayFreeCoinNotEqualTo(Integer value) {
            addCriterion("every_day_free_coin <>", value, "everyDayFreeCoin");
            return (Criteria) this;
        }

        public Criteria andEveryDayFreeCoinGreaterThan(Integer value) {
            addCriterion("every_day_free_coin >", value, "everyDayFreeCoin");
            return (Criteria) this;
        }

        public Criteria andEveryDayFreeCoinGreaterThanOrEqualTo(Integer value) {
            addCriterion("every_day_free_coin >=", value, "everyDayFreeCoin");
            return (Criteria) this;
        }

        public Criteria andEveryDayFreeCoinLessThan(Integer value) {
            addCriterion("every_day_free_coin <", value, "everyDayFreeCoin");
            return (Criteria) this;
        }

        public Criteria andEveryDayFreeCoinLessThanOrEqualTo(Integer value) {
            addCriterion("every_day_free_coin <=", value, "everyDayFreeCoin");
            return (Criteria) this;
        }

        public Criteria andEveryDayFreeCoinIn(List<Integer> values) {
            addCriterion("every_day_free_coin in", values, "everyDayFreeCoin");
            return (Criteria) this;
        }

        public Criteria andEveryDayFreeCoinNotIn(List<Integer> values) {
            addCriterion("every_day_free_coin not in", values, "everyDayFreeCoin");
            return (Criteria) this;
        }

        public Criteria andEveryDayFreeCoinBetween(Integer value1, Integer value2) {
            addCriterion("every_day_free_coin between", value1, value2, "everyDayFreeCoin");
            return (Criteria) this;
        }

        public Criteria andEveryDayFreeCoinNotBetween(Integer value1, Integer value2) {
            addCriterion("every_day_free_coin not between", value1, value2, "everyDayFreeCoin");
            return (Criteria) this;
        }

        public Criteria andTotalFreeCoinIsNull() {
            addCriterion("total_free_coin is null");
            return (Criteria) this;
        }

        public Criteria andTotalFreeCoinIsNotNull() {
            addCriterion("total_free_coin is not null");
            return (Criteria) this;
        }

        public Criteria andTotalFreeCoinEqualTo(Integer value) {
            addCriterion("total_free_coin =", value, "totalFreeCoin");
            return (Criteria) this;
        }

        public Criteria andTotalFreeCoinNotEqualTo(Integer value) {
            addCriterion("total_free_coin <>", value, "totalFreeCoin");
            return (Criteria) this;
        }

        public Criteria andTotalFreeCoinGreaterThan(Integer value) {
            addCriterion("total_free_coin >", value, "totalFreeCoin");
            return (Criteria) this;
        }

        public Criteria andTotalFreeCoinGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_free_coin >=", value, "totalFreeCoin");
            return (Criteria) this;
        }

        public Criteria andTotalFreeCoinLessThan(Integer value) {
            addCriterion("total_free_coin <", value, "totalFreeCoin");
            return (Criteria) this;
        }

        public Criteria andTotalFreeCoinLessThanOrEqualTo(Integer value) {
            addCriterion("total_free_coin <=", value, "totalFreeCoin");
            return (Criteria) this;
        }

        public Criteria andTotalFreeCoinIn(List<Integer> values) {
            addCriterion("total_free_coin in", values, "totalFreeCoin");
            return (Criteria) this;
        }

        public Criteria andTotalFreeCoinNotIn(List<Integer> values) {
            addCriterion("total_free_coin not in", values, "totalFreeCoin");
            return (Criteria) this;
        }

        public Criteria andTotalFreeCoinBetween(Integer value1, Integer value2) {
            addCriterion("total_free_coin between", value1, value2, "totalFreeCoin");
            return (Criteria) this;
        }

        public Criteria andTotalFreeCoinNotBetween(Integer value1, Integer value2) {
            addCriterion("total_free_coin not between", value1, value2, "totalFreeCoin");
            return (Criteria) this;
        }

        public Criteria andSignTimeIsNull() {
            addCriterion("sign_time is null");
            return (Criteria) this;
        }

        public Criteria andSignTimeIsNotNull() {
            addCriterion("sign_time is not null");
            return (Criteria) this;
        }

        public Criteria andSignTimeEqualTo(Integer value) {
            addCriterion("sign_time =", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeNotEqualTo(Integer value) {
            addCriterion("sign_time <>", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeGreaterThan(Integer value) {
            addCriterion("sign_time >", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("sign_time >=", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeLessThan(Integer value) {
            addCriterion("sign_time <", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeLessThanOrEqualTo(Integer value) {
            addCriterion("sign_time <=", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeIn(List<Integer> values) {
            addCriterion("sign_time in", values, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeNotIn(List<Integer> values) {
            addCriterion("sign_time not in", values, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeBetween(Integer value1, Integer value2) {
            addCriterion("sign_time between", value1, value2, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("sign_time not between", value1, value2, "signTime");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNull() {
            addCriterion("card_type is null");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNotNull() {
            addCriterion("card_type is not null");
            return (Criteria) this;
        }

        public Criteria andCardTypeEqualTo(Integer value) {
            addCriterion("card_type =", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotEqualTo(Integer value) {
            addCriterion("card_type <>", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThan(Integer value) {
            addCriterion("card_type >", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("card_type >=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThan(Integer value) {
            addCriterion("card_type <", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThanOrEqualTo(Integer value) {
            addCriterion("card_type <=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeIn(List<Integer> values) {
            addCriterion("card_type in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotIn(List<Integer> values) {
            addCriterion("card_type not in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeBetween(Integer value1, Integer value2) {
            addCriterion("card_type between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("card_type not between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardSaleNumIsNull() {
            addCriterion("card_sale_num is null");
            return (Criteria) this;
        }

        public Criteria andCardSaleNumIsNotNull() {
            addCriterion("card_sale_num is not null");
            return (Criteria) this;
        }

        public Criteria andCardSaleNumEqualTo(Integer value) {
            addCriterion("card_sale_num =", value, "cardSaleNum");
            return (Criteria) this;
        }

        public Criteria andCardSaleNumNotEqualTo(Integer value) {
            addCriterion("card_sale_num <>", value, "cardSaleNum");
            return (Criteria) this;
        }

        public Criteria andCardSaleNumGreaterThan(Integer value) {
            addCriterion("card_sale_num >", value, "cardSaleNum");
            return (Criteria) this;
        }

        public Criteria andCardSaleNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("card_sale_num >=", value, "cardSaleNum");
            return (Criteria) this;
        }

        public Criteria andCardSaleNumLessThan(Integer value) {
            addCriterion("card_sale_num <", value, "cardSaleNum");
            return (Criteria) this;
        }

        public Criteria andCardSaleNumLessThanOrEqualTo(Integer value) {
            addCriterion("card_sale_num <=", value, "cardSaleNum");
            return (Criteria) this;
        }

        public Criteria andCardSaleNumIn(List<Integer> values) {
            addCriterion("card_sale_num in", values, "cardSaleNum");
            return (Criteria) this;
        }

        public Criteria andCardSaleNumNotIn(List<Integer> values) {
            addCriterion("card_sale_num not in", values, "cardSaleNum");
            return (Criteria) this;
        }

        public Criteria andCardSaleNumBetween(Integer value1, Integer value2) {
            addCriterion("card_sale_num between", value1, value2, "cardSaleNum");
            return (Criteria) this;
        }

        public Criteria andCardSaleNumNotBetween(Integer value1, Integer value2) {
            addCriterion("card_sale_num not between", value1, value2, "cardSaleNum");
            return (Criteria) this;
        }

        public Criteria andCardtTotalNumIsNull() {
            addCriterion("cardt_total_num is null");
            return (Criteria) this;
        }

        public Criteria andCardtTotalNumIsNotNull() {
            addCriterion("cardt_total_num is not null");
            return (Criteria) this;
        }

        public Criteria andCardtTotalNumEqualTo(Integer value) {
            addCriterion("cardt_total_num =", value, "cardtTotalNum");
            return (Criteria) this;
        }

        public Criteria andCardtTotalNumNotEqualTo(Integer value) {
            addCriterion("cardt_total_num <>", value, "cardtTotalNum");
            return (Criteria) this;
        }

        public Criteria andCardtTotalNumGreaterThan(Integer value) {
            addCriterion("cardt_total_num >", value, "cardtTotalNum");
            return (Criteria) this;
        }

        public Criteria andCardtTotalNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("cardt_total_num >=", value, "cardtTotalNum");
            return (Criteria) this;
        }

        public Criteria andCardtTotalNumLessThan(Integer value) {
            addCriterion("cardt_total_num <", value, "cardtTotalNum");
            return (Criteria) this;
        }

        public Criteria andCardtTotalNumLessThanOrEqualTo(Integer value) {
            addCriterion("cardt_total_num <=", value, "cardtTotalNum");
            return (Criteria) this;
        }

        public Criteria andCardtTotalNumIn(List<Integer> values) {
            addCriterion("cardt_total_num in", values, "cardtTotalNum");
            return (Criteria) this;
        }

        public Criteria andCardtTotalNumNotIn(List<Integer> values) {
            addCriterion("cardt_total_num not in", values, "cardtTotalNum");
            return (Criteria) this;
        }

        public Criteria andCardtTotalNumBetween(Integer value1, Integer value2) {
            addCriterion("cardt_total_num between", value1, value2, "cardtTotalNum");
            return (Criteria) this;
        }

        public Criteria andCardtTotalNumNotBetween(Integer value1, Integer value2) {
            addCriterion("cardt_total_num not between", value1, value2, "cardtTotalNum");
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