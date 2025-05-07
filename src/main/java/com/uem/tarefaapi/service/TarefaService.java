package com.uem.tarefaapi.service;

import com.uem.tarefaapi.dto.TarefaDTO;
import com.uem.tarefaapi.model.Tarefa;
import java.util.List;

public interface TarefaService {
    
    List<Tarefa> buscarTodasTarefas();

    Tarefa buscarTarefaPorId(Long id);

    void deletarTarefaPorId(Long id);

    Tarefa salvarTarefa(TarefaDTO tarefaDTO);

    Tarefa atualizarTarefa(TarefaDTO tarefaDTO, Long id);

}
