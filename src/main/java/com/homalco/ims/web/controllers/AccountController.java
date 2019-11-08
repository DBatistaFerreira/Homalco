package com.homalco.ims.web.controllers;

import com.homalco.ims.services.AccountService;
import com.homalco.ims.web.model.AccountRequest;
import com.homalco.ims.web.model.AccountResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api")
public class AccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @ResponseStatus(CREATED)
    @PostMapping(path = "/Accounts", produces = MediaType.APPLICATION_JSON_VALUE)
    public AccountResponse addAccount(
            @Valid @RequestBody AccountRequest accountRequest) {
        return null;
    }

    @ResponseStatus(OK)
    @PostMapping(path = "/Accounts/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public AccountResponse login(
            @Valid @RequestBody AccountRequest accountRequest) {
        return null;
    }


    @ResponseStatus(OK)
    @GetMapping(path = "/Accounts/{accountName}", produces = MediaType.APPLICATION_JSON_VALUE)
        public AccountResponse getAccount(
            @PathVariable(value = "accountName") String accountName) {
        return null;
    }
}
