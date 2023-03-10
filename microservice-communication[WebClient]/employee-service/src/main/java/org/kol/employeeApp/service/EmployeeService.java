package org.kol.employeeApp.service;

import org.kol.employeeApp.entity.Employee;
import org.kol.employeeApp.repository.EmployeeRepo;
import org.kol.employeeApp.response.AddressResponse;
import org.kol.employeeApp.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    //not using here
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;


    @Value("${addresservice.base.url}")
     private String addressBaseURL;


    public EmployeeResponse getEmployeesById(int id) {

        //set data by rest api call
        Employee employee=employeeRepo.findById(id).get(); //dbcall

        //Replaced commented code with ModelMapper

        EmployeeResponse employeeResponse=  modelMapper.map(employee, EmployeeResponse.class);

       return employeeResponse;

   }

   //not using
    public EmployeeResponse getAddressByUsingRestTemplate(int id) {
        //set data by rest api call
        Employee employee=employeeRepo.findById(id).get(); //dbcall

        //only fetch employee details from db
        EmployeeResponse employeeResponse=  modelMapper.map(employee, EmployeeResponse.class);

        //  restTemplate.getForObject(url,response, urivariable);
        //get data from external source(ex: address service)

      //  AddressResponse addressResponse=restTemplate.getForObject("http://localhost:8081/address-app/api/address/{id}", AddressResponse.class, id);


        //code improvement for passing url: line 51 & line 56 are same
        AddressResponse  addressResponse=restTemplate.getForObject(addressBaseURL+"/address/{id}",AddressResponse.class, id);

        //note:: restTemplate is blocking features
        //add address details with employee service
        employeeResponse.setAddressResponse(addressResponse);

        return employeeResponse;

    }

    public EmployeeResponse getAddressByUsingWebClient(int id) {
        //set data by rest api call
        Employee employee=employeeRepo.findById(id).get(); //dbcall

        //only fetch employee details from db
        EmployeeResponse employeeResponse=  modelMapper.map(employee, EmployeeResponse.class);

        //  restTemplate.getForObject(url,response, urivariable);
        //get data from external source(ex: address service)

        //  AddressResponse addressResponse=restTemplate.getForObject("http://localhost:8081/address-app/api/address/{id}", AddressResponse.class, id);


        //code improvement for passing url
        //AddressResponse  addressResponse=restTemplate.getForObject(addressBaseURL+"/address/{id}",AddressResponse.class, id);

        //note:: restTemplate is blocking features
        //add address details with employee service




        //using webclient
        //get data from external source(ex: address service)
        AddressResponse addressResponse =webClient.get().uri("/address/"+id).retrieve().bodyToMono(AddressResponse.class).block();
        employeeResponse.setAddressResponse(addressResponse);

        return employeeResponse;

    }
}
