package com.homalco.ims.services;

import com.homalco.ims.entities.Account;
import com.homalco.ims.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public Account saveAccount(Account account){
        return accountRepository.save(account);
    }

    public void deleteAccount(long id){
        accountRepository.delete(accountRepository.getOne(id));
    }

    public Account getAccount(long id){
        return accountRepository.getOne(id);
    }

}
