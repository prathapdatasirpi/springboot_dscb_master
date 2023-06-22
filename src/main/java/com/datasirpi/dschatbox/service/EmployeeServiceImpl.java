package com.datasirpi.dschatbox.service;

import com.datasirpi.dschatbox.dto.Employee;
import com.datasirpi.dschatbox.dto.Message;
import com.datasirpi.dschatbox.entity.EmployeeEntity;
import com.datasirpi.dschatbox.mapper.EmployeeMapper;
import com.datasirpi.dschatbox.repository.EmployeeRepository;
import com.datasirpi.dschatbox.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    private final BCryptPasswordEncoder passwordEncoder;
    public EmployeeServiceImpl (BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.passwordEncoder = bCryptPasswordEncoder;
    }

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    MessageServiceImpl messageService;

    @Override
    public void saveEmployee(Employee employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employeeRepository.save(EmployeeMapper.INSTANCE.employeeToEmployeeEntity(employee));
    }

    @Override
    public Map<String, Object> findByEmpMail(Employee user) {
        EmployeeEntity employeeEntity = employeeRepository.findByEmpMail(user.getUserMail());
        if (employeeEntity != null){
            Map<String, Object> data = new HashMap<>();
            if(passwordEncoder.matches(user.getPassword(),employeeEntity.getPassword())){
                data.put("userName", employeeEntity.getEmpName());
                data.put("userMail", employeeEntity.getEmpMail());
                data.put("userId", employeeEntity.getEmpId());

                // generate Jwt token by employee
                String accessToken = jwtUtils.generateJwt(employeeEntity);
                data.put("accessToken", accessToken);
                return data;
            }
        }
        return null;
    }

    @Override
    public List<Employee> fetchAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<Employee> employees = EmployeeMapper.INSTANCE.employeeEntitiesToEmployees(employeeEntities);
        return employees;
    }

    @Override
    public List<Employee> getChatContacts(String userId) {
        List<Employee> employees = fetchAllEmployees();
        List<Employee> chatContacts = new ArrayList<>();

        employees.stream()
                .forEach(employee -> {
                    if(Integer.parseInt(userId) != employee.getUserId()) {
                        List<Message> messages = messageService.getMessagesById(userId, String.valueOf(employee.getUserId()));
                        if (messages.size() != 0) {
                            chatContacts.add(mapUser(employee));
                        }
                    }
                });
        return chatContacts;
    }

    // for user data mutations
    @Override
    public Employee mapUser(Employee user) {
        Employee data = new Employee();
        data.setUserName(user.getUserName());
        data.setUserMail(user.getUserMail());
        data.setUserId(user.getUserId());
        return data;
    }
}
