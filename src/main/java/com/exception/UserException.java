package com.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class UserException extends RuntimeException {

    private String message;

    private Integer statusCode;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;

    private String stackTrace;


}
