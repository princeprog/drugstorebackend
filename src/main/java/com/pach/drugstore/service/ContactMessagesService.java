package com.pach.drugstore.service;

import com.pach.drugstore.entity.ContactMessages;
import com.pach.drugstore.repository.ContactMessagesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactMessagesService {

    @Autowired
    private ContactMessagesRepo contactMessagesRepo;

    public ContactMessages saveContactMessage(ContactMessages contactMessage) {
        return contactMessagesRepo.save(contactMessage);
    }

    public List<ContactMessages> findAllMessages() {
        return contactMessagesRepo.findAll();
    }

    public List<ContactMessages> findMessagesByUserId(int userId) {
        return contactMessagesRepo.findByUser_UserId(userId);
    }

    public ContactMessages getMessageById(int messageId) {
        return contactMessagesRepo.findById(messageId).orElse(null);
    }

    public ContactMessages updateMessage(ContactMessages updatedMessage, int messageId) {
        ContactMessages existingMessage = contactMessagesRepo.findById(messageId).orElseThrow(() -> new RuntimeException("Message not found"));
        existingMessage.setSubject(updatedMessage.getSubject());
        existingMessage.setMessage(updatedMessage.getMessage());
        return contactMessagesRepo.save(existingMessage);
    }

    public void deleteMessage(int messageId) {
        ContactMessages message = contactMessagesRepo.findById(messageId).orElseThrow(() -> new RuntimeException("Message not found"));
        contactMessagesRepo.delete(message);
    }
}
