package br.pucpr.projetowebservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;

    @NotNull(message = "NAME_REQUIRED")
    @NotBlank(message = "NAME_REQUIRED")
    private String nome;

    @Email
    @NotBlank(message = "EMAIL_REQUIRED")
    private String email;

    @NotBlank(message = "SENHA_REQUIRED")
    private String senha;

    private LocalDate data;
}
