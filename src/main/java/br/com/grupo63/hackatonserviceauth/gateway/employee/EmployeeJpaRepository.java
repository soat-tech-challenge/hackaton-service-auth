package br.com.grupo63.hackatonserviceauth.gateway.employee;

import br.com.grupo63.hackatonserviceauth.gateway.employee.entity.EmployeePersistenceEntity;
import br.com.grupo63.hackatonserviceauth.gateway.repository.IJpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeJpaRepository extends CrudRepository<EmployeePersistenceEntity, String>, IJpaRepository<EmployeePersistenceEntity> {

    Optional<EmployeePersistenceEntity> findByRegistrationNumberAndDeletedFalse(String registrationNumber);

}
