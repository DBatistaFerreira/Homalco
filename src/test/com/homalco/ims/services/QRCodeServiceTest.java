package com.homalco.ims.services;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class QRCodeServiceTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testCreateQRCode() {
        QRCodeService qrCodeService = new QRCodeService();
        qrCodeService.createQRCode("12345678987654321");
        assertTrue(outContent.toString().contains("product_12345678987654321_"));
        assertTrue(outContent.toString().contains(".png"));
    }
}