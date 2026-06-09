package com.aura.service;

import com.aura.domain.Usuario;
import com.aura.dto.AutenticacaoResponse;
import com.aura.dto.LoginRequest;
import com.aura.dto.RegistroRequest;
import com.aura.enums.MensagemErro;
import com.aura.exception.ConflitoException;
import com.aura.exception.NaoAutorizadoException;
import com.aura.exception.NaoEncontradoException;
import com.aura.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder encoder;
    private final JWTService jwtService;

    public AutenticacaoService(UsuarioRepository usuarioRepository, PasswordEncoder encoder, JWTService jwtService) {
        this.usuarioRepository = usuarioRepository;
        this.encoder = encoder;
        this.jwtService = jwtService;
    }

    public AutenticacaoResponse registrar(RegistroRequest registroRequest) {

        boolean emailJaCadastrado = usuarioRepository.findByEmail(registroRequest.email()).isPresent();

        if  (emailJaCadastrado) {
            throw new ConflitoException(MensagemErro.EMAIL_CADASTRADO.getMensagem());
        }

        Usuario usuario = Usuario.builder()
                .dataNascimento(registroRequest.dataNascimento())
                .cpf(registroRequest.cpf())
                .nome(registroRequest.nome())
                .email(registroRequest.email())
                .senha(encoder.encode(registroRequest.senha()))
                .cargo(registroRequest.cargo())
                .estaAtivo(true)
                .build();

        usuarioRepository.save(usuario);

        String token = jwtService.gerarToken(usuario);
        return new AutenticacaoResponse(token);
    }

    public AutenticacaoResponse login(LoginRequest loginRequest) {
        Usuario usuario = usuarioRepository.findByEmail(loginRequest.email()).orElseThrow(
                () -> new NaoEncontradoException(MensagemErro.USUARIO_NAO_ENCONTRADO.getMensagem()));

        boolean senhaValida = encoder.matches(loginRequest.senha(), usuario.getSenha());

        if (!senhaValida) {
            throw new NaoAutorizadoException(MensagemErro.CREDENCIAIS_INVALIDAS.getMensagem());
        }

        String token = jwtService.gerarToken(usuario);
        return new AutenticacaoResponse(token);
    }
}
