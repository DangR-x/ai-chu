package com.aichu.dao.autogeneration.object;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AcOrderWithdrawExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AcOrderWithdrawExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andWithDrawOutTradeNoIsNull() {
            addCriterion("with_draw_out_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andWithDrawOutTradeNoIsNotNull() {
            addCriterion("with_draw_out_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andWithDrawOutTradeNoEqualTo(String value) {
            addCriterion("with_draw_out_trade_no =", value, "withDrawOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andWithDrawOutTradeNoNotEqualTo(String value) {
            addCriterion("with_draw_out_trade_no <>", value, "withDrawOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andWithDrawOutTradeNoGreaterThan(String value) {
            addCriterion("with_draw_out_trade_no >", value, "withDrawOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andWithDrawOutTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("with_draw_out_trade_no >=", value, "withDrawOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andWithDrawOutTradeNoLessThan(String value) {
            addCriterion("with_draw_out_trade_no <", value, "withDrawOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andWithDrawOutTradeNoLessThanOrEqualTo(String value) {
            addCriterion("with_draw_out_trade_no <=", value, "withDrawOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andWithDrawOutTradeNoLike(String value) {
            addCriterion("with_draw_out_trade_no like", value, "withDrawOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andWithDrawOutTradeNoNotLike(String value) {
            addCriterion("with_draw_out_trade_no not like", value, "withDrawOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andWithDrawOutTradeNoIn(List<String> values) {
            addCriterion("with_draw_out_trade_no in", values, "withDrawOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andWithDrawOutTradeNoNotIn(List<String> values) {
            addCriterion("with_draw_out_trade_no not in", values, "withDrawOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andWithDrawOutTradeNoBetween(String value1, String value2) {
            addCriterion("with_draw_out_trade_no between", value1, value2, "withDrawOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andWithDrawOutTradeNoNotBetween(String value1, String value2) {
            addCriterion("with_draw_out_trade_no not between", value1, value2, "withDrawOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andWithDrawDesIsNull() {
            addCriterion("with_draw_des is null");
            return (Criteria) this;
        }

        public Criteria andWithDrawDesIsNotNull() {
            addCriterion("with_draw_des is not null");
            return (Criteria) this;
        }

        public Criteria andWithDrawDesEqualTo(String value) {
            addCriterion("with_draw_des =", value, "withDrawDes");
            return (Criteria) this;
        }

        public Criteria andWithDrawDesNotEqualTo(String value) {
            addCriterion("with_draw_des <>", value, "withDrawDes");
            return (Criteria) this;
        }

        public Criteria andWithDrawDesGreaterThan(String value) {
            addCriterion("with_draw_des >", value, "withDrawDes");
            return (Criteria) this;
        }

        public Criteria andWithDrawDesGreaterThanOrEqualTo(String value) {
            addCriterion("with_draw_des >=", value, "withDrawDes");
            return (Criteria) this;
        }

        public Criteria andWithDrawDesLessThan(String value) {
            addCriterion("with_draw_des <", value, "withDrawDes");
            return (Criteria) this;
        }

        public Criteria andWithDrawDesLessThanOrEqualTo(String value) {
            addCriterion("with_draw_des <=", value, "withDrawDes");
            return (Criteria) this;
        }

        public Criteria andWithDrawDesLike(String value) {
            addCriterion("with_draw_des like", value, "withDrawDes");
            return (Criteria) this;
        }

        public Criteria andWithDrawDesNotLike(String value) {
            addCriterion("with_draw_des not like", value, "withDrawDes");
            return (Criteria) this;
        }

        public Criteria andWithDrawDesIn(List<String> values) {
            addCriterion("with_draw_des in", values, "withDrawDes");
            return (Criteria) this;
        }

        public Criteria andWithDrawDesNotIn(List<String> values) {
            addCriterion("with_draw_des not in", values, "withDrawDes");
            return (Criteria) this;
        }

        public Criteria andWithDrawDesBetween(String value1, String value2) {
            addCriterion("with_draw_des between", value1, value2, "withDrawDes");
            return (Criteria) this;
        }

        public Criteria andWithDrawDesNotBetween(String value1, String value2) {
            addCriterion("with_draw_des not between", value1, value2, "withDrawDes");
            return (Criteria) this;
        }

        public Criteria andWithDrawMoneyIsNull() {
            addCriterion("with_draw_money is null");
            return (Criteria) this;
        }

        public Criteria andWithDrawMoneyIsNotNull() {
            addCriterion("with_draw_money is not null");
            return (Criteria) this;
        }

        public Criteria andWithDrawMoneyEqualTo(Integer value) {
            addCriterion("with_draw_money =", value, "withDrawMoney");
            return (Criteria) this;
        }

        public Criteria andWithDrawMoneyNotEqualTo(Integer value) {
            addCriterion("with_draw_money <>", value, "withDrawMoney");
            return (Criteria) this;
        }

        public Criteria andWithDrawMoneyGreaterThan(Integer value) {
            addCriterion("with_draw_money >", value, "withDrawMoney");
            return (Criteria) this;
        }

        public Criteria andWithDrawMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("with_draw_money >=", value, "withDrawMoney");
            return (Criteria) this;
        }

        public Criteria andWithDrawMoneyLessThan(Integer value) {
            addCriterion("with_draw_money <", value, "withDrawMoney");
            return (Criteria) this;
        }

        public Criteria andWithDrawMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("with_draw_money <=", value, "withDrawMoney");
            return (Criteria) this;
        }

        public Criteria andWithDrawMoneyIn(List<Integer> values) {
            addCriterion("with_draw_money in", values, "withDrawMoney");
            return (Criteria) this;
        }

        public Criteria andWithDrawMoneyNotIn(List<Integer> values) {
            addCriterion("with_draw_money not in", values, "withDrawMoney");
            return (Criteria) this;
        }

        public Criteria andWithDrawMoneyBetween(Integer value1, Integer value2) {
            addCriterion("with_draw_money between", value1, value2, "withDrawMoney");
            return (Criteria) this;
        }

        public Criteria andWithDrawMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("with_draw_money not between", value1, value2, "withDrawMoney");
            return (Criteria) this;
        }

        public Criteria andWithDrawStatusIsNull() {
            addCriterion("with_draw_status is null");
            return (Criteria) this;
        }

        public Criteria andWithDrawStatusIsNotNull() {
            addCriterion("with_draw_status is not null");
            return (Criteria) this;
        }

        public Criteria andWithDrawStatusEqualTo(Integer value) {
            addCriterion("with_draw_status =", value, "withDrawStatus");
            return (Criteria) this;
        }

        public Criteria andWithDrawStatusNotEqualTo(Integer value) {
            addCriterion("with_draw_status <>", value, "withDrawStatus");
            return (Criteria) this;
        }

        public Criteria andWithDrawStatusGreaterThan(Integer value) {
            addCriterion("with_draw_status >", value, "withDrawStatus");
            return (Criteria) this;
        }

        public Criteria andWithDrawStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("with_draw_status >=", value, "withDrawStatus");
            return (Criteria) this;
        }

        public Criteria andWithDrawStatusLessThan(Integer value) {
            addCriterion("with_draw_status <", value, "withDrawStatus");
            return (Criteria) this;
        }

        public Criteria andWithDrawStatusLessThanOrEqualTo(Integer value) {
            addCriterion("with_draw_status <=", value, "withDrawStatus");
            return (Criteria) this;
        }

        public Criteria andWithDrawStatusIn(List<Integer> values) {
            addCriterion("with_draw_status in", values, "withDrawStatus");
            return (Criteria) this;
        }

        public Criteria andWithDrawStatusNotIn(List<Integer> values) {
            addCriterion("with_draw_status not in", values, "withDrawStatus");
            return (Criteria) this;
        }

        public Criteria andWithDrawStatusBetween(Integer value1, Integer value2) {
            addCriterion("with_draw_status between", value1, value2, "withDrawStatus");
            return (Criteria) this;
        }

        public Criteria andWithDrawStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("with_draw_status not between", value1, value2, "withDrawStatus");
            return (Criteria) this;
        }

        public Criteria andWithDrawNickNameIsNull() {
            addCriterion("with_draw_nick_name is null");
            return (Criteria) this;
        }

        public Criteria andWithDrawNickNameIsNotNull() {
            addCriterion("with_draw_nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andWithDrawNickNameEqualTo(String value) {
            addCriterion("with_draw_nick_name =", value, "withDrawNickName");
            return (Criteria) this;
        }

        public Criteria andWithDrawNickNameNotEqualTo(String value) {
            addCriterion("with_draw_nick_name <>", value, "withDrawNickName");
            return (Criteria) this;
        }

        public Criteria andWithDrawNickNameGreaterThan(String value) {
            addCriterion("with_draw_nick_name >", value, "withDrawNickName");
            return (Criteria) this;
        }

        public Criteria andWithDrawNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("with_draw_nick_name >=", value, "withDrawNickName");
            return (Criteria) this;
        }

        public Criteria andWithDrawNickNameLessThan(String value) {
            addCriterion("with_draw_nick_name <", value, "withDrawNickName");
            return (Criteria) this;
        }

        public Criteria andWithDrawNickNameLessThanOrEqualTo(String value) {
            addCriterion("with_draw_nick_name <=", value, "withDrawNickName");
            return (Criteria) this;
        }

        public Criteria andWithDrawNickNameLike(String value) {
            addCriterion("with_draw_nick_name like", value, "withDrawNickName");
            return (Criteria) this;
        }

        public Criteria andWithDrawNickNameNotLike(String value) {
            addCriterion("with_draw_nick_name not like", value, "withDrawNickName");
            return (Criteria) this;
        }

        public Criteria andWithDrawNickNameIn(List<String> values) {
            addCriterion("with_draw_nick_name in", values, "withDrawNickName");
            return (Criteria) this;
        }

        public Criteria andWithDrawNickNameNotIn(List<String> values) {
            addCriterion("with_draw_nick_name not in", values, "withDrawNickName");
            return (Criteria) this;
        }

        public Criteria andWithDrawNickNameBetween(String value1, String value2) {
            addCriterion("with_draw_nick_name between", value1, value2, "withDrawNickName");
            return (Criteria) this;
        }

        public Criteria andWithDrawNickNameNotBetween(String value1, String value2) {
            addCriterion("with_draw_nick_name not between", value1, value2, "withDrawNickName");
            return (Criteria) this;
        }

        public Criteria andWithDrawAccountIsNull() {
            addCriterion("with_draw_account is null");
            return (Criteria) this;
        }

        public Criteria andWithDrawAccountIsNotNull() {
            addCriterion("with_draw_account is not null");
            return (Criteria) this;
        }

        public Criteria andWithDrawAccountEqualTo(String value) {
            addCriterion("with_draw_account =", value, "withDrawAccount");
            return (Criteria) this;
        }

        public Criteria andWithDrawAccountNotEqualTo(String value) {
            addCriterion("with_draw_account <>", value, "withDrawAccount");
            return (Criteria) this;
        }

        public Criteria andWithDrawAccountGreaterThan(String value) {
            addCriterion("with_draw_account >", value, "withDrawAccount");
            return (Criteria) this;
        }

        public Criteria andWithDrawAccountGreaterThanOrEqualTo(String value) {
            addCriterion("with_draw_account >=", value, "withDrawAccount");
            return (Criteria) this;
        }

        public Criteria andWithDrawAccountLessThan(String value) {
            addCriterion("with_draw_account <", value, "withDrawAccount");
            return (Criteria) this;
        }

        public Criteria andWithDrawAccountLessThanOrEqualTo(String value) {
            addCriterion("with_draw_account <=", value, "withDrawAccount");
            return (Criteria) this;
        }

        public Criteria andWithDrawAccountLike(String value) {
            addCriterion("with_draw_account like", value, "withDrawAccount");
            return (Criteria) this;
        }

        public Criteria andWithDrawAccountNotLike(String value) {
            addCriterion("with_draw_account not like", value, "withDrawAccount");
            return (Criteria) this;
        }

        public Criteria andWithDrawAccountIn(List<String> values) {
            addCriterion("with_draw_account in", values, "withDrawAccount");
            return (Criteria) this;
        }

        public Criteria andWithDrawAccountNotIn(List<String> values) {
            addCriterion("with_draw_account not in", values, "withDrawAccount");
            return (Criteria) this;
        }

        public Criteria andWithDrawAccountBetween(String value1, String value2) {
            addCriterion("with_draw_account between", value1, value2, "withDrawAccount");
            return (Criteria) this;
        }

        public Criteria andWithDrawAccountNotBetween(String value1, String value2) {
            addCriterion("with_draw_account not between", value1, value2, "withDrawAccount");
            return (Criteria) this;
        }

        public Criteria andWithDrawTypeIsNull() {
            addCriterion("with_draw_type is null");
            return (Criteria) this;
        }

        public Criteria andWithDrawTypeIsNotNull() {
            addCriterion("with_draw_type is not null");
            return (Criteria) this;
        }

        public Criteria andWithDrawTypeEqualTo(Integer value) {
            addCriterion("with_draw_type =", value, "withDrawType");
            return (Criteria) this;
        }

        public Criteria andWithDrawTypeNotEqualTo(Integer value) {
            addCriterion("with_draw_type <>", value, "withDrawType");
            return (Criteria) this;
        }

        public Criteria andWithDrawTypeGreaterThan(Integer value) {
            addCriterion("with_draw_type >", value, "withDrawType");
            return (Criteria) this;
        }

        public Criteria andWithDrawTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("with_draw_type >=", value, "withDrawType");
            return (Criteria) this;
        }

        public Criteria andWithDrawTypeLessThan(Integer value) {
            addCriterion("with_draw_type <", value, "withDrawType");
            return (Criteria) this;
        }

        public Criteria andWithDrawTypeLessThanOrEqualTo(Integer value) {
            addCriterion("with_draw_type <=", value, "withDrawType");
            return (Criteria) this;
        }

        public Criteria andWithDrawTypeIn(List<Integer> values) {
            addCriterion("with_draw_type in", values, "withDrawType");
            return (Criteria) this;
        }

        public Criteria andWithDrawTypeNotIn(List<Integer> values) {
            addCriterion("with_draw_type not in", values, "withDrawType");
            return (Criteria) this;
        }

        public Criteria andWithDrawTypeBetween(Integer value1, Integer value2) {
            addCriterion("with_draw_type between", value1, value2, "withDrawType");
            return (Criteria) this;
        }

        public Criteria andWithDrawTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("with_draw_type not between", value1, value2, "withDrawType");
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