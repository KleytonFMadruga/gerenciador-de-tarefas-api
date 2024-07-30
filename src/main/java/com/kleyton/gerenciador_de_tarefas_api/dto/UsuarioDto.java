package com.kleyton.gerenciador_de_tarefas_api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuarioDto {

	private Long id;

	@NotBlank
	private String nome;

}