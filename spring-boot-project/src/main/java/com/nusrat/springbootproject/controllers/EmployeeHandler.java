package com.nusrat.springbootproject.controllers;

import com.nusrat.springbootproject.entities.Employee;
import com.nusrat.springbootproject.entities.EmployeeReimbursement;
import com.nusrat.springbootproject.repositories.EmployeeRepository;
import com.nusrat.springbootproject.repositories.NewRepository;
import com.nusrat.springbootproject.services.ReimbursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("employeereimbursement")
public class EmployeeHandler {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ReimbursementService reimbursementService;

    @Autowired
    private NewRepository newRepository;

    /**
     * @param employeeId - employee identifier
     * @return - all reimbursements requested by the specific employee
     */

    @GetMapping("{employeeId}")
    public ResponseEntity getReimbursementByEmployeeId(@PathVariable int employeeId) {
        try {
            List<EmployeeReimbursement> r = reimbursementService.findAllByEmployeeId(employeeId);
            return ResponseEntity.ok(r);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * @param b - Body of EmployeeReimbursement Class
     * @return - Create a new reimbursement request
     */
    @PostMapping("new/{employeeId}")
    public ResponseEntity addReimbursement (@PathVariable int employeeId, @RequestBody EmployeeReimbursement b) {
        try {
            Employee emp = newRepository.findById(employeeId);
            b.setEmployee(emp);
            employeeRepository.save(b);
            return ResponseEntity.created(new URI("http://localhost/employeereimbursement/new" + b.getReimbursementId())).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error saving new Reimbursement");
        }
    }
}