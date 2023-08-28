package br.edu.iftm.saudesolidaria.model.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultasInput {
    private Date data;

    private Long medico;

    private Long local;
}
