package com.atm.zinkworks.zinkworks.responses;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;

public class BalanceResponse {

    private Integer accountNumber;
    private Integer balance;

    private Integer overdraft;

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(Integer overdraft) {
        this.overdraft = overdraft;
    }
}
