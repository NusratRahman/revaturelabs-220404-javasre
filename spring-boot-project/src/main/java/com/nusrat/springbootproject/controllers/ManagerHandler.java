package com.nusrat.springbootproject.controllers;

import com.nusrat.springbootproject.ResourceNotFoundException;
import com.nusrat.springbootproject.entities.EmployeeReimbursement;
import com.nusrat.springbootproject.entities.ManagerReimbursementList;
import com.nusrat.springbootproject.repositories.EmployeeRepository;
import com.nusrat.springbootproject.repositories.ManagerRepository;
import com.nusrat.springbootproject.services.ReimbursementService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reimbursementlist")
public class ManagerHandler {

    @Setter(onMethod = @__({@Autowired}))
    private ManagerRepository managerRepository;

    @Setter(onMethod = @__({@Autowired}))
    private EmployeeRepository employeeRepository;

    @Autowired
    private ReimbursementService reimbursementService;

    /**
     * @param managerToTakeAction - Manager identifier
     * @return - All Reimbursements under a specific manager
     */

    @GetMapping("{managerToTakeAction}")
    public ResponseEntity getManagerReimbursementListByManagerId (@PathVariable int managerToTakeAction) {
        try {
            List<ManagerReimbursementList> m = reimbursementService.findAllByManagerId(managerToTakeAction);
            return ResponseEntity.ok(m);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * @param managerReimbursementListId - Reimbursement identifier for a manager
     * @param managerReimbursementList - Body of ManagerReimbursementList class
     * @return - change the status of the action taken by manager
     * @throws ResourceNotFoundException - if Reimbursement Request not found for the given id
     */
    @PutMapping("/action/{managerReimbursementListId}")
    public ResponseEntity updateStatus (@PathVariable Integer managerReimbursementListId,
                                        @RequestBody ManagerReimbursementList managerReimbursementList) throws ResourceNotFoundException {

        ManagerReimbursementList rl = managerRepository.findById(managerReimbursementListId)
                .orElseThrow(() -> new ResourceNotFoundException("Reimbursement Request not found for this id :: " + managerReimbursementListId));
        EmployeeReimbursement e = employeeRepository.findById(managerReimbursementListId)
                .orElseThrow(() -> new ResourceNotFoundException("Reimbursement Request not found for this id :: " + managerReimbursementListId));

        e.setReimbursementStatus(managerReimbursementList.getActionTakenByManager());
        employeeRepository.save(e);

        rl.setActionTakenByManager(managerReimbursementList.getActionTakenByManager());
        final ManagerReimbursementList updatedAction = managerRepository.save(rl);
        return ResponseEntity.ok(updatedAction);
    }
}