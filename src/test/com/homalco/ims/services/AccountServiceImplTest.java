package com.homalco.ims.services;

import com.homalco.ims.Tests;
import com.homalco.ims.entities.Account;
import com.homalco.ims.services.impl.AccountServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Java6Assertions.assertThat;

@Transactional
@Configurable
public class AccountServiceImplTest extends Tests {

    @Autowired
    private AccountServiceImpl accountService;

    public Account dummyAccount() {
        Account account = new Account();
        account.setUsername("Sam");
        account.setId((long) 343);
        account.setType("Anything");
        account.setPassword("Boogus");
        account.setBundles(null);
        account.setProducts(null);
        return account;
    }

    @Test
    public void accountServiceFlow_Test() {
        Account account = dummyAccount();

        accountService.saveAccount(account);

        Account result = accountService.getAccount(account.getId());

        assertThat(result).isNotNull();
        assertThat(result.getUsername()).isEqualTo(account.getUsername());

        accountService.deleteAccount(account.getId());

        assertThat(result).isNull();

    }

}