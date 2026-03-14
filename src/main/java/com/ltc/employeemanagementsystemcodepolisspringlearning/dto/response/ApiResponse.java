package com.ltc.employeemanagementsystemcodepolisspringlearning.dto.response;

import lombok.Data;

@Data
public class ApiResponse <T> {

    String message;

    T data ;
}
