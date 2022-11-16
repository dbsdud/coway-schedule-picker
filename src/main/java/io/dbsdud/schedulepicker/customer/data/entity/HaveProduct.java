package io.dbsdud.schedulepicker.customer.data.entity;

import io.dbsdud.schedulepicker.common.model.BaseTimeEntity;
import io.dbsdud.schedulepicker.product.data.entity.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class HaveProduct extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long haveProductId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    private Product product;

    @Builder
    public HaveProduct(long haveProductId,
                       Customer customer,
                       Product product
    ) {
        this.haveProductId = haveProductId;
        this.customer = customer;
        this.product = product;
    }
}
