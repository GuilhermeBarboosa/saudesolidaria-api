package br.edu.iftm.saudesolidaria.model.repository;

import br.edu.iftm.saudesolidaria.model.entity.Consultas;
import br.edu.iftm.saudesolidaria.model.entity.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultasRepository extends JpaRepository<Consultas, Long> {
}
