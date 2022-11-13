package io.dbsdud.schedulepicker.product.data.repository;

import io.dbsdud.schedulepicker.product.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
