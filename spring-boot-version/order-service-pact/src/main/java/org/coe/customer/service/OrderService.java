package org.coe.customer.service;

import org.coe.customer.api.CustomerClient;
import org.coe.customer.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private CustomerClient customerClient;

    public OrderService(CustomerClient customerClient) {
        this.customerClient = customerClient;
    }

    public List<Customer> getAllCustomer() {
        return customerClient.findAll();
    }
}
