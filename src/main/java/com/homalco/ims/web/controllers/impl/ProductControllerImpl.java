package com.homalco.ims.web.controllers.impl;

import com.homalco.ims.services.ProductService;
import com.homalco.ims.web.controllers.ProductController;
import com.homalco.ims.web.model.ProductRequest;
import com.homalco.ims.web.model.ProductResponse;
import com.homalco.ims.web.utils.ProductRequestToProductConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("api")
public class ProductControllerImpl implements ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    private ProductService productService;

    public ProductControllerImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override@ResponseStatus(CREATED)
    @PostMapping(path = "/Products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponse> addProduct(
            @Valid @RequestBody ProductRequest productRequest) {
        LOGGER.info("Creating Product with product name: {}", productRequest.getName());
        ProductRequestToProductConverter converter = new ProductRequestToProductConverter();
        ProductResponse response = productService.saveProduct(converter.convert(productRequest));

        if (response != null) {
            return ResponseEntity.status(BAD_REQUEST).body(response);
        }

        LOGGER.info("Successfully Created Product with name: {}", productRequest.getName());
        return ResponseEntity.status(CREATED).body(response);

    }

    @Override@ResponseStatus(OK)
    @PutMapping(path = "/Products/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponse> editProduct(
            @PathVariable(value = "productId") String productId,
            @Valid @RequestBody ProductRequest productRequest) {
        return null;
    }

    @Override@ResponseStatus(OK)
    @GetMapping(path = "/Products/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponse> getProduct(
            @PathVariable(value = "productId") String productId) {
        return null;
    }
}
