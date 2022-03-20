package com.example.rtcs.qrcode;


import com.example.rtcs.MessageResponse;
import com.example.rtcs.QRcodeRepository;
import com.example.rtcs.entity.QRcode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QRcodeControllerTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean //จำลองbean ไม่ได้ไปเรียกของจริง
    private QRcodeRepository qRcodeRepository;

    @Test
    @DisplayName("ส่ง code = 1  แล้วจะต้องได้รับข้อความ found")
    void getQRcode_Success_Case(){
        // Arrange
        QRcode qRcode = new QRcode();
        qRcode.setId(1L);
        qRcode.setSender("TestSender");
        qRcode.setReceiver("TestReceiver");
        qRcode.setAmount(10L);

        when(qRcodeRepository.findById(qRcode.getId())).thenReturn(Optional.of(qRcode));
        // Act
        MessageResponse result = testRestTemplate.getForObject("/qrcode/1", MessageResponse.class);

        // Assert verify
        assertEquals("found", result.getMessage());
    }

    @Test
    @DisplayName("Generate  แล้วจะต้องได้รับข้อความ Generate Success")
    void generate_Success_Case() {
        QRcode qRcode = new QRcode();
        qRcode.setId(1L);
        qRcode.setSender("TestSender");
        qRcode.setReceiver("TestReceiver");
        qRcode.setAmount(10L);
        // Act
        when(qRcodeRepository.findById(qRcode.getId())).thenReturn(Optional.of(qRcode));
//        when(qRcodeRepository.save(qRcode)).thenReturn(qRcode);
        MessageResponse result = testRestTemplate.postForObject("/qrcode/Generate",qRcode, MessageResponse.class);
        // Assert verify
        assertEquals("Generate Success",result.getMessage());
    }

}
