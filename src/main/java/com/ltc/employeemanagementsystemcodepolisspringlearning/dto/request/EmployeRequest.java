package com.ltc.employeemanagementsystemcodepolisspringlearning.dto.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeRequest {

    @NotBlank(message = "Ad mutleq daxil edilmelidir")
            @Size(min = 3,max = 50,message = "Minimum 3 max 50 simvol daxil edin")
     String firstName;

    @NotBlank(message = "Ad mutleq daxil edilmelidir")
    @Size(min = 3,max = 50,message = "Minimum 3 max 50 simvol daxil edin")
     String lastName;

    @NotBlank(message = "Ad mutleq daxil edilmelidir")
    @Size(min = 3,max = 50,message = "Minimum 3 max 50 simvol daxil edin")
     String address;

    @Email(message = "Email formatina uygun olaraq yazin")
     String email;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Minimum 8 simvoldan ibaret , bir kichik bir poyuk herf olmalidir")
     String password;
}
