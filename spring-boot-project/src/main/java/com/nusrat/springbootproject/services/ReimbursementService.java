package com.nusrat.springbootproject.services;

import com.nusrat.springbootproject.entities.EmployeeReimbursement;
import com.nusrat.springbootproject.entities.ManagerReimbursementList;
import com.nusrat.springbootproject.repositories.EmployeeRepository;
import com.nusrat.springbootproject.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ReimbursementService {

    @Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ManagerRepository managerRepository;

    public ReimbursementService(EmployeeRepository employeeRepository, ManagerRepository managerRepository) {
        this.employeeRepository = employeeRepository;
        this.managerRepository = managerRepository;
    }

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    public ManagerRepository getManagerRepository() {
        return managerRepository;
    }

    /**
     *
     * @param employeeId - employee identifier
     * @return - all Reimbursements Requested by the specific employee
     */
    public List<EmployeeReimbursement> findAllByEmployeeId (int employeeId){
        List<EmployeeReimbursement> er = employeeRepository.findAllByEmployeeId(employeeId);
        return er;
    }

    /**
     *
     * @param managerToTakeAction - manager identifier
     * @return - all Reimbursement Requests under one specific manager
     */
    public List<ManagerReimbursementList> findAllByManagerId (int managerToTakeAction) {
        List<ManagerReimbursementList> ml = managerRepository.findAllByManagerId(managerToTakeAction);
        return ml;
    }
}
