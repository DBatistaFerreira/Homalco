package com.homalco.ims.web.controllers;

import com.homalco.ims.services.AccountService;
import com.homalco.ims.web.model.AccountRequest;
import com.homalco.ims.web.model.AccountResponse;
import com.homalco.ims.web.utils.AccountRequestToAccountConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("api")
public class AccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

    private AccountService accountService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AccountController(AccountService accountService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.accountService = accountService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping(path = "/Accounts")
    public ResponseEntity<AccountResponse> addAccount(
            @Valid @RequestBody AccountRequest accountRequest) {
        LOGGER.info("Creating Account with username {}", accountRequest.getUsername());

        AccountRequestToAccountConverter converter = new AccountRequestToAccountConverter();

        accountRequest.setPassword(bCryptPasswordEncoder.encode(accountRequest.getPassword()));
        AccountResponse response = accountService.saveAccount(converter.convert(accountRequest));
        if (response != null) {
            return ResponseEntity.status(BAD_REQUEST).body(response);
        }

        LOGGER.info("Successfully Created Account with username {}", accountRequest.getUsername());
        return ResponseEntity.status(CREATED).body(response);
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
