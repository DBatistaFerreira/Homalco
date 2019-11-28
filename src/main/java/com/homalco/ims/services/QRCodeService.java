package com.homalco.ims.services;

import lombok.Getter;
import net.glxn.qrgen.javase.QRCode;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@Getter
public class QRCodeService{

    private File QRCodeImage;

    public void createQRCode(String id) {
        this.QRCodeImage = QRCode.from(id).file("product_" + String.join("_", id.toLowerCase().split("\\s")) + "_");
        printQRCode();
    }

    public void printQRCode() {
//      TODO: print to a printer
        System.out.println(this.QRCodeImage.getAbsolutePath());
    }
}
