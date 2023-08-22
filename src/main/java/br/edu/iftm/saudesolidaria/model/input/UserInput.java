package br.edu.iftm.saudesolidaria.model.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInput {

    private String nome;

    private String cpf;

    private String email;

    private String senha;

    private Long role;
}
