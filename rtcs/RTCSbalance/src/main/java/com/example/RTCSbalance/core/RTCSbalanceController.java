package com.example.RTCSbalance.core;


import com.example.RTCSbalance.MessageResponse;
import com.example.RTCSbalance.entity.Account;
import com.example.RTCSbalance.exception.AccountAlreadyExistAuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;

@RestController
@RequestMapping("/balance")
public class RTCSbalanceController {

    private static final Logger log
            = LoggerFactory.getLogger(RTCSbalanceController.class);

    @Autowired
    private RTCSbalanceService rtcSbalanceService;

    @Autowired
    private RTCSbalanceRepository rtcSbalanceRepository;

    @GetMapping("/{name}")
    public MessageResponse getBalance(@PathVariable String name) throws AccountNotFoundException {
        log.info("Get Account Info");
        return new MessageResponse(rtcSbalanceService.findAccount(name));
    }

    @PostMapping("/CreateAccount")
    public MessageResponse Generate(@RequestBody Account account) throws AccountAlreadyExistAuthenticationException {
        log.info("Create Account");
        return new MessageResponse(rtcSbalanceService.createAccount(account));
    }
}
