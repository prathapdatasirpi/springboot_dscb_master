package com.datasirpi.dschatbox.entity;

import com.datasirpi.dschatbox.dto.Employee;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity

@Table(name="dscb_users")
@Getter
@Setter
public class EmployeeEntity extends Employee implements Serializable {
    @Id
    @Column(name="id")
    private int empId;

    @Column(name="user_name")
    private String empName;

    @Column(name="user_mail")
    private String empMail;

    @Column(name = "password")
    private String password;
}
