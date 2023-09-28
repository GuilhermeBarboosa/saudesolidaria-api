package br.edu.iftm.saudesolidaria.model.output;

import br.edu.iftm.saudesolidaria.model.defaults.DefaultEntityDTO;
import br.edu.iftm.saudesolidaria.model.entity.Consultas;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultasOutput extends DefaultEntityDTO {

    private Long id;
    private String data;

    private Long id_medico;
    private String crm;
    private String nome_medico;
    private String cpf_medico;
    private String especialidade;

    private Long id_local;
    private String rua;
    private String bairro;
    private String numero;
    private String nome_local;

    public ConsultasOutput(Consultas consulta) {
        this.id = consulta.getId();
        this.data = consulta.getData().toString();
        this.id_medico = consulta.getMedico().getId();
        this.crm = consulta.getMedico().getCrm();
        this.nome_medico = consulta.getMedico().getUser().getNome();
        this.cpf_medico = consulta.getMedico().getUser().getCpf();
        this.id_local = consulta.getLocal().getId();
        this.rua = consulta.getLocal().getRua();
        this.bairro = consulta.getLocal().getBairro();
        this.numero = consulta.getLocal().getNumero();
        this.especialidade = consulta.getMedico().getEspecialidade().getEspecialidade();
        this.nome_local = consulta.getLocal().getNome_local();
        this.setActived(consulta.getActived());
        this.setCreated(consulta.getCreated());
        this.setUpdated(consulta.getUpdated());
    }


}
