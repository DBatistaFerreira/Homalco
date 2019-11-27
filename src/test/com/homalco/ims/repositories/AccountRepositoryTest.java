package com.homalco.ims.repositories;

import com.homalco.ims.entities.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Java6Assertions.assertThat;

@Transactional
@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void findByUsername_Success() {
        String password = "poop";
        String username = "daniel";
        Long id = (long) 20;
        String type = "wizard";

        Account account = new Account();
        account.setPassword(password);
        account.setUsername(username);
        account.setId(id);
        account.setType(type);

        entityManager.clear();
        entityManager.merge(account);
        entityManager.flush();

        Account found = accountRepository.findByUsername(username);

        assertThat(found.getPassword()).isEqualTo(password);
    }

    @Test
    public void findByUsername_Failure() {
        String username = "daniel";

        Account found = accountRepository.findByUsername(username);

        assertThat(found).isNull();
    }

}