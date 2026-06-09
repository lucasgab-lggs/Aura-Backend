package com.aura.exception;

import org.springframework.http.HttpStatus;

public class NaoAutorizadoException extends RegraDeNegocioException {
    public NaoAutorizadoException(String mensagem) {
        super(mensagem, HttpStatus.UNAUTHORIZED);
    }
}
