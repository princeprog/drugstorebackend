package com.pach.drugstore.controller;

import com.pach.drugstore.entity.User;
import com.pach.drugstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public User saveUser(User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/getallusers")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/getuserbyid/{id}")
    public User findUserById(int id) {
        return userService.findUserById(id);
    }

    @PutMapping("/updateuser/{id}")
    public User updateUser(User updatedUser, int id) {
        return userService.updateUser(updatedUser, id);
    }

    @DeleteMapping("/deleteuser/{id}")
    public void deleteUser(int id) {
        userService.deleteUser(id);
    }
}
