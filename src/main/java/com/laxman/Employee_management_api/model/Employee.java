package com.laxman.Employee_management_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serial;
import java.io.Serializable;

@Entity //Its make Sure that instances of the class stored as rows in a database table.
@Table(name="employee_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Employee implements Serializable {
    @Serial
    private static final long serialVersionUID =1954355911137869829L;
    @Id  //to define the primaryKey.
    @GeneratedValue(strategy = GenerationType.IDENTITY)//the id value should be automatically generated
    @Column(name ="id")
    private Long id;

    @Column(name ="FirstName")
    private String FirstName;

    @Column(name ="LastName")
    private String LastName;

    @Column(name ="Email")
    private String Email;

    @Column(name ="JobTitle")
    private String JobTitle;

    @Column(name ="Dept")
    private String Dept;

    @Column(name ="Phone")
    private String Phone;
}
