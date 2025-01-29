package com.pach.drugstore.service;

import com.pach.drugstore.entity.User;
import com.pach.drugstore.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(int userId) {
        return userRepo.findById(userId).orElse(null);
    }

    public User updateUser(User updatedUser, int userId) {
        User existingUser = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setFirstname(updatedUser.getFirstname());
        existingUser.setLastname(updatedUser.getLastname());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setPhone(updatedUser.getPhone());
        return userRepo.save(existingUser);
    }

    public void deleteUser(int userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        userRepo.delete(user);
    }
}
