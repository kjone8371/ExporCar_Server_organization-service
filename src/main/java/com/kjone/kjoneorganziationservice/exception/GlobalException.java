package com.kjone.kjoneorganziationservice.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/*
최상위 예외 처리 클래스
 */


@Getter
@AllArgsConstructor
public class GlobalException extends RuntimeException{
    private final HttpStatus httpStatus;
    private String message;
}
