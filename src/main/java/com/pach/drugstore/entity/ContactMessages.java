package com.pach.drugstore.entity;

import jakarta.persistence.*;


@Entity
public class ContactMessages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int messageId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    private String subject;
    private String message;

    // Default constructor
    public ContactMessages() {
    }

    // Parameterized constructor
    public ContactMessages(User user, String subject, String message) {
        this.user = user;
        this.subject = subject;
        this.message = message;
    }

    // Getter and setter methods
    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}