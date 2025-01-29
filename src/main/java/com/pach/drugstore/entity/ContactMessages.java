package com.pach.drugstore.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "contact_messages")
@JsonPropertyOrder({"messageId", "userId", "subject", "message"})
public class ContactMessages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private int messageId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
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