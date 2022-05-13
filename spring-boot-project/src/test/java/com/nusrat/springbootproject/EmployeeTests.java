package com.nusrat.springbootproject;

import com.nusrat.springbootproject.entities.Employee;
import com.nusrat.springbootproject.entities.Manager;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmployeeTests {

    Employee e = new Employee(7, "Nusrat", "nusrat@gmail.com", new Manager(1, "Ola", "ola@outlook.com"));
    Employee e1 = new Employee();

    @Test
    void shouldGetId() {
        assertEquals(7, e.getEmployeeId());
    }

    @Test
    void shouldGetName() {
        assertEquals("Nusrat", e.getEmployeeName());
    }

    @Test
    void shouldGetEmail() {
        assertEquals("nusrat@gmail.com", e.getEmail1());
    }

    @Test
    void shouldSetId() {
        e1.setEmployeeId(13);
        assertEquals(13, e1.getEmployeeId());
    }

    @Test
    void shouldSetName() {
        e1.setEmployeeName("Jack");
        assertEquals("Jack", e1.getEmployeeName());
    }

    @Test
    void shouldSetEmail() {
        e1.setEmail1("jack@hotmail.com");
        assertEquals("jack@hotmail.com", e1.getEmail1());
    }

    @Test
    void testEquals() {
        assertEquals(false, e1.equals("test"));
    }
}