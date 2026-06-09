package com.aura.dto;

import com.aura.enums.Cargo;

import java.time.LocalDate;

public record RegistroRequest(
        LocalDate dataNascimento,
        String cpf,
        String nome,
        String email,
        String senha,
        Cargo cargo
) {
}
