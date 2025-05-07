package com.uem.tarefaapi.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public record TarefaDTO(
    String tarefa,
    String descricao,
    String status,
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime dataFinal
) {
    
}
