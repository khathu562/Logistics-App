package com.logistics.logisticsapp.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Indicates that this class is a JPA entity
@Table(name = "invoices") // Optional: Specify the table name in the database
public class Invoice  {
    @Id // Specifies the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates the ID
    private Long id;

    private LocalDate deliveryDate; // The date of delivery
    private double amount; // The amount of the invoice
    private String status; // The status of the invoice (e.g., Paid, Unpaid)

    // Default constructor
    public Invoice() {
    }

    // Parameterized constructor
    public Invoice(LocalDate deliveryDate, double amount, String status) {
        this.deliveryDate = deliveryDate;
        this.amount = amount;
        this.status = status;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Optional: Override toString() for easier debugging
    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", deliveryDate=" + deliveryDate +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}
