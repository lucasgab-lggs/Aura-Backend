package com.aura.filter;

import com.aura.domain.Usuario;
import com.aura.enums.MensagemErro;
import com.aura.exception.NaoEncontradoException;
import com.aura.repository.UsuarioRepository;
import com.aura.service.JWTService;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JWTFilter extends OncePerRequestFilter {
    private final JWTService jwtService;
    private final UsuarioRepository usuarioRepository;

    public JWTFilter(JWTService jwtService, UsuarioRepository usuarioRepository) {
        this.jwtService = jwtService;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String cabecalhoAutenticacao = request.getHeader("Authorization");

        if (cabecalhoAutenticacao != null && cabecalhoAutenticacao.startsWith("Bearer ")) {
            String token = cabecalhoAutenticacao.replace("Bearer ", "");
            DecodedJWT decodedJWT = jwtService.validarToken(token);
            String email = decodedJWT.getSubject();
            String cargo =  decodedJWT.getClaim("role").asString();
            Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(() ->
                    new NaoEncontradoException(MensagemErro.USUARIO_NAO_ENCONTRADO.getMensagem()));
            List<GrantedAuthority> autoridades = List.of(new SimpleGrantedAuthority(
                    "ROLE_"+ cargo
            ));
            UsernamePasswordAuthenticationToken autenticacao = new UsernamePasswordAuthenticationToken(
                    usuario,
                    null,
                    autoridades
            );
            SecurityContextHolder.getContext().setAuthentication(autenticacao);
        }

        filterChain.doFilter(request, response);
    }
}
