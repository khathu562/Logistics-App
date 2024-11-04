package com.logistics.logisticsapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessagingController {
    
    @GetMapping("/messaging")
    public String getMessagingPage() {
        return "messaging"; // This will return the messaging.html file
    }
}
