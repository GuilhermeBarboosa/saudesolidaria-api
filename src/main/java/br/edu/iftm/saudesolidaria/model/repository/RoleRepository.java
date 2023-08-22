package br.edu.iftm.saudesolidaria.model.repository;

import br.edu.iftm.saudesolidaria.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
