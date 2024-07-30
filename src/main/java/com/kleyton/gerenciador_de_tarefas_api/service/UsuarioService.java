package com.kleyton.gerenciador_de_tarefas_api.service;

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
}
