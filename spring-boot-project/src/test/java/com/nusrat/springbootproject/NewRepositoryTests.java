package com.nusrat.springbootproject;

import com.nusrat.springbootproject.entities.Employee;
import com.nusrat.springbootproject.repositories.NewRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NewRepositoryTests {

    @Autowired
    private NewRepository newRepository;

    @Test
    public void shouldGetEmployeeById(){
        Employee e = newRepository.findById(7);
        Assertions.assertEquals("Nusrat", e.getEmployeeName());
    }
}