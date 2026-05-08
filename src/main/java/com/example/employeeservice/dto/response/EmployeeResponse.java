package com.example.employeeservice.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class EmployeeResponse {

    private Long id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String motherLastName;

    private Integer age;

    private String gender;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;

    private String position;

    private LocalDateTime createdAt;

    private Boolean active;
}