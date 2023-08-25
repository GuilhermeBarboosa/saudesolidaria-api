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
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medicos")
public class Medico extends DefaultEntity implements Serializable {

    @Id
    @SequenceGenerator(name="gerador4", sequenceName="sequence_id_medico", allocationSize=1)
    @GeneratedValue(generator="gerador4", strategy=GenerationType.SEQUENCE)
    private Long id;

    @Size(max = 255)
    @NotNull
    @Column(name = "crm", nullable = false)
    private String crm;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users", nullable = false)
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "especialidade", nullable = false)
    private Especialidade especialidade;
}
