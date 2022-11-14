package io.dbsdud.schedulepicker.schedule.data.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @Param coordinateId 코디ID
 * @Param customerId 고객ID
 * @Param productId 상품ID
 * @Param dateTime 방문일
 * */
@Getter
@Setter
public class RegisterScheduleRequest {

    private long coordinateId;
    private long customerId;
    private long productId;
    private String date;
    private String time;

}
