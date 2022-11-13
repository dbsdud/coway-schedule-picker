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
    public Page<Schedule> findAllByCoordinateId(long coordinateId, Pageable pageable) {
        return scheduleRepository.findAllByCoordinate_CoordinateId(coordinateId, pageable);
    }

    public ScheduleResponse createSchedule(RegisterScheduleRequest req) {
        Coordinate coordinate = coordinateRepository.getReferenceById(req.getCoordinateId());
        Customer customer = customerRepository.getReferenceById(req.getCustomerId());
        Product product = productRepository.getReferenceById(req.getProductId());

        return new ScheduleResponse(scheduleRepository.save(Schedule.create(req.getDateTime(), coordinate, customer, product)));
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
