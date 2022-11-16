package io.dbsdud.schedulepicker.schedule.data.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.dbsdud.schedulepicker.common.model.BaseTimeEntity;
import io.dbsdud.schedulepicker.coordinate.data.entity.Coordinate;
import io.dbsdud.schedulepicker.customer.data.entity.HaveProduct;
import io.dbsdud.schedulepicker.schedule.data.dto.request.UpdateScheduleRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@NoArgsConstructor
public class Schedule extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long scheduleId;
    @Enumerated(value = EnumType.STRING)
    private ScheduleStatus status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dateTime;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coordinateId")
    private Coordinate coordinate;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "haveProductId")
    private HaveProduct haveProduct;

//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "customerId")
//    private Customer customer;
//
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "productId")
//    private Product product;

    @Builder
    public Schedule(long scheduleId,
                    ScheduleStatus status,
                    LocalDateTime dateTime,
                    Coordinate coordinate,
                    HaveProduct haveProduct
//                    Customer customer,
//                    Product product
    ) {
        this.scheduleId = scheduleId;
        this.status = status;
        this.dateTime = dateTime;
        this.coordinate = coordinate;
        this.haveProduct = haveProduct;
//        this.coordinate = coordinate;
//        this.customer = customer;
//        this.product = product;
    }

    public static Schedule create(String dateTimeStr,
                            Coordinate coordinate,
                            HaveProduct haveProduct
//                           Customer customer,
//                           Product product
    ) {
        return Schedule.builder()
                .status(ScheduleStatus.SEND_REQUEST)
                .dateTime(LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                .coordinate(coordinate)
                .haveProduct(haveProduct)
//                .customer(customer)
//                .product(product)
                .build();
    }

    public void update(UpdateScheduleRequest req) {
        this.status = ScheduleStatus.VERIFIED;
        this.dateTime = req.getDateTime();
    }

}
