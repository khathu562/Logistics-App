package com.logistics.logisticsapp.model;

import java.time.LocalDateTime;

public class Message {
     private String text;
    private LocalDateTime timestamp;
    private boolean sent;

    public Message(String text, boolean sent) {
        this.text = text;
        this.timestamp = LocalDateTime.now();
        this.sent = sent;
    }

    // Getters and Setters
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }
}
