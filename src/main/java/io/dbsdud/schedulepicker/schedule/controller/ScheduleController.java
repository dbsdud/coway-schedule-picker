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

    /*
     * TODO: 1. 월 단위 스케쥴 목록을 가져온다.
     * */

    /*
     * TODO: 2. 현재 시간 이후의 전체 일정을 가져온다.
     * */

    /*
     * TODO: 3. 특정 날짜의 스케쥴 목록을 가져온다.
     * */

    /*
     * TODO: 4. 특정 일정의 상세정보를 가져온다.
     * */

    /*
     * TODO: 5. 특정 날짜 이전의 스케쥴 목록을 가져온다.
     * */

    /*
     * TODO: 6. 오늘 날짜 + 3개월 후의 스케쥴 목록을 가져온다.
     * */

    /*
     * TODO: 7. 특정 일시에 일정을 저장한다.
     * */

    /*
     * TODO: 8. 특정 일시의 일정을 수정한다.
     * */

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
