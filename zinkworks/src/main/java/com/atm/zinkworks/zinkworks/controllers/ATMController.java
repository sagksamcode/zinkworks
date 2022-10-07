package com.atm.zinkworks.zinkworks.controllers;

import com.atm.zinkworks.zinkworks.responses.BalanceResponse;
import com.atm.zinkworks.zinkworks.responses.FundsResponse;
import com.atm.zinkworks.zinkworks.services.ATMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/")
public class ATMController {

    private final ATMService service;

    @Autowired
    public ATMController(final ATMService service) {
        this.service = service;
    }

    @GetMapping(value = "balance", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BalanceResponse> balance(@RequestParam Integer accountNumber, @RequestParam Integer pin){

        return new ResponseEntity<>(service.getBalance( accountNumber, pin), HttpStatus.OK);
    }

    @GetMapping(value = "funds", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FundsResponse> funds(@RequestParam Integer accountNumber, @RequestParam Integer pin, @RequestParam Integer cashRequested){

        return new ResponseEntity<>(service.getFunds( accountNumber, pin, cashRequested), HttpStatus.OK);
    }
}
