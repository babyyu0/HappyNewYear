package com.prp.business.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@RequiredArgsConstructor
public enum ErrorMessage {
    BUSINESS_NOT_FOUND(BAD_REQUEST, "해당 업무가 존재하지 않습니다."),
    BUSINESS_INVALID(INTERNAL_SERVER_ERROR, "해당 업무가 유효하지 않습니다."),
    WRITER_INVALID(INTERNAL_SERVER_ERROR, "해당 업무의 작성자가 유효하지 않습니다."),
    TITLE_INVALID(INTERNAL_SERVER_ERROR, "해당 업무의 제목이 유효하지 않습니다."),
    CONTENTS_INVALID(INTERNAL_SERVER_ERROR, "해당 업무의 내용이 유효하지 않습니다."),
    DATA_SAVE_FAILED(INTERNAL_SERVER_ERROR, "데이터 저장에 실패했습니다.");

    private final HttpStatus status;
    private final String message;
}