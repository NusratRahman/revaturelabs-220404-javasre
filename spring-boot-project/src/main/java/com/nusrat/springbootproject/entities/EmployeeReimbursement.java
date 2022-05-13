package com.nusrat.springbootproject.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name= "EmployeeReimbursement")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeReimbursement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reimbursementId", columnDefinition = "AUTO_INCREMENT")
    private int reimbursementId;

    private double amount;

    private String reimbursementStatus = "Waiting for Action";

    /**
     * Many to One relationship between the class EmployeeReimbursement and Employee
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="employeeId")
    private Employee employee;
}
