package com.kleyton.gerenciador_de_tarefas_api.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kleyton.gerenciador_de_tarefas_api.enums.Status;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TarefaDto {

	private Long id;
	@NotBlank
	private String descricao;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime prazo;
	private Status status;
}
