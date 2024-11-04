package com.logistics.logisticsapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logistics.logisticsapp.model.Message;
import com.logistics.logisticsapp.service.MessageService;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
     @Autowired
    private MessageService messageService;

    @GetMapping
    public ResponseEntity<List<Message>> getMessages() {
        return ResponseEntity.ok(messageService.getMessages());
    }

    @PostMapping
    public ResponseEntity<Void> sendMessage(@RequestBody Message message) {
        messageService.addMessage(message);
        return ResponseEntity.ok().build();
    }
}
