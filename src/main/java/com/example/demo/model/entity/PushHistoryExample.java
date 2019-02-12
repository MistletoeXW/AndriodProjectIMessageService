package com.example.demo.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PushHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PushHistoryExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andReceiveridIsNull() {
            addCriterion("receiverId is null");
            return (Criteria) this;
        }

        public Criteria andReceiveridIsNotNull() {
            addCriterion("receiverId is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveridEqualTo(String value) {
            addCriterion("receiverId =", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridNotEqualTo(String value) {
            addCriterion("receiverId <>", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridGreaterThan(String value) {
            addCriterion("receiverId >", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridGreaterThanOrEqualTo(String value) {
            addCriterion("receiverId >=", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridLessThan(String value) {
            addCriterion("receiverId <", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridLessThanOrEqualTo(String value) {
            addCriterion("receiverId <=", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridLike(String value) {
            addCriterion("receiverId like", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridNotLike(String value) {
            addCriterion("receiverId not like", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridIn(List<String> values) {
            addCriterion("receiverId in", values, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridNotIn(List<String> values) {
            addCriterion("receiverId not in", values, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridBetween(String value1, String value2) {
            addCriterion("receiverId between", value1, value2, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridNotBetween(String value1, String value2) {
            addCriterion("receiverId not between", value1, value2, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiverpushidIsNull() {
            addCriterion("receiverPushId is null");
            return (Criteria) this;
        }

        public Criteria andReceiverpushidIsNotNull() {
            addCriterion("receiverPushId is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverpushidEqualTo(String value) {
            addCriterion("receiverPushId =", value, "receiverpushid");
            return (Criteria) this;
        }

        public Criteria andReceiverpushidNotEqualTo(String value) {
            addCriterion("receiverPushId <>", value, "receiverpushid");
            return (Criteria) this;
        }

        public Criteria andReceiverpushidGreaterThan(String value) {
            addCriterion("receiverPushId >", value, "receiverpushid");
            return (Criteria) this;
        }

        public Criteria andReceiverpushidGreaterThanOrEqualTo(String value) {
            addCriterion("receiverPushId >=", value, "receiverpushid");
            return (Criteria) this;
        }

        public Criteria andReceiverpushidLessThan(String value) {
            addCriterion("receiverPushId <", value, "receiverpushid");
            return (Criteria) this;
        }

        public Criteria andReceiverpushidLessThanOrEqualTo(String value) {
            addCriterion("receiverPushId <=", value, "receiverpushid");
            return (Criteria) this;
        }

        public Criteria andReceiverpushidLike(String value) {
            addCriterion("receiverPushId like", value, "receiverpushid");
            return (Criteria) this;
        }

        public Criteria andReceiverpushidNotLike(String value) {
            addCriterion("receiverPushId not like", value, "receiverpushid");
            return (Criteria) this;
        }

        public Criteria andReceiverpushidIn(List<String> values) {
            addCriterion("receiverPushId in", values, "receiverpushid");
            return (Criteria) this;
        }

        public Criteria andReceiverpushidNotIn(List<String> values) {
            addCriterion("receiverPushId not in", values, "receiverpushid");
            return (Criteria) this;
        }

        public Criteria andReceiverpushidBetween(String value1, String value2) {
            addCriterion("receiverPushId between", value1, value2, "receiverpushid");
            return (Criteria) this;
        }

        public Criteria andReceiverpushidNotBetween(String value1, String value2) {
            addCriterion("receiverPushId not between", value1, value2, "receiverpushid");
            return (Criteria) this;
        }

        public Criteria andSenderidIsNull() {
            addCriterion("senderId is null");
            return (Criteria) this;
        }

        public Criteria andSenderidIsNotNull() {
            addCriterion("senderId is not null");
            return (Criteria) this;
        }

        public Criteria andSenderidEqualTo(String value) {
            addCriterion("senderId =", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidNotEqualTo(String value) {
            addCriterion("senderId <>", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidGreaterThan(String value) {
            addCriterion("senderId >", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidGreaterThanOrEqualTo(String value) {
            addCriterion("senderId >=", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidLessThan(String value) {
            addCriterion("senderId <", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidLessThanOrEqualTo(String value) {
            addCriterion("senderId <=", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidLike(String value) {
            addCriterion("senderId like", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidNotLike(String value) {
            addCriterion("senderId not like", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidIn(List<String> values) {
            addCriterion("senderId in", values, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidNotIn(List<String> values) {
            addCriterion("senderId not in", values, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidBetween(String value1, String value2) {
            addCriterion("senderId between", value1, value2, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidNotBetween(String value1, String value2) {
            addCriterion("senderId not between", value1, value2, "senderid");
            return (Criteria) this;
        }

        public Criteria andEntitytypeIsNull() {
            addCriterion("entityType is null");
            return (Criteria) this;
        }

        public Criteria andEntitytypeIsNotNull() {
            addCriterion("entityType is not null");
            return (Criteria) this;
        }

        public Criteria andEntitytypeEqualTo(Integer value) {
            addCriterion("entityType =", value, "entitytype");
            return (Criteria) this;
        }

        public Criteria andEntitytypeNotEqualTo(Integer value) {
            addCriterion("entityType <>", value, "entitytype");
            return (Criteria) this;
        }

        public Criteria andEntitytypeGreaterThan(Integer value) {
            addCriterion("entityType >", value, "entitytype");
            return (Criteria) this;
        }

        public Criteria andEntitytypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("entityType >=", value, "entitytype");
            return (Criteria) this;
        }

        public Criteria andEntitytypeLessThan(Integer value) {
            addCriterion("entityType <", value, "entitytype");
            return (Criteria) this;
        }

        public Criteria andEntitytypeLessThanOrEqualTo(Integer value) {
            addCriterion("entityType <=", value, "entitytype");
            return (Criteria) this;
        }

        public Criteria andEntitytypeIn(List<Integer> values) {
            addCriterion("entityType in", values, "entitytype");
            return (Criteria) this;
        }

        public Criteria andEntitytypeNotIn(List<Integer> values) {
            addCriterion("entityType not in", values, "entitytype");
            return (Criteria) this;
        }

        public Criteria andEntitytypeBetween(Integer value1, Integer value2) {
            addCriterion("entityType between", value1, value2, "entitytype");
            return (Criteria) this;
        }

        public Criteria andEntitytypeNotBetween(Integer value1, Integer value2) {
            addCriterion("entityType not between", value1, value2, "entitytype");
            return (Criteria) this;
        }

        public Criteria andArrivalatIsNull() {
            addCriterion("arrivalAt is null");
            return (Criteria) this;
        }

        public Criteria andArrivalatIsNotNull() {
            addCriterion("arrivalAt is not null");
            return (Criteria) this;
        }

        public Criteria andArrivalatEqualTo(Date value) {
            addCriterion("arrivalAt =", value, "arrivalat");
            return (Criteria) this;
        }

        public Criteria andArrivalatNotEqualTo(Date value) {
            addCriterion("arrivalAt <>", value, "arrivalat");
            return (Criteria) this;
        }

        public Criteria andArrivalatGreaterThan(Date value) {
            addCriterion("arrivalAt >", value, "arrivalat");
            return (Criteria) this;
        }

        public Criteria andArrivalatGreaterThanOrEqualTo(Date value) {
            addCriterion("arrivalAt >=", value, "arrivalat");
            return (Criteria) this;
        }

        public Criteria andArrivalatLessThan(Date value) {
            addCriterion("arrivalAt <", value, "arrivalat");
            return (Criteria) this;
        }

        public Criteria andArrivalatLessThanOrEqualTo(Date value) {
            addCriterion("arrivalAt <=", value, "arrivalat");
            return (Criteria) this;
        }

        public Criteria andArrivalatIn(List<Date> values) {
            addCriterion("arrivalAt in", values, "arrivalat");
            return (Criteria) this;
        }

        public Criteria andArrivalatNotIn(List<Date> values) {
            addCriterion("arrivalAt not in", values, "arrivalat");
            return (Criteria) this;
        }

        public Criteria andArrivalatBetween(Date value1, Date value2) {
            addCriterion("arrivalAt between", value1, value2, "arrivalat");
            return (Criteria) this;
        }

        public Criteria andArrivalatNotBetween(Date value1, Date value2) {
            addCriterion("arrivalAt not between", value1, value2, "arrivalat");
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