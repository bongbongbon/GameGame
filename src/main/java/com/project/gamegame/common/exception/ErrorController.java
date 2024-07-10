package com.project.gamegame.common.exception;

import com.project.gamegame.common.response.ApiErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class ErrorController {


    // CustomException 처리
    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<ApiErrorResponse> handleBaseException(CustomException e) {
        return ResponseEntity
                .status(e.getHttpStatus())
                .body(ApiErrorResponse.from(e.getErrorCode()));
    }

    // @Valid에서 binding error 발생
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ApiErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        List<String> params = new ArrayList<>();

        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            params.add(error.getField() + ": " + error.getDefaultMessage());
        }

        String errorMessage = String.join(", ", params);

        ApiErrorResponse response = ApiErrorResponse.from(ErrorCode.VALIDATION_FAILED);
        response.changeMessage(errorMessage);

        return response;
    }


    // 에상하지 못한 에러 처리
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    protected ApiErrorResponse handleRuntimeException(RuntimeException e) {
        log.error(e.getMessage());
        return ApiErrorResponse.from(ErrorCode.INTERNAL_SERVER_ERROR);
    }
}
