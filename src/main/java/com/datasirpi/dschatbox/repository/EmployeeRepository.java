package com.datasirpi.dschatbox.repository;

import com.datasirpi.dschatbox.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
    public EmployeeEntity findByEmpMail(String userMail);
}
