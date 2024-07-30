package com.kleyton.gerenciador_de_tarefas_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.kleyton.gerenciador_de_tarefas_api.enums.Status;
import com.kleyton.gerenciador_de_tarefas_api.model.Tarefa;
import com.kleyton.gerenciador_de_tarefas_api.model.Usuario;
import com.kleyton.gerenciador_de_tarefas_api.repositories.TarefaRepository;
import com.kleyton.gerenciador_de_tarefas_api.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TarefaService {

	@Autowired
	private final UsuarioRepository usuarioRepository;

	@Autowired
	private final TarefaRepository tarefaRepository;

	@Transactional
	public Tarefa adicionarTarefa(Long idUsuario, Tarefa tarefa) {
		Usuario usuario = usuarioRepository.findById(idUsuario)
				.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + idUsuario));

		tarefa.setUsuario(usuario);
		tarefa.setStatus(Status.PENDENTE);
		return tarefaRepository.save(tarefa);
	}

	@Transactional
	public List<Tarefa> getTarefasPorUsuario(Long idUsuario) {
		Usuario usuario = usuarioRepository.findById(idUsuario)
				.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + idUsuario));

		return usuario.getTarefas();
	}
}
