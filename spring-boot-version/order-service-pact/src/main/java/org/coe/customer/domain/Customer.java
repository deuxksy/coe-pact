package org.coe.customer.domain;

import lombok.Data;

@Data
public class Customer {
    private int customerId;
    private String name;
    private String email;
}
