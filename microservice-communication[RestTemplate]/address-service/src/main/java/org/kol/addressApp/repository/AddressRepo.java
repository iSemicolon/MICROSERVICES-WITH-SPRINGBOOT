package org.kol.addressApp.repository;

import org.kol.addressApp.entity.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {
    @Query(nativeQuery = true,value = "SELECT addrs.id, addrs.lane1, addrs.lane2, addrs.state, addrs.zip FROM organisation.address addrs join organisation.employee emp on emp.id=addrs.employee_id where addrs.employee_id=:employeeId")
    Address findAddressDetailsByEmployeeId(@Param("employeeId") int employeeId);

}
