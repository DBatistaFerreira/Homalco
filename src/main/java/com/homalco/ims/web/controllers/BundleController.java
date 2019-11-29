package com.homalco.ims.web.controllers;

import com.homalco.ims.web.model.BundleRequest;
import com.homalco.ims.web.model.BundleResponse;
import com.homalco.ims.web.model.ProductResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

public interface BundleController {
    @ResponseStatus(CREATED)
    @PostMapping(path = "/Bundles", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BundleResponse> addBundle(
            @Valid @RequestBody BundleRequest bundleRequest);

    @ResponseStatus(OK)
    @PutMapping(path = "/Bundles/{bundleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ProductResponse> editBundle(
            @PathVariable(value = "bundleId") String bundleId,
            @Valid @RequestBody BundleRequest bundleRequest);
}
