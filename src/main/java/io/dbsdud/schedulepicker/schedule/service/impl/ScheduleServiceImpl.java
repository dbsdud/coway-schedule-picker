package io.dbsdud.schedulepicker.schedule.service.impl;

import io.dbsdud.schedulepicker.coordinate.data.entity.Coordinate;
import io.dbsdud.schedulepicker.coordinate.data.repository.CoordinateRepository;
import io.dbsdud.schedulepicker.customer.data.entity.Customer;
import io.dbsdud.schedulepicker.customer.data.repository.CustomerRepository;
import io.dbsdud.schedulepicker.product.data.entity.Product;
import io.dbsdud.schedulepicker.product.data.repository.ProductRepository;
import io.dbsdud.schedulepicker.schedule.data.dto.request.RegisterScheduleRequest;
import io.dbsdud.schedulepicker.schedule.data.dto.request.UpdateScheduleRequest;
import io.dbsdud.schedulepicker.schedule.data.dto.response.ScheduleResponse;
import io.dbsdud.schedulepicker.schedule.data.entity.Schedule;
import io.dbsdud.schedulepicker.schedule.data.repository.ScheduleRepository;
import io.dbsdud.schedulepicker.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final CoordinateRepository coordinateRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public Page<Schedule> findAll(Pageable pageable) {
        return scheduleRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Page<Schedule> findAllByCoordinateIdAndDateTimeBetween(long coordinateId, String year, String month, Pageable pageable) {
        String firstDateTimeStr = year + "-" + month + "-01" + " 00:00";
        LocalDateTime firstDateTime = LocalDateTime.parse(firstDateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(year), Integer.parseInt(month) - 1, 1);
        String lastDateTimeStr = year + "-" + month + "-" + cal.getActualMaximum(Calendar.DAY_OF_MONTH) + " 23:59";
        LocalDateTime lastDateTime = LocalDateTime.parse(lastDateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        return scheduleRepository.findAllByCoordinate_CoordinateIdAndDateTimeBetween(coordinateId, firstDateTime, lastDateTime, pageable);
    }

    @Transactional(readOnly = true)
    public Page<Schedule> findAllByCoordinateIdAndDateTimeGreaterThanEqual(long coordinateId, Pageable pageable) {
        String nowStr = String.valueOf(LocalDateTime.now());
        String dateStr = nowStr.split("T")[0];
        String timeStr = nowStr.split("T")[1].substring(0, 8);

        nowStr = dateStr + " " + timeStr;

        LocalDateTime now = LocalDateTime.parse(nowStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        return scheduleRepository.findAllByCoordinate_CoordinateIdAndDateTimeGreaterThanEqual(coordinateId, now, pageable);
    }

    @Transactional(readOnly = true)
    public Optional<Schedule> findAllByCoordinateIdAndDateTime(long coordinateId, String year, String month, String day) {
        String startDateTimeStr = year + "-" + month + "-" + day + " 00:00";
        LocalDateTime startDateTime = LocalDateTime.parse(startDateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        String endDateTimeStr = year + "-" + month + "-" + day + " 23:59";
        LocalDateTime endDateTime = LocalDateTime.parse(endDateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        return scheduleRepository.findAllByCoordinate_CoordinateIdAndDateTimeBetween(coordinateId, startDateTime, endDateTime);
    }

    @Transactional(readOnly = true)
    public Page<Schedule> findAllByCoordinateIdAndDateTimeLessThan(long coordinateId, Pageable pageable) {
        String nowStr = String.valueOf(LocalDateTime.now());
        String dateStr = nowStr.split("T")[0];
        String timeStr = nowStr.split("T")[1].substring(0, 6);

        nowStr = dateStr + " " + timeStr;
        LocalDateTime now = LocalDateTime.parse(nowStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:"));

        return scheduleRepository.findAllByCoordinate_CoordinateIdAndDateTimeLessThan(coordinateId, now, pageable);
    }


    public ScheduleResponse createSchedule(RegisterScheduleRequest req) {
        String dateTimeStr = req.getDate() + " " + req.getTime();
        Coordinate coordinate = coordinateRepository.getReferenceById(req.getCoordinateId());
        Customer customer = customerRepository.getReferenceById(req.getCustomerId());
        Product product = productRepository.getReferenceById(req.getProductId());

        return new ScheduleResponse(scheduleRepository.save(Schedule.create(dateTimeStr, coordinate, customer, product)));
    }

    @Transactional(readOnly = true)
    public Schedule findById(long scheduleId) {
        final Optional<Schedule> schedule = scheduleRepository.findById(scheduleId);
        return schedule.get();
    }

    public ScheduleResponse updateSchedule(UpdateScheduleRequest req) {
        Schedule schedule = findById(req.getCoordinateId());
        schedule.update(req);
        return new ScheduleResponse(scheduleRepository.getReferenceById(req.getScheduleId()));
    }
}
