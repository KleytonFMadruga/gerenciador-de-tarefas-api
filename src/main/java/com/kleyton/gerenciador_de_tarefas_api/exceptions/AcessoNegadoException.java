package com.kleyton.gerenciador_de_tarefas_api.exceptions;

public class AcessoNegadoException extends RuntimeException {
	public AcessoNegadoException(String message) {
		super(message);
	}
}
