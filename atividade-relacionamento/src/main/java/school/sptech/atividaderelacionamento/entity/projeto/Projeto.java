package school.sptech.atividaderelacionamento.entity.projeto;

import jakarta.persistence.*;
import lombok.*;
import school.sptech.atividaderelacionamento.entity.tarefa.Tarefa;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    @OneToMany(mappedBy = "projeto")
    private List<Tarefa> tarefas;
}
