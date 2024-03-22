package br.com.grupo63.hackatonserviceauth.api.controller.employee;

import br.com.grupo63.hackatonserviceauth.config.JwtService;
import br.com.grupo63.hackatonserviceauth.controller.EmployeeController;
import br.com.grupo63.hackatonserviceauth.controller.dto.EmployeeControllerDTO;
import br.com.grupo63.techchallenge.common.api.controller.AbstractAPIController;
import br.com.grupo63.techchallenge.common.exception.NotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Tag(name = "empregados", description = "CRUD de empregados para gerenciamento")
@RequiredArgsConstructor
@RestController
@RequestMapping("/authentication")
public class EmployeeAPIController extends AbstractAPIController {

    private final EmployeeController employeeController;
    private final JwtService jwtService;

    @Operation(
            tags = "1ª chamada - Fluxo principal - Identificação",
            summary = "Identificar o empregado (Utilizado pelo Lambda de identificação)",
            description = "Recupera o ID do empregado caso ele exista")
    @PostMapping("/login")
    public ResponseEntity<String> identify(@RequestParam String registrationNumber, @RequestParam String password) {
        try {
            EmployeeControllerDTO employeeDTO = new EmployeeControllerDTO(registrationNumber, password, null);
            EmployeeControllerDTO existingEmployee = employeeController.identify(employeeDTO);
            String token = jwtService.createToken(Long.toString(existingEmployee.getId()), existingEmployee.getEmail());

            return ResponseEntity.ok(token);
        } catch (NotFoundException exception) {
            return ResponseEntity.notFound().build();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
