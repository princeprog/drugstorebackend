package com.pach.drugstore.repository;

import com.pach.drugstore.entity.ContactMessages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactMessagesRepo extends JpaRepository<ContactMessages, Integer> {
    List<ContactMessages> findByUser_UserId(int userId);  // To fetch messages by userId
}
