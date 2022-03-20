package com.example.RTCSbalance.core;

import com.example.RTCSbalance.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RTCSbalanceRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByName(String name);
}
