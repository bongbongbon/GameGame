package com.project.gamegame.common.exception;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER_NOT_FOUND", "존재하지 않는 유저입니다."),
    VALIDATION_FAILED(HttpStatus.BAD_REQUEST, "VALIDATION_FAILED", "입력값 유효성 검사에 실패하였습니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.BAD_REQUEST, "INTERNAL_SERVER_ERROR", "예상치 못한 서버 에러가 발생했습니다."),
    SUBJECTIVE_QUESTION_NOT_FOUND(HttpStatus.NOT_FOUND, "USER_NOT_FOUND", "존재하지 않는 주관식문제입니다."),
    OBJECTIVE_QUESTION_NOT_FOUND(HttpStatus.NOT_FOUND, "USER_NOT_FOUND", "존재하지 않는 객관식문제입니다.");




    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
