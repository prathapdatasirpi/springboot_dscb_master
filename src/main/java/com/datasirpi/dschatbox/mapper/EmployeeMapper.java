package com.datasirpi.dschatbox.mapper;

import com.datasirpi.dschatbox.dto.Employee;
import com.datasirpi.dschatbox.entity.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    // for assign employee to employeeEntity
    @Mapping(source = "userId" ,target = "empId")
    @Mapping(source = "userName",target = "empName")
    @Mapping(source = "userMail",target = "empMail")
    @Mapping(source = "password",target = "password")
    EmployeeEntity employeeToEmployeeEntity(Employee employee);


    // for get employee from employeeEntity
    @Mapping(source = "empId" ,target = "userId")
    @Mapping(source = "empName",target = "userName")
    @Mapping(source = "empMail",target = "userMail")
    @Mapping(source = "password",target = "password")
    Employee employeeEntityToEmployee(EmployeeEntity employeeEntity);

    // for get employees list from employeeEntities
    List<Employee> employeeEntitiesToEmployees(List<EmployeeEntity> employeeEntities);
}
