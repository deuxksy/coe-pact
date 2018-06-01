package org.coe.customer.service;

import org.coe.customer.domain.Customer;
import org.coe.customer.message.Sender;
import org.coe.customer.repository.CustomerRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Lazy
@Service
public class CustomerService {

    CustomerRepository customerRepository;
    Sender sender;

    public CustomerService(CustomerRepository customerRepository, Sender sender) {
        this.customerRepository = customerRepository;
        this.sender = sender;
    }

    public Customer register(Customer customer) {
        Optional<Customer> existingCustomer = customerRepository.findByName(customer.getName());
        if (existingCustomer.isPresent()) {
            throw new RuntimeException("is already exists");
        } else {
            customerRepository.save(customer);
            sender.send(customer.getEmail());
        }
        return customer;
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Customer get(Integer id) {
        return customerRepository.findOne(id);
    }
}