package com.datasirpi.dschatbox.dto;

import com.datasirpi.dschatbox.entity.EmployeeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    int userId;
    String userName;
    String userMail;
    String password;
}
