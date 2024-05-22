package school.sptech.atividaderelacionamento.entity.tarefa;

import jakarta.persistence.*;
import lombok.*;
import school.sptech.atividaderelacionamento.entity.projeto.Projeto;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private boolean concluida;
    private String prioridade;

    @ManyToOne
    private Projeto projeto;
}
