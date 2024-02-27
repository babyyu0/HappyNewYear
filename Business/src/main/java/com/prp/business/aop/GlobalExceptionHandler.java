package com.prp.business.aop;

import com.prp.business.model.dto.ErrorResponseDto;
import com.prp.business.util.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<?> handleException(DataAccessException e) {
        log.error("DataAccessException : {}", e.getMessage());
        return ResponseEntity.internalServerError()
                .body(new ErrorResponseDto(INTERNAL_SERVER_ERROR.name(), "서버 오류입니다. 상황이 지속되면 문의 게시판을 이용해 주세요."));
    }
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> handleException(BusinessException e) {
        log.error("BusinessException : {}", e.getMessage());
        String message = (e.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR)? "서버 오류입니다. 상황이 지속되면 문의 게시판을 이용해 주세요." : e.getMessage();
        return ResponseEntity.status(e.getStatus())
                .body(new ErrorResponseDto(e.getStatus().name(), message));
    }
}
