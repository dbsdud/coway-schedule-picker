package io.dbsdud.schedulepicker.schedule.data.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SearchScheduleRequest {

    @NotNull
    private ScheduleSearchType searchType;
    @NotNull
    private String value;
    @Nullable
    private int year;
    @Nullable
    private int month;
    @Nullable
    private int day;
    @Nullable
    private int hour;
    @Nullable
    private int minute;

}
