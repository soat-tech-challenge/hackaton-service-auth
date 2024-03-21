package br.com.grupo63.hackatonserviceauth.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeControllerDTO extends AbstractControllerDTO {

    @Schema(example = "01234567890")
    private String registrationNumber;

    @Schema(example = "abc12345")
    private String password;

    @Schema(example = "example@example.com")
    private String email;

}
