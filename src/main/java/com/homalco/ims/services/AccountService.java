package com.homalco.ims.services;

import com.homalco.ims.entities.Account;
import com.homalco.ims.repositories.AccountRepository;
import com.homalco.ims.web.model.AccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AccountService implements UserDetailsService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountResponse saveAccount(Account account) {
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

    public void deleteAccount(long id) {
        accountRepository.delete(accountRepository.getOne(id));
    }

    public Account getAccount(long id) {
        return accountRepository.getOne(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException(username);
        }

        return new User(account.getUsername(), account.getPassword(), Collections.emptyList());
    }
}
