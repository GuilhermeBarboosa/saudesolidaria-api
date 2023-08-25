package br.edu.iftm.saudesolidaria.model.repository;

import br.edu.iftm.saudesolidaria.model.entity.Especialidade;
import br.edu.iftm.saudesolidaria.model.entity.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long> {
}
