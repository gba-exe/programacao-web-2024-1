package school.sptech.projetofilmebidirecional.dto.diretor;

import lombok.Data;
import school.sptech.projetofilmebidirecional.dto.filme.FilmeListagemDto;
import school.sptech.projetofilmebidirecional.entity.Filme;

import java.time.LocalDate;
import java.util.List;

@Data
public class DiretorListagemDto {

    private Integer id;
    private String nome;
    private String nacionalidade;
    private LocalDate dataNascimento;

    private List<DiretorFilmeListagemDto> filmes;
}
