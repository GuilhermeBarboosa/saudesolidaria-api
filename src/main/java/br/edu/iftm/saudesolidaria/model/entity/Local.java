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
@Table(name = "local")
public class Local extends DefaultEntity implements Serializable {

    @Id
    @SequenceGenerator(name="gerador3", sequenceName="sequence_id_local", allocationSize=1)
    @GeneratedValue(generator="gerador3", strategy=GenerationType.SEQUENCE)
    private Long id;

    @Size(max = 255)
    @NotNull
    @Column(name = "rua", nullable = false)
    private String rua;

    @Size(max = 255)
    @NotNull
    @Column(name = "bairro", nullable = false)
    private String bairro;

    @Size(max = 255)
    @NotNull
    @Column(name = "numero", nullable = false)
    private String numero;

    @Size(max = 255)
    @NotNull
    @Column(name = "nome_local", nullable = false)
    private String nome_local;


}
