package org.kol.employeeApp.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeResponse {

    private  int id;

    private  String name;

    private  String email;

    private  String bloodGroup;

    private AddressResponse addressResponse;

}
