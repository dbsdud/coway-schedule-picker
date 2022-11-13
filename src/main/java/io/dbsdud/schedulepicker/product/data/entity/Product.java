package io.dbsdud.schedulepicker.product.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.dbsdud.schedulepicker.common.model.BaseTimeEntity;
import io.dbsdud.schedulepicker.coordinate.data.entity.Coordinate;
import io.dbsdud.schedulepicker.customer.data.entity.Customer;
import io.dbsdud.schedulepicker.schedule.data.entity.Schedule;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    @Enumerated(value = EnumType.STRING)
    private ProductType type;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coordinateId")
    private Coordinate coordinate;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Schedule> schedules;

    @Builder
    public Product(long productId,
                   ProductType type,
                   Coordinate coordinate,
                   Customer customer,
                   List<Schedule> schedules) {
        this.productId = productId;
        this.type = type;
        this.coordinate = coordinate;
        this.customer = customer;
        this.schedules = schedules;
    }

}
