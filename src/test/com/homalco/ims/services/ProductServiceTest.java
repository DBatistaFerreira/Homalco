package com.homalco.ims.services;

import com.homalco.ims.Tests;
import com.homalco.ims.entities.Product;
import com.homalco.ims.repositories.ProductRepository;
import com.homalco.ims.services.impl.ProductServiceImpl;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@Transactional
@Configurable
public class ProductServiceTest extends Tests {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void productServiceBasicFlows() {
        Product testProduct = createTestProduct("testName", "testCategory","testDescription", 0);
        productService.saveProduct(testProduct);

        Product retrieveTestProduct = productService.getProduct(testProduct.getId());

        LOGGER.info("Testing Creation and Retrieval of Product");
        assertNotNull(retrieveTestProduct);

        productService.deleteProduct(testProduct.getId());

        retrieveTestProduct = productService.getProduct(testProduct.getId());

        LOGGER.info("Testing Deletion of Product");
        assertNull(retrieveTestProduct);
    }

    private Product createTestProduct(String name, String category, String description, double marketPrice){
        Product testProduct = new Product();
        testProduct.setName(name);
        testProduct.setCategory(category);
        testProduct.setDescription(description);
        testProduct.setMarketPrice(marketPrice);

        return testProduct;
    }
}