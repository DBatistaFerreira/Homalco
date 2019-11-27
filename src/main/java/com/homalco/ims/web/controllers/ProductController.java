package com.homalco.ims.web.controllers;

import com.homalco.ims.services.ProductService;
import com.homalco.ims.services.QRCodeService;
import com.homalco.ims.web.model.ProductRequest;
import com.homalco.ims.web.model.ProductResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api")
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    private ProductService productService;
    private QRCodeService qrCodeService;

    public ProductController(ProductService productService, QRCodeService qrCodeService) {
        this.productService = productService;
        this.qrCodeService = qrCodeService;
    }

    @ResponseStatus(CREATED)
    @PostMapping(path = "/Products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponse addProduct(
            @Valid @RequestBody ProductRequest productRequest) {
        qrCodeService.createQRCode(productRequest.getId());
        return null;
    }

    @ResponseStatus(OK)
    @PutMapping(path = "/Products/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponse editProduct(
            @PathVariable(value = "productId") String productId,
            @Valid @RequestBody ProductRequest productRequest) {
        return null;
    }

    @ResponseStatus(OK)
    @GetMapping(path = "/Products/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponse getProduct(
            @PathVariable(value = "productId") String productId) {
        return null;
    }
}
