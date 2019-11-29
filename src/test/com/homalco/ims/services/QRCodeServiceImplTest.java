package com.homalco.ims.services;

import com.homalco.ims.Tests;
import com.homalco.ims.services.impl.QRCodeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;

import static org.junit.Assert.assertTrue;

@Transactional
@Configurable
public class QRCodeServiceImplTest extends Tests {

    @Autowired
    private QRCodeServiceImpl qrCodeService;

    @Test
    public void testCreateQRCode() {
        File result = qrCodeService.createQRCode("12345678987654321");
        assertTrue(result.toString().contains("product_12345678987654321_"));
        assertTrue(result.toString().contains(".png"));
    }
}