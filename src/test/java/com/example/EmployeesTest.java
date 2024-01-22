package com.example;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class EmployeesTest {


    @Mock
    EmployeeRepository employeeRepo = mock(EmployeeRepository.class);

    @Mock
    BankService bankService = mock(BankService.class);

    // testing the constructor?

    // testing payEmployees
    // in order to test payEmployees we need to mock EmployeeRepository, and BakService Classes
    // need to mock findAll method in EmployeeRepository, this should return a list of random employee



    @Test
    @DisplayName("PayEmployees sets employee paid to true")
    void payEmployeesSetsEmployeePaidToTrue() {

        EmployeeRepository employeeRepoMock = mock(EmployeeRepository.class);
        BankService bankServiceMock = mock(BankService.class);
        Employees employees = new Employees(employeeRepoMock, bankServiceMock);
        Employee mockEmployee1 = new Employee("1", 1000.0);

        // when findAll is called on, then return a list with mockEmployee1 in it, you can add more employees if you need
        when(employeeRepoMock.findAll()).thenReturn(Arrays.asList(mockEmployee1));

        assertThat(mockEmployee1.isPaid()).isEqualTo(false);
        int payments = employees.payEmployees();
        assertThat(mockEmployee1.isPaid()).isEqualTo(true);
        assertThat(payments).isEqualTo(1);





    }

    @Test
    @DisplayName("payEmployees returns an int containing the number of people who got paid ")
    void payEmployeesReturnsAnIntContainingTheNumberOfPeopleWhoGotPaid() {

    }


}