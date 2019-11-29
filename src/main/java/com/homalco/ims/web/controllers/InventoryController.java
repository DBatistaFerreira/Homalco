package com.homalco.ims.web.controllers;

import com.homalco.ims.web.model.InventoryResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.OK;

public interface InventoryController {
    @ResponseStatus(OK)
    @PostMapping(path = "/Inventory", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<InventoryResponse> getGlobalInventoryStats();
}
