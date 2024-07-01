package com.wesleymartins.codigocerto.services;

import com.wesleymartins.codigocerto.entities.Tarefa;
import com.wesleymartins.codigocerto.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;

    @Transactional(readOnly = true)
    public Optional<Tarefa> findById(Long id){
        return tarefaRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Tarefa findAll(){
        List<Tarefa> list = tarefaRepository.findAll();
        return (Tarefa) list;
    }

    @Transactional(readOnly = false)
    public Tarefa insert(Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }

    @Transactional(readOnly = false)
    public Tarefa update(Tarefa tarefa, Long id){
        Tarefa obj = tarefaRepository.getReferenceById(id);
        updateTarefa(obj, tarefa);
        return tarefaRepository.save(obj);
    }

    private void updateTarefa(Tarefa obj, Tarefa tarefa) {
        obj.setNome(tarefa.getNome());
        obj.setDescricao(tarefa.getDescricao());
    }

    @Transactional(readOnly = false)
    private void delete(Long id){
        tarefaRepository.deleteById(id);
    }
}
