package com.aura.controller;

import com.aura.dto.AutenticacaoResponse;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "Administração",
        description = "Endpoints exclusivos de administradores"
)
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Hidden
    @GetMapping("/test")
    public ResponseEntity<AutenticacaoResponse> getAdminTest() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
