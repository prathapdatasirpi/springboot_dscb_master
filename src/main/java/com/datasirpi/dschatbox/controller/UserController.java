package com.datasirpi.dschatbox.controller;

import com.datasirpi.dschatbox.dto.User;
import com.datasirpi.dschatbox.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
    UserService userService;

    List<User> users = new ArrayList<>();
    UserController() {
        users.add(new User(101, "Prathap", "password"));
        users.add(new User(102, "Jasber", "password1"));
        users.add(new User(103, "Dixon", "password2"));
        users.add(new User(104, "Prabhu", "password3"));
    }
    @GetMapping ("get-users")
    public ResponseEntity<?> getAllUsers() {
        System.out.println(users);
//        userService.getAllUsers();
        return new ResponseEntity<> (users, HttpStatus.OK);
    }
    @DeleteMapping("delete-user/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable int userId) {
        System.out.println(userId);
        users.removeIf(user -> user.userId == userId);
        return new ResponseEntity<> (users, HttpStatus.OK);
    }

    @PostMapping("save-user")
    public ResponseEntity<?> saveUser(@RequestBody User user2) {
        System.out.println(user2.userId);
        boolean isNewUser = users.stream().noneMatch(user -> user.userId == user2.userId);
        if(isNewUser)  {
            users.add(user2);
        } else {
            users.stream().filter(user -> user.userId == user2.userId).forEach(user -> {
                user.userName = user2.userName;
                user.password = user2.password;
            });
        }
        return new ResponseEntity<> (users, HttpStatus.OK);
    }
}
