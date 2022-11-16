package io.dbsdud.schedulepicker.coordinate.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.dbsdud.schedulepicker.common.model.BaseTimeEntity;
import io.dbsdud.schedulepicker.customer.data.entity.Customer;
import io.dbsdud.schedulepicker.product.data.entity.Product;
import io.dbsdud.schedulepicker.schedule.data.entity.Schedule;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Coordinate extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long coordinateId;
    private String name;
    private String tel;

//    @JsonIgnore
//    @OneToMany(mappedBy = "coordinate", cascade = CascadeType.ALL)
//    private List<Schedule> schedules;
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "coordinate", cascade = CascadeType.ALL)
//    private List<Customer> customers;
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "coordinate", cascade = CascadeType.ALL)
//    private List<Product> products;

    @Builder
    public Coordinate(long coordinateId,
                      String name,
                      String tel
//                      List<Schedule> schedules,
//                      List<Customer> customers,
//                      List<Product> products
    ) {
        this.coordinateId = coordinateId;
        this.name = name;
        this.tel = tel;
//        this.schedules = schedules;
//        this.customers = customers;
//        this.products = products;
    }

}
