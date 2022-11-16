package io.dbsdud.schedulepicker.customer.data.repository;

import io.dbsdud.schedulepicker.customer.data.entity.HaveProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HaveProductRepository extends JpaRepository<HaveProduct, Long> {

    HaveProduct findHaveProductByCustomer_CustomerIdAndProduct_ProductId(long customerId, long productId);
}
