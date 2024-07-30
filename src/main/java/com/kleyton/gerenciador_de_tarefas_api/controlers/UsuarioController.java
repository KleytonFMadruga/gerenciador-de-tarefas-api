package com.kleyton.gerenciador_de_tarefas_api.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kleyton.gerenciador_de_tarefas_api.dto.TarefaDto;
import com.kleyton.gerenciador_de_tarefas_api.dto.UsuarioDto;
import com.kleyton.gerenciador_de_tarefas_api.model.Tarefa;
import com.kleyton.gerenciador_de_tarefas_api.model.Usuario;
import com.kleyton.gerenciador_de_tarefas_api.service.TarefaService;
import com.kleyton.gerenciador_de_tarefas_api.service.UsuarioService;
import com.kleyton.gerenciador_de_tarefas_api.service.utils.MapperUtils;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

	@Autowired
	private final UsuarioService usuarioService;

	@Autowired
	private final TarefaService tarefaService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioDto salvaUsuario(@RequestBody @Valid UsuarioDto usuarioDto) {
		return MapperUtils.map(usuarioService.cadastraUsuario(MapperUtils.map(usuarioDto, Usuario.class)),
				UsuarioDto.class);
	}

	@PostMapping("/{id_usuario}/tarefas")
	@ResponseStatus(HttpStatus.CREATED)
	public TarefaDto adicionarTarefa(@PathVariable("id_usuario") Long idUsuario, @RequestBody TarefaDto tarefaDto) {

		return MapperUtils.map(tarefaService.adicionarTarefa(idUsuario, MapperUtils.map(tarefaDto, Tarefa.class)),
				TarefaDto.class);

	}

	@GetMapping("/{id_usuario}/tarefas")
	public List<Tarefa> getTarefas(@PathVariable("id_usuario") Long idUsuario) {

		return tarefaService.getTarefasPorUsuario(idUsuario);
	}

	@GetMapping("/{id_usuario}/tarefas/{id_tarefa}")
	public Tarefa getTarefa(@PathVariable("id_usuario") Long idUsuario, @PathVariable("id_tarefa") Long idTarefa) {

		return tarefaService.getTarefa(idUsuario, idTarefa);
	}

	@PutMapping("/{id_usuario}/tarefas/{id_tarefa}")
	public TarefaDto atualizarTarefa(@PathVariable("id_usuario") Long idUsuario,
			@PathVariable("id_tarefa") Long idTarefa, @RequestBody TarefaDto tarefaDto) {

		return MapperUtils.map(
				tarefaService.atualizarTarefa(idUsuario, idTarefa, MapperUtils.map(tarefaDto, Tarefa.class)),
				TarefaDto.class);
	}
}