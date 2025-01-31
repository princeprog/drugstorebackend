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
    public User updateUser(@RequestBody User updatedUser, @PathVariable int id) {
        return userService.updateUser(updatedUser, id);
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

}
