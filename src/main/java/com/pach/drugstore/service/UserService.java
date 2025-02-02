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

    public User saveUser(User user) throws Exception {
        if (userRepo.existsByEmail(user.getEmail())) {
            throw new Exception("Email is already taken. Please choose a different email.");
        }

        // Check if the phone number already exists
        if (userRepo.existsByPhone(user.getPhone())) {
            throw new Exception("Phone Number is already taken. Please choose a different Phone Number.");
        }

        return userRepo.save(user);
    }

    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(int userId) {
        return userRepo.findById(userId).orElse(null);
    }

    public User updateUser(User updatedUser, int id) throws Exception {
        User existingUser = userRepo.findById(id).orElseThrow(() -> new Exception("User not found"));

        // Only check for email conflict if the email is updated
        if (updatedUser.getEmail() != null && !updatedUser.getEmail().equals(existingUser.getEmail())) {
            User userWithSameEmail = userRepo.findByEmail(updatedUser.getEmail());
            if (userWithSameEmail != null) {
                throw new Exception("Email is already taken. Please choose a different email.");
            }
            existingUser.setEmail(updatedUser.getEmail());
        }

        // Only update phone number if it's different
        if (updatedUser.getPhone() != null && !updatedUser.getPhone().equals(existingUser.getPhone())) {
            existingUser.setPhone(updatedUser.getPhone());
        }

        // Update other fields (if provided)
        if (updatedUser.getFirstname() != null) {
            existingUser.setFirstname(updatedUser.getFirstname());
        }
        if (updatedUser.getLastname() != null) {
            existingUser.setLastname(updatedUser.getLastname());
        }
        if (updatedUser.getPassword() != null) {
            existingUser.setPassword(updatedUser.getPassword()); // You can add password hashing here
        }

        // Save updated user
        return userRepo.save(existingUser);
    }


    public void deleteUser(int userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        userRepo.delete(user);
    }

    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public User getUserByPhone(String phone) {
        return userRepo.findByPhone(phone);
    }
}