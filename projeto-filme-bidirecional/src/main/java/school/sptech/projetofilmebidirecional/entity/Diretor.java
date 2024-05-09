package school.sptech.projetofilmebidirecional.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Diretor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String nacionalidade;
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "diretor")
    private List<Filme> filmes;
}
