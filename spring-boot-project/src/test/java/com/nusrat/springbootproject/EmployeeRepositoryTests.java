package com.nusrat.springbootproject;

import com.nusrat.springbootproject.entities.EmployeeReimbursement;
import com.nusrat.springbootproject.repositories.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void shouldGetReimbursementListById(){
        List<EmployeeReimbursement> erl = employeeRepository.findAllByEmployeeId(12);
        Assertions.assertEquals(1, erl.size());
    }
}