package io.dbsdud.schedulepicker.schedule.data.dto.response;

import io.dbsdud.schedulepicker.schedule.data.entity.Schedule;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleResponse {

    private long scheduleId;
    private String status;
    private String dateTime;
    private long coordinateId;
    private long customerId;
    private String productType;

    public ScheduleResponse(Schedule schedule) {

        String date = String.valueOf(schedule.getDateTime()).split("T")[0];
        String time = String.valueOf(schedule.getDateTime()).split("T")[1];

        this.scheduleId = schedule.getScheduleId();
        this.status = schedule.getStatus().getStatus1value();
        this.dateTime = date + " " + time;
        this.coordinateId = schedule.getCoordinate().getCoordinateId();
        this.customerId = schedule.getHaveProduct().getCustomer().getCustomerId();
        this.productType = schedule.getHaveProduct().getProduct().getType().getType1Value();
//        this.customerId = schedule.getCustomer().getCustomerId();
//        this.productType = schedule.getProduct().getType().getType1Value();
    }

}
