package com.atm.zinkworks.zinkworks.services;

import com.atm.zinkworks.zinkworks.builders.ATMBuilder;
import com.atm.zinkworks.zinkworks.builders.BalanceResponseBuilder;
import com.atm.zinkworks.zinkworks.builders.FundsResponseBuilder;
import com.atm.zinkworks.zinkworks.exceptions.BadRequestException;
import com.atm.zinkworks.zinkworks.exceptions.NotFoundException;
import com.atm.zinkworks.zinkworks.models.ATM;
import com.atm.zinkworks.zinkworks.models.Account;
import com.atm.zinkworks.zinkworks.repositories.ATMRepository;
import com.atm.zinkworks.zinkworks.responses.BalanceResponse;
import com.atm.zinkworks.zinkworks.responses.FundsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ATMService {

    private final ATMRepository repository;

    @Autowired
    public ATMService(ATMRepository repository) {
        this.repository = repository;
    }

    public final BalanceResponse getBalance(final Integer accountNumber, Integer pin){

        final Optional<Account> optionalAccount = repository.findById(accountNumber);
        if(optionalAccount.isPresent()){

            return parseBalanceResponse(optionalAccount.get(), pin);
        }
        throw NotFoundException.notFoundAccount();
    }

    public final FundsResponse getFunds(final Integer accountNumber, final Integer pin, final Integer cashRequested){

        final Optional<Account> optionalAccount = repository.findById(accountNumber);
        if(optionalAccount.isPresent()){

            return parseFundsResponse(optionalAccount.get(), pin, cashRequested);
        }
        throw NotFoundException.notFoundAccount();

    }

    private BalanceResponse parseBalanceResponse(final Account account, final Integer pin){

        if(!account.getPin().equals(pin)){

            throw BadRequestException.invalidPinForAccount();
        }
        else{
            return new BalanceResponseBuilder().withBalance(account.getOpenBalance())
                    .withAccountNumber(account.getAccountNumber())
                    .withOverdraft(account.getOverdraft())
                    .build();
        }

    }

    private FundsResponse parseFundsResponse(final Account account, final Integer pin, final Integer cashRequested){

        if(!account.getPin().equals(pin)){

            throw BadRequestException.invalidPinForAccount();
        }
        else {

            if(account.getOpenBalance() + account.getOverdraft() < cashRequested){
                throw BadRequestException.exceededCashRequested();
            }

            if(getAtm().getTotalMoney() < cashRequested){
                throw BadRequestException.exceededAtmAmount();
            }
            account.setOpenBalance(setNewBalance(account.getOpenBalance(), cashRequested));
            return calculateAmount(account, cashRequested);
        }
    }


    private Integer setNewBalance(Integer openBalance, final Integer cashRequested){

       return openBalance -= cashRequested;
    }

    private FundsResponse calculateAmount(Account account, Integer cashRequested){
        int c = cashRequested;
        int index = 0;
        List<Integer> cashDisp = new ArrayList<>();
        int[] notes = {50, 20, 10, 5};

        while (c > 0){
            if((c - notes[index] >= 0) && getCashNote(notes[index]) > 0){
                c -= notes[index];
                remove(notes[index]);
                cashDisp.add(notes[index]);
            }else{
                index++;
            }
        }
        repository.save(account);
        return new FundsResponseBuilder().withAccountNumber(account.getAccountNumber())
                .withCurrentBalance(account.getOpenBalance())
                .withFundsRequested(cashRequested)
                .build();
    }

    private boolean remove(Integer note)  {
        Integer bills = getAtm().getCashMap().get(note);
        if(bills == 0){
            return false;
        }
        getAtm().getCashMap().replace(note, bills - 1);
        return true;
    }

    private Integer getCashNote(Integer note){
        return getAtm().getCashMap().get(note);
    }

    private ATM getAtm(){

        Map<Integer, Integer> cashMap = new HashMap<>();
        cashMap.put(50, 10);
        cashMap.put(20, 30);
        cashMap.put(10, 30);
        cashMap.put(5, 20);
        return new ATMBuilder().withTotalMoney(1500)
                .withCashMap(cashMap)
                .build();
    }

}
