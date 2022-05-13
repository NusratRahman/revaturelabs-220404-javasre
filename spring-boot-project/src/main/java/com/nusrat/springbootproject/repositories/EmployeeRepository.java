package com.nusrat.springbootproject.repositories;

import com.nusrat.springbootproject.entities.EmployeeReimbursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeReimbursement, Integer> {

    /**
     * @param employeeId - employee identifier
     * @return Finds all reimbursements using employee ID
     */
    @Query("From EmployeeReimbursement where employeeId = :employeeId")
    List<EmployeeReimbursement> findAllByEmployeeId(@Param("employeeId") int employeeId);
}
