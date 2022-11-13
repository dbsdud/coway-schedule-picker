package io.dbsdud.schedulepicker.schedule.data.repository;

import io.dbsdud.schedulepicker.schedule.data.entity.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Page<Schedule> findAllByCoordinate_CoordinateId(long coordinateId, Pageable pageable);
}
