package com.example.employeeservice.controller;

import com.example.employeeservice.dto.response.EmployeeResponse;
import com.example.employeeservice.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldReturnAllEmployees() throws Exception {

        EmployeeResponse employee = EmployeeResponse.builder()
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

        when(employeeService.getAllEmployees())
                .thenReturn(List.of(employee));

        mockMvc.perform(get("/employees")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName")
                        .value("Jordi"));
    }
}