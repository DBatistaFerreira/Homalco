package com.homalco.ims.services.impl;

import com.homalco.ims.entities.Product;
import com.homalco.ims.repositories.ProductRepository;
import com.homalco.ims.services.ProductService;
import com.homalco.ims.services.QRCodeService;
import com.homalco.ims.web.model.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private QRCodeService qrCodeService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, QRCodeService qrCodeService) {
        this.productRepository = productRepository;
        this.qrCodeService = qrCodeService;
    }


    @Override public ProductResponse saveProduct(Product product){
        if (product == null){
            return new ProductResponse("Product is null.");
        }

        try{
            Product savedProduct = productRepository.save(product);
            qrCodeService.createQRCode(savedProduct.getId().toString());
            return null;
        } catch(DataIntegrityViolationException e){
            return new ProductResponse("Product already exists.");
        }
    }

    @Override public void deleteProduct(long id){
        productRepository.delete(productRepository.getOne(id));
    }

    @Override public void getProduct(long id){
        productRepository.getOne(id);
    }
}
