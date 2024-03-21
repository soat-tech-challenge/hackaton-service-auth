package br.com.grupo63.hackatonserviceauth.entity.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {

    private Long id;
    private String password;
    private String registrationNumber;
    private String email;

}
