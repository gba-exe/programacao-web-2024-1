package school.sptech.projetofilmebidirecional.dto.filme;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FilmeDiretorListagemDto {

    private Integer id;
    private String nome;
    private String nacionalidade;
    private LocalDate dataNascimento;
}
