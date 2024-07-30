package com.kleyton.gerenciador_de_tarefas_api.dto;

import java.util.List;

import com.kleyton.gerenciador_de_tarefas_api.model.Tarefa;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuarioDto {

	private Long id;

	@NotBlank
	private String nome;

	private List<Tarefa> tarefas;
}
