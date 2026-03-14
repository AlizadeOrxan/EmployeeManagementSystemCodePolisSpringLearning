package com.ltc.employeemanagementsystemcodepolisspringlearning.exception;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ErrorResponse {


    String message;
    int statusCode;
    LocalDateTime timestamp;






}
