package com.revenuePulse.invoice.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
public class InvoiceResponseDto {
    private Long id;
    private InvoiceDetails invoiceDetails;
    private String status;
    private OffsetDateTime createdDate;
    private OffsetDateTime updatedDate;
}
