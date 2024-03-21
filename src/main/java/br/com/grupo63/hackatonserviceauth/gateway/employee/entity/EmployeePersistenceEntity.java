package br.com.grupo63.hackatonserviceauth.gateway.employee.entity;

import br.com.grupo63.hackatonserviceauth.entity.employee.Employee;
import br.com.grupo63.techchallenge.common.gateway.repository.entity.PersistenceEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter

@Entity
@Table(name = "emp_employee", indexes = {})
public class EmployeePersistenceEntity extends PersistenceEntity {

    @Column(name = "registration_number", nullable = false, unique = true)
    private String registrationNumber;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    public EmployeePersistenceEntity(Employee employee) {
        this.id = employee.getId();
        this.registrationNumber = employee.getRegistrationNumber();
        this.password = employee.getPassword();
        this.email = employee.getEmail();
    }

    public Employee toModel() {
        return new Employee(this.getId(), this.getPassword(), this.getRegistrationNumber(), this.getEmail());
    }

}
