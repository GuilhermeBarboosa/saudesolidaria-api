package br.edu.iftm.saudesolidaria.model.output;

import br.edu.iftm.saudesolidaria.model.defaults.DefaultEntityDTO;
import br.edu.iftm.saudesolidaria.model.entity.Medico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoOutput extends DefaultEntityDTO {

    private Long id;
    private String crm;

    //UserOutput
    private Long id_user;
    private String nome_user;
    private String cpf_user;
    private String email_user;

    private Long id_role;
    private String role;

    private Long id_especialidade;
    private String especialidade;

    public MedicoOutput(Medico medico) {
        this.id = medico.getId();
        this.crm = medico.getCrm();
        this.id_user = medico.getUser().getId();
        this.nome_user = medico.getUser().getNome();
        this.cpf_user = medico.getUser().getCpf();
        this.id_role = medico.getUser().getRole().getId();
        this.role = medico.getUser().getRole().getRole();
        this.id_especialidade = medico.getEspecialidade().getId();
        this.especialidade = medico.getEspecialidade().getEspecialidade();
        this.email_user = medico.getUser().getEmail();
        this.setActived(medico.getActived());
        this.setCreated(medico.getCreated());
        this.setUpdated(medico.getUpdated());
    }

}
