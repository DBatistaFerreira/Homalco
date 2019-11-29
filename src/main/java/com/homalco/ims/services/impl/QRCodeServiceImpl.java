package com.homalco.ims.services.impl;

import com.homalco.ims.services.ProductService;
import com.homalco.ims.services.QRCodeService;
import net.glxn.qrgen.javase.QRCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class QRCodeServiceImpl implements QRCodeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    @Override
    public File createQRCode(String id) {
        File qrCodeImage = QRCode.from(id).file("product_" + String.join("_", id.toLowerCase().split("\\s")) + "_");
        printQRCode(qrCodeImage);
        return qrCodeImage;
    }

    private void printQRCode(File qrCodeImage) {
        LOGGER.info("Created QR code at: " + qrCodeImage.getAbsolutePath());
    }
}
