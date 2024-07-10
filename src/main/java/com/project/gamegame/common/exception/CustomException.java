package com.project.gamegame.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class CustomException extends RuntimeException{

    public static final CustomException USER_NOT_FOUND = new CustomException(ErrorCode.USER_NOT_FOUND);
    public static final CustomException VALIDATION_FAILED = new CustomException(ErrorCode.VALIDATION_FAILED);

    private final ErrorCode errorCode;



    public HttpStatus getHttpStatus() {
        return errorCode.getHttpStatus();
    }
}
