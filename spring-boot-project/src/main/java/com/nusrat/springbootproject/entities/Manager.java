package com.nusrat.springbootproject.entities;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name= "Manager")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="managerId", columnDefinition = "AUTO_INCREMENT")
    private int managerId;

    private String managerName;
    private String email;
}
