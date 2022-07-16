package dev.fullstack.employeemanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
 public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private  String email;
    private  String jobTitle;
    private  String phone;
    private  String imageUrl;
    @Column(nullable = false, updatable = false)
    private  String employeeCode;
}
