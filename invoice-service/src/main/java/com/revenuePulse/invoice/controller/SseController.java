package com.revenuePulse.invoice.controller;

import com.revenuePulse.invoice.entity.InvoiceResponseDto;
import com.revenuePulse.invoice.service.InvoiceConsumer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/stream")
public class SseController {

    private final InvoiceConsumer consumer;

    public  SseController(InvoiceConsumer consumer) {
        this.consumer = consumer;
    }

    @GetMapping(value = "/invoiceEvent", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<InvoiceResponseDto> streamKafkaMessages() {
        return consumer.getMessageStream();
    }
}
