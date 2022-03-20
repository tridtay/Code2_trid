package com.example.RTCSbalance.entity;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String  name;

    @Column(name = "balance")
    private Long balance;

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account(String name) {
        this.name = name;
    }

    public Long getBalance() {
        return balance;
    }

    public Account(Long id, String name, Long balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Account(String name, Long balance) {
        this.name = name;
        this.balance = balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
