package com.homalco.ims.repositories;

import com.homalco.ims.entities.Product;
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
public class ProductRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    private final long id = (long) 42;

    @Test
    public void getById_Success() {
        final String name = "Bouncy Ball";

        Product product = new Product();
        product.setId(id);
        product.setName(name);

        entityManager.clear();
        entityManager.merge(product);
        entityManager.flush();

        Product found = productRepository.getOne(id);

        assertThat(found.getName()).isEqualTo(name);
    }

    @Test
    public void getById_Failure() {
        Product found = productRepository.getOne(id);

        assertThat(found).isNull();
    }

}