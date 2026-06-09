package com.aura.enums;

import lombok.Getter;

@Getter
public enum MensagemErro {

    CREDENCIAIS_INVALIDAS("Email ou senha inválidos!"),
    EMAIL_CADASTRADO("Email já cadastrado!"),
    USUARIO_NAO_ENCONTRADO("Usuário não encontrado!");

    private final String mensagem;

    MensagemErro(String mensagem) {
        this.mensagem = mensagem;
    }
}
