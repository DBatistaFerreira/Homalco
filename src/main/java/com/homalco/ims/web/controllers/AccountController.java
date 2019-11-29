package com.homalco.ims.web.controllers;

import com.homalco.ims.web.model.AccountRequest;
import com.homalco.ims.web.model.AccountResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;

public interface AccountController {
    @PostMapping(path = "/Accounts")
    ResponseEntity<AccountResponse> addAccount(
            @Valid @RequestBody AccountRequest accountRequest);

    @ResponseStatus(OK)
    @PostMapping(path = "/Accounts/login", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<AccountResponse> login(
            @Valid @RequestBody AccountRequest accountRequest);

    @ResponseStatus(OK)
    @GetMapping(path = "/Accounts/{accountName}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<AccountResponse> getAccount(
            @PathVariable(value = "accountName") String accountName);
}
