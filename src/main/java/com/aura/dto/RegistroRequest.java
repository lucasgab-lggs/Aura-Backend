package com.aura.dto;

import com.aura.enums.Cargo;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public record RegistroRequest(
        @Schema(
                example = "2000-01-01",
                description = "Data de nascimento do usuário"
        )
        LocalDate dataNascimento,

        @Schema(
                example = "123.456.789-00",
                description = "CPF do usuário"
        )
        String cpf,

        @Schema(
                example = "Fulano da Silva",
                description = "Nome completo do usuário"
        )
        String nome,

        @Schema(
                example = "seuemail@email.com",
                description = "Email do usuário"
        )
        String email,

        @Schema(
                example = "123321",
                description = "Senha do usuário"
        )
        String senha,

        @Schema(
                example = "USUARIO",
                description = "Cargo do usuario (ADMIN, PROFISSIONAL ou USUARIO)"
        )
        Cargo cargo
) {
}
