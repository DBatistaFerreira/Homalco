package com.homalco.ims.services;

import net.glxn.qrgen.javase.QRCode;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class QRCodeService{

    public void createQRCode(String id) {
        File QRcodeImage = QRCode.from(id).file("product_" + String.join("_", id.toLowerCase().split("\\s")) + "_");
        printQRCode(QRcodeImage);
    }

    private void printQRCode(File QRcodeImage) {
//      TODO: print to a printer
        System.out.println(QRcodeImage.getAbsolutePath());
    }
}
