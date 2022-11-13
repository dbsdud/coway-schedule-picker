package io.dbsdud.schedulepicker.schedule.service;

import io.dbsdud.schedulepicker.schedule.data.dto.request.RegisterScheduleRequest;
import io.dbsdud.schedulepicker.schedule.data.dto.request.UpdateScheduleRequest;
import io.dbsdud.schedulepicker.schedule.data.dto.response.ScheduleResponse;
import io.dbsdud.schedulepicker.schedule.data.entity.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ScheduleService {

    Page<Schedule> findAll(Pageable pageable);
    Page<Schedule> findAllByCoordinateId(long coordinateId, Pageable pageable);
    ScheduleResponse createSchedule(RegisterScheduleRequest req);
    ScheduleResponse updateSchedule(UpdateScheduleRequest req);

}
