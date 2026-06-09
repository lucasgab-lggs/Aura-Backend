package com.aura.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RegraDeNegocioException extends RuntimeException{
    private final HttpStatus status;

    public RegraDeNegocioException(String mensagem, HttpStatus status){
        super(mensagem);
        this.status = status;
    }
}
