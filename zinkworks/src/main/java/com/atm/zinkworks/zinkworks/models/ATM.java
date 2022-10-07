package com.atm.zinkworks.zinkworks.models;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.Map;

public class ATM {

    private Integer totalMoney;
    private Map<Integer, Integer> cashMap;

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Map<Integer, Integer> getCashMap() {
        return cashMap;
    }

    public void setCashMap(Map<Integer, Integer> cashMap) {
        this.cashMap = cashMap;
    }
}
