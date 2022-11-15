package io.dbsdud.schedulepicker.schedule.data.entity;

import lombok.Getter;

@Getter
public enum ScheduleStatus {

    SEND_REQUEST("요청전송") { // 방문일정 전송됨
        @Override
        public String toString() {
            return "SEND_REQUEST";
        }
    },
    VERIFIED("요청승인") { // 방문일정 승인됨
        @Override
        public String toString() {
            return "VERIFIED";
        }
    },
    WAITING_CALL("통화요청") { // 방문일정 거절 및 통화 요청
        @Override
        public String toString() {
            return "WAITING_CALL";
        }
    }, // TODO: 통화요청상태 지우기
    END("종료") { // 스케쥴 종료
        @Override
        public String toString() {
            return "END";
        }
    };

    private final String status1value;

    ScheduleStatus(String status1value) {
        this.status1value = status1value;
    }

}
