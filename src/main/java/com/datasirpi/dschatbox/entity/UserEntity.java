package com.datasirpi.dschatbox.entity;

import com.datasirpi.dschatbox.dto.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity

@Table(name = "users")
@Getter
@Setter
public class UserEntity extends User implements Serializable {
    @Id
    @Column(name="userID")
    private int userId;

    @Column(name="userName")
    private String empName  ;

    @Column(name = "password")
    private String password;
}
