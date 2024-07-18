package com.project.gamegame.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class CustomException extends RuntimeException{

    public static final CustomException USER_NOT_FOUND = new CustomException(ErrorCode.USER_NOT_FOUND);
    public static final CustomException VALIDATION_FAILED = new CustomException(ErrorCode.VALIDATION_FAILED);
    public static final CustomException SUBJECTIVE_QUESTION_NOT_FOUㅌND = new CustomException(ErrorCode.SUBJECTIVE_QUESTION_NOT_FOUND);
    public static final CustomException OBJECTIVE_QUESTION_NOT_FOUND = new CustomException(ErrorCode.OBJECTIVE_QUESTION_NOT_FOUND);
    public static final CustomException SECTION_NOT_FOUND = new CustomException(ErrorCode.SECTION_NOT_FOUND);
    public static final CustomException BOARD_NOT_FOUND = new CustomException(ErrorCode.BOARD_NOT_FOUND);



    private final ErrorCode errorCode;



    public HttpStatus getHttpStatus() {
        return errorCode.getHttpStatus();
    }
}
