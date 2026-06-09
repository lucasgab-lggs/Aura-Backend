package com.aura.controller;

import com.aura.dto.AutenticacaoResponse;
import com.aura.dto.LoginRequest;
import com.aura.dto.RegistroRequest;
import com.aura.service.AutenticacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
    private final AutenticacaoService autenticacaoService;

    public AutenticacaoController(AutenticacaoService autenticacaoService) {
        this.autenticacaoService = autenticacaoService;
    }

    @PostMapping("/register")
    public ResponseEntity<AutenticacaoResponse> registrar(@RequestBody RegistroRequest registroRequest) {
        return new ResponseEntity<>(autenticacaoService.registrar(registroRequest), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AutenticacaoResponse> login(@RequestBody LoginRequest loginRequest) {
        return new ResponseEntity<>(autenticacaoService.login(loginRequest), HttpStatus.OK);
    }
}
