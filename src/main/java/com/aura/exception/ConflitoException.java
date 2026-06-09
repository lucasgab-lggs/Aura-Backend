package com.aura.exception;

import org.springframework.http.HttpStatus;

public class ConflitoException extends RegraDeNegocioException {
    public ConflitoException(String mensagem) {
        super(mensagem, HttpStatus.CONFLICT);
    }
}
