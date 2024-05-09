package school.sptech.projetofilmebidirecional.dto.filme;

import jakarta.persistence.ManyToOne;
import lombok.Data;
import school.sptech.projetofilmebidirecional.entity.Diretor;

@Data
public class FilmeListagemDto {

    private Integer id;
    private String titulo;
    private String genero;
    private Integer anoLancamento;
    private String sinopse;
    private FilmeDiretorListagemDto diretor;
}
