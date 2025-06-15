package com.revenuePulse.invoice.service;

import com.revenuePulse.invoice.entity.InvoiceResponseDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Service
public class InvoiceConsumer {

    private final Sinks.Many<InvoiceResponseDto> sink;

    public InvoiceConsumer() {
        sink = Sinks.many().multicast().onBackpressureBuffer();
    }

    public void sendInvoice(InvoiceResponseDto message) {
        sink.tryEmitNext(message); // emit message to all connected SSE clients
    }

    // Expose this Flux to the controller
    public Flux<InvoiceResponseDto> getMessageStream() {
        return sink.asFlux();
    }
}
