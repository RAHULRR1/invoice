package com.revenuePulse.invoice.repository;

import com.revenuePulse.invoice.entity.Invoice;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;


@Repository
public interface InvoiceRepository extends ReactiveCrudRepository<Invoice,Long> {
    // Additional query methods (if needed) can go here

    @Query("INSERT INTO \"RevenuePulse\".invoice (invoice_detail, status) VALUES (CAST(:invoiceDetail AS jsonb), :status) RETURNING *")
    Mono<Invoice> insertInvoice(String invoiceDetail, String status);
}
