package com.example;

import static org.assertj.core.api.Assertions.assertThat;
import org.assertj.core.api.Assertions;
import org.assertj.core.internal.IterableElementComparisonStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {


    @Test
    @DisplayName("constructor properly creates instances of the class")
    void constructorProperlyCreatesInstancesOfTheClass() {
        Employee employee = new Employee("123",123);

        assertThat(employee.getId()).isEqualTo("123");
        assertThat(employee.getSalary()).isEqualTo(123);
    }

    @Test
    @DisplayName("getId returns the correct id")
    void getIdReturnsTheCorrectId() {
        Employee employee = new Employee("123",123);
        String employeeId = employee.getId();

        assertThat(employeeId).isEqualTo("123");
    }

    @Test
    @DisplayName("setId properly sets an id")
    void setIdProperlySetsAnId() {
        Employee employee = new Employee("123",123);
        String newId = "321";
        employee.setId(newId);

        assertThat(employee.getId()).isEqualTo("321");
    }

    @Test
    @DisplayName("getSalary returns the correct salary")
    void getSalaryReturnsTheCorrectSalary() {
        Employee employee = new Employee("123",123.5);
        Double employeeSalary = employee.getSalary();

        assertThat(employeeSalary).isEqualTo(123.5);
    }

    @Test
    @DisplayName("setSalary properly updates salary")
    void setSalaryProperlyUpdatesSalary() {
        Employee employee = new Employee("123",123.5);
        Double newSalary = 321.5;
        employee.setSalary(newSalary);

        assertThat(employee.getSalary()).isEqualTo(321.5);
    }

    @Test
    @DisplayName("setPaid properly updates the paid boolean")
    void setPaidProperlyUpdatesThePaidBoolean() {
        Employee employee = new Employee("123",123.5);
        employee.setPaid(true);

        assertThat(employee.isPaid()).isEqualTo(true);
    }

    @Test
    @DisplayName("isPaid returns correct boolean value")
    void isPaidReturnsCorrectBooleanValue() {
        Employee employee = new Employee("123",123.5);
        employee.setPaid(false);

        assertThat(employee.isPaid()).isEqualTo(false);
    }

    @Test
    public void testToString() {
        Employee employee = new Employee("123", 123.5);
        String expectedString = "Employee [id=123, salary=123.5]";
        assertEquals(expectedString, employee.toString());
    }




}