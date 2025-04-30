package com.example.productservice.dto;

import lombok.*;

import java.time.Instant;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProductResponse {
    private UUID productId;
    private String name;
    private String description;
    private String category;
    private double price;
    private int availableStock;
    private String lastUpdated;
}
