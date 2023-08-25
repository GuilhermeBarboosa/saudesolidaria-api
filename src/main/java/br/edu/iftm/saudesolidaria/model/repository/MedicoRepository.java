package br.edu.iftm.saudesolidaria.model.repository;

import br.edu.iftm.saudesolidaria.model.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
