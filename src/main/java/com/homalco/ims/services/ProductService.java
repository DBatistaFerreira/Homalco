package com.homalco.ims.services;

import com.homalco.ims.entities.Product;
import com.homalco.ims.web.model.ProductResponse;

public interface ProductService {
    ProductResponse saveProduct(Product product);

    void deleteProduct(long id);

    void getProduct(long id);
}
