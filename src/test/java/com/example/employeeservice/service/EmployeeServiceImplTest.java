package com.example.employeeservice.service;

import com.example.employeeservice.dto.request.EmployeeRequest;
import com.example.employeeservice.dto.response.EmployeeResponse;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.exception.EmployeeNotFoundException;
import com.example.employeeservice.repository.EmployeeRepository;
import com.example.employeeservice.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    void shouldCreateEmployeeSuccessfully() {

        EmployeeRequest request = new EmployeeRequest();
        request.setFirstName("Jordi");
        request.setLastName("Corona");
        request.setAge(29);
        request.setGender("MALE");
        request.setBirthDate(LocalDate.of(1996, 8, 22));
        request.setPosition("Backend Developer");
        request.setActive(true);

        Employee employee = Employee.builder()
                .id(1L)
                .firstName("Jordi")
                .lastName("Corona")
                .age(29)
                .gender("MALE")
                .birthDate(LocalDate.of(1996, 8, 22))
                .position("Backend Developer")
                .createdAt(LocalDateTime.now())
                .active(true)
                .build();

        when(employeeRepository.save(any(Employee.class)))
                .thenReturn(employee);

        EmployeeResponse response =
                employeeService.createEmployee(request);

        assertNotNull(response);
        assertEquals("Jordi", response.getFirstName());

        verify(employeeRepository, times(1))
                .save(any(Employee.class));
    }

    @Test
    void shouldReturnEmployeeById() {

        Employee employee = Employee.builder()
                .id(1L)
                .firstName("Jordi")
                .lastName("Corona")
                .age(29)
                .gender("MALE")
                .birthDate(LocalDate.of(1996, 8, 22))
                .position("Backend Developer")
                .createdAt(LocalDateTime.now())
                .active(true)
                .build();

        when(employeeRepository.findById(1L))
                .thenReturn(Optional.of(employee));

        EmployeeResponse response =
                employeeService.getEmployeeById(1L);

        assertNotNull(response);
        assertEquals(1L, response.getId());
    }

    @Test
    void shouldThrowExceptionWhenEmployeeNotFound() {

        when(employeeRepository.findById(1L))
                .thenReturn(Optional.empty());

        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.getEmployeeById(1L));
    }
}