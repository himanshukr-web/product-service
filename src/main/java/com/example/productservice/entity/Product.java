package com.example.productservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue
    private UUID productId;

    private String name;
    private String description;
    private String category;
    private BigDecimal price;
    private Integer availableStock;
    private LocalDateTime lastUpdated;
}
