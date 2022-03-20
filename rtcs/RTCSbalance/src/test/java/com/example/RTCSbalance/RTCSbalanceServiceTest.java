package com.example.RTCSbalance;

import com.example.RTCSbalance.core.RTCSbalanceRepository;
import com.example.RTCSbalance.core.RTCSbalanceService;
import com.example.RTCSbalance.entity.Account;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class RTCSbalanceServiceTest {
    @Mock
    private RTCSbalanceRepository rtcSbalanceRepository;

    @Test//unit test
    @DisplayName("ส่ง rewwy  แล้วจะต้องได้รับข้อความ found")
    void findAccount_Success_Case() throws AccountNotFoundException {
        //Arrange
        Account account = new Account();
        account.setName("rewwy");
        account.setBalance(500L);
        when(rtcSbalanceRepository.findByName(account.getName())).thenReturn(Optional.of(account));
        // Act
        RTCSbalanceService rtcSbalanceService = new RTCSbalanceService();
        rtcSbalanceService.setQRcodeRepository(rtcSbalanceRepository);
        String result = rtcSbalanceService.findAccount("rewwy");
        // Assert
        assertEquals("found", result);
    }
}

