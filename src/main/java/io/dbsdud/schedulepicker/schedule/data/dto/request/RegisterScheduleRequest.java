package io.dbsdud.schedulepicker.schedule.data.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterScheduleRequest {

    private long coordinateId;
    private long customerId;
    private long productId;
    private String date;
    private String time;
    private String mail;

}
