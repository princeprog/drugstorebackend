package com.pach.drugstore.controller;

import com.pach.drugstore.entity.User;
import com.pach.drugstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        try {
            userService.saveUser(user);
            return ResponseEntity.ok("User registered successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getallusers")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/getuserbyid/{id}")
    public User findUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PutMapping("/updateuser/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User updatedUser, @PathVariable int id) {
        try {
            User updated = userService.updateUser(updatedUser, id);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            e.printStackTrace();  // You can handle logging here
            return ResponseEntity.status(500).body(null);
        }
    }


    @DeleteMapping("/deleteuser/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User userLogin) {
        User existingUser = userService.getUserByEmail(userLogin.getEmail());

        if (existingUser == null) {
            return ResponseEntity.status(401).body("Email not found");
        }

        if (!existingUser.getPassword().equals(userLogin.getPassword())) {
            return ResponseEntity.status(401).body("Invalid email or password");
        }

        return ResponseEntity.ok("Login successful");
    }

    @GetMapping("/profile")
    public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
        User user = userService.getUserByEmail(email);
        if (user == null) {
            return ResponseEntity.status(404).body(null); // User not found
        }
        return ResponseEntity.ok(user); // Return user data
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody User updatedUser) {
        try {
            System.out.println("Attempting to update user: " + updatedUser.getEmail());
            if (updatedUser.getEmail() == null || updatedUser.getEmail().isEmpty()) {
                return ResponseEntity.badRequest().body("Email is required to update user.");
            }

            User existingUser = userService.getUserByEmail(updatedUser.getEmail());
            if (existingUser == null) {
                return ResponseEntity.status(404).body("User not found.");
            }

            existingUser.setFirstname(updatedUser.getFirstname());
            existingUser.setLastname(updatedUser.getLastname());
            existingUser.setPhone(updatedUser.getPhone());

            if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
                existingUser.setPassword(updatedUser.getPassword());
            }

            userService.saveUser(existingUser);

            return ResponseEntity.ok("Profile updated successfully!");
        } catch (Exception e) {
            e.printStackTrace();  // Print the stack trace to the console for debugging
            return ResponseEntity.status(500).body("An error occurred while updating the profile.");
        }
    }
}
