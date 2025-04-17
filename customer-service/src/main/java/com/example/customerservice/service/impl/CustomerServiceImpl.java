package com.example.customerservice.service.impl;

import com.example.customerservice.model.Customer;
import com.example.customerservice.repository.CustomerRepository;
import com.example.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    
    private final CustomerRepository customerRepository;
    
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    
    @Override
    public Optional<Customer> getCustomerById(String id) {
        return customerRepository.findById(id);
    }
    
    @Override
    public Optional<Customer> getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
    
    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    
    @Override
    public Customer updateCustomer(String id, Customer customer) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        if (existingCustomer.isPresent()) {
            Customer updatedCustomer = existingCustomer.get();
            updatedCustomer.setName(customer.getName());
            updatedCustomer.setEmail(customer.getEmail());
            updatedCustomer.setPhone(customer.getPhone());
            updatedCustomer.setAddress(customer.getAddress());
            return customerRepository.save(updatedCustomer);
        }
        return null;
    }
    
    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }
}
