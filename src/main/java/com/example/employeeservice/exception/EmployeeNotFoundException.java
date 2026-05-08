package com.example.employeeservice.exception;

import com.example.employeeservice.util.Constants;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(Long id) {
        super(Constants.EMPLOYEE_NOT_FOUND + id);
    }
}