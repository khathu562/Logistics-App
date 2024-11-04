package com.logistics.logisticsapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.logistics.logisticsapp.model.Payment;
import com.logistics.logisticsapp.service.PaymentService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")  // Allowing requests from all origins
public class PaymentController {

    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private PaymentService paymentService;

    // Get all payments
    @GetMapping("/payments")
    public ResponseEntity<List<Payment>> getPayments() {
        try {
            List<Payment> payments = paymentService.getAllPayments();
            return ResponseEntity.ok(payments);
        } catch (Exception e) {
            logger.error("Failed to retrieve payments", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Submit a new payment
    @PostMapping("/payments")
    public ResponseEntity<String> submitPayment(
            @RequestParam double amount,
            @RequestParam String method,
            @RequestParam String date,
            @RequestParam String status) {
        try {
            paymentService.savePayment(amount, method, date, status);
            return ResponseEntity.status(HttpStatus.CREATED).body("Payment submitted successfully");
        } catch (IllegalArgumentException e) {
            logger.warn("Invalid payment data provided: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid payment data: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Error submitting payment", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error submitting payment");
        }
    }

    // Delete a payment by ID
    @DeleteMapping("/payments/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable Long id) {
        try {
            paymentService.deletePayment(id);
            return ResponseEntity.noContent().build(); 
        } catch (IllegalArgumentException e) {
            logger.warn("Invalid payment ID provided: {}", id);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid payment ID");
        } catch (Exception e) {
            logger.error("Error deleting payment with ID: " + id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting payment");
        }
    }
}
