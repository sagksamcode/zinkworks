package com.atm.zinkworks.zinkworks.builders;

import com.atm.zinkworks.zinkworks.responses.FundsResponse;

import java.math.BigDecimal;

public class FundsResponseBuilder {

    private FundsResponse fundsResponse = new FundsResponse();

    public FundsResponseBuilder withAccountNumber(final Integer accountNumber){

        fundsResponse.setAccountNumber(accountNumber);
        return this;
    }

    public FundsResponseBuilder withFundsRequested(final Integer fundsRequested){

        fundsResponse.setFundsRequested(fundsRequested);
        return this;
    }

    public FundsResponseBuilder withCurrentBalance(final Integer currentBalance){

        fundsResponse.setCurrentBalance(currentBalance);
        return this;
    }

    public FundsResponse build(){
        return fundsResponse;
    }
}
