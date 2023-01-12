package org.kol.employeeApp.controller;
import org.kol.employeeApp.response.EmployeeResponse;
import org.kol.employeeApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
   EmployeeService employeeService;

    @GetMapping("/employees/{Id}") //Id=2
     //http://localhost:8080/employee-app/api/employees/2
    //for get request status ok, post created
    ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("Id") int id){

        // db call -> employee 1
       EmployeeResponse employeeResponse=employeeService.getEmployeesById(id);

       //return to response to the client
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);

    }
}
