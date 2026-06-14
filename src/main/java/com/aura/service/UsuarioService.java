package com.aura.service;

import com.aura.domain.Usuario;
import com.aura.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // 1. Cadastrar
    public Usuario cadastrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // 2. Listar Todos
    public List<Usuario> listarTodos() {
        return StreamSupport
                .stream(usuarioRepository.findAll().spliterator(), false)
                .toList();
    }

    // 3. Buscar por ID
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + id));
    }

    // 4. Atualizar
    public Usuario atualizarUsuario(Long id, Usuario dadosNovos) {
        Usuario usuarioExistente = buscarPorId(id);
        
        usuarioExistente.setNome(dadosNovos.getNome());
        usuarioExistente.setEmail(dadosNovos.getEmail());
        usuarioExistente.setCpf(dadosNovos.getCpf());
        usuarioExistente.setCargo(dadosNovos.getCargo());
        usuarioExistente.setEstaAtivo(dadosNovos.isEstaAtivo());
        
        return usuarioRepository.save(usuarioExistente);
    }

    // 5. Deletar
    public void deletarUsuario(Long id) {
        Usuario usuario = buscarPorId(id);
        usuarioRepository.delete(usuario);
    }
}