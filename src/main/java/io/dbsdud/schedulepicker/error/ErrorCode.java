package io.dbsdud.schedulepicker.error;

import lombok.Getter;

@Getter
public enum ErrorCode {

    INPUT_VALUE_INVALID("ERR_001", "입력값이 올바르지 않습니다.", 400),
    SCHEDULE_NOT_FOUND("ERR_S001", "해당 스케줄을 찾을 수 없습니다.", 404);

    private final String code;
    private final String message;
    private final int status;

    ErrorCode(String code, String message, int status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }
}
