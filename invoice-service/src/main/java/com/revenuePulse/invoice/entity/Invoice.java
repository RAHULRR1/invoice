package com.revenuePulse.invoice.entity;


import lombok.Data;
import java.time.OffsetDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Table("\"RevenuePulse\".invoice")
public class Invoice {

    @Id
    private Long id;

    @Column("invoice_detail")
    private String invoiceDetail;

    private String status;
    @Column("created_date")
    private OffsetDateTime createdDate;
    @Column("updated_date")
    private OffsetDateTime updatedDate;
}
