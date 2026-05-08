package com.example.employeeservice.mapper;

import com.example.employeeservice.dto.request.EmployeeRequest;
import com.example.employeeservice.dto.response.EmployeeResponse;
import com.example.employeeservice.entity.Employee;

public class EmployeeMapper {

    private EmployeeMapper() {
    }

    public static Employee toEntity(EmployeeRequest request) {

        return Employee.builder()
                .firstName(request.getFirstName())
                .middleName(request.getMiddleName())
                .lastName(request.getLastName())
                .motherLastName(request.getMotherLastName())
                .age(request.getAge())
                .gender(request.getGender())
                .birthDate(request.getBirthDate())
                .position(request.getPosition())
                .active(request.getActive())
                .build();
    }

    public static EmployeeResponse toResponse(Employee employee) {

        return EmployeeResponse.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .middleName(employee.getMiddleName())
                .lastName(employee.getLastName())
                .motherLastName(employee.getMotherLastName())
                .age(employee.getAge())
                .gender(employee.getGender())
                .birthDate(employee.getBirthDate())
                .position(employee.getPosition())
                .createdAt(employee.getCreatedAt())
                .active(employee.getActive())
                .build();
    }
}