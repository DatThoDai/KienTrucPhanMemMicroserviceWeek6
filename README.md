# Hệ thống quản lý bán hàng với Microservices

Hệ thống quản lý bán hàng được xây dựng bằng kiến trúc Microservices, bao gồm các thành phần:
- Product Service: Quản lý thông tin sản phẩm
- Order Service: Quản lý đơn hàng
- Customer Service: Quản lý thông tin khách hàng
- API Gateway: Điểm truy cập duy nhất cho client
- Eureka Server: Dịch vụ đăng ký và khám phá service

## Sơ đồ gọi giữa các services

```
+----------------+      +----------------+      +----------------+
|                |      |                |      |                |
| Product Service|      | Order Service  |      |Customer Service|
|                |      |                |      |                |
+-------+--------+      +-------+--------+      +-------+--------+
        |                       |                       |
        |                       |                       |
        v                       v                       v
+-------+-------+       +-------+-------+       +-------+-------+
|  MongoDB      |       |  MongoDB      |       |  MongoDB   |
|  Database     |       |  Database     |       |  Database     |
+---------------+       +---------------+       +---------------+
        ^                       ^                       ^
        |                       |                       |
        |                       |                       |
+-------+-----------------------------------------------+-------+
|                                                               |
|                         API Gateway                           |
|                                                               |
+---------------------------------------------------------------+
                                ^
                                |
                                |
                        +-------+-------+
                        |               |
                        |    Client     |
                        |               |
                        +---------------+
```

## Luồng giao tiếp

1. Client gửi request đến API Gateway
2. API Gateway xác định service phù hợp và chuyển tiếp request
3. Các service giao tiếp thông qua REST API:
   - Order Service gọi đến Product Service để lấy thông tin sản phẩm
   - Order Service gọi đến Customer Service để xác thực khách hàng

## Cấu trúc dự án

```
Microservices-Part1-SalesApp/
├── api-gateway/               # API Gateway Service
├── customer-service/          # Customer Service
├── discovery-server/          # Eureka Service Discovery
├── order-service/             # Order Service
├── product-service/           # Product Service
├── docker-compose.yml         # Docker Compose file
└── README.md                  # Hướng dẫn
```

## Các công nghệ sử dụng

- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Cloud**: Gateway, Eureka, OpenFeign
- **Spring Data MongoDB**
- **MongoDB**: Cơ sở dữ liệu
- **Docker & Docker Compose**: Containerization
- **Maven**: Build tool

## Hướng dẫn chạy dự án
Chạy các service theo thứ tự:
- discovery-server
- api-gateway
- product-service
- customer-service
- order-service

## Kiểm tra hệ thống

1. Eureka Dashboard: http://localhost:8762
2. API Gateway: http://localhost:8080
3. Swagger UI cho các service:
   - Product Service: http://localhost:8081/swagger-ui.html
   - Order Service: http://localhost:8082/swagger-ui.html
   - Customer Service: http://localhost:8083/swagger-ui.html

## API Endpoints

### Product Service
- GET /api/products - Lấy tất cả sản phẩm
- GET /api/products/{id} - Lấy sản phẩm theo ID
- POST /api/products - Tạo sản phẩm mới
- PUT /api/products/{id} - Cập nhật sản phẩm
- DELETE /api/products/{id} - Xóa sản phẩm

### Order Service
- GET /api/orders - Lấy tất cả đơn hàng
- GET /api/orders/{id} - Lấy đơn hàng theo ID
- GET /api/orders/customer/{customerId} - Lấy đơn hàng theo khách hàng
- POST /api/orders - Tạo đơn hàng mới
- PUT /api/orders/{id}/status - Cập nhật trạng thái đơn hàng
- DELETE /api/orders/{id} - Xóa đơn hàng

### Customer Service
- GET /api/customers - Lấy tất cả khách hàng
- GET /api/customers/{id} - Lấy khách hàng theo ID
- GET /api/customers/email/{email} - Lấy khách hàng theo email
- POST /api/customers - Tạo khách hàng mới
- PUT /api/customers/{id} - Cập nhật thông tin khách hàng
- DELETE /api/customers/{id} - Xóa khách hàng
