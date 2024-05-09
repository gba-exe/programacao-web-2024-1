package exe.gba.projetoconsultorio.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// @ToString
// @Data - Nao usar em Entity, somente Dto
@Builder
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private LocalDate dataAgendamento;
    private Double preco;
    private String local;

    @ManyToOne
//    @JoinColumn(name = "fk_medico") - caso coluna se chama fk_medico
//    @JoinColumn(name = "medico_id") - padrao, nao precisa nem colocar
    private Medico medico;
}
