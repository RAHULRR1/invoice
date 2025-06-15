package com.revenuePulse.invoice.controller;

import com.revenuePulse.invoice.entity.Invoice;
import com.revenuePulse.invoice.entity.InvoiceResponseDto;
import com.revenuePulse.invoice.mapper.InvoiceMapper;
import com.revenuePulse.invoice.service.InvoiceService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final InvoiceMapper invoiceMapper;

    public InvoiceController(InvoiceService invoiceService, InvoiceMapper invoiceMapper) {
        this.invoiceService = invoiceService;
        this.invoiceMapper = invoiceMapper;
    }

    @GetMapping
    public Flux<InvoiceResponseDto> getAllInvoices() {
        return invoiceService.getAllInvoices().map(invoiceMapper::toDto);
    }

    @GetMapping("/{invoiceId}")
    public Mono<Invoice> getInvoiceById(@PathVariable  Long invoiceId) {
        return invoiceService.getInvoiceById(invoiceId);
    }

    @PatchMapping("/{invoiceId}/status")
    public Mono<Invoice> updateInvoiceStatus(@PathVariable  Long invoiceId,@RequestBody String status) {
        return invoiceService.updateInvoiceStatus(invoiceId, status);
    }
}
