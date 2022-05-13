package com.nusrat.springbootproject.entities;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name= "ManagerReimbursementList")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ManagerReimbursementList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="managerReimbursementListId", columnDefinition = "AUTO_INCREMENT")
    private int managerReimbursementListId;

    private String actionTakenByManager;

    /**
     * One to One relationship between the class ManagerReimbursementList and EmployeeReimbursement
     */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="managerReimbursementListId")
    private EmployeeReimbursement employeeReimbursement;

    /**
     * Many to One relationship between the class ManagerReimbursementList and Manager
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="managerToTakeAction")
    private Manager manager;
}
