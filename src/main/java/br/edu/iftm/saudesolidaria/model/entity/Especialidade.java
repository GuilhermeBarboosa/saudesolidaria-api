package br.edu.iftm.saudesolidaria.model.entity;

import br.edu.iftm.saudesolidaria.model.defaults.DefaultEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "especialidades")
public class Especialidade  extends DefaultEntity implements Serializable {

    @Id
    @SequenceGenerator(name="gerador2", sequenceName="sequence_id_espec", allocationSize=1)
    @GeneratedValue(generator="gerador2", strategy=GenerationType.SEQUENCE)
    private Long id;

    @Size(max = 255)
    @NotNull
    @Column(name = "especialidade", nullable = false)
    private String especialidade;
}
