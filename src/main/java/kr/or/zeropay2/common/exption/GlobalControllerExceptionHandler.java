package kr.or.zeropay2.common.exption;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.springframework.http.HttpStatus.NOT_FOUND;


// 프로젝트 전역에 적용된다.
@RestControllerAdvice
@Slf4j
public class GlobalControllerExceptionHandler {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public @ResponseBody HttpErrorInfo handleNotFoundExceptions(ServerHttpRequest request, Exception ex) {

        return createHttpErrorInfo(NOT_FOUND, request, ex);
    }

    private HttpErrorInfo createHttpErrorInfo(HttpStatus httpStatus, ServerHttpRequest request, Exception ex){
        final String path = request.getPath().pathWithinApplication().value();
        final String message = ex.getMessage();
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));

        log.debug("Return HTTP status; {} for path: {}, message: {}",httpStatus, path, message);
        return new HttpErrorInfo(now, httpStatus, path, message);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public @ResponseBody HttpErrorInfo handleNotFoundExceptions2(ServerHttpRequest request, Exception ex) {

        return createHttpErrorInfo(HttpStatus.BAD_REQUEST, request, ex);
    }
}

