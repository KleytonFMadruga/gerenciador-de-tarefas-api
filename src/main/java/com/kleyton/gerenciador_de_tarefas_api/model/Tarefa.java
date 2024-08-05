package com.kleyton.gerenciador_de_tarefas_api.model;

import java.time.LocalDateTime;

import com.kleyton.gerenciador_de_tarefas_api.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "TAREFAS")
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	private String descricao;
	private LocalDateTime prazo;
	@Enumerated(EnumType.STRING)
	private Status status;
}
