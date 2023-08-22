package br.edu.iftm.saudesolidaria.model.output;

import br.edu.iftm.saudesolidaria.model.defaults.DefaultEntityDTO;
import br.edu.iftm.saudesolidaria.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserOutput extends DefaultEntityDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;

    private Long idRole;
    private String role;

    public UserOutput(User user) {
        this.id = user.getId();
        this.nome = user.getNome();
        this.cpf = user.getCpf();
        this.email = user.getEmail();
        this.senha = user.getSenha();
        this.idRole = user.getRole().getId();
        this.role = user.getRole().getRole();
        this.setActived(user.getActived());
        this.setCreated(user.getCreated());
        this.setUpdated(user.getUpdated());
    }

}
