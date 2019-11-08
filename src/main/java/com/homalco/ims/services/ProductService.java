package com.homalco.ims.services;

import com.homalco.ims.entities.Product;
import com.homalco.ims.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    public void saveProduct(Product product){
        productRepository.save(product);
    }

    public void deleteProduct(long id){
        productRepository.delete(productRepository.getOne(id));
    }

    public void getProduct(long id){
        productRepository.getOne(id);
    }
}
