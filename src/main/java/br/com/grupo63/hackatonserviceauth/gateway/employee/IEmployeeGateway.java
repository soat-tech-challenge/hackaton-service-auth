package br.com.grupo63.hackatonserviceauth.gateway.employee;

import br.com.grupo63.hackatonserviceauth.entity.employee.Employee;

import java.util.Optional;

public interface IEmployeeGateway {

    Optional<Employee> findByRegistrationNumber(String registrationNumber);

    Optional<Employee> findById(Long id);

}
