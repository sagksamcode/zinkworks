package com.atm.zinkworks.zinkworks.builders;

import com.atm.zinkworks.zinkworks.models.ATM;

import java.math.BigDecimal;
import java.util.Map;

public class ATMBuilder {

    private ATM atm = new ATM();

    public ATMBuilder withTotalMoney(Integer totalMoney){

        atm.setTotalMoney(totalMoney);
        return this;
    }

    public ATMBuilder withCashMap(Map<Integer, Integer> cashMap){

        atm.setCashMap(cashMap);
        return this;
    }

    public ATM build(){
        return atm;
    }
}
