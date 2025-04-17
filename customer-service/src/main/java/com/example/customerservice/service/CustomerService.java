package com.example.customerservice.service;

import com.example.customerservice.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Optional<Customer> getCustomerById(String id);
    Optional<Customer> getCustomerByEmail(String email);
    Customer createCustomer(Customer customer);
    Customer updateCustomer(String id, Customer customer);
    void deleteCustomer(String id);
}
