package com.kleyton.gerenciador_de_tarefas_api.service;

import java.util.Optional;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.kleyton.gerenciador_de_tarefas_api.model.Usuario;
import com.kleyton.gerenciador_de_tarefas_api.repositories.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	public Usuario cadastraUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Usuario getUsuario(Long idUsuario) {
		Optional<Usuario> usuarioOpt = usuarioRepository.findById(idUsuario);
		return usuarioOpt.orElse(null);
	}

	public Usuario atualizaUsuario(Long idUsuario, Usuario usuarioAtualizado) {
		Usuario usuarioExistente = usuarioRepository.findById(idUsuario)
				.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + idUsuario));
		if (usuarioAtualizado.getNome() != null) {
			usuarioExistente.setNome(usuarioAtualizado.getNome());
		}
		return usuarioRepository.save(usuarioExistente);
	}

	public void deletaUsuario(Long idUsuario) {
		Usuario usuarioExistente = usuarioRepository.findById(idUsuario)
				.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + idUsuario));
		usuarioRepository.deleteById(idUsuario);
	}
}
