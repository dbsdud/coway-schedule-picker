package io.dbsdud.schedulepicker.schedule.data.entity;

public enum ScheduleStatus {

    SEND_REQUEST { // 방문일정 전송됨
        @Override
        public String toString() {
            return "SEND_REQUEST";
        }
    },
    VERIFIED { // 방문일정 승인됨
        @Override
        public String toString() {
            return "VERIFIED";
        }
    },
    WAITING_CALL { // 방문일정 거절 및 통화 요청
        @Override
        public String toString() {
            return "WAITING_CALL";
        }
    }, // TODO: 통화요청상태 지우기
    END { // 스케쥴 종료
        @Override
        public String toString() {
            return "END";
        }
    }
}
