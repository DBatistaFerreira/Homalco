package com.homalco.ims.web.utils;

import org.springframework.core.convert.converter.Converter;
import com.homalco.ims.entities.Product;
import com.homalco.ims.web.model.ProductRequest;

public class ProductRequestToProductConverter implements Converter<ProductRequest, Product> {

    @Override
    public Product convert(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setCategory(productRequest.getCategory());
        product.setDescription(productRequest.getDescription());
        product.setMarketPrice(productRequest.getMarketPrice());

        return product;
    }
}
