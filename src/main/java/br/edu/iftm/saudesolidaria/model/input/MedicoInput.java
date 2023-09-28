package br.edu.iftm.saudesolidaria.model.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Null;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoInput {

    private String nome;

    private String cpf;

    private String email;

    private String senha;

    private Long role;


    private String crm;

    private Long id_user;

    private Long especialidade;
}
