package br.com.grupo63.hackatonserviceauth.usecase.employee;

import br.com.grupo63.hackatonserviceauth.config.PasswordEncoder;
import br.com.grupo63.hackatonserviceauth.controller.dto.EmployeeControllerDTO;
import br.com.grupo63.hackatonserviceauth.entity.employee.Employee;
import br.com.grupo63.hackatonserviceauth.gateway.employee.IEmployeeGateway;
import br.com.grupo63.hackatonserviceauth.presenter.EmployeePresenter;
import br.com.grupo63.techchallenge.common.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmployeeUseCase implements IEmployeeUseCase {

    private final IEmployeeGateway gateway;
    private final PasswordEncoder passwordEncoder;

    @Override
    public EmployeeControllerDTO identify(Employee employee) throws NotFoundException {

        Optional<Employee> optionalClient = gateway.findByRegistrationNumber(employee.getRegistrationNumber());

        if (optionalClient.isPresent() && passwordEncoder.matches(employee.getPassword(), optionalClient.get().getPassword())) {
            return EmployeePresenter.toDto(optionalClient.get());
        }

        throw new NotFoundException();
    }

}
