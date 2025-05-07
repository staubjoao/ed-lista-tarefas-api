package com.uem.tarefaapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uem.tarefaapi.dto.TarefaDTO;
import com.uem.tarefaapi.model.Tarefa;
import com.uem.tarefaapi.repository.TarefaRepository;
import com.uem.tarefaapi.service.TarefaService;

@Service
public class TarefaServiceImpl implements TarefaService {

    private TarefaRepository tarefaRepository;

    @Autowired
    public TarefaServiceImpl (TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    @Override
    public List<Tarefa> buscarTodasTarefas() {
        List<Tarefa> listaDeTarefas = tarefaRepository.findAll();
        return listaDeTarefas;
    }

    @Override
    public Tarefa buscarTarefaPorId(Long id) {
        Optional<Tarefa> tarefaOp = tarefaRepository.findById(id);

        if (tarefaOp.isEmpty()) {
            return null;
        }

        return tarefaOp.get();
    }

    @Override
    public void deletarTarefaPorId(Long id) {
        Optional<Tarefa> tarefaOp = tarefaRepository.findById(id);

        if (tarefaOp.isEmpty()) {
            return;
        }

        tarefaRepository.delete(tarefaOp.get());
    }

    @Override
    public Tarefa salvarTarefa(TarefaDTO tarefaDTO) {
        Tarefa tarefaSave = new Tarefa();

        tarefaSave.setTarefa(tarefaDTO.tarefa());
        tarefaSave.setDescricao(tarefaDTO.descricao());
        tarefaSave.setStatus(tarefaDTO.status());
        tarefaSave.setDataFinal(tarefaDTO.dataFinal());

        return tarefaRepository.save(tarefaSave);
    }

    @Override
    public Tarefa atualizarTarefa(TarefaDTO tarefaDTO, Long id) {
        Optional<Tarefa> tarefaOp = tarefaRepository.findById(id);

        if (tarefaOp.isEmpty()) {
            return null;
        }

        Tarefa tarefa = tarefaOp.get();

        tarefa.setTarefa(tarefaDTO.tarefa());
        tarefa.setDescricao(tarefaDTO.descricao());
        tarefa.setStatus(tarefaDTO.status());
        tarefa.setDataFinal(tarefaDTO.dataFinal());

        return tarefaRepository.save(tarefa);
    }
    
}
