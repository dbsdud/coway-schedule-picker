package io.dbsdud.schedulepicker.schedule.data.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;

@Getter
@Setter
public class SearchScheduleRequest {

    @Valid
    private long coordinateId;
    @Valid
    private ScheduleSearchType searchType;
    @Valid
    private String value;
    private Integer year;
    private Integer month;
    private Integer day;
    private Integer hour;
    private Integer minute;

}
