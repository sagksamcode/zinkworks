package com.atm.zinkworks.zinkworks.configs;

import com.atm.zinkworks.zinkworks.builders.AccountBuilder;
import com.atm.zinkworks.zinkworks.models.Account;
import com.atm.zinkworks.zinkworks.repositories.ATMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Configuration
public class DatabaseConfig {

    private final ATMRepository ATMRepository;

    @Autowired
    public DatabaseConfig(ATMRepository ATMRepository) {
        this.ATMRepository = ATMRepository;
    }

    @PostConstruct
    public void initAccountsDB(){

        final Account firstAccount = new AccountBuilder()
                .withAccount(123456789)
                .withPin(1234)
                .withOpenBalance(800)
                .withOverdraft(150)
                .build();

        final Account secondAccount = new AccountBuilder()
                .withAccount(987654321)
                .withPin(4321)
                .withOpenBalance(800)
                .withOverdraft(150)
                .build();

        ATMRepository.saveAll(Arrays.asList(firstAccount, secondAccount));
    }
}
