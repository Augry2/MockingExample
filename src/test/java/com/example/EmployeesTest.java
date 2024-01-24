package com.example;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class EmployeesTest {

    // testing the constructor?

    // testing payEmployees
    // in order to test payEmployees we need to mock EmployeeRepository, and BakService Classes
    // need to mock findAll method in EmployeeRepository, this should return a list of random employee



    // MOCKITO
    @Test
    @DisplayName("PayEmployees sets employee paid to true")
    void payEmployeesSetsEmployeePaidToTrue() {

        EmployeeRepository employeeRepoMock = mock(EmployeeRepository.class);
        BankService bankServiceMock = mock(BankService.class);
        Employees employees = new Employees(employeeRepoMock, bankServiceMock);
        Employee mockEmployee1 = new Employee("1", 1000.0);

        // when findAll is called on, then return a list with mockEmployee1 in it, you can add more employees if you need
        when(employeeRepoMock.findAll()).thenReturn(Arrays.asList(mockEmployee1));
        employees.payEmployees();

        assertThat(mockEmployee1.isPaid()).isEqualTo(true);


    }

    //STUB
    @Test
    @DisplayName("payEmployees returns an int containing the number of people who got paid ")
    void payEmployeesReturnsAnIntContainingTheNumberOfPeopleWhoGotPaid() {
        EmployeeRepository employeeRepoStub = new EmployeeRepositoryStub();
        BankService bankServiceStub = new BankServiceStub();
        Employees employees = new Employees(employeeRepoStub, bankServiceStub);

        int numOfEmployeePaid = employees.payEmployees();

        assertThat(numOfEmployeePaid).isEqualTo(2);
    }

    @Test
    @DisplayName("payEmployees can cause a runtime exception")
    void payEmployeesCanCauseARuntimeException() {

        EmployeeRepository employeeRepoMock = mock(EmployeeRepository.class);
        BankService bankServiceMock = mock(BankService.class);
        Employees employees = new Employees(employeeRepoMock, bankServiceMock);
        Employee mockEmployee1 = new Employee(null, 500);

        when(employeeRepoMock.findAll()).thenReturn(Arrays.asList(mockEmployee1));

        doThrow(new RuntimeException("Some error message")).when(bankServiceMock).pay(null, 500);

        int payments = employees.payEmployees();

        assertThat(payments).isEqualTo(0);


    }


}