package io.dbsdud.schedulepicker.customer.data.repository;

import io.dbsdud.schedulepicker.customer.data.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
