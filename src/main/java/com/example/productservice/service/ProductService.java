package com.example.productservice.service;


import com.example.productservice.entity.Product;
import com.example.productservice.dto.ProductRequest;
import com.example.productservice.dto.ProductResponse;
import com.example.productservice.event.EventPublisher;
import com.example.productservice.event.ProductEvent;
import com.example.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final EventPublisher eventPublisher;

    public ProductResponse createProduct(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setCategory(request.getCategory());
        product.setPrice(request.getPrice());
        product.setAvailableStock(request.getAvailableStock());
        product.setLastUpdated(Instant.now().toString());

        Product saved = productRepository.save(product);
        eventPublisher.publishEvent(new ProductEvent("PRODUCT_CREATED", Instant.now().toString(), saved));

        return mapToResponse(saved);
    }

    public ProductResponse updateProduct(UUID id, ProductRequest request) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setCategory(request.getCategory());
        product.setPrice(request.getPrice());
        product.setAvailableStock(request.getAvailableStock());
        product.setLastUpdated(Instant.now().toString());

        Product updated = productRepository.save(product);
        eventPublisher.publishEvent(new ProductEvent("PRODUCT_UPDATED", Instant.now().toString(), updated));

        return mapToResponse(updated);
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public ProductResponse getProductById(UUID id) {
        return productRepository.findById(id).map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    private ProductResponse mapToResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.setProductId(product.getProductId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setCategory(product.getCategory());
        response.setPrice(product.getPrice());
        response.setAvailableStock(product.getAvailableStock());
        response.setLastUpdated(product.getLastUpdated());
        return response;
    }
}
