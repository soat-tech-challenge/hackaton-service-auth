package br.com.grupo63.hackatonserviceauth.adapter;


import br.com.grupo63.hackatonserviceauth.controller.dto.EmployeeControllerDTO;
import br.com.grupo63.hackatonserviceauth.entity.employee.Employee;

public class EmployeeAdapter {

    public static void fillEntity(EmployeeControllerDTO dto, Employee entity) {

        entity.setId(dto.getId());
        entity.setRegistrationNumber(dto.getRegistrationNumber());
        entity.setPassword(dto.getPassword());

    }

}
