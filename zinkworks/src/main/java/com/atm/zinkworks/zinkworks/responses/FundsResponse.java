package com.atm.zinkworks.zinkworks.responses;

import java.math.BigDecimal;

public class FundsResponse {

    private Integer accountNumber;
    private Integer fundsRequested;
    private Integer currentBalance;

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getFundsRequested() {
        return fundsRequested;
    }

    public void setFundsRequested(Integer fundsRequested) {
        this.fundsRequested = fundsRequested;
    }

    public Integer getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Integer currentBalance) {
        this.currentBalance = currentBalance;
    }
}
