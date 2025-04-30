package com.example.productservice.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private UUID productId;
    private String name;
    private String description;
    private String category;
    private BigDecimal price;
    private Integer availableStock;
    private String lastUpdated;
}
