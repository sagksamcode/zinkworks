package com.atm.zinkworks.zinkworks.builders;

import com.atm.zinkworks.zinkworks.models.Account;

import java.math.BigDecimal;

public class AccountBuilder {

    Account account = new Account();

    public AccountBuilder withAccount(final Integer accountNumber){

        account.setAccountNumber(accountNumber);
        return this;
    }

    public AccountBuilder withPin(final Integer pin){

        account.setPin(pin);
        return this;
    }

    public AccountBuilder withOpenBalance(final Integer openBalance){

        account.setOpenBalance(openBalance);
        return this;
    }

    public AccountBuilder withOverdraft(final Integer overdraft){

        account.setOverdraft(overdraft);
        return this;
    }

    public Account build(){
        return account;
    }
}
