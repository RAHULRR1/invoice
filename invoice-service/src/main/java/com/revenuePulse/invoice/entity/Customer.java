package com.revenuePulse.invoice.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Customer {
    private Integer customerId;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String customerType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
