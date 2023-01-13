package org.kol.addressApp.repository;

import org.kol.addressApp.entity.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {
    @Query(nativeQuery = true,value = "SELECT ea.id, ea.lane1, ea.lane2, ea.state, ea.zip FROM organisation.address ea join organisation.employee e on e.id=ea.employee_id where ea.employee_id=:employeeId")
    Address findAddressDetailsByEmployeeId(@Param("employeeId") int employeeId);

}
