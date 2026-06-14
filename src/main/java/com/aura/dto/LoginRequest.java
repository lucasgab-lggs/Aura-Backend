package com.aura.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginRequest(
        @Schema(
                example = "seuemail@email.com",
                description = "Email do usuário"
        )
        String email,

        @Schema(
                example = "123321",
                description = "Senha do usuario"
        )
        String senha
) {}
