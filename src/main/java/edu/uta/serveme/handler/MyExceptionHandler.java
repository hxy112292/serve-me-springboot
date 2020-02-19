package edu.uta.serveme.handler;

import edu.uta.serveme.base.BaseResponse;
import edu.uta.serveme.base.ErrorResponse;
import edu.uta.serveme.constant.ErrorMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author housirvip
 */
@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class MyExceptionHandler {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(RuntimeException.class)
    public BaseResponse handlerRuntimeException(RuntimeException ex) {

        if (ex.getMessage() == null || ex.getMessage().isEmpty()) {
            return new ErrorResponse(ErrorMessage.SERVICE_EXCEPTION);
        }

        return new ErrorResponse(ex.getMessage());
    }
}
