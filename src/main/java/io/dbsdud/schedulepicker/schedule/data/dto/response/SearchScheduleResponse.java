package io.dbsdud.schedulepicker.schedule.data.dto.response;

import io.dbsdud.schedulepicker.schedule.data.entity.Schedule;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchScheduleResponse {

    private String customerName;
    private String customerTel;
    private String customerAddress;
    private String productType;
    private String scheduleDateTime;
    private String scheduleStatus;

    public SearchScheduleResponse(Schedule schedule) {

        String date = String.valueOf(schedule.getDateTime()).split("T")[0];
        String time = String.valueOf(schedule.getDateTime()).split("T")[1];
        String address1 = schedule.getHaveProduct().getCustomer().getAddress().getAddress1();
        String address2 = schedule.getHaveProduct().getCustomer().getAddress().getAddress2();

        this.customerName = schedule.getHaveProduct().getCustomer().getName();
        this.customerTel = schedule.getHaveProduct().getCustomer().getTel();
        this.customerAddress = address1 + ", " + address2;
        this.productType = schedule.getHaveProduct().getProduct().getType().getType1Value();
//        this.customerName = schedule.getCustomer().getName();
//        this.customerTel = schedule.getCustomer().getTel();
//        this.customerAddress = schedule.getCustomer().getAddress().getAddress1() + ", " + schedule.getCustomer().getAddress().getAddress2();
//        this.productType = schedule.getProduct().getType().getType1Value();
        this.scheduleDateTime = date + " " + time;
        this.scheduleStatus = schedule.getStatus().getStatus1value();
    }
}
