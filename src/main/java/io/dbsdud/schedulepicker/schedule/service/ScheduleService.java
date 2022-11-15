package io.dbsdud.schedulepicker.schedule.service;

import io.dbsdud.schedulepicker.schedule.data.dto.request.RegisterScheduleRequest;
import io.dbsdud.schedulepicker.schedule.data.dto.request.UpdateScheduleRequest;
import io.dbsdud.schedulepicker.schedule.data.dto.response.ScheduleResponse;
import io.dbsdud.schedulepicker.schedule.data.entity.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ScheduleService {

    Page<Schedule> findAllByCoordinateIdAndDateTimeBetween(long coordinateId, int year, int month, Pageable pageable);
    Page<Schedule> findAllByCoordinateIdAndDateTimeGreaterThanEqual(long coordinateId, Pageable pageable);
    Optional<Schedule> findAllByCoordinateIdAndDateTime(long coordinateId, int year, int month, int day);
    Schedule findById(long scheduleId);
    Page<Schedule> findAllByCoordinateIdAndDateTimeLessThan(long coordinateId, Pageable pageable);
    ScheduleResponse createSchedule(RegisterScheduleRequest req);
    ScheduleResponse updateSchedule(UpdateScheduleRequest req);

//    Page<Schedule> findAll(Pageable pageable);

}
