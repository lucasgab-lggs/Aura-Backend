package com.aura.exception;

import org.springframework.http.HttpStatus;

public class AcessoProibidoException extends RegraDeNegocioException {
    public AcessoProibidoException(String mensagem) {
        super(mensagem, HttpStatus.FORBIDDEN);
    }
}
