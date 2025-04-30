package com.example.productservice.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProductRequest {
    private String name;
    private String description;
    private String category;
    private double price;
    private int availableStock;
}
