package com.homalco.ims.web.controllers.impl;

import com.homalco.ims.services.BundleService;
import com.homalco.ims.services.ProductService;
import com.homalco.ims.web.controllers.InventoryController;
import com.homalco.ims.web.model.InventoryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api")
public class InventoryControllerImpl implements InventoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryController.class);

    private BundleService bundleService;
    private ProductService productService;

    public InventoryControllerImpl(BundleService bundleService, ProductService productService) {
        this.bundleService = bundleService;
        this.productService = productService;
    }

    @Override@ResponseStatus(OK)
    @PostMapping(path = "/Inventory", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InventoryResponse> getGlobalInventoryStats() {
        return null;
    }


}
