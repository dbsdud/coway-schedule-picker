package io.dbsdud.schedulepicker.schedule.controller;

import io.dbsdud.schedulepicker.common.util.PageRequest;
import io.dbsdud.schedulepicker.schedule.data.dto.request.RegisterScheduleRequest;
import io.dbsdud.schedulepicker.schedule.data.dto.request.UpdateScheduleRequest;
import io.dbsdud.schedulepicker.schedule.data.dto.response.ScheduleResponse;
import io.dbsdud.schedulepicker.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/${spring.application.name}/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping
    public ResponseEntity<Page<ScheduleResponse>> getAllSchedules(final PageRequest pageRequest) {
        Page<ScheduleResponse> scheduleResponses = scheduleService.findAll(pageRequest.of()).map(ScheduleResponse::new);
        return ResponseEntity.status(HttpStatus.OK).body(scheduleResponses);
    }

    @GetMapping("/find")
    public ResponseEntity<Page<ScheduleResponse>> getAllSchedulesByCoordinateId(
            @RequestParam(name = "coordinate") final long coordinateId,
            final PageRequest pageRequest
    ) {
        Page<ScheduleResponse> scheduleResponses = scheduleService.findAllByCoordinateId(coordinateId, pageRequest.of()).map(ScheduleResponse::new);
        return ResponseEntity.status(HttpStatus.OK).body(scheduleResponses);
    }

    @PostMapping
    public ResponseEntity<ScheduleResponse> registerSchedule(@RequestBody @Valid RegisterScheduleRequest req) {
        ScheduleResponse scheduleResponse = scheduleService.createSchedule(req);
        return ResponseEntity.status(HttpStatus.OK).body(scheduleResponse);
    }

    @PutMapping
    public ResponseEntity<ScheduleResponse> updateSchedule(@RequestBody @Valid UpdateScheduleRequest req) {
        ScheduleResponse scheduleResponse = scheduleService.updateSchedule(req);
        return ResponseEntity.status(HttpStatus.OK).body(scheduleResponse);
    }
}
