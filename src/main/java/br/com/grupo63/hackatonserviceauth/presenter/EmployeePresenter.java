package br.com.grupo63.hackatonserviceauth.presenter;

import br.com.grupo63.hackatonserviceauth.controller.dto.EmployeeControllerDTO;
import br.com.grupo63.hackatonserviceauth.entity.employee.Employee;

public class EmployeePresenter {

    public static EmployeeControllerDTO toDto(Employee entity) {
        EmployeeControllerDTO dto = new EmployeeControllerDTO();

        dto.setId(entity.getId());
        dto.setRegistrationNumber(entity.getRegistrationNumber());
        dto.setEmail(entity.getEmail());

        return dto;
    }

}
