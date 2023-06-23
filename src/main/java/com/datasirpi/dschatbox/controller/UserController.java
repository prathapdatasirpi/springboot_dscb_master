package com.datasirpi.dschatbox.controller;

import com.datasirpi.dschatbox.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
    IUserService iUserService;
    @PostMapping("user-login")
    public ResponseEntity<?> login() {
        iUserService.getAllUsers();
//        System.out.println(iUserService);
        return new ResponseEntity<> ("users", HttpStatus.CREATED);
    }
    @PostMapping("user-signup")
    public ResponseEntity<?> signup() {
//        Logger ("user-signup");
        return ResponseEntity.ok().body("user");
    }
}
