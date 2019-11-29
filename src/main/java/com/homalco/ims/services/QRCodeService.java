package com.homalco.ims.services;

public interface QRCodeService {
    void createQRCode(String id);

    void printQRCode();

    java.io.File getQrCodeImage();
}
