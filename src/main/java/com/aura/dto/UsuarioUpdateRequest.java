package com.aura.dto;

import java.time.LocalDate;

public record UsuarioUpdateRequest(
        LocalDate dataNascimento,
        String nome,
        String email
) {
}
