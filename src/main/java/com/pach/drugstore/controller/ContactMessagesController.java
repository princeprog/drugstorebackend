package com.pach.drugstore.controller;

import com.pach.drugstore.entity.ContactMessages;
import com.pach.drugstore.service.ContactMessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contactmessages")
public class ContactMessagesController {

    @Autowired
    private ContactMessagesService contactMessagesService;

    @PostMapping("/save")
    public ContactMessages saveMessage(@RequestBody ContactMessages contactMessage) {
        return contactMessagesService.saveContactMessage(contactMessage);
    }

    @GetMapping("/getallmessages")
    public List<ContactMessages> getAllMessages() {
        return contactMessagesService.findAllMessages();
    }

    @GetMapping("/getmessagesbyuser/{userId}")
    public List<ContactMessages> getMessagesByUserId(@PathVariable int userId) {
        return contactMessagesService.findMessagesByUserId(userId);
    }

    @GetMapping("/getmessagebyid/{messageId}")
    public ContactMessages getMessageById(@PathVariable int messageId) {
        return contactMessagesService.getMessageById(messageId);
    }

    @PutMapping("/updatemessage/{messageId}")
    public ContactMessages updateMessage(@RequestBody ContactMessages updatedMessage, @PathVariable int messageId) {
        return contactMessagesService.updateMessage(updatedMessage, messageId);
    }

    @DeleteMapping("/deletemessage/{messageId}")
    public void deleteMessage(@PathVariable int messageId) {
        contactMessagesService.deleteMessage(messageId);
    }
}
