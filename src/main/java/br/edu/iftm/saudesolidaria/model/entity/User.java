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
@Table(name = "users")
public class User  extends DefaultEntity implements Serializable {

    @Id
    @SequenceGenerator(name="gerador1", sequenceName="sequence_id_user", allocationSize=1)
    @GeneratedValue(generator="gerador1", strategy=GenerationType.SEQUENCE)
    private Long id;

    @Size(max = 255)
    @NotNull
    @Column(name = "nome", nullable = false)
    private String nome;

    @Size(max = 30)
    @NotNull
    @Column(name = "cpf", nullable = false, length = 30)
    private String cpf;

    @Size(max = 40)
    @NotNull
    @Column(name = "email", nullable = false, length = 40)
    private String email;

    @Size(max = 255)
    @NotNull
    @Column(name = "senha", nullable = false, length = 255)
    private String senha;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role", nullable = false)
    private Role role;

    public boolean isAdmin(){
        if(this.role.getRole().equals("ADMIN")){
            return true;
        }else{
            return false;
        }
    }

}