package com.homalco.ims.web.controllers;

import com.homalco.ims.services.BundleService;
import com.homalco.ims.services.QRCodeService;
import com.homalco.ims.web.model.BundleRequest;
import com.homalco.ims.web.model.BundleResponse;
import com.homalco.ims.web.model.ProductResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api")
public class BundleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BundleController.class);

    private BundleService bundleService;
    private QRCodeService qrCodeService;

    public BundleController(BundleService bundleService, QRCodeService qrCodeService) {
        this.bundleService = bundleService;
        this.qrCodeService = qrCodeService;
    }

    @ResponseStatus(CREATED)
    @PostMapping(path = "/Bundles", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BundleResponse> addBundle(
            @Valid @RequestBody BundleRequest bundleRequest) {
        return null;
    }

    @ResponseStatus(OK)
    @PutMapping(path = "/Bundles/{bundleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponse> editBundle(
            @PathVariable(value = "bundleId") String bundleId,
            @Valid @RequestBody BundleRequest bundleRequest) {
        return null;
    }

}
