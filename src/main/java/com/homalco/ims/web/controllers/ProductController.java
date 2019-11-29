package com.homalco.ims.web.controllers;

import com.homalco.ims.web.model.ProductRequest;
import com.homalco.ims.web.model.ProductResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

public interface ProductController {
    @ResponseStatus(CREATED)
    @PostMapping(path = "/Products", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ProductResponse> addProduct(
            @Valid @RequestBody ProductRequest productRequest);

    @ResponseStatus(OK)
    @PutMapping(path = "/Products/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ProductResponse> editProduct(
            @PathVariable(value = "productId") String productId,
            @Valid @RequestBody ProductRequest productRequest);

    @ResponseStatus(OK)
    @GetMapping(path = "/Products/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ProductResponse> getProduct(
            @PathVariable(value = "productId") String productId);
}
