package br.edu.iftm.saudesolidaria.model.entity;

import br.edu.iftm.saudesolidaria.model.defaults.DefaultEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "consultas")
public class Consultas extends DefaultEntity implements Serializable {

    @Id
    @SequenceGenerator(name="gerador5", sequenceName="sequence_id_consulta", allocationSize=1)
    @GeneratedValue(generator="gerador5", strategy=GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @Column(name = "data", nullable = false)
    private Date data;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "medico", nullable = false)
    private Medico medico;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "local", nullable = false)
    private Local local;
}
