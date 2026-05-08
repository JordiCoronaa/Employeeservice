package com.example.employeeservice.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class EmployeeRequest {

    @NotBlank(message = "First name is required")
    private String firstName;

    private String middleName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    private String motherLastName;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Minimum age is 18")
    private Integer age;

    @NotBlank(message = "Gender is required")
    private String gender;

    @NotNull(message = "Birth date is required")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;

    @NotBlank(message = "Position is required")
    private String position;

    @NotNull(message = "Active status is required")
    private Boolean active;
}