package com.aura.controller;

import com.aura.dto.AutenticacaoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profissional")
public class ProfissionalController {
    @GetMapping("/test")
    public ResponseEntity<AutenticacaoResponse> getProfissionaltest() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
