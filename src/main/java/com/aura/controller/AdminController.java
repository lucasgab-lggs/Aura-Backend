package com.aura.controller;

import com.aura.dto.AutenticacaoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/test")
    public ResponseEntity<AutenticacaoResponse> getAdminTest() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
