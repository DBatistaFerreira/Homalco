package com.homalco.ims.services;

import com.homalco.ims.Tests;
import com.homalco.ims.entities.Product;
import com.homalco.ims.services.impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@Transactional
@Configurable
public class ProductServiceImplTest extends Tests {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void productServiceBasicFlows() {
        Product testProduct = createTestProduct();
        productService.saveProduct(testProduct);

        Product retrieveTestProduct = productService.getProduct(testProduct.getId());

        LOGGER.info("Testing Creation and Retrieval of Product");
        assertNotNull(retrieveTestProduct);

        productService.deleteProduct(testProduct.getId());

        retrieveTestProduct = productService.getProduct(testProduct.getId());

        LOGGER.info("Testing Deletion of Product");
        assertNull(retrieveTestProduct);
    }

    private Product createTestProduct() {
        Product testProduct = new Product();
        testProduct.setName("testName");
        testProduct.setCategory("testCategory");
        testProduct.setDescription("testDescription");
        testProduct.setMarketPrice((double) 0);

        return testProduct;
    }
}