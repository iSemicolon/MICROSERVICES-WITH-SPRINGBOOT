package org.kol.employeeApp.service;

import org.kol.employeeApp.entity.Employee;
import org.kol.employeeApp.repository.EmployeeRepo;
import org.kol.employeeApp.response.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public EmployeeResponse getEmployeesById(int id) {

        //set data by rest api call
        Employee employee=employeeRepo.findById(id).get(); //dbcall

        EmployeeResponse employeeResponse= new EmployeeResponse();

        employeeResponse.setId(employee.getId());
        employeeResponse.setName(employee.getName());
        employeeResponse.setEmail(employee.getEmail());
        employeeResponse.setBloodGroup(employee.getBloodGroup());


       return employeeResponse;

   }

    }
