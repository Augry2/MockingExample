package com.example;

import java.util.Arrays;
import java.util.List;

public class EmployeeRepositoryStub implements EmployeeRepository {
    @Override
    public List<Employee> findAll() {
        return Arrays.asList(new Employee("1", 1000.0), new Employee("2", 2000.0));
    }

    @Override
    public Employee save(Employee e) {
        return null;
    }
}
