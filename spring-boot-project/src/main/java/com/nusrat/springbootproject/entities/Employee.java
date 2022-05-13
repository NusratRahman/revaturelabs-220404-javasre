package com.nusrat.springbootproject.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name= "Employee")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employeeId", columnDefinition = "AUTO_INCREMENT")
    private int employeeId;

    private String employeeName;

    private String email1;

    /**
     * Many to One relationship between the class Employee and Manager
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="supervisingManagerId")
    private Manager manager;
}
