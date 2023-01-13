package org.kol.addressApp.controller;

import org.kol.addressApp.response.AddressResponse;
import org.kol.addressApp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("/address/{employeeId}")
    //for get request status ok, post created
    public ResponseEntity<AddressResponse> getAddressId(@PathVariable("employeeId") int id){

        // db call -> employee 1

        AddressResponse addressResponse=null;
       // addressResponse=addressService.findAddresById(id);

        addressResponse=addressService.findAddressByEmployeeId(id);

        return ResponseEntity.status(HttpStatus.OK).body(addressResponse);


    }
}
