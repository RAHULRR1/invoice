package com.revenuePulse.invoice.service;

import com.revenuePulse.invoice.entity.Invoice;
import com.revenuePulse.invoice.repository.InvoiceRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Mono<Invoice> SaveInvoice(Invoice invoice) {
        return this.invoiceRepository.save(invoice);
    }

    public Mono<Invoice> insertInvoice(String invoice, String status) {
        return this.invoiceRepository.insertInvoice(invoice, status);
    }

    public Mono<Invoice> getInvoiceById(Long invoiceId) {
        return this.invoiceRepository.findById(invoiceId);
    }

    public Flux<Invoice> getAllInvoices() {
        return this.invoiceRepository.findAll();
    }

    public Mono<Void> deleteInvoice(Long invoiceId) {
        return this.invoiceRepository.deleteById(invoiceId);
    }

    public Mono<Invoice> updateInvoiceStatus(Long invoiceId, String status) {
        return this.invoiceRepository.findById(invoiceId)
                .flatMap(existingInvoice -> {
                    existingInvoice.setStatus(status);
                    return this.invoiceRepository.save(existingInvoice);
                });
    }
}
