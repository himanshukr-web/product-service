package com.example.productservice.pubsub;

import com.example.productservice.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class PubSubPublisher {

    private final ObjectMapper objectMapper;

    public void publishProductEvent(Product product, String eventType) {
        try {
            Map<String, Object> eventPayload = new HashMap<>();
            eventPayload.put("eventType", eventType);
            eventPayload.put("timestamp", Instant.now().toString());
            eventPayload.put("product", product);

            String message = objectMapper.writeValueAsString(eventPayload);
            log.info("Publishing to Pub/Sub Topic [product-events]: {}", message);

            // In real GCP: pubSubTemplate.publish("product-events", message)
            // Here just log it.

        } catch (Exception e) {
            log.error("Failed to publish event", e);
        }
    }
}
