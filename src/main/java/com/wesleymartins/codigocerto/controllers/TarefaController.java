package com.wesleymartins.codigocerto.controllers;

import com.wesleymartins.codigocerto.entities.Tarefa;
import com.wesleymartins.codigocerto.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/tarefas")
public class TarefaController {
    @Autowired
    private TarefaService tarefaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Tarefa>> findById(Long id){
        return ResponseEntity.ok().body(tarefaService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> findAll(){
        List<Tarefa> tarefas = (List<Tarefa>) tarefaService.findAll();
        return ResponseEntity.ok().body(tarefas);
    }

    @PostMapping
    public ResponseEntity<Tarefa> insert(Tarefa tarefa) {
        return ResponseEntity.ok().body(tarefaService.insert(tarefa));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(Long id){
        tarefaService.delete(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Tarefa> update(Long id, Tarefa entity){
        return ResponseEntity.ok().body(tarefaService.update(entity, id));
    }
}
