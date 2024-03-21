package br.com.grupo63.hackatonserviceauth.usecase.employee;

import br.com.grupo63.hackatonserviceauth.controller.dto.EmployeeControllerDTO;
import br.com.grupo63.hackatonserviceauth.entity.employee.Employee;
import br.com.grupo63.hackatonserviceauth.presenter.EmployeePresenter;
import br.com.grupo63.techchallenge.common.exception.NotFoundException;

public interface IEmployeeUseCase {

    EmployeeControllerDTO identify(Employee employee) throws NotFoundException;

}
