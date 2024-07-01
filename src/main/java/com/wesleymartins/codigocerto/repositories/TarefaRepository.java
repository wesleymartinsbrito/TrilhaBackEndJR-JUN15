package com.wesleymartins.codigocerto.repositories;

import com.wesleymartins.codigocerto.entities.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
