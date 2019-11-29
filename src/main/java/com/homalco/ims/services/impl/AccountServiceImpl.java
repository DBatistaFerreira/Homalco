package com.homalco.ims.services.impl;

import com.homalco.ims.entities.Account;
import com.homalco.ims.repositories.AccountRepository;
import com.homalco.ims.services.AccountService;
import com.homalco.ims.web.model.AccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override public AccountResponse saveAccount(Account account) {
        if (account == null) {
            return new AccountResponse("User is null.");
        }

        try {
            accountRepository.save(account);
            return null;
        } catch (DataIntegrityViolationException e) {
            return new AccountResponse("User already exists.");
        }
    }

    @Override public void deleteAccount(long id) {
        accountRepository.delete(accountRepository.getOne(id));
    }

    @Override public Account getAccount(long id) {
        return accountRepository.getOne(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException(username);
        }

        return new User(account.getUsername(), account.getPassword(), Collections.emptyList());
    }
}
