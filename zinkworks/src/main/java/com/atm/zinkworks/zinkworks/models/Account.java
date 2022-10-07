package com.atm.zinkworks.zinkworks.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;

@Entity
public class Account {

    @Id
    @Column(name = "account_number")
    private Integer accountNumber;
    private Integer pin;

    @Column(name = "open_balance")
    private Integer openBalance;

    @Column(name = "overdraft")
    private Integer overdraft;

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public Integer getOpenBalance() {
        return openBalance;
    }

    public void setOpenBalance(Integer openBalance) {
        this.openBalance = openBalance;
    }

    public Integer getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(Integer overdraft) {
        this.overdraft = overdraft;
    }
}
