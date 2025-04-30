package com.example.productservice.event;

import com.example.productservice.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class ProductEvent {
    private String eventType;
    private String timestamp;
    private Product product;
}
