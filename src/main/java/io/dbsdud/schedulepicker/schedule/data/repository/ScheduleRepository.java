package io.dbsdud.schedulepicker.schedule.data.repository;

import io.dbsdud.schedulepicker.schedule.data.entity.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    Page<Schedule> findAllByCoordinate_CoordinateIdAndDateTimeBetween(long coordinateId, LocalDateTime firstDateTime, LocalDateTime lastDateTime, Pageable pageable);
    Page<Schedule> findAllByCoordinate_CoordinateIdAndDateTimeGreaterThanEqual(long coordinateId, LocalDateTime dateTime, Pageable pageable);
    Optional<Schedule> findAllByCoordinate_CoordinateIdAndDateTimeBetween(long coordinateId, LocalDateTime startDateTime, LocalDateTime endDateTime);
    Page<Schedule> findAllByCoordinate_CoordinateIdAndDateTimeLessThan(long coordinateId, LocalDateTime dateTime, Pageable pageable);
    Page<Schedule> findAllByCoordinate_CoordinateId(long coordinateId, Pageable pageable);

}
