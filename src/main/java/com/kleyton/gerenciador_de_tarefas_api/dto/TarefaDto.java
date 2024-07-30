package com.kleyton.gerenciador_de_tarefas_api.dto;

import java.time.LocalDateTime;

import com.kleyton.gerenciador_de_tarefas_api.enums.Status;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TarefaDto {

	private Long id;
	@NotBlank
	private String descricao;
	private LocalDateTime prazo;
	private Status status;
}
