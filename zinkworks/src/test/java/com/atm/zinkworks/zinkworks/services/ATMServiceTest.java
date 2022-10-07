package com.atm.zinkworks.zinkworks.services;

import com.atm.zinkworks.zinkworks.builders.AccountBuilder;
import com.atm.zinkworks.zinkworks.builders.BalanceResponseBuilder;
import com.atm.zinkworks.zinkworks.builders.FundsResponseBuilder;
import com.atm.zinkworks.zinkworks.exceptions.BadRequestException;
import com.atm.zinkworks.zinkworks.exceptions.NotFoundException;
import com.atm.zinkworks.zinkworks.models.Account;
import com.atm.zinkworks.zinkworks.repositories.ATMRepository;
import com.atm.zinkworks.zinkworks.responses.BalanceResponse;
import com.atm.zinkworks.zinkworks.responses.FundsResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ATMServiceTest {

    @InjectMocks
    ATMService service;
    @Mock
    ATMRepository repository;

    @Test
    public void getBalanceShouldReturnValid(){

        Account mockAccount = new AccountBuilder()
                .withAccount(123456789)
                .withPin(1234)
                .withOpenBalance(500)
                .withOverdraft(200)
                .build();

        BalanceResponse mockBalanceResponse =  new BalanceResponseBuilder().withBalance(500)
                .withAccountNumber(123456789)
                .withBalance(500)
                .withOverdraft(200)
                .build();

        Optional<Account> optionalAccountMock = Optional.of(mockAccount);
        when(repository.findById(123456789)).thenReturn(optionalAccountMock);
        final BalanceResponse balanceResponse = service.getBalance(123456789, 1234);
        assertEquals(balanceResponse.getAccountNumber(), mockBalanceResponse.getAccountNumber());
        assertEquals(balanceResponse.getBalance(), mockBalanceResponse.getBalance());
        assertEquals(balanceResponse.getOverdraft(), mockBalanceResponse.getOverdraft());
    }

    @Test
    public void getBalanceShouldReturnNotFoundException(){

        Assertions.assertThrows(
                NotFoundException.class,
                () ->
                        service.getBalance(
                                12345, 1234));
    }

    @Test
    public void getFundsShouldReturnValid(){

        Account mockAccount = new AccountBuilder()
                .withAccount(123456789)
                .withPin(1234)
                .withOpenBalance(500)
                .withOverdraft(200)
                .build();

        FundsResponse mockFundsResponse = new FundsResponseBuilder().withAccountNumber(123456789)
                .withCurrentBalance(200)
                .withFundsRequested(300)
                .build();

        Optional<Account> optionalAccountMock = Optional.of(mockAccount);
        when(repository.findById(123456789)).thenReturn(optionalAccountMock);
        final FundsResponse fundsResponseResponse = service.getFunds(123456789, 1234, 300);
        assertEquals(fundsResponseResponse.getAccountNumber(), mockFundsResponse.getAccountNumber());
        assertEquals(fundsResponseResponse.getCurrentBalance(), mockFundsResponse.getCurrentBalance());
        assertEquals(fundsResponseResponse.getFundsRequested(), mockFundsResponse.getFundsRequested());
    }

    @Test
    public void getFundsShouldReturnNotFoundException(){

        Assertions.assertThrows(
                NotFoundException.class,
                () ->
                        service.getFunds(
                                12345, 1234, 500));
    }

    @Test
    public void getFundsShouldReturnBadRequest(){

        Account mockAccount = new AccountBuilder()
                .withAccount(123456789)
                .withPin(1234)
                .withOpenBalance(500)
                .withOverdraft(200)
                .build();

        Optional<Account> optionalAccountMock = Optional.of(mockAccount);
        when(repository.findById(123456789)).thenReturn(optionalAccountMock);
        Assertions.assertThrows(
                BadRequestException.class,
                () ->
                        service.getFunds(
                                123456789, 00000, 500));
    }

    @Test
    public void getFundsShouldReturnBadRequestExceedCashRequested(){

        Account mockAccount = new AccountBuilder()
                .withAccount(123456789)
                .withPin(1234)
                .withOpenBalance(500)
                .withOverdraft(200)
                .build();

        Optional<Account> optionalAccountMock = Optional.of(mockAccount);
        when(repository.findById(123456789)).thenReturn(optionalAccountMock);
        Assertions.assertThrows(
                BadRequestException.class,
                () ->
                        service.getFunds(
                                123456789, 1234, 8000));
    }

    @Test
    public void getFundsShouldReturnBadRequestExceedCashAmount(){

        Account mockAccount = new AccountBuilder()
                .withAccount(123456789)
                .withPin(1234)
                .withOpenBalance(50000)
                .withOverdraft(200)
                .build();

        Optional<Account> optionalAccountMock = Optional.of(mockAccount);
        when(repository.findById(123456789)).thenReturn(optionalAccountMock);
        Assertions.assertThrows(
                BadRequestException.class,
                () ->
                        service.getFunds(
                                123456789, 1234, 20000));
    }



}
