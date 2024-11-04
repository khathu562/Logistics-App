package com.logistics.logisticsapp.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.logistics.logisticsapp.model.Message;


@Service
public class MessageService {
     private final List<Message> messages = new ArrayList<>();

    public List<Message> getMessages() {
        return messages;
    }

    public void addMessage(Message message) {
        messages.add(message);
    }
}
