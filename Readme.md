# Product Service - Spring Boot Microservice 🛍️

## Tech Stack
- Java 21
- Spring Boot 3.x
- PostgreSQL
- RabbitMQ
- Maven
- Docker, Docker Compose
- Swagger / OpenAPI
- GitLab / GitHub (for version control)

---

## Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/himanshukr-web/product-service.git
cd product-service
```
### 2. Build the Project
```bash
mvn clean package
```
### 3. Run with Docker Compose
``` bash
docker-compose up --build
App will be available at: http://localhost:8080

RabbitMQ management: http://localhost:15672 (guest/guest)

PostgreSQL: localhost:5432
```

### API Endpoints
``` bash
Method	Endpoint	Description
POST	/products	Create a new product
PUT	/products/{id}	Update a product
GET	/products	List all products
GET	/products/{id}	Get a product by ID
```

### Event-Driven Behavior (RabbitMQ)
On product create/update, an event is published to RabbitMQ exchange.

Event structure:

``` json
{
  "eventType": "PRODUCT_CREATED" | "PRODUCT_UPDATED",
  "timestamp": "2025-04-23T12:00:00Z",
  "product": 
  {
    "productId": "UUID",
    "name": "Product Name",
    "description": "Product Description",
    "category": "Category",
    "price": 99.99,
    "availableStock": 100,
    "lastUpdated": "2025-04-23T12:00:00Z"
  }
}
```

### Swagger UI
Access API documentation at:
http://localhost:8080/swagger-ui.html

