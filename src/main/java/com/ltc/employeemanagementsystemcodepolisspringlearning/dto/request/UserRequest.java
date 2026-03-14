package com.ltc.employeemanagementsystemcodepolisspringlearning.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {


    @NotBlank(message = "Mutleq doldurulmalidir")
            @Size(min = 3, max = 50,message = "En kichik 3 max 50")
    String firstName;


    @NotBlank(message = "Mutleq doldurulmalidir")
    @Size(min = 3, max = 50,message = "En kichik 3 max 50")
    String lastName;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Minimum 8 simvoldan ibaret , bir kichik bir poyuk herf olmalidir")
    String password;
}
