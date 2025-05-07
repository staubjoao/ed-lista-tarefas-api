package com.uem.tarefaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uem.tarefaapi.dto.TarefaDTO;
import com.uem.tarefaapi.model.Tarefa;
import com.uem.tarefaapi.service.impl.TarefaServiceImpl;

@RestController
@RequestMapping("/tarefa")
@CrossOrigin(origins = "*")
public class TarefaController {
    
    // localhost:8080/tarefa   GET
    // localhost:8080/tarefa/1 GET
    // localhost:8080/tarefa/1 PUT

    private TarefaServiceImpl service;

    @Autowired
    public TarefaController (TarefaServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public List<Tarefa> buscarTodasTarefas(){
        return service.buscarTodasTarefas();
    }

    @GetMapping("/{id}")
    public Tarefa buscarTarefaPorId(@PathVariable("id") Long idTarefa) {
        return service.buscarTarefaPorId(idTarefa);
    }

    @PostMapping
    public Tarefa salvarNovaTarefa(@RequestBody TarefaDTO tarefaDTO) {
        return service.salvarTarefa(tarefaDTO);
    }

    @PutMapping("/{id}")
    public Tarefa atualizarTarefa(
        @RequestBody TarefaDTO tarefaDTO, 
        @PathVariable("id") Long idTarefa
        ) {
        return service.atualizarTarefa(tarefaDTO, idTarefa);
    }

    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable("id") Long idTarefa) {
        service.deletarTarefaPorId(idTarefa);
    }

}
