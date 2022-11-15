package io.dbsdud.schedulepicker.schedule.data.dto.request;

import lombok.Getter;

@Getter
public enum ScheduleSearchType {

    CUSTOMER_NAME("고객성함"),
    CUSTOMER_ADDRESS("고객주소"),
    CUSTOMER_TEL("고객연락처"),
    PRODUCT_TYPE("상품타입"),
    SCHEDULE_DATE("일정날짜"),
    SCHEDULE_DATETIME("일정일시"),
    SCHEDULE_STATUS("일정상태");

    private final String search1value;

    ScheduleSearchType(String search1value) {
        this.search1value = search1value;
    }

}
