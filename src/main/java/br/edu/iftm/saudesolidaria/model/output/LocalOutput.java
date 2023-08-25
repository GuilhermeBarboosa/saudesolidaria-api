package br.edu.iftm.saudesolidaria.model.output;

import br.edu.iftm.saudesolidaria.model.defaults.DefaultEntityDTO;
import br.edu.iftm.saudesolidaria.model.entity.Local;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalOutput extends DefaultEntityDTO {

    private Long id;
    private String rua;
    private String bairro;
    private String numero;
    private String nome_local;

    public LocalOutput(Local local) {
        this.id = local.getId();
        this.rua = local.getRua();
        this.bairro = local.getBairro();
        this.numero = local.getNumero();
        this.nome_local = local.getNome_local();
        this.setActived(local.getActived());
        this.setCreated(local.getCreated());
        this.setUpdated(local.getUpdated());
    }
}
