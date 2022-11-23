package io.dbsdud.schedulepicker.customer.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.dbsdud.schedulepicker.common.model.BaseTimeEntity;
import io.dbsdud.schedulepicker.coordinate.data.entity.Coordinate;
import io.dbsdud.schedulepicker.product.data.entity.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Customer extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;
    private String name;
    private String tel;
    @Embedded
    private Address address;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coordinateId")
    private Coordinate coordinate;

//    @JsonIgnore
//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//    private List<Product> products;

    @Builder
    public Customer(long customerId, String name, String tel, Address address, Coordinate coordinate
//                    List<Product> products
    ) {
        this.customerId = customerId;
        this.name = name;
        this.tel = tel;
        this.address = address;
        this.coordinate = coordinate;
//        this.products = products;
    }
}
