package com.moonlight.userService.mappers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRequest {
    @NotBlank(message = "First Name is mandatory")
    private String firstName;
    private String middleName;
    @NotBlank(message = "Last Name is Mandatory")
    private String lastName;
    @NotBlank(message = "Email is Mandatory")
    private String email;
    @Size(min = 10, max = 10, message = "Mobile number length should be 10")
    private String mobileNumber;
//    @NotNull(message = "Password is required")
//    @Size(min = 4, max = 60, message = "Password length min 4 and max 60")
//    private String password;
//    private String matchingPassword;
}
