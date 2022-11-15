package io.dbsdud.schedulepicker.schedule.controller;

import io.dbsdud.schedulepicker.common.util.PageRequest;
import io.dbsdud.schedulepicker.schedule.data.dto.request.RegisterScheduleRequest;
import io.dbsdud.schedulepicker.schedule.data.dto.request.UpdateScheduleRequest;
import io.dbsdud.schedulepicker.schedule.data.dto.response.DetailScheduleResponse;
import io.dbsdud.schedulepicker.schedule.data.dto.response.ScheduleResponse;
import io.dbsdud.schedulepicker.schedule.data.entity.Schedule;
import io.dbsdud.schedulepicker.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/${spring.application.name}/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    /*
     * 1. 특정 판매인의 월 단위 스케쥴 목록을 가져온다.
     * */
    @GetMapping("/find")
    public ResponseEntity<Page<ScheduleResponse>> getAllSchedulesByCoordinateIdAndDateTimeBetween (
            @RequestParam(name = "coordinate") final long coordinateId,
            @RequestParam(name = "year") final int year,
            @RequestParam(name = "month") final int month,
            final PageRequest pageRequest
    ) {
        Page<ScheduleResponse> scheduleResponses = scheduleService.findAllByCoordinateIdAndDateTimeBetween(coordinateId, year, month, pageRequest.of()).map(ScheduleResponse::new);

        return ResponseEntity.status(HttpStatus.OK).body(scheduleResponses);
    }

    /*
     * 2. 현재 시간 이후의 전체 일정을 가져온다. (GreaterThanEqual)
     * */
    @GetMapping("/find/afterNow")
    public ResponseEntity<Page<ScheduleResponse>> getAllSchedulesByCoordinateIdAndDateTimeGreaterThanEqual (
            @RequestParam(name = "coordinate") final long coordinateId,
            final PageRequest pageRequest
    ) {
        Page<ScheduleResponse> scheduleResponses = scheduleService.findAllByCoordinateIdAndDateTimeGreaterThanEqual(coordinateId, pageRequest.of()).map(ScheduleResponse::new);

        return ResponseEntity.status(HttpStatus.OK).body(scheduleResponses);
    }

    /*
     * 3. 특정 날짜의 스케쥴 목록을 가져온다. (findByDateTime)
     * */
    @GetMapping("/find/date")
    public ResponseEntity<Optional<ScheduleResponse>> getSchedulesByCoordinateIdAndDateTime (
            @RequestParam(name = "coordinate") final long coordinateId,
            @RequestParam(name = "year") final int year,
            @RequestParam(name = "month") final int month,
            @RequestParam(name = "day") final int day
    ) {
        Optional<ScheduleResponse> scheduleResponses = scheduleService.findAllByCoordinateIdAndDateTime(coordinateId, year, month, day).map(ScheduleResponse::new);

        return ResponseEntity.status(HttpStatus.OK).body(scheduleResponses);
    }

    /*
     * 4. 특정 일정의 상세정보를 가져온다. (findById)
     * */
    @GetMapping("/find/detail/{scheduleId}")
    public ResponseEntity<DetailScheduleResponse> getDetail(@PathVariable @Valid long scheduleId) {

        DetailScheduleResponse scheduleResponse = new DetailScheduleResponse(scheduleService.findById(scheduleId));

        return ResponseEntity.status(HttpStatus.OK).body(scheduleResponse);
    }

    /*
     * 5. 오늘 날짜 이전의 스케쥴 목록을 가져온다. (Before)
     * */
    @GetMapping("/find/beforeNow")
    public ResponseEntity<Page<ScheduleResponse>> getAllByCoordinateAndDateTimeBefore(
            @RequestParam(name = "coordinate") final long coordinateId,
            final PageRequest pageRequest
    ) {
        Page<ScheduleResponse> scheduleResponses = scheduleService.findAllByCoordinateIdAndDateTimeLessThan(coordinateId, pageRequest.of()).map(ScheduleResponse::new);

        return ResponseEntity.status(HttpStatus.OK).body(scheduleResponses);
    }

    /*
     * 6. 특정 일시에 일정을 저장한다.
     * */
    @PostMapping("/register")
    public ResponseEntity<ScheduleResponse> registerSchedule(@RequestBody @Valid RegisterScheduleRequest req) {

        ScheduleResponse scheduleResponse = scheduleService.createSchedule(req);

        return ResponseEntity.status(HttpStatus.OK).body(scheduleResponse);
    }

    /*
     * 7. 특정 일시의 일정을 수정한다.
     * */
    @PutMapping("/update")
    public ResponseEntity<ScheduleResponse> updateSchedule(@RequestBody @Valid UpdateScheduleRequest req) {

        ScheduleResponse scheduleResponse = scheduleService.updateSchedule(req);

        return ResponseEntity.status(HttpStatus.OK).body(scheduleResponse);
    }

//    @GetMapping
//    public ResponseEntity<Page<ScheduleResponse>> getAllSchedules(final PageRequest pageRequest) {
//
//        Page<ScheduleResponse> scheduleResponses = scheduleService.findAll(pageRequest.of()).map(ScheduleResponse::new);
//
//        return ResponseEntity.status(HttpStatus.OK).body(scheduleResponses);
//    }
}
