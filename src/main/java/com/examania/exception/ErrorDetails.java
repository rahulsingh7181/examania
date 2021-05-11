package com.examania.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private List<String> details;
}
