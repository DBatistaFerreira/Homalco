package com.homalco.ims.services;

import com.homalco.ims.entities.Product;
import com.homalco.ims.repositories.ProductRepository;
import com.homalco.ims.web.model.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    public ProductResponse saveProduct(Product product){
        if (product == null){
            return new ProductResponse("Product is null.");
        }

        try{
            productRepository.save(product);
            return null;
        } catch(DataIntegrityViolationException e){
            return new ProductResponse("Product already exists.");
        }
    }

    public void deleteProduct(long id){
        productRepository.delete(productRepository.getOne(id));
    }

    public void getProduct(long id){
        productRepository.getOne(id);
    }
}
