package com.example.customerservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "customers")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    private String id;
    
    private String name;
    private String email;
    private String phone;
    private String address;
}
