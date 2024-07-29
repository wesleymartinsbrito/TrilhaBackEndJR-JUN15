package com.wesleymartins.codigocerto.controllers;

import com.wesleymartins.codigocerto.entities.Tarefa;
import com.wesleymartins.codigocerto.services.TarefaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/tarefas", produces = {"application/json"})
@Tag(name = "codigo-certo")
public class TarefaController {
    @Autowired
    private TarefaService tarefaService;

    @Operation(summary = "Encontra tarefa por ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa encontrada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao encontrar a tarefa"),
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Tarefa>> findById(Long id){
        return ResponseEntity.ok().body(tarefaService.findById(id));
    }

    @Operation(summary = "Encontra todas tarefas", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa encontrada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao encontrar a tarefa"),
    })
    @GetMapping
    public ResponseEntity<List<Tarefa>> findAll(){
        List<Tarefa> tarefas = (List<Tarefa>) tarefaService.findAll();
        return ResponseEntity.ok().body(tarefas);
    }

    @Operation(summary = "Insere tarefas", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa inserida com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao inserir a tarefa"),
    })
    @PostMapping
    public ResponseEntity<Tarefa> insert(Tarefa tarefa) {
        return ResponseEntity.ok().body(tarefaService.insert(tarefa));
    }

    @Operation(summary = "Deleta tarefa por ID", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa deleta com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao deletar a tarefa"),
    })
    @DeleteMapping(value = "/{id}")
    public void delete(Long id){
        tarefaService.delete(id);
    }

    @Operation(summary = "Encontra tarefa por ID", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa atualizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar a tarefa"),
    })
    @PutMapping(value = "/{id}")
    public ResponseEntity<Tarefa> update(Long id, Tarefa entity){
        return ResponseEntity.ok().body(tarefaService.update(entity, id));
    }
}
