package com.nusrat.springbootproject;

import com.nusrat.springbootproject.entities.Manager;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ManagerTests {

    Manager m = new Manager(1, "Ola", "ola@outlook.com");
    Manager m1 = new Manager();

    @Test
    void shouldGetId() {
        assertEquals(1, m.getManagerId());
    }

    @Test
    void shouldGetName() {
        assertEquals("Ola", m.getManagerName());
    }

    @Test
    void shouldGetEmail() {
        assertEquals("ola@outlook.com", m.getEmail());
    }

    @Test
    void shouldSetId() {
        m1.setManagerId(3);
        assertEquals(3, m1.getManagerId());
    }

    @Test
    void shouldSetName() {
        m1.setManagerName("Riz");
        assertEquals("Riz", m1.getManagerName());
    }

    @Test
    void shouldSetEmail() {
        m1.setEmail("riz@hotmail.com");
        assertEquals("riz@hotmail.com", m1.getEmail());
    }

    @Test
    void testEquals() {
        assertEquals(false, m1.equals("test"));
    }
}
