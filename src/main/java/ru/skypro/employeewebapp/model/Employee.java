package ru.skypro.employeewebapp.model;

import java.util.Objects;
import java.util.Random;

public class Employee {
    private final String firstName;
    private final String lastName;
    private int salary;
    private int departmentNumber;
    private final Random random = new Random();

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = random.nextInt(10000) + 1000;
        this.departmentNumber = random.nextInt(5) + 1;
    }

    public Employee(String firstName, String lastName, int salary, int departmentNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.departmentNumber = departmentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && departmentNumber == employee.departmentNumber && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, salary, departmentNumber);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", departmentNumber=" + departmentNumber +
                '}';
    }
}
