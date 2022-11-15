package io.dbsdud.schedulepicker.schedule.controller;

import io.dbsdud.schedulepicker.common.util.PageRequest;
import io.dbsdud.schedulepicker.schedule.data.dto.request.ScheduleSearchType;
import io.dbsdud.schedulepicker.schedule.data.dto.response.SearchScheduleResponse;
import io.dbsdud.schedulepicker.schedule.service.impl.ScheduleSearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/${spring.application.name}/schedule/search")
public class ScheduleSearchController {

    private final ScheduleSearchService scheduleSearchService;

    @GetMapping
    public ResponseEntity<Page<SearchScheduleResponse>> searchSchedule(
            @RequestParam(name = "type") @Valid final ScheduleSearchType type,
            @RequestParam(name = "value") @Valid final String value,
            @RequestParam(name = "year", required = false) final Integer year,
            @RequestParam(name = "month", required = false) final Integer month,
            @RequestParam(name = "day", required = false) final Integer day,
            @RequestParam(name = "hour", required = false) final Integer hour,
            @RequestParam(name = "minute", required = false) final Integer minute,
            final PageRequest pageRequest
    ) {
        Page<SearchScheduleResponse> searchScheduleResponses = scheduleSearchService.search(type, value, year, month, day, hour, minute, pageRequest.of()).map(SearchScheduleResponse::new);

        return ResponseEntity.status(HttpStatus.OK).body(searchScheduleResponses);
    }

}
