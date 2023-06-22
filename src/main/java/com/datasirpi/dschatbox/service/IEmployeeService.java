package com.datasirpi.dschatbox.service;

import com.datasirpi.dschatbox.dto.Employee;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {
    public void saveEmployee(Employee employee);
    public Map<String, Object> findByEmpMail(Employee user);
    public List<Employee> fetchAllEmployees();
    public Employee mapUser(Employee user);
    public List<Employee> getChatContacts(String userId);
}
