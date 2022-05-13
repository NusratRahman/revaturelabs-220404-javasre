package com.nusrat.springbootproject;

import com.nusrat.springbootproject.entities.EmployeeReimbursement;
import com.nusrat.springbootproject.entities.ManagerReimbursementList;
import com.nusrat.springbootproject.repositories.EmployeeRepository;
import com.nusrat.springbootproject.services.ReimbursementService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ReimbursementServiceTests {

    @Autowired
    private ReimbursementService reimbursementService;

    @Test
    public void shouldGetAllReimbursementRequestsByEmployeeId() {
        List<EmployeeReimbursement> er = reimbursementService.findAllByEmployeeId(12);
        Assertions.assertEquals(1, er.size());
    }

    @Test
    public void shouldGetAllReimbursementRequestsByManagerId() {
        List<ManagerReimbursementList> mr = reimbursementService.findAllByManagerId(2);
        Assertions.assertEquals(4, mr.size());
    }
}
