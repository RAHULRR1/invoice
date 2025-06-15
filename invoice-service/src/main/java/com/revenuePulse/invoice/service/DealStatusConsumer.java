package com.revenuePulse.invoice.service;


import com.revenuePulse.invoice.mapper.InvoiceMapper;
import io.r2dbc.spi.Parameter;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;



@Service
public class DealStatusConsumer {

    private final InvoiceConsumer invoiceConsumer;
    private final InvoiceService invoiceService;
    private final InvoiceMapper invoiceMapper;

    public DealStatusConsumer(InvoiceConsumer invoiceConsumer, InvoiceService invoiceService, InvoiceMapper invoiceMapper) {
        this.invoiceConsumer = invoiceConsumer;
        this.invoiceService = invoiceService;
        this.invoiceMapper = invoiceMapper;
    }


    @KafkaListener(topics = "deal-status", groupId = "invoice-service")
    public void consumeDealStatus(String message) {
        invoiceService.insertInvoice(message, "UNPAID")
                .doOnSuccess(savedInvoice -> {
                    System.out.println("Invoice saved successfully: " + savedInvoice);
                    invoiceConsumer.sendInvoice((invoiceMapper.toDto(savedInvoice)));
                })
                .doOnError(error ->
                        System.err.println("Error saving invoice: " + error.getMessage()))
                .subscribe(); // trigger reactive chain
    }











}