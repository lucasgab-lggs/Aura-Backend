package com.aura.service;

import com.aura.domain.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class JWTService {
    // O token deveria ficar em um .env e ser maior por razões de segurança, mas estou simplificando.
    private static final String JWT_SECRET = "AUraPROJECT_APISecret@2026*";
    private static final String EMISSOR_TOKEN = "Aura Project - API 1.0";

    public String gerarToken(Usuario usuario) {
        Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);

        return JWT.create()
                .withIssuer(EMISSOR_TOKEN)
                .withSubject(usuario.getEmail())
                .withClaim(
                        "role",
                        usuario.getCargo().name()
                )
                .withExpiresAt(
                        Instant.now()
                                .plus(2, ChronoUnit.HOURS) // O token tem duração de 2 horas.
                )
                .sign(algorithm);
    }

    public DecodedJWT validarToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);

        return JWT.require(algorithm)
                .withIssuer(EMISSOR_TOKEN)
                .build()
                .verify(token);
    }
}
