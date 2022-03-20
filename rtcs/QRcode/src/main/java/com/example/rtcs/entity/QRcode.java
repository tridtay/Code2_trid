package com.example.rtcs.entity;

import javax.persistence.*;

@Entity
public class QRcode {
    @Id
    @Column(name = "QRcode_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sender", nullable = false)
    private String sender;
    @Column(name = "receiver", nullable = false)
    private String receiver;
    @Column(name = "amount", nullable = false)
    private Long amount;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public QRcode() {
    }

    public QRcode(String sender, String receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}


