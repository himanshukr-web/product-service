package com.example.productservice.service;

import com.example.productservice.dto.ProductDTO;
import com.example.productservice.entity.Product;
import com.example.productservice.pubsub.PubSubPublisher;
import com.example.productservice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private PubSubPublisher pubSubPublisher;

    @InjectMocks
    private ProductService productService;

    public ProductServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetProductById() {
        UUID id = UUID.randomUUID();
        Product product = new Product();
        product.setProductId(id);
        product.setName("Test");

        when(productRepository.findById(id)).thenReturn(Optional.of(product));

        ProductDTO result = productService.getProductById(id);
        assertEquals("Test", result.getName());
    }
}
