package org.coe.customer.repository;

import org.coe.customer.domain.Customer;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@Lazy
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByName(@Param("name") String name);
}
