package io.dbsdud.schedulepicker.schedule.exception;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleNotFoundException extends RuntimeException {

    private long scheduleId;
    private LocalDateTime dateTime;

    public ScheduleNotFoundException(long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public ScheduleNotFoundException(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
