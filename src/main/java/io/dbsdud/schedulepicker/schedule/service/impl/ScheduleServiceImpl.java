package io.dbsdud.schedulepicker.schedule.service.impl;

import io.dbsdud.schedulepicker.coordinate.data.entity.Coordinate;
import io.dbsdud.schedulepicker.coordinate.data.repository.CoordinateRepository;
import io.dbsdud.schedulepicker.customer.data.entity.Customer;
import io.dbsdud.schedulepicker.customer.data.repository.CustomerRepository;
import io.dbsdud.schedulepicker.product.data.entity.Product;
import io.dbsdud.schedulepicker.product.data.repository.ProductRepository;
import io.dbsdud.schedulepicker.proxy.NotificationProxy;
import io.dbsdud.schedulepicker.proxy.request.MailRequest;
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

import java.time.LocalDateTime;
import java.time.YearMonth;
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

    private final NotificationProxy notificationProxy;

    @Transactional(readOnly = true)
    public Page<Schedule> findAllByCoordinateIdAndDateTimeBetween(long coordinateId, int year, int month, Pageable pageable) {

        LocalDateTime firstDateTime = LocalDateTime.of(year, month, 1, 0, 0);
        int lastDateOfDay = Integer.parseInt(String.valueOf(YearMonth.of(year, month).atEndOfMonth().getDayOfMonth()));
        LocalDateTime lastDateTime = LocalDateTime.of(year, month, lastDateOfDay, 23, 59);

        return scheduleRepository.findAllByCoordinate_CoordinateIdAndDateTimeBetween(coordinateId, firstDateTime, lastDateTime, pageable);
    }

    @Transactional(readOnly = true)
    public Page<Schedule> findAllByCoordinateIdAndDateTimeGreaterThanEqual(long coordinateId, Pageable pageable) {

        LocalDateTime now = LocalDateTime.now();

        return scheduleRepository.findAllByCoordinate_CoordinateIdAndDateTimeGreaterThanEqual(coordinateId, now, pageable);
    }

    @Transactional(readOnly = true)
    public Optional<Schedule> findAllByCoordinateIdAndDateTime(long coordinateId, int year, int month, int day) {

        LocalDateTime startDateTime = LocalDateTime.of(year, month, day, 0, 0);
        LocalDateTime endDateTime = LocalDateTime.of(year, month, day, 23, 59);

        return scheduleRepository.findAllByCoordinate_CoordinateIdAndDateTimeBetween(coordinateId, startDateTime, endDateTime);
    }

    @Transactional(readOnly = true)
    public Page<Schedule> findAllByCoordinateIdAndDateTimeLessThan(long coordinateId, Pageable pageable) {

        LocalDateTime now = LocalDateTime.now();

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

//    @Transactional(readOnly = true)
//    public Page<Schedule> findAll(Pageable pageable) {
//        return scheduleRepository.findAll(pageable);
//    }

}
