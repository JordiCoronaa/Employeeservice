package com.example.employeeservice.controller;

import com.example.employeeservice.dto.request.EmployeeRequest;
import com.example.employeeservice.dto.response.EmployeeResponse;
import com.example.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Employees", description = "Employee management APIs")
@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
@Validated
public class EmployeeController {

    private final EmployeeService employeeService;

    @Operation(summary = "Create a new employee")
    @PostMapping
    public ResponseEntity<EmployeeResponse> createEmployee(
            @Valid @RequestBody EmployeeRequest request) {

        EmployeeResponse response = employeeService.createEmployee(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Get all employees")
    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {

        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @Operation(summary = "Get employee by id")
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(
            @PathVariable Long id) {

        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @Operation(summary = "Search employees by name")
    @GetMapping("/search")
    public ResponseEntity<List<EmployeeResponse>> searchEmployees(
            @RequestParam String name) {

        return ResponseEntity.ok(
                employeeService.searchEmployeesByName(name));
    }

    @Operation(summary = "Update employee")
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeRequest request) {

        return ResponseEntity.ok(
                employeeService.updateEmployee(id, request));
    }

    @Operation(summary = "Delete employee")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(
            @PathVariable Long id) {

        employeeService.deleteEmployee(id);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Create multiple employees")
    @PostMapping("/batch")
    public ResponseEntity<List<EmployeeResponse>> createEmployees(
            @Valid @RequestBody List<EmployeeRequest> requests) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeeService.createEmployees(requests));
    }
}