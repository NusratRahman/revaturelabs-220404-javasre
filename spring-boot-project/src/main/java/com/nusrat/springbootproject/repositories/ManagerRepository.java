package com.nusrat.springbootproject.repositories;

import com.nusrat.springbootproject.entities.ManagerReimbursementList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<ManagerReimbursementList, Integer> {

    /**
     * @param managerToTakeAction - manager ID
     * @return - all reimbursements under specific manager
     */
    @Query("From ManagerReimbursementList where managerToTakeAction = :managerToTakeAction")
    List<ManagerReimbursementList> findAllByManagerId(@Param("managerToTakeAction") int managerToTakeAction);
}