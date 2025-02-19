package com.project.gamegame.common.exception;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    //user
    EXISTS_USER_EMAIL(HttpStatus.BAD_REQUEST, "U-001", "이메일이 존재합니다."),
    NOT_EXISTS_USER_EMAIL(HttpStatus.NOT_FOUND, "U-002", "회원 이메일이 존재하지 않습니다."),
    NOT_ACCORD_USER_PASSWORD(HttpStatus.BAD_REQUEST, "U-003", "패스워드가 맞지 않습니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "U-004", "존재하지 않는 유저입니다."),
    NOT_ACCORD_USER_EMAIL(HttpStatus.BAD_REQUEST, "U-005", "이메일이 맞지 않습니다."),

    VALIDATION_FAILED(HttpStatus.BAD_REQUEST, "VALIDATION_FAILED", "입력값 유효성 검사에 실패하였습니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.BAD_REQUEST, "INTERNAL_SERVER_ERROR", "예상치 못한 서버 에러가 발생했습니다."),
    SUBJECTIVE_QUESTION_NOT_FOUND(HttpStatus.BAD_REQUEST, "USER_NOT_FOUND", "존재하지 않는 주관식문제입니다."),
    OBJECTIVE_QUESTION_NOT_FOUND(HttpStatus.BAD_REQUEST, "USER_NOT_FOUND", "존재하지 않는 객관식문제입니다."),
    SECTION_NOT_FOUND(HttpStatus.BAD_REQUEST, "SECTION_NOT_FOUND", "존재하지 않는 섹션입니다."),
    BOARD_NOT_FOUND(HttpStatus.BAD_REQUEST, "BOARD_NOT_FOUND", "존재하지 않는 게시판입니다."),
    ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "ALREADY_EXISTS","이미 같은 이름이 존재합니다."),
    QUIZ_NOT_FOUND(HttpStatus.BAD_REQUEST, "QUIZ_NOT_FOUND", "존재하지 않는 퀴즈입니다,");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;}