package com.nusrat.springbootproject.repositories;

import com.nusrat.springbootproject.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NewRepository extends JpaRepository <Employee, Integer> {

    /**
     * @param employeeId - employee identifier
     * @return - specific employee identified by ID
     */
    @Query("From Employee where employeeId = :employeeId")
    Employee findById(@Param("employeeId") int employeeId);
}
