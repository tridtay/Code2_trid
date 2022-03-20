package com.example.RTCSbalance;

import com.example.RTCSbalance.core.RTCSbalanceRepository;
import com.example.RTCSbalance.entity.Account;
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
public class RTCSbalanceControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private RTCSbalanceRepository rtcSbalanceRepository;

    @Test
    @DisplayName("ส่ง rew  แล้วจะต้องได้รับข้อความ found")
    void find_Account_Success(){
        // Arrange
        Account account = new Account();
        account.setName("rewwy");
        account.setBalance(500L);

        when(rtcSbalanceRepository.findByName(account.getName())).thenReturn(Optional.of(account));
        // Act
        MessageResponse result = testRestTemplate.getForObject("/balance/rewwy", MessageResponse.class);

        // Assert verify
        assertEquals("found", result.getMessage());
    }
}
