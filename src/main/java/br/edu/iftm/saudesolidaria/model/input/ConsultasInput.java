package br.edu.iftm.saudesolidaria.model.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ConsultasInput {
    private Date data;

    private Long medico;

    private Long local;
}
