package br.edu.iftm.saudesolidaria.model.output;

import br.edu.iftm.saudesolidaria.model.defaults.DefaultEntityDTO;
import br.edu.iftm.saudesolidaria.model.entity.Especialidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EspecialidadeOutput extends DefaultEntityDTO {

    private Long id;
    private String especialidade;

    public EspecialidadeOutput(Especialidade especialidade) {
        this.id = especialidade.getId();
        this.especialidade = especialidade.getEspecialidade();
        this.setActived(especialidade.getActived());
        this.setCreated(especialidade.getCreated());
        this.setUpdated(especialidade.getUpdated());
    }
}
