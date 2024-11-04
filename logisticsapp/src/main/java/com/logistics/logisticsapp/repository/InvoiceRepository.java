package com.logistics.logisticsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.logistics.logisticsapp.model.Invoice;

@Repository // This annotation is optional since Spring Data JPA repositories are already considered as components
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    // You can add custom query methods here if needed
}
