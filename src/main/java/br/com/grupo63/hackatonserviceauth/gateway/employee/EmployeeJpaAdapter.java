package br.com.grupo63.hackatonserviceauth.gateway.employee;

import br.com.grupo63.hackatonserviceauth.entity.employee.Employee;
import br.com.grupo63.hackatonserviceauth.gateway.employee.entity.EmployeePersistenceEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EmployeeJpaAdapter implements IEmployeeGateway {

    private final EmployeeJpaRepository jpaRepository;

    @Override
    public Optional<Employee> findByRegistrationNumber(String registrationNumber) {
        return jpaRepository.findByRegistrationNumberAndDeletedFalse(registrationNumber)
                .map(EmployeePersistenceEntity::toModel);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return jpaRepository.findById(Long.toString(id)).map(EmployeePersistenceEntity::toModel);
    }

}
