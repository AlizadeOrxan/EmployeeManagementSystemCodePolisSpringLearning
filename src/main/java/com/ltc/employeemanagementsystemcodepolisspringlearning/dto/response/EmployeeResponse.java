package com.ltc.employeemanagementsystemcodepolisspringlearning.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeResponse {


    String firstName;

    String lastName;

    String email;
}
