package com.aura.controller;

import com.aura.dto.AutenticacaoResponse;
import com.aura.dto.LoginRequest;
import com.aura.dto.RegistroRequest;
import com.aura.service.AutenticacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "Autenticação",
        description = "Endpoints de registro e login"
)
@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
    private final AutenticacaoService autenticacaoService;

    public AutenticacaoController(AutenticacaoService autenticacaoService) {
        this.autenticacaoService = autenticacaoService;
    }

    @Operation(summary = "Cadastra usuário")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Cadastro realizado"
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "Email já cadastrado"
            )
    })
    @PostMapping("/register")
    public ResponseEntity<AutenticacaoResponse> registrar(@RequestBody RegistroRequest registroRequest) {
        return new ResponseEntity<>(autenticacaoService.registrar(registroRequest), HttpStatus.OK);
    }

    @Operation(summary = "Realiza login")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Login realizado"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Usuário não encontrado"
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Login incorreto"
            )
    })
    @PostMapping("/login")
    public ResponseEntity<AutenticacaoResponse> login(@RequestBody LoginRequest loginRequest) {
        return new ResponseEntity<>(autenticacaoService.login(loginRequest), HttpStatus.OK);
    }
}
