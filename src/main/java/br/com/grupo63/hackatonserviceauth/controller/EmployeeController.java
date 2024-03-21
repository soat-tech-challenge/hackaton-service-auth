package br.com.grupo63.hackatonserviceauth.controller;

import br.com.grupo63.hackatonserviceauth.adapter.EmployeeAdapter;
import br.com.grupo63.hackatonserviceauth.controller.dto.EmployeeControllerDTO;
import br.com.grupo63.hackatonserviceauth.entity.employee.Employee;
import br.com.grupo63.hackatonserviceauth.presenter.EmployeePresenter;
import br.com.grupo63.hackatonserviceauth.usecase.employee.EmployeeUseCase;
import br.com.grupo63.techchallenge.common.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmployeeController {

    private final EmployeeUseCase employeeUseCase;

    public EmployeeControllerDTO identify(EmployeeControllerDTO dto) throws NotFoundException {
        Employee entity = new Employee();
        EmployeeAdapter.fillEntity(dto, entity);
        return employeeUseCase.identify(entity);
    }

}
