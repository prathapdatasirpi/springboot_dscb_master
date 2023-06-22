package com.datasirpi.dschatbox.controller;

import com.datasirpi.dschatbox.dto.Message;
import com.datasirpi.dschatbox.dto.RequestMeta;
import com.datasirpi.dschatbox.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

public class MessageController {
    @Autowired
    IMessageService iMessageService;

    @Autowired
    RequestMeta requestMeta;

    @PostMapping("sendMessage")
    public ResponseEntity sendMessage(@RequestBody Message message) {
        // getting serderId from jwt auth
        int senderId = requestMeta.getUserId();
        // set senderId to request body
        message.setSenderId(senderId);
        iMessageService.saveMessage(message);
        return new ResponseEntity(message, HttpStatus.CREATED);
    }

    @GetMapping(path = "messages/{receiverId}")
    public ResponseEntity getMessages(@PathVariable(required = true) String receiverId) {
        // getting serder id(userId) from jwt auth
        String senderId = String.valueOf(requestMeta.getUserId());

        List<Message> messages = iMessageService.getMessagesById(senderId,receiverId);
        return new ResponseEntity(messages, HttpStatus.ACCEPTED);
    }
}
