package com.revenuePulse.invoice.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revenuePulse.invoice.entity.Invoice;
import com.revenuePulse.invoice.entity.InvoiceDetails;
import com.revenuePulse.invoice.entity.InvoiceResponseDto;
import org.springframework.stereotype.Service;

@Service
public class InvoiceMapper {

    private final ObjectMapper objectMapper;

    public InvoiceMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public InvoiceResponseDto toDto(Invoice invoice) {
        try {
            InvoiceDetails detail = objectMapper.readValue(invoice.getInvoiceDetail(), InvoiceDetails.class);
            return new InvoiceResponseDto(
                    invoice.getId(),
                    detail,
                    invoice.getStatus(),
                    invoice.getCreatedDate(),
                    invoice.getUpdatedDate()
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to parse invoiceDetail JSON", e);
        }
    }
}
