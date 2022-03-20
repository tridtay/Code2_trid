package com.example.RTCSbalance.core;

import com.example.RTCSbalance.entity.Account;
import com.example.RTCSbalance.exception.AccountAlreadyExistAuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Locale;
import java.util.Optional;

@Service
public class RTCSbalanceService {

    @Autowired
    private  RTCSbalanceRepository rtcSbalanceRepository;

    public void setQRcodeRepository(RTCSbalanceRepository rtcSbalanceRepository) {
        this.rtcSbalanceRepository = rtcSbalanceRepository;
    }


    public String findAccount(String name) throws AccountNotFoundException {
        Optional<Account> result = rtcSbalanceRepository.findByName(name);
        if (result.isPresent()) {
            return "found";
        } throw new AccountNotFoundException(name);
    }

    public String createAccount(Account account) throws AccountAlreadyExistAuthenticationException {
        Optional<Account> result = rtcSbalanceRepository.findByName(account.getName());
        if (result.isEmpty()) {
            rtcSbalanceRepository.save(account);
            return "Create Account Success";
        } throw new AccountAlreadyExistAuthenticationException(account.getName());
    }

}
