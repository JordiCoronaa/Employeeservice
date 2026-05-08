package com.example.employeeservice.service.impl;

import com.example.employeeservice.dto.request.EmployeeRequest;
import com.example.employeeservice.dto.response.EmployeeResponse;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.exception.EmployeeNotFoundException;
import com.example.employeeservice.mapper.EmployeeMapper;
import com.example.employeeservice.repository.EmployeeRepository;
import com.example.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeResponse createEmployee(EmployeeRequest request) {

        log.info("Creating employee with firstName: {}", request.getFirstName());

        Employee employee = EmployeeMapper.toEntity(request);

        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.toResponse(savedEmployee);
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {

        log.info("Fetching all employees");

        return employeeRepository.findAll()
                .stream()
                .map(EmployeeMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeResponse getEmployeeById(Long id) {

        log.info("Fetching employee by id: {}", id);

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(id));

        return EmployeeMapper.toResponse(employee);
    }

    @Override
    public List<EmployeeResponse> searchEmployeesByName(String name) {

        log.info("Searching employees by name: {}", name);

        return employeeRepository
                .findByFirstNameContainingIgnoreCase(name)
                .stream()
                .map(EmployeeMapper::toResponse)
                .toList();
    }

    @Override
    public EmployeeResponse updateEmployee(Long id, EmployeeRequest request) {

        log.info("Updating employee with id: {}", id);

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(id));

        employee.setFirstName(request.getFirstName());
        employee.setMiddleName(request.getMiddleName());
        employee.setLastName(request.getLastName());
        employee.setMotherLastName(request.getMotherLastName());
        employee.setAge(request.getAge());
        employee.setGender(request.getGender());
        employee.setBirthDate(request.getBirthDate());
        employee.setPosition(request.getPosition());
        employee.setActive(request.getActive());

        Employee updatedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.toResponse(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {

        log.info("Deleting employee with id: {}", id);

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(id));

        employeeRepository.delete(employee);

        log.info("Employee deleted successfully with id: {}", id);
    }

    @Override
    public List<EmployeeResponse> createEmployees(
            List<EmployeeRequest> requests) {

        log.info("Creating multiple employees. Total: {}", requests.size());

        List<Employee> employees = requests.stream()
                .map(EmployeeMapper::toEntity)
                .toList();

        List<Employee> savedEmployees =
                employeeRepository.saveAll(employees);

        return savedEmployees.stream()
                .map(EmployeeMapper::toResponse)
                .toList();
    }
}