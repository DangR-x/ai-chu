package com.aichu.dao.autogeneration.object;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WzUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WzUserExample() {
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

        public Criteria andWzUidIsNull() {
            addCriterion("wz_uid is null");
            return (Criteria) this;
        }

        public Criteria andWzUidIsNotNull() {
            addCriterion("wz_uid is not null");
            return (Criteria) this;
        }

        public Criteria andWzUidEqualTo(String value) {
            addCriterion("wz_uid =", value, "wzUid");
            return (Criteria) this;
        }

        public Criteria andWzUidNotEqualTo(String value) {
            addCriterion("wz_uid <>", value, "wzUid");
            return (Criteria) this;
        }

        public Criteria andWzUidGreaterThan(String value) {
            addCriterion("wz_uid >", value, "wzUid");
            return (Criteria) this;
        }

        public Criteria andWzUidGreaterThanOrEqualTo(String value) {
            addCriterion("wz_uid >=", value, "wzUid");
            return (Criteria) this;
        }

        public Criteria andWzUidLessThan(String value) {
            addCriterion("wz_uid <", value, "wzUid");
            return (Criteria) this;
        }

        public Criteria andWzUidLessThanOrEqualTo(String value) {
            addCriterion("wz_uid <=", value, "wzUid");
            return (Criteria) this;
        }

        public Criteria andWzUidLike(String value) {
            addCriterion("wz_uid like", value, "wzUid");
            return (Criteria) this;
        }

        public Criteria andWzUidNotLike(String value) {
            addCriterion("wz_uid not like", value, "wzUid");
            return (Criteria) this;
        }

        public Criteria andWzUidIn(List<String> values) {
            addCriterion("wz_uid in", values, "wzUid");
            return (Criteria) this;
        }

        public Criteria andWzUidNotIn(List<String> values) {
            addCriterion("wz_uid not in", values, "wzUid");
            return (Criteria) this;
        }

        public Criteria andWzUidBetween(String value1, String value2) {
            addCriterion("wz_uid between", value1, value2, "wzUid");
            return (Criteria) this;
        }

        public Criteria andWzUidNotBetween(String value1, String value2) {
            addCriterion("wz_uid not between", value1, value2, "wzUid");
            return (Criteria) this;
        }

        public Criteria andFirstNameIsNull() {
            addCriterion("first_name is null");
            return (Criteria) this;
        }

        public Criteria andFirstNameIsNotNull() {
            addCriterion("first_name is not null");
            return (Criteria) this;
        }

        public Criteria andFirstNameEqualTo(String value) {
            addCriterion("first_name =", value, "firstName");
            return (Criteria) this;
        }

        public Criteria andFirstNameNotEqualTo(String value) {
            addCriterion("first_name <>", value, "firstName");
            return (Criteria) this;
        }

        public Criteria andFirstNameGreaterThan(String value) {
            addCriterion("first_name >", value, "firstName");
            return (Criteria) this;
        }

        public Criteria andFirstNameGreaterThanOrEqualTo(String value) {
            addCriterion("first_name >=", value, "firstName");
            return (Criteria) this;
        }

        public Criteria andFirstNameLessThan(String value) {
            addCriterion("first_name <", value, "firstName");
            return (Criteria) this;
        }

        public Criteria andFirstNameLessThanOrEqualTo(String value) {
            addCriterion("first_name <=", value, "firstName");
            return (Criteria) this;
        }

        public Criteria andFirstNameLike(String value) {
            addCriterion("first_name like", value, "firstName");
            return (Criteria) this;
        }

        public Criteria andFirstNameNotLike(String value) {
            addCriterion("first_name not like", value, "firstName");
            return (Criteria) this;
        }

        public Criteria andFirstNameIn(List<String> values) {
            addCriterion("first_name in", values, "firstName");
            return (Criteria) this;
        }

        public Criteria andFirstNameNotIn(List<String> values) {
            addCriterion("first_name not in", values, "firstName");
            return (Criteria) this;
        }

        public Criteria andFirstNameBetween(String value1, String value2) {
            addCriterion("first_name between", value1, value2, "firstName");
            return (Criteria) this;
        }

        public Criteria andFirstNameNotBetween(String value1, String value2) {
            addCriterion("first_name not between", value1, value2, "firstName");
            return (Criteria) this;
        }

        public Criteria andLastNameIsNull() {
            addCriterion("last_name is null");
            return (Criteria) this;
        }

        public Criteria andLastNameIsNotNull() {
            addCriterion("last_name is not null");
            return (Criteria) this;
        }

        public Criteria andLastNameEqualTo(String value) {
            addCriterion("last_name =", value, "lastName");
            return (Criteria) this;
        }

        public Criteria andLastNameNotEqualTo(String value) {
            addCriterion("last_name <>", value, "lastName");
            return (Criteria) this;
        }

        public Criteria andLastNameGreaterThan(String value) {
            addCriterion("last_name >", value, "lastName");
            return (Criteria) this;
        }

        public Criteria andLastNameGreaterThanOrEqualTo(String value) {
            addCriterion("last_name >=", value, "lastName");
            return (Criteria) this;
        }

        public Criteria andLastNameLessThan(String value) {
            addCriterion("last_name <", value, "lastName");
            return (Criteria) this;
        }

        public Criteria andLastNameLessThanOrEqualTo(String value) {
            addCriterion("last_name <=", value, "lastName");
            return (Criteria) this;
        }

        public Criteria andLastNameLike(String value) {
            addCriterion("last_name like", value, "lastName");
            return (Criteria) this;
        }

        public Criteria andLastNameNotLike(String value) {
            addCriterion("last_name not like", value, "lastName");
            return (Criteria) this;
        }

        public Criteria andLastNameIn(List<String> values) {
            addCriterion("last_name in", values, "lastName");
            return (Criteria) this;
        }

        public Criteria andLastNameNotIn(List<String> values) {
            addCriterion("last_name not in", values, "lastName");
            return (Criteria) this;
        }

        public Criteria andLastNameBetween(String value1, String value2) {
            addCriterion("last_name between", value1, value2, "lastName");
            return (Criteria) this;
        }

        public Criteria andLastNameNotBetween(String value1, String value2) {
            addCriterion("last_name not between", value1, value2, "lastName");
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

        public Criteria andCoverFamilyIsNull() {
            addCriterion("cover_family is null");
            return (Criteria) this;
        }

        public Criteria andCoverFamilyIsNotNull() {
            addCriterion("cover_family is not null");
            return (Criteria) this;
        }

        public Criteria andCoverFamilyEqualTo(String value) {
            addCriterion("cover_family =", value, "coverFamily");
            return (Criteria) this;
        }

        public Criteria andCoverFamilyNotEqualTo(String value) {
            addCriterion("cover_family <>", value, "coverFamily");
            return (Criteria) this;
        }

        public Criteria andCoverFamilyGreaterThan(String value) {
            addCriterion("cover_family >", value, "coverFamily");
            return (Criteria) this;
        }

        public Criteria andCoverFamilyGreaterThanOrEqualTo(String value) {
            addCriterion("cover_family >=", value, "coverFamily");
            return (Criteria) this;
        }

        public Criteria andCoverFamilyLessThan(String value) {
            addCriterion("cover_family <", value, "coverFamily");
            return (Criteria) this;
        }

        public Criteria andCoverFamilyLessThanOrEqualTo(String value) {
            addCriterion("cover_family <=", value, "coverFamily");
            return (Criteria) this;
        }

        public Criteria andCoverFamilyLike(String value) {
            addCriterion("cover_family like", value, "coverFamily");
            return (Criteria) this;
        }

        public Criteria andCoverFamilyNotLike(String value) {
            addCriterion("cover_family not like", value, "coverFamily");
            return (Criteria) this;
        }

        public Criteria andCoverFamilyIn(List<String> values) {
            addCriterion("cover_family in", values, "coverFamily");
            return (Criteria) this;
        }

        public Criteria andCoverFamilyNotIn(List<String> values) {
            addCriterion("cover_family not in", values, "coverFamily");
            return (Criteria) this;
        }

        public Criteria andCoverFamilyBetween(String value1, String value2) {
            addCriterion("cover_family between", value1, value2, "coverFamily");
            return (Criteria) this;
        }

        public Criteria andCoverFamilyNotBetween(String value1, String value2) {
            addCriterion("cover_family not between", value1, value2, "coverFamily");
            return (Criteria) this;
        }

        public Criteria andCoverSocietyIsNull() {
            addCriterion("cover_society is null");
            return (Criteria) this;
        }

        public Criteria andCoverSocietyIsNotNull() {
            addCriterion("cover_society is not null");
            return (Criteria) this;
        }

        public Criteria andCoverSocietyEqualTo(String value) {
            addCriterion("cover_society =", value, "coverSociety");
            return (Criteria) this;
        }

        public Criteria andCoverSocietyNotEqualTo(String value) {
            addCriterion("cover_society <>", value, "coverSociety");
            return (Criteria) this;
        }

        public Criteria andCoverSocietyGreaterThan(String value) {
            addCriterion("cover_society >", value, "coverSociety");
            return (Criteria) this;
        }

        public Criteria andCoverSocietyGreaterThanOrEqualTo(String value) {
            addCriterion("cover_society >=", value, "coverSociety");
            return (Criteria) this;
        }

        public Criteria andCoverSocietyLessThan(String value) {
            addCriterion("cover_society <", value, "coverSociety");
            return (Criteria) this;
        }

        public Criteria andCoverSocietyLessThanOrEqualTo(String value) {
            addCriterion("cover_society <=", value, "coverSociety");
            return (Criteria) this;
        }

        public Criteria andCoverSocietyLike(String value) {
            addCriterion("cover_society like", value, "coverSociety");
            return (Criteria) this;
        }

        public Criteria andCoverSocietyNotLike(String value) {
            addCriterion("cover_society not like", value, "coverSociety");
            return (Criteria) this;
        }

        public Criteria andCoverSocietyIn(List<String> values) {
            addCriterion("cover_society in", values, "coverSociety");
            return (Criteria) this;
        }

        public Criteria andCoverSocietyNotIn(List<String> values) {
            addCriterion("cover_society not in", values, "coverSociety");
            return (Criteria) this;
        }

        public Criteria andCoverSocietyBetween(String value1, String value2) {
            addCriterion("cover_society between", value1, value2, "coverSociety");
            return (Criteria) this;
        }

        public Criteria andCoverSocietyNotBetween(String value1, String value2) {
            addCriterion("cover_society not between", value1, value2, "coverSociety");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNull() {
            addCriterion("id_card is null");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNotNull() {
            addCriterion("id_card is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardEqualTo(String value) {
            addCriterion("id_card =", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotEqualTo(String value) {
            addCriterion("id_card <>", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThan(String value) {
            addCriterion("id_card >", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("id_card >=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThan(String value) {
            addCriterion("id_card <", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThanOrEqualTo(String value) {
            addCriterion("id_card <=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLike(String value) {
            addCriterion("id_card like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotLike(String value) {
            addCriterion("id_card not like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardIn(List<String> values) {
            addCriterion("id_card in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotIn(List<String> values) {
            addCriterion("id_card not in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardBetween(String value1, String value2) {
            addCriterion("id_card between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotBetween(String value1, String value2) {
            addCriterion("id_card not between", value1, value2, "idCard");
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

        public Criteria andPassWordIsNull() {
            addCriterion("pass_word is null");
            return (Criteria) this;
        }

        public Criteria andPassWordIsNotNull() {
            addCriterion("pass_word is not null");
            return (Criteria) this;
        }

        public Criteria andPassWordEqualTo(String value) {
            addCriterion("pass_word =", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotEqualTo(String value) {
            addCriterion("pass_word <>", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordGreaterThan(String value) {
            addCriterion("pass_word >", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordGreaterThanOrEqualTo(String value) {
            addCriterion("pass_word >=", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordLessThan(String value) {
            addCriterion("pass_word <", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordLessThanOrEqualTo(String value) {
            addCriterion("pass_word <=", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordLike(String value) {
            addCriterion("pass_word like", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotLike(String value) {
            addCriterion("pass_word not like", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordIn(List<String> values) {
            addCriterion("pass_word in", values, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotIn(List<String> values) {
            addCriterion("pass_word not in", values, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordBetween(String value1, String value2) {
            addCriterion("pass_word between", value1, value2, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotBetween(String value1, String value2) {
            addCriterion("pass_word not between", value1, value2, "passWord");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(String value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(String value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(String value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(String value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(String value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLike(String value) {
            addCriterion("birthday like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotLike(String value) {
            addCriterion("birthday not like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<String> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<String> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(String value1, String value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(String value1, String value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andDeathdayIsNull() {
            addCriterion("deathday is null");
            return (Criteria) this;
        }

        public Criteria andDeathdayIsNotNull() {
            addCriterion("deathday is not null");
            return (Criteria) this;
        }

        public Criteria andDeathdayEqualTo(String value) {
            addCriterion("deathday =", value, "deathday");
            return (Criteria) this;
        }

        public Criteria andDeathdayNotEqualTo(String value) {
            addCriterion("deathday <>", value, "deathday");
            return (Criteria) this;
        }

        public Criteria andDeathdayGreaterThan(String value) {
            addCriterion("deathday >", value, "deathday");
            return (Criteria) this;
        }

        public Criteria andDeathdayGreaterThanOrEqualTo(String value) {
            addCriterion("deathday >=", value, "deathday");
            return (Criteria) this;
        }

        public Criteria andDeathdayLessThan(String value) {
            addCriterion("deathday <", value, "deathday");
            return (Criteria) this;
        }

        public Criteria andDeathdayLessThanOrEqualTo(String value) {
            addCriterion("deathday <=", value, "deathday");
            return (Criteria) this;
        }

        public Criteria andDeathdayLike(String value) {
            addCriterion("deathday like", value, "deathday");
            return (Criteria) this;
        }

        public Criteria andDeathdayNotLike(String value) {
            addCriterion("deathday not like", value, "deathday");
            return (Criteria) this;
        }

        public Criteria andDeathdayIn(List<String> values) {
            addCriterion("deathday in", values, "deathday");
            return (Criteria) this;
        }

        public Criteria andDeathdayNotIn(List<String> values) {
            addCriterion("deathday not in", values, "deathday");
            return (Criteria) this;
        }

        public Criteria andDeathdayBetween(String value1, String value2) {
            addCriterion("deathday between", value1, value2, "deathday");
            return (Criteria) this;
        }

        public Criteria andDeathdayNotBetween(String value1, String value2) {
            addCriterion("deathday not between", value1, value2, "deathday");
            return (Criteria) this;
        }

        public Criteria andDeathCriterionIsNull() {
            addCriterion("death_criterion is null");
            return (Criteria) this;
        }

        public Criteria andDeathCriterionIsNotNull() {
            addCriterion("death_criterion is not null");
            return (Criteria) this;
        }

        public Criteria andDeathCriterionEqualTo(Integer value) {
            addCriterion("death_criterion =", value, "deathCriterion");
            return (Criteria) this;
        }

        public Criteria andDeathCriterionNotEqualTo(Integer value) {
            addCriterion("death_criterion <>", value, "deathCriterion");
            return (Criteria) this;
        }

        public Criteria andDeathCriterionGreaterThan(Integer value) {
            addCriterion("death_criterion >", value, "deathCriterion");
            return (Criteria) this;
        }

        public Criteria andDeathCriterionGreaterThanOrEqualTo(Integer value) {
            addCriterion("death_criterion >=", value, "deathCriterion");
            return (Criteria) this;
        }

        public Criteria andDeathCriterionLessThan(Integer value) {
            addCriterion("death_criterion <", value, "deathCriterion");
            return (Criteria) this;
        }

        public Criteria andDeathCriterionLessThanOrEqualTo(Integer value) {
            addCriterion("death_criterion <=", value, "deathCriterion");
            return (Criteria) this;
        }

        public Criteria andDeathCriterionIn(List<Integer> values) {
            addCriterion("death_criterion in", values, "deathCriterion");
            return (Criteria) this;
        }

        public Criteria andDeathCriterionNotIn(List<Integer> values) {
            addCriterion("death_criterion not in", values, "deathCriterion");
            return (Criteria) this;
        }

        public Criteria andDeathCriterionBetween(Integer value1, Integer value2) {
            addCriterion("death_criterion between", value1, value2, "deathCriterion");
            return (Criteria) this;
        }

        public Criteria andDeathCriterionNotBetween(Integer value1, Integer value2) {
            addCriterion("death_criterion not between", value1, value2, "deathCriterion");
            return (Criteria) this;
        }

        public Criteria andDeathdayLunarIsNull() {
            addCriterion("deathday_lunar is null");
            return (Criteria) this;
        }

        public Criteria andDeathdayLunarIsNotNull() {
            addCriterion("deathday_lunar is not null");
            return (Criteria) this;
        }

        public Criteria andDeathdayLunarEqualTo(String value) {
            addCriterion("deathday_lunar =", value, "deathdayLunar");
            return (Criteria) this;
        }

        public Criteria andDeathdayLunarNotEqualTo(String value) {
            addCriterion("deathday_lunar <>", value, "deathdayLunar");
            return (Criteria) this;
        }

        public Criteria andDeathdayLunarGreaterThan(String value) {
            addCriterion("deathday_lunar >", value, "deathdayLunar");
            return (Criteria) this;
        }

        public Criteria andDeathdayLunarGreaterThanOrEqualTo(String value) {
            addCriterion("deathday_lunar >=", value, "deathdayLunar");
            return (Criteria) this;
        }

        public Criteria andDeathdayLunarLessThan(String value) {
            addCriterion("deathday_lunar <", value, "deathdayLunar");
            return (Criteria) this;
        }

        public Criteria andDeathdayLunarLessThanOrEqualTo(String value) {
            addCriterion("deathday_lunar <=", value, "deathdayLunar");
            return (Criteria) this;
        }

        public Criteria andDeathdayLunarLike(String value) {
            addCriterion("deathday_lunar like", value, "deathdayLunar");
            return (Criteria) this;
        }

        public Criteria andDeathdayLunarNotLike(String value) {
            addCriterion("deathday_lunar not like", value, "deathdayLunar");
            return (Criteria) this;
        }

        public Criteria andDeathdayLunarIn(List<String> values) {
            addCriterion("deathday_lunar in", values, "deathdayLunar");
            return (Criteria) this;
        }

        public Criteria andDeathdayLunarNotIn(List<String> values) {
            addCriterion("deathday_lunar not in", values, "deathdayLunar");
            return (Criteria) this;
        }

        public Criteria andDeathdayLunarBetween(String value1, String value2) {
            addCriterion("deathday_lunar between", value1, value2, "deathdayLunar");
            return (Criteria) this;
        }

        public Criteria andDeathdayLunarNotBetween(String value1, String value2) {
            addCriterion("deathday_lunar not between", value1, value2, "deathdayLunar");
            return (Criteria) this;
        }

        public Criteria andBirthdayLunarIsNull() {
            addCriterion("birthday_lunar is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayLunarIsNotNull() {
            addCriterion("birthday_lunar is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayLunarEqualTo(String value) {
            addCriterion("birthday_lunar =", value, "birthdayLunar");
            return (Criteria) this;
        }

        public Criteria andBirthdayLunarNotEqualTo(String value) {
            addCriterion("birthday_lunar <>", value, "birthdayLunar");
            return (Criteria) this;
        }

        public Criteria andBirthdayLunarGreaterThan(String value) {
            addCriterion("birthday_lunar >", value, "birthdayLunar");
            return (Criteria) this;
        }

        public Criteria andBirthdayLunarGreaterThanOrEqualTo(String value) {
            addCriterion("birthday_lunar >=", value, "birthdayLunar");
            return (Criteria) this;
        }

        public Criteria andBirthdayLunarLessThan(String value) {
            addCriterion("birthday_lunar <", value, "birthdayLunar");
            return (Criteria) this;
        }

        public Criteria andBirthdayLunarLessThanOrEqualTo(String value) {
            addCriterion("birthday_lunar <=", value, "birthdayLunar");
            return (Criteria) this;
        }

        public Criteria andBirthdayLunarLike(String value) {
            addCriterion("birthday_lunar like", value, "birthdayLunar");
            return (Criteria) this;
        }

        public Criteria andBirthdayLunarNotLike(String value) {
            addCriterion("birthday_lunar not like", value, "birthdayLunar");
            return (Criteria) this;
        }

        public Criteria andBirthdayLunarIn(List<String> values) {
            addCriterion("birthday_lunar in", values, "birthdayLunar");
            return (Criteria) this;
        }

        public Criteria andBirthdayLunarNotIn(List<String> values) {
            addCriterion("birthday_lunar not in", values, "birthdayLunar");
            return (Criteria) this;
        }

        public Criteria andBirthdayLunarBetween(String value1, String value2) {
            addCriterion("birthday_lunar between", value1, value2, "birthdayLunar");
            return (Criteria) this;
        }

        public Criteria andBirthdayLunarNotBetween(String value1, String value2) {
            addCriterion("birthday_lunar not between", value1, value2, "birthdayLunar");
            return (Criteria) this;
        }

        public Criteria andBirthCriterionIsNull() {
            addCriterion("birth_criterion is null");
            return (Criteria) this;
        }

        public Criteria andBirthCriterionIsNotNull() {
            addCriterion("birth_criterion is not null");
            return (Criteria) this;
        }

        public Criteria andBirthCriterionEqualTo(Integer value) {
            addCriterion("birth_criterion =", value, "birthCriterion");
            return (Criteria) this;
        }

        public Criteria andBirthCriterionNotEqualTo(Integer value) {
            addCriterion("birth_criterion <>", value, "birthCriterion");
            return (Criteria) this;
        }

        public Criteria andBirthCriterionGreaterThan(Integer value) {
            addCriterion("birth_criterion >", value, "birthCriterion");
            return (Criteria) this;
        }

        public Criteria andBirthCriterionGreaterThanOrEqualTo(Integer value) {
            addCriterion("birth_criterion >=", value, "birthCriterion");
            return (Criteria) this;
        }

        public Criteria andBirthCriterionLessThan(Integer value) {
            addCriterion("birth_criterion <", value, "birthCriterion");
            return (Criteria) this;
        }

        public Criteria andBirthCriterionLessThanOrEqualTo(Integer value) {
            addCriterion("birth_criterion <=", value, "birthCriterion");
            return (Criteria) this;
        }

        public Criteria andBirthCriterionIn(List<Integer> values) {
            addCriterion("birth_criterion in", values, "birthCriterion");
            return (Criteria) this;
        }

        public Criteria andBirthCriterionNotIn(List<Integer> values) {
            addCriterion("birth_criterion not in", values, "birthCriterion");
            return (Criteria) this;
        }

        public Criteria andBirthCriterionBetween(Integer value1, Integer value2) {
            addCriterion("birth_criterion between", value1, value2, "birthCriterion");
            return (Criteria) this;
        }

        public Criteria andBirthCriterionNotBetween(Integer value1, Integer value2) {
            addCriterion("birth_criterion not between", value1, value2, "birthCriterion");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Integer value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Integer value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Integer value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Integer> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Integer> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("number not between", value1, value2, "number");
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

        public Criteria andBusinessIsNull() {
            addCriterion("business is null");
            return (Criteria) this;
        }

        public Criteria andBusinessIsNotNull() {
            addCriterion("business is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessEqualTo(String value) {
            addCriterion("business =", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessNotEqualTo(String value) {
            addCriterion("business <>", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessGreaterThan(String value) {
            addCriterion("business >", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessGreaterThanOrEqualTo(String value) {
            addCriterion("business >=", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessLessThan(String value) {
            addCriterion("business <", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessLessThanOrEqualTo(String value) {
            addCriterion("business <=", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessLike(String value) {
            addCriterion("business like", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessNotLike(String value) {
            addCriterion("business not like", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessIn(List<String> values) {
            addCriterion("business in", values, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessNotIn(List<String> values) {
            addCriterion("business not in", values, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessBetween(String value1, String value2) {
            addCriterion("business between", value1, value2, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessNotBetween(String value1, String value2) {
            addCriterion("business not between", value1, value2, "business");
            return (Criteria) this;
        }

        public Criteria andOccupationIsNull() {
            addCriterion("occupation is null");
            return (Criteria) this;
        }

        public Criteria andOccupationIsNotNull() {
            addCriterion("occupation is not null");
            return (Criteria) this;
        }

        public Criteria andOccupationEqualTo(String value) {
            addCriterion("occupation =", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationNotEqualTo(String value) {
            addCriterion("occupation <>", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationGreaterThan(String value) {
            addCriterion("occupation >", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationGreaterThanOrEqualTo(String value) {
            addCriterion("occupation >=", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationLessThan(String value) {
            addCriterion("occupation <", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationLessThanOrEqualTo(String value) {
            addCriterion("occupation <=", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationLike(String value) {
            addCriterion("occupation like", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationNotLike(String value) {
            addCriterion("occupation not like", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationIn(List<String> values) {
            addCriterion("occupation in", values, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationNotIn(List<String> values) {
            addCriterion("occupation not in", values, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationBetween(String value1, String value2) {
            addCriterion("occupation between", value1, value2, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationNotBetween(String value1, String value2) {
            addCriterion("occupation not between", value1, value2, "occupation");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNull() {
            addCriterion("school is null");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNotNull() {
            addCriterion("school is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolEqualTo(String value) {
            addCriterion("school =", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotEqualTo(String value) {
            addCriterion("school <>", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThan(String value) {
            addCriterion("school >", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("school >=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThan(String value) {
            addCriterion("school <", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThanOrEqualTo(String value) {
            addCriterion("school <=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLike(String value) {
            addCriterion("school like", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotLike(String value) {
            addCriterion("school not like", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolIn(List<String> values) {
            addCriterion("school in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotIn(List<String> values) {
            addCriterion("school not in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolBetween(String value1, String value2) {
            addCriterion("school between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotBetween(String value1, String value2) {
            addCriterion("school not between", value1, value2, "school");
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

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Integer value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Integer value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Integer value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Integer value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Integer value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Integer> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Integer> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Integer value1, Integer value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andFamilyTreeIdIsNull() {
            addCriterion("family_tree_id is null");
            return (Criteria) this;
        }

        public Criteria andFamilyTreeIdIsNotNull() {
            addCriterion("family_tree_id is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyTreeIdEqualTo(Integer value) {
            addCriterion("family_tree_id =", value, "familyTreeId");
            return (Criteria) this;
        }

        public Criteria andFamilyTreeIdNotEqualTo(Integer value) {
            addCriterion("family_tree_id <>", value, "familyTreeId");
            return (Criteria) this;
        }

        public Criteria andFamilyTreeIdGreaterThan(Integer value) {
            addCriterion("family_tree_id >", value, "familyTreeId");
            return (Criteria) this;
        }

        public Criteria andFamilyTreeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("family_tree_id >=", value, "familyTreeId");
            return (Criteria) this;
        }

        public Criteria andFamilyTreeIdLessThan(Integer value) {
            addCriterion("family_tree_id <", value, "familyTreeId");
            return (Criteria) this;
        }

        public Criteria andFamilyTreeIdLessThanOrEqualTo(Integer value) {
            addCriterion("family_tree_id <=", value, "familyTreeId");
            return (Criteria) this;
        }

        public Criteria andFamilyTreeIdIn(List<Integer> values) {
            addCriterion("family_tree_id in", values, "familyTreeId");
            return (Criteria) this;
        }

        public Criteria andFamilyTreeIdNotIn(List<Integer> values) {
            addCriterion("family_tree_id not in", values, "familyTreeId");
            return (Criteria) this;
        }

        public Criteria andFamilyTreeIdBetween(Integer value1, Integer value2) {
            addCriterion("family_tree_id between", value1, value2, "familyTreeId");
            return (Criteria) this;
        }

        public Criteria andFamilyTreeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("family_tree_id not between", value1, value2, "familyTreeId");
            return (Criteria) this;
        }

        public Criteria andFamilyHouseIdIsNull() {
            addCriterion("family_house_id is null");
            return (Criteria) this;
        }

        public Criteria andFamilyHouseIdIsNotNull() {
            addCriterion("family_house_id is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyHouseIdEqualTo(String value) {
            addCriterion("family_house_id =", value, "familyHouseId");
            return (Criteria) this;
        }

        public Criteria andFamilyHouseIdNotEqualTo(String value) {
            addCriterion("family_house_id <>", value, "familyHouseId");
            return (Criteria) this;
        }

        public Criteria andFamilyHouseIdGreaterThan(String value) {
            addCriterion("family_house_id >", value, "familyHouseId");
            return (Criteria) this;
        }

        public Criteria andFamilyHouseIdGreaterThanOrEqualTo(String value) {
            addCriterion("family_house_id >=", value, "familyHouseId");
            return (Criteria) this;
        }

        public Criteria andFamilyHouseIdLessThan(String value) {
            addCriterion("family_house_id <", value, "familyHouseId");
            return (Criteria) this;
        }

        public Criteria andFamilyHouseIdLessThanOrEqualTo(String value) {
            addCriterion("family_house_id <=", value, "familyHouseId");
            return (Criteria) this;
        }

        public Criteria andFamilyHouseIdLike(String value) {
            addCriterion("family_house_id like", value, "familyHouseId");
            return (Criteria) this;
        }

        public Criteria andFamilyHouseIdNotLike(String value) {
            addCriterion("family_house_id not like", value, "familyHouseId");
            return (Criteria) this;
        }

        public Criteria andFamilyHouseIdIn(List<String> values) {
            addCriterion("family_house_id in", values, "familyHouseId");
            return (Criteria) this;
        }

        public Criteria andFamilyHouseIdNotIn(List<String> values) {
            addCriterion("family_house_id not in", values, "familyHouseId");
            return (Criteria) this;
        }

        public Criteria andFamilyHouseIdBetween(String value1, String value2) {
            addCriterion("family_house_id between", value1, value2, "familyHouseId");
            return (Criteria) this;
        }

        public Criteria andFamilyHouseIdNotBetween(String value1, String value2) {
            addCriterion("family_house_id not between", value1, value2, "familyHouseId");
            return (Criteria) this;
        }

        public Criteria andExProvinceIdIsNull() {
            addCriterion("ex_province_id is null");
            return (Criteria) this;
        }

        public Criteria andExProvinceIdIsNotNull() {
            addCriterion("ex_province_id is not null");
            return (Criteria) this;
        }

        public Criteria andExProvinceIdEqualTo(Integer value) {
            addCriterion("ex_province_id =", value, "exProvinceId");
            return (Criteria) this;
        }

        public Criteria andExProvinceIdNotEqualTo(Integer value) {
            addCriterion("ex_province_id <>", value, "exProvinceId");
            return (Criteria) this;
        }

        public Criteria andExProvinceIdGreaterThan(Integer value) {
            addCriterion("ex_province_id >", value, "exProvinceId");
            return (Criteria) this;
        }

        public Criteria andExProvinceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ex_province_id >=", value, "exProvinceId");
            return (Criteria) this;
        }

        public Criteria andExProvinceIdLessThan(Integer value) {
            addCriterion("ex_province_id <", value, "exProvinceId");
            return (Criteria) this;
        }

        public Criteria andExProvinceIdLessThanOrEqualTo(Integer value) {
            addCriterion("ex_province_id <=", value, "exProvinceId");
            return (Criteria) this;
        }

        public Criteria andExProvinceIdIn(List<Integer> values) {
            addCriterion("ex_province_id in", values, "exProvinceId");
            return (Criteria) this;
        }

        public Criteria andExProvinceIdNotIn(List<Integer> values) {
            addCriterion("ex_province_id not in", values, "exProvinceId");
            return (Criteria) this;
        }

        public Criteria andExProvinceIdBetween(Integer value1, Integer value2) {
            addCriterion("ex_province_id between", value1, value2, "exProvinceId");
            return (Criteria) this;
        }

        public Criteria andExProvinceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ex_province_id not between", value1, value2, "exProvinceId");
            return (Criteria) this;
        }

        public Criteria andExCityIdIsNull() {
            addCriterion("ex_city_id is null");
            return (Criteria) this;
        }

        public Criteria andExCityIdIsNotNull() {
            addCriterion("ex_city_id is not null");
            return (Criteria) this;
        }

        public Criteria andExCityIdEqualTo(Integer value) {
            addCriterion("ex_city_id =", value, "exCityId");
            return (Criteria) this;
        }

        public Criteria andExCityIdNotEqualTo(Integer value) {
            addCriterion("ex_city_id <>", value, "exCityId");
            return (Criteria) this;
        }

        public Criteria andExCityIdGreaterThan(Integer value) {
            addCriterion("ex_city_id >", value, "exCityId");
            return (Criteria) this;
        }

        public Criteria andExCityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ex_city_id >=", value, "exCityId");
            return (Criteria) this;
        }

        public Criteria andExCityIdLessThan(Integer value) {
            addCriterion("ex_city_id <", value, "exCityId");
            return (Criteria) this;
        }

        public Criteria andExCityIdLessThanOrEqualTo(Integer value) {
            addCriterion("ex_city_id <=", value, "exCityId");
            return (Criteria) this;
        }

        public Criteria andExCityIdIn(List<Integer> values) {
            addCriterion("ex_city_id in", values, "exCityId");
            return (Criteria) this;
        }

        public Criteria andExCityIdNotIn(List<Integer> values) {
            addCriterion("ex_city_id not in", values, "exCityId");
            return (Criteria) this;
        }

        public Criteria andExCityIdBetween(Integer value1, Integer value2) {
            addCriterion("ex_city_id between", value1, value2, "exCityId");
            return (Criteria) this;
        }

        public Criteria andExCityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ex_city_id not between", value1, value2, "exCityId");
            return (Criteria) this;
        }

        public Criteria andExAreaIdIsNull() {
            addCriterion("ex_area_id is null");
            return (Criteria) this;
        }

        public Criteria andExAreaIdIsNotNull() {
            addCriterion("ex_area_id is not null");
            return (Criteria) this;
        }

        public Criteria andExAreaIdEqualTo(Integer value) {
            addCriterion("ex_area_id =", value, "exAreaId");
            return (Criteria) this;
        }

        public Criteria andExAreaIdNotEqualTo(Integer value) {
            addCriterion("ex_area_id <>", value, "exAreaId");
            return (Criteria) this;
        }

        public Criteria andExAreaIdGreaterThan(Integer value) {
            addCriterion("ex_area_id >", value, "exAreaId");
            return (Criteria) this;
        }

        public Criteria andExAreaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ex_area_id >=", value, "exAreaId");
            return (Criteria) this;
        }

        public Criteria andExAreaIdLessThan(Integer value) {
            addCriterion("ex_area_id <", value, "exAreaId");
            return (Criteria) this;
        }

        public Criteria andExAreaIdLessThanOrEqualTo(Integer value) {
            addCriterion("ex_area_id <=", value, "exAreaId");
            return (Criteria) this;
        }

        public Criteria andExAreaIdIn(List<Integer> values) {
            addCriterion("ex_area_id in", values, "exAreaId");
            return (Criteria) this;
        }

        public Criteria andExAreaIdNotIn(List<Integer> values) {
            addCriterion("ex_area_id not in", values, "exAreaId");
            return (Criteria) this;
        }

        public Criteria andExAreaIdBetween(Integer value1, Integer value2) {
            addCriterion("ex_area_id between", value1, value2, "exAreaId");
            return (Criteria) this;
        }

        public Criteria andExAreaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ex_area_id not between", value1, value2, "exAreaId");
            return (Criteria) this;
        }

        public Criteria andExAddressIsNull() {
            addCriterion("ex_address is null");
            return (Criteria) this;
        }

        public Criteria andExAddressIsNotNull() {
            addCriterion("ex_address is not null");
            return (Criteria) this;
        }

        public Criteria andExAddressEqualTo(String value) {
            addCriterion("ex_address =", value, "exAddress");
            return (Criteria) this;
        }

        public Criteria andExAddressNotEqualTo(String value) {
            addCriterion("ex_address <>", value, "exAddress");
            return (Criteria) this;
        }

        public Criteria andExAddressGreaterThan(String value) {
            addCriterion("ex_address >", value, "exAddress");
            return (Criteria) this;
        }

        public Criteria andExAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ex_address >=", value, "exAddress");
            return (Criteria) this;
        }

        public Criteria andExAddressLessThan(String value) {
            addCriterion("ex_address <", value, "exAddress");
            return (Criteria) this;
        }

        public Criteria andExAddressLessThanOrEqualTo(String value) {
            addCriterion("ex_address <=", value, "exAddress");
            return (Criteria) this;
        }

        public Criteria andExAddressLike(String value) {
            addCriterion("ex_address like", value, "exAddress");
            return (Criteria) this;
        }

        public Criteria andExAddressNotLike(String value) {
            addCriterion("ex_address not like", value, "exAddress");
            return (Criteria) this;
        }

        public Criteria andExAddressIn(List<String> values) {
            addCriterion("ex_address in", values, "exAddress");
            return (Criteria) this;
        }

        public Criteria andExAddressNotIn(List<String> values) {
            addCriterion("ex_address not in", values, "exAddress");
            return (Criteria) this;
        }

        public Criteria andExAddressBetween(String value1, String value2) {
            addCriterion("ex_address between", value1, value2, "exAddress");
            return (Criteria) this;
        }

        public Criteria andExAddressNotBetween(String value1, String value2) {
            addCriterion("ex_address not between", value1, value2, "exAddress");
            return (Criteria) this;
        }

        public Criteria andNowProvinceIdIsNull() {
            addCriterion("now_province_id is null");
            return (Criteria) this;
        }

        public Criteria andNowProvinceIdIsNotNull() {
            addCriterion("now_province_id is not null");
            return (Criteria) this;
        }

        public Criteria andNowProvinceIdEqualTo(Integer value) {
            addCriterion("now_province_id =", value, "nowProvinceId");
            return (Criteria) this;
        }

        public Criteria andNowProvinceIdNotEqualTo(Integer value) {
            addCriterion("now_province_id <>", value, "nowProvinceId");
            return (Criteria) this;
        }

        public Criteria andNowProvinceIdGreaterThan(Integer value) {
            addCriterion("now_province_id >", value, "nowProvinceId");
            return (Criteria) this;
        }

        public Criteria andNowProvinceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("now_province_id >=", value, "nowProvinceId");
            return (Criteria) this;
        }

        public Criteria andNowProvinceIdLessThan(Integer value) {
            addCriterion("now_province_id <", value, "nowProvinceId");
            return (Criteria) this;
        }

        public Criteria andNowProvinceIdLessThanOrEqualTo(Integer value) {
            addCriterion("now_province_id <=", value, "nowProvinceId");
            return (Criteria) this;
        }

        public Criteria andNowProvinceIdIn(List<Integer> values) {
            addCriterion("now_province_id in", values, "nowProvinceId");
            return (Criteria) this;
        }

        public Criteria andNowProvinceIdNotIn(List<Integer> values) {
            addCriterion("now_province_id not in", values, "nowProvinceId");
            return (Criteria) this;
        }

        public Criteria andNowProvinceIdBetween(Integer value1, Integer value2) {
            addCriterion("now_province_id between", value1, value2, "nowProvinceId");
            return (Criteria) this;
        }

        public Criteria andNowProvinceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("now_province_id not between", value1, value2, "nowProvinceId");
            return (Criteria) this;
        }

        public Criteria andNowCityIdIsNull() {
            addCriterion("now_city_id is null");
            return (Criteria) this;
        }

        public Criteria andNowCityIdIsNotNull() {
            addCriterion("now_city_id is not null");
            return (Criteria) this;
        }

        public Criteria andNowCityIdEqualTo(Integer value) {
            addCriterion("now_city_id =", value, "nowCityId");
            return (Criteria) this;
        }

        public Criteria andNowCityIdNotEqualTo(Integer value) {
            addCriterion("now_city_id <>", value, "nowCityId");
            return (Criteria) this;
        }

        public Criteria andNowCityIdGreaterThan(Integer value) {
            addCriterion("now_city_id >", value, "nowCityId");
            return (Criteria) this;
        }

        public Criteria andNowCityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("now_city_id >=", value, "nowCityId");
            return (Criteria) this;
        }

        public Criteria andNowCityIdLessThan(Integer value) {
            addCriterion("now_city_id <", value, "nowCityId");
            return (Criteria) this;
        }

        public Criteria andNowCityIdLessThanOrEqualTo(Integer value) {
            addCriterion("now_city_id <=", value, "nowCityId");
            return (Criteria) this;
        }

        public Criteria andNowCityIdIn(List<Integer> values) {
            addCriterion("now_city_id in", values, "nowCityId");
            return (Criteria) this;
        }

        public Criteria andNowCityIdNotIn(List<Integer> values) {
            addCriterion("now_city_id not in", values, "nowCityId");
            return (Criteria) this;
        }

        public Criteria andNowCityIdBetween(Integer value1, Integer value2) {
            addCriterion("now_city_id between", value1, value2, "nowCityId");
            return (Criteria) this;
        }

        public Criteria andNowCityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("now_city_id not between", value1, value2, "nowCityId");
            return (Criteria) this;
        }

        public Criteria andNowAreaIdIsNull() {
            addCriterion("now_area_id is null");
            return (Criteria) this;
        }

        public Criteria andNowAreaIdIsNotNull() {
            addCriterion("now_area_id is not null");
            return (Criteria) this;
        }

        public Criteria andNowAreaIdEqualTo(Integer value) {
            addCriterion("now_area_id =", value, "nowAreaId");
            return (Criteria) this;
        }

        public Criteria andNowAreaIdNotEqualTo(Integer value) {
            addCriterion("now_area_id <>", value, "nowAreaId");
            return (Criteria) this;
        }

        public Criteria andNowAreaIdGreaterThan(Integer value) {
            addCriterion("now_area_id >", value, "nowAreaId");
            return (Criteria) this;
        }

        public Criteria andNowAreaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("now_area_id >=", value, "nowAreaId");
            return (Criteria) this;
        }

        public Criteria andNowAreaIdLessThan(Integer value) {
            addCriterion("now_area_id <", value, "nowAreaId");
            return (Criteria) this;
        }

        public Criteria andNowAreaIdLessThanOrEqualTo(Integer value) {
            addCriterion("now_area_id <=", value, "nowAreaId");
            return (Criteria) this;
        }

        public Criteria andNowAreaIdIn(List<Integer> values) {
            addCriterion("now_area_id in", values, "nowAreaId");
            return (Criteria) this;
        }

        public Criteria andNowAreaIdNotIn(List<Integer> values) {
            addCriterion("now_area_id not in", values, "nowAreaId");
            return (Criteria) this;
        }

        public Criteria andNowAreaIdBetween(Integer value1, Integer value2) {
            addCriterion("now_area_id between", value1, value2, "nowAreaId");
            return (Criteria) this;
        }

        public Criteria andNowAreaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("now_area_id not between", value1, value2, "nowAreaId");
            return (Criteria) this;
        }

        public Criteria andNowAddressIsNull() {
            addCriterion("now_address is null");
            return (Criteria) this;
        }

        public Criteria andNowAddressIsNotNull() {
            addCriterion("now_address is not null");
            return (Criteria) this;
        }

        public Criteria andNowAddressEqualTo(String value) {
            addCriterion("now_address =", value, "nowAddress");
            return (Criteria) this;
        }

        public Criteria andNowAddressNotEqualTo(String value) {
            addCriterion("now_address <>", value, "nowAddress");
            return (Criteria) this;
        }

        public Criteria andNowAddressGreaterThan(String value) {
            addCriterion("now_address >", value, "nowAddress");
            return (Criteria) this;
        }

        public Criteria andNowAddressGreaterThanOrEqualTo(String value) {
            addCriterion("now_address >=", value, "nowAddress");
            return (Criteria) this;
        }

        public Criteria andNowAddressLessThan(String value) {
            addCriterion("now_address <", value, "nowAddress");
            return (Criteria) this;
        }

        public Criteria andNowAddressLessThanOrEqualTo(String value) {
            addCriterion("now_address <=", value, "nowAddress");
            return (Criteria) this;
        }

        public Criteria andNowAddressLike(String value) {
            addCriterion("now_address like", value, "nowAddress");
            return (Criteria) this;
        }

        public Criteria andNowAddressNotLike(String value) {
            addCriterion("now_address not like", value, "nowAddress");
            return (Criteria) this;
        }

        public Criteria andNowAddressIn(List<String> values) {
            addCriterion("now_address in", values, "nowAddress");
            return (Criteria) this;
        }

        public Criteria andNowAddressNotIn(List<String> values) {
            addCriterion("now_address not in", values, "nowAddress");
            return (Criteria) this;
        }

        public Criteria andNowAddressBetween(String value1, String value2) {
            addCriterion("now_address between", value1, value2, "nowAddress");
            return (Criteria) this;
        }

        public Criteria andNowAddressNotBetween(String value1, String value2) {
            addCriterion("now_address not between", value1, value2, "nowAddress");
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

        public Criteria andActionUserIdIsNull() {
            addCriterion("action_user_id is null");
            return (Criteria) this;
        }

        public Criteria andActionUserIdIsNotNull() {
            addCriterion("action_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andActionUserIdEqualTo(Integer value) {
            addCriterion("action_user_id =", value, "actionUserId");
            return (Criteria) this;
        }

        public Criteria andActionUserIdNotEqualTo(Integer value) {
            addCriterion("action_user_id <>", value, "actionUserId");
            return (Criteria) this;
        }

        public Criteria andActionUserIdGreaterThan(Integer value) {
            addCriterion("action_user_id >", value, "actionUserId");
            return (Criteria) this;
        }

        public Criteria andActionUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("action_user_id >=", value, "actionUserId");
            return (Criteria) this;
        }

        public Criteria andActionUserIdLessThan(Integer value) {
            addCriterion("action_user_id <", value, "actionUserId");
            return (Criteria) this;
        }

        public Criteria andActionUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("action_user_id <=", value, "actionUserId");
            return (Criteria) this;
        }

        public Criteria andActionUserIdIn(List<Integer> values) {
            addCriterion("action_user_id in", values, "actionUserId");
            return (Criteria) this;
        }

        public Criteria andActionUserIdNotIn(List<Integer> values) {
            addCriterion("action_user_id not in", values, "actionUserId");
            return (Criteria) this;
        }

        public Criteria andActionUserIdBetween(Integer value1, Integer value2) {
            addCriterion("action_user_id between", value1, value2, "actionUserId");
            return (Criteria) this;
        }

        public Criteria andActionUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("action_user_id not between", value1, value2, "actionUserId");
            return (Criteria) this;
        }

        public Criteria andIsRegisterIsNull() {
            addCriterion("is_register is null");
            return (Criteria) this;
        }

        public Criteria andIsRegisterIsNotNull() {
            addCriterion("is_register is not null");
            return (Criteria) this;
        }

        public Criteria andIsRegisterEqualTo(Integer value) {
            addCriterion("is_register =", value, "isRegister");
            return (Criteria) this;
        }

        public Criteria andIsRegisterNotEqualTo(Integer value) {
            addCriterion("is_register <>", value, "isRegister");
            return (Criteria) this;
        }

        public Criteria andIsRegisterGreaterThan(Integer value) {
            addCriterion("is_register >", value, "isRegister");
            return (Criteria) this;
        }

        public Criteria andIsRegisterGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_register >=", value, "isRegister");
            return (Criteria) this;
        }

        public Criteria andIsRegisterLessThan(Integer value) {
            addCriterion("is_register <", value, "isRegister");
            return (Criteria) this;
        }

        public Criteria andIsRegisterLessThanOrEqualTo(Integer value) {
            addCriterion("is_register <=", value, "isRegister");
            return (Criteria) this;
        }

        public Criteria andIsRegisterIn(List<Integer> values) {
            addCriterion("is_register in", values, "isRegister");
            return (Criteria) this;
        }

        public Criteria andIsRegisterNotIn(List<Integer> values) {
            addCriterion("is_register not in", values, "isRegister");
            return (Criteria) this;
        }

        public Criteria andIsRegisterBetween(Integer value1, Integer value2) {
            addCriterion("is_register between", value1, value2, "isRegister");
            return (Criteria) this;
        }

        public Criteria andIsRegisterNotBetween(Integer value1, Integer value2) {
            addCriterion("is_register not between", value1, value2, "isRegister");
            return (Criteria) this;
        }

        public Criteria andIsNewUserIsNull() {
            addCriterion("is_new_user is null");
            return (Criteria) this;
        }

        public Criteria andIsNewUserIsNotNull() {
            addCriterion("is_new_user is not null");
            return (Criteria) this;
        }

        public Criteria andIsNewUserEqualTo(Integer value) {
            addCriterion("is_new_user =", value, "isNewUser");
            return (Criteria) this;
        }

        public Criteria andIsNewUserNotEqualTo(Integer value) {
            addCriterion("is_new_user <>", value, "isNewUser");
            return (Criteria) this;
        }

        public Criteria andIsNewUserGreaterThan(Integer value) {
            addCriterion("is_new_user >", value, "isNewUser");
            return (Criteria) this;
        }

        public Criteria andIsNewUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_new_user >=", value, "isNewUser");
            return (Criteria) this;
        }

        public Criteria andIsNewUserLessThan(Integer value) {
            addCriterion("is_new_user <", value, "isNewUser");
            return (Criteria) this;
        }

        public Criteria andIsNewUserLessThanOrEqualTo(Integer value) {
            addCriterion("is_new_user <=", value, "isNewUser");
            return (Criteria) this;
        }

        public Criteria andIsNewUserIn(List<Integer> values) {
            addCriterion("is_new_user in", values, "isNewUser");
            return (Criteria) this;
        }

        public Criteria andIsNewUserNotIn(List<Integer> values) {
            addCriterion("is_new_user not in", values, "isNewUser");
            return (Criteria) this;
        }

        public Criteria andIsNewUserBetween(Integer value1, Integer value2) {
            addCriterion("is_new_user between", value1, value2, "isNewUser");
            return (Criteria) this;
        }

        public Criteria andIsNewUserNotBetween(Integer value1, Integer value2) {
            addCriterion("is_new_user not between", value1, value2, "isNewUser");
            return (Criteria) this;
        }

        public Criteria andIsAliveIsNull() {
            addCriterion("is_alive is null");
            return (Criteria) this;
        }

        public Criteria andIsAliveIsNotNull() {
            addCriterion("is_alive is not null");
            return (Criteria) this;
        }

        public Criteria andIsAliveEqualTo(Integer value) {
            addCriterion("is_alive =", value, "isAlive");
            return (Criteria) this;
        }

        public Criteria andIsAliveNotEqualTo(Integer value) {
            addCriterion("is_alive <>", value, "isAlive");
            return (Criteria) this;
        }

        public Criteria andIsAliveGreaterThan(Integer value) {
            addCriterion("is_alive >", value, "isAlive");
            return (Criteria) this;
        }

        public Criteria andIsAliveGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_alive >=", value, "isAlive");
            return (Criteria) this;
        }

        public Criteria andIsAliveLessThan(Integer value) {
            addCriterion("is_alive <", value, "isAlive");
            return (Criteria) this;
        }

        public Criteria andIsAliveLessThanOrEqualTo(Integer value) {
            addCriterion("is_alive <=", value, "isAlive");
            return (Criteria) this;
        }

        public Criteria andIsAliveIn(List<Integer> values) {
            addCriterion("is_alive in", values, "isAlive");
            return (Criteria) this;
        }

        public Criteria andIsAliveNotIn(List<Integer> values) {
            addCriterion("is_alive not in", values, "isAlive");
            return (Criteria) this;
        }

        public Criteria andIsAliveBetween(Integer value1, Integer value2) {
            addCriterion("is_alive between", value1, value2, "isAlive");
            return (Criteria) this;
        }

        public Criteria andIsAliveNotBetween(Integer value1, Integer value2) {
            addCriterion("is_alive not between", value1, value2, "isAlive");
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