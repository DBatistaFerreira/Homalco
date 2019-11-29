package com.homalco.ims.services;

import com.homalco.ims.entities.Account;
import com.homalco.ims.web.model.AccountResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends UserDetailsService {
    AccountResponse saveAccount(Account account);

    void deleteAccount(long id);

    Account getAccount(long id);

    @Override
    UserDetails loadUserByUsername(String username);
}
