package com.shri.zeero.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * Created by zeeroiq on 9/8/20, 4:53 AM
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Beer implements Serializable {

    private final UUID serial_number = UUID.randomUUID();

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 40, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID id;

    @Version // gives optimistic locking, and ensures integrity while performing the merge operation and for optimistic concurrency control
    private Long version;
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createOn;
    @UpdateTimestamp
    private Timestamp lastModifiedOn;
    private String beerName;
    private String beerStyle;
    @Column(unique = true)
    private Long upc;
    private BigDecimal price;
    private Integer minOnHand;
    private Integer quantityToBrew;
}
