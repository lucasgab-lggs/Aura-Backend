package com.aura.exception;

import java.time.LocalDateTime;

public record ErroResponse(
        int status,
        String mensagem,
        String caminho,
        LocalDateTime timestamp
) {
}
