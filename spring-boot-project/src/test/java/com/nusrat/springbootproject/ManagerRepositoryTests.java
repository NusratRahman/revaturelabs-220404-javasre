package com.nusrat.springbootproject;

import com.nusrat.springbootproject.entities.ManagerReimbursementList;
import com.nusrat.springbootproject.repositories.ManagerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ManagerRepositoryTests {

    @Autowired
    private ManagerRepository managerRepository;

    @Test
    public void shouldGetAllReimbursementsByManagerId(){
        List<ManagerReimbursementList> mrl = managerRepository.findAllByManagerId(2);
        Assertions.assertEquals(4, mrl.size());
    }
}
