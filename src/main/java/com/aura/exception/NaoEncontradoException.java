package com.aura.exception;

import org.springframework.http.HttpStatus;

public class NaoEncontradoException extends RegraDeNegocioException {
    public NaoEncontradoException(String mensagem) {
        super(mensagem, HttpStatus.NOT_FOUND);
    }
}
