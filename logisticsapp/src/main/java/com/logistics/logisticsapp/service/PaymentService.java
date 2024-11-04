package com.logistics.logisticsapp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistics.logisticsapp.model.Invoice;
import com.logistics.logisticsapp.model.Payment;
import com.logistics.logisticsapp.repository.InvoiceRepository;
import com.logistics.logisticsapp.repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment savePayment(double amount, String method, String date, String status) {
        Payment payment = new Payment();
        payment.setAmount(amount);
        payment.setMethod(method);
        payment.setDate(LocalDate.parse(date)); // Ensure the date is in the correct format
        payment.setStatus(status);
        return paymentRepository.save(payment); // Return the saved payment
    }

    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}
