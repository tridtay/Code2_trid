package com.example.rtcs.qrcode;


import com.example.rtcs.QRcodeRepository;
import com.example.rtcs.QRcodeService;
import com.example.rtcs.entity.QRcode;
import com.example.rtcs.exception.QRcodeCantStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class QRcodeServiceTests {
    @Mock //อยู่ในส่วนmockito
    private QRcodeRepository qRcodeRepository;

    @Test//unit test
    @DisplayName("findQRcode(1L)  แล้วจะต้องได้รับข้อความ found")
    void findQRcode_Success_Case() {
        //Arrange
        QRcode qRcode = new QRcode();
        qRcode.setId(1L);
        qRcode.setSender("TestSender");
        qRcode.setReceiver("TestReceiver");
        qRcode.setAmount(10L);
        when(qRcodeRepository.findById(qRcode.getId())).thenReturn(Optional.of(qRcode));
        // Act
        QRcodeService qRcodeService = new QRcodeService();
        qRcodeService.setQRcodeRepository(qRcodeRepository);
        String result = qRcodeService.findQRcode(1L);
        // Assert
        assertEquals("found", result);
    }

    @Test //unit test
    @DisplayName("Generate(qRcode)  แล้วจะต้องได้รับข้อความ Generate Success")
    void Generate_Success_Case() throws QRcodeCantStore {
        //Arrange
        QRcode qRcode = new QRcode();
        qRcode.setId(1L);
        qRcode.setSender("TestSender");
        qRcode.setReceiver("TestReceiver");
        qRcode.setAmount(10L);
        when(qRcodeRepository.findById(qRcode.getId())).thenReturn(Optional.of(qRcode));
        // Act
        QRcodeService qRcodeService = new QRcodeService();
        qRcodeService.setQRcodeRepository(qRcodeRepository);
        String result = qRcodeService.Generate(qRcode);
        // Assert
        assertEquals("Generate Success", result);
    }


}
