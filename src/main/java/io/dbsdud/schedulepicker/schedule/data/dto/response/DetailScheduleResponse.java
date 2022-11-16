package io.dbsdud.schedulepicker.schedule.data.dto.response;

import io.dbsdud.schedulepicker.schedule.data.entity.Schedule;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetailScheduleResponse {

    private String dateTime;
    private String customerName;
    private String address;
    private String productType;

    public DetailScheduleResponse(Schedule schedule) {
        String date = String.valueOf(schedule.getDateTime()).split("T")[0];
        String time = String.valueOf(schedule.getDateTime()).split("T")[1];
        String address1 = schedule.getHaveProduct().getCustomer().getAddress().getAddress1();
        String address2 = schedule.getHaveProduct().getCustomer().getAddress().getAddress2();

        this.dateTime = date + " " + time;
        this.customerName = schedule.getHaveProduct().getCustomer().getName();
        this.address = address1 + " " + address2;
        this.productType = schedule.getHaveProduct().getProduct().getType().getType1Value();
//        this.customerName = schedule.getCustomer().getName();
//        this.address = schedule.getCustomer().getAddress().getAddress1() + ", " + schedule.getCustomer().getAddress().getAddress2();
//        this.productType = schedule.getProduct().getType().getType1Value();
    }

}
