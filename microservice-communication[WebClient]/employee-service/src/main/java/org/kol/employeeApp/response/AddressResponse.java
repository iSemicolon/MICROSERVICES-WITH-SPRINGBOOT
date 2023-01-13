package org.kol.employeeApp.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddressResponse {

    private  int id;

    private  String lane1;

    private  String lane2;

    private  long zip;

    private  String state;


}
