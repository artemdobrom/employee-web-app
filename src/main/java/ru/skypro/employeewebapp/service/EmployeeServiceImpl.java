package ru.skypro.employeewebapp.service;

import org.springframework.stereotype.Service;
import ru.skypro.employeewebapp.exception.EmployeeAlreadyAddedException;
import ru.skypro.employeewebapp.exception.EmployeeNotFoundException;
import ru.skypro.employeewebapp.model.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees = new HashMap<>();
    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(),employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee.getFullName());
        return employee;

    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Collection<Employee> findAll() {
        return employees.values();
    }
}
