package com.example.RTCSbalance;

import com.example.RTCSbalance.core.RTCSbalanceRepository;
import com.example.RTCSbalance.entity.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;


@DataJpaTest
public class RTCSbalanceRepositoryTest {

    @Autowired
    private RTCSbalanceRepository rtcSbalanceRepository;

    @Test
    void findById_with_success_Case() {
        // Arrange
        Account account = new Account();
        account.setName("rewwy");
        account.setBalance(500L);
        rtcSbalanceRepository.save(account);
        // Act
        Optional<Account> result = rtcSbalanceRepository.findByName("rewwy");
        // Assert
        assertTrue(result.isPresent());
    }
}