package com.revenuePulse.invoice.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Deal {
    private Integer dealId;
    private String dealTitle;
    private Integer customerId;
    private String customerName;
    private Double amount;
    private String status;
    private LocalDateTime createdDate;
    private LocalDateTime closedDate;
}
