package io.dbsdud.schedulepicker.schedule.data.dto.response;

import io.dbsdud.schedulepicker.product.data.entity.ProductType;
import io.dbsdud.schedulepicker.schedule.data.entity.Schedule;
import io.dbsdud.schedulepicker.schedule.data.entity.ScheduleStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ScheduleResponse {

    private long scheduleId;
    private ScheduleStatus status;
    private LocalDateTime dateTime;
    private long coordinateId;
    private long customerId;
    private ProductType productType;

    public ScheduleResponse(Schedule schedule) {
        this.scheduleId = schedule.getScheduleId();
        this.status = schedule.getStatus();
        this.dateTime = schedule.getDateTime();
        this.coordinateId = schedule.getCoordinate().getCoordinateId();
        this.customerId = schedule.getCustomer().getCustomerId();
        this.productType = schedule.getProduct().getType();
    }
}
