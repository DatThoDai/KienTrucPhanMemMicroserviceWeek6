# Hệ thống quản lý bán hàng với Microservices
![image](https://github.com/user-attachments/assets/a6e1d694-03c1-4997-9ab9-9fdc9d59f18a)
![image](https://github.com/user-attachments/assets/d5592bea-dff9-433a-b168-3557539bba19)
![image](https://github.com/user-attachments/assets/2db9f820-50c4-4ee4-bda6-978cf78467d7)
![image](https://github.com/user-attachments/assets/78dcf9ff-e20a-46e9-8df4-ae07eeb6cb13)
<h1>Tạo sản phẩm mới</h1>

![image](https://github.com/user-attachments/assets/d95b6eca-615c-4c43-a49e-fb6b6fe10f94)

<h1>Lấy danh sách sản phẩm</h1>

![image](https://github.com/user-attachments/assets/0d45b71a-32b1-4983-b9d9-9374d8478779)

<h1>Tạo khách hàng mới</h1>

![image](https://github.com/user-attachments/assets/aa514988-6fce-4c03-8274-dd2adc805063)

<h1>Lấy danh sách khách hàng</h1>

![image](https://github.com/user-attachments/assets/e2e3fdf1-e6d2-4e56-8915-9b5533ef41db)

<h1>Tạo đơn hàng mới</h1>

![image](https://github.com/user-attachments/assets/10f2cc2f-a76f-4d9c-a813-395edf911143)

<h1>Lấy danh sách đơn hàng</h1>

![image](https://github.com/user-attachments/assets/5ff2db85-6dc5-4217-be05-c260534d1b2f)

Hệ thống quản lý bán hàng được xây dựng bằng kiến trúc Microservices, bao gồm các thành phần:
- Product Service: Quản lý thông tin sản phẩm
- Order Service: Quản lý đơn hàng
- Customer Service: Quản lý thông tin khách hàng
- API Gateway: Điểm truy cập duy nhất cho client
- Eureka Server: Dịch vụ đăng ký và khám phá service

## Sơ đồ gọi giữa các services

![image](https://github.com/user-attachments/assets/b71e2c61-2737-40b1-9777-59c7c4112d49)


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
