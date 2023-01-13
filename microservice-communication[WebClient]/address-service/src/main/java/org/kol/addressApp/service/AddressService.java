package org.kol.addressApp.service;

import org.kol.addressApp.entity.Address;
import org.kol.addressApp.repository.AddressRepo;
import org.kol.addressApp.response.AddressResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private ModelMapper modelMapper;

    public AddressResponse findAddresById(int id) {

        //set data by rest api call
       Address address=addressRepo.findById(id).get(); //dbcall

        AddressResponse addressResponse=  modelMapper.map(address, AddressResponse.class);

       return addressResponse;

   }

    public AddressResponse findAddressByEmployeeId(int id) {

        //set data by rest api call
        Address address=addressRepo.findAddressDetailsByEmployeeId(id); //dbcall

        AddressResponse addressResponse=  modelMapper.map(address, AddressResponse.class);

        return addressResponse;



    }


   }
