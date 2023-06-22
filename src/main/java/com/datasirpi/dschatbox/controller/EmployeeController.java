package com.datasirpi.dschatbox.controller;

import com.datasirpi.dschatbox.dto.Employee;
import com.datasirpi.dschatbox.dto.RequestMeta;
import com.datasirpi.dschatbox.entity.EmployeeEntity;
import com.datasirpi.dschatbox.repository.EmployeeRepository;
import com.datasirpi.dschatbox.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class EmployeeController  {
    @Autowired
    RequestMeta requestMeta;

    @Autowired
    IEmployeeService iEmployeeService;

    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping("signup")
    public ResponseEntity userSave(@RequestBody Employee employee) {
        EmployeeEntity employeeEntity = employeeRepository.findByEmpMail(employee.getUserMail());
        if(employeeEntity != null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body("Email Id Already Exists");
        }
        iEmployeeService.saveEmployee(employee);
        return new ResponseEntity(employee, HttpStatus.CREATED);
    }

    @PostMapping("login")
    public ResponseEntity onLogin(@RequestBody Employee user) {
        Map<String, Object> employee = iEmployeeService.findByEmpMail(user);
        if (employee == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body("Invalid User");
        }
        return new ResponseEntity(employee, HttpStatus.ACCEPTED);
    }

    @GetMapping("members")
    public ResponseEntity getUsers() throws Exception {
        List<Employee> employees = iEmployeeService.fetchAllEmployees();
        return new ResponseEntity(employees, HttpStatus.OK);
    }

    @GetMapping("searchUsers")
    public ResponseEntity filterUsers(@RequestParam(name = "searchingInput") String searchingText) throws Exception {
        List<Employee> employees = iEmployeeService.fetchAllEmployees();
        if(searchingText == "") {
            return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body("field should be not empty");
        }
        List<Employee> filteredUsers = new ArrayList<>();
        employees.stream()
                .filter(employee -> employee.getUserName().contains(searchingText))
                .forEach(u-> filteredUsers.add(iEmployeeService.mapUser(u)));
        return new ResponseEntity(filteredUsers, HttpStatus.OK);
    }

    @GetMapping(path = "get-contacts")
    public ResponseEntity getContacts() {
        String userId = String.valueOf(requestMeta.getUserId());
        List<Employee> chatContacts = iEmployeeService.getChatContacts(userId);
        return new ResponseEntity(chatContacts, HttpStatus.OK);
    }
}
