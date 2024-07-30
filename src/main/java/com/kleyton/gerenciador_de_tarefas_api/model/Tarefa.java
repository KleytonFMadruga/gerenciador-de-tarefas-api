package com.kleyton.gerenciador_de_tarefas_api.model;

import java.time.LocalDateTime;

import com.kleyton.gerenciador_de_tarefas_api.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
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
	private Status status;
}
