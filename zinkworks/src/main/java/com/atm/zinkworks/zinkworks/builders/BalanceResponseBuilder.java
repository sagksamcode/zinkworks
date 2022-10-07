package com.atm.zinkworks.zinkworks.builders;

import com.atm.zinkworks.zinkworks.responses.BalanceResponse;

import java.math.BigDecimal;

public class BalanceResponseBuilder {

    private BalanceResponse balanceResponse = new BalanceResponse();

    public BalanceResponseBuilder withAccountNumber(final Integer accountNumber){

        balanceResponse.setAccountNumber(accountNumber);
        return this;
    }

    public BalanceResponseBuilder withBalance(final Integer balance){

        balanceResponse.setBalance(balance);
        return this;
    }

    public BalanceResponseBuilder withOverdraft(final Integer overdraft){

        balanceResponse.setOverdraft(overdraft);
        return this;
    }

    public BalanceResponse build(){
        return balanceResponse;
    }
}
