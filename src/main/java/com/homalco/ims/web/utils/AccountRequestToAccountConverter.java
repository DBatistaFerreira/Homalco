package com.homalco.ims.web.utils;

import com.homalco.ims.entities.Account;
import com.homalco.ims.web.model.AccountRequest;
import org.springframework.core.convert.converter.Converter;

public class AccountRequestToAccountConverter  implements Converter<AccountRequest, Account> {

    @Override
    public Account convert(AccountRequest accountRequest) {
        Account account = new Account();
        account.setUsername(accountRequest.getUsername());
        account.setPassword(accountRequest.getPassword());

        return account;
    }
}
