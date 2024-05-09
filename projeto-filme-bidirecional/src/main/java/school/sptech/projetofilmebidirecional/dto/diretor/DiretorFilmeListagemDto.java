package school.sptech.projetofilmebidirecional.dto.diretor;

import lombok.Data;

@Data
public class DiretorFilmeListagemDto {

    private Integer id;
    private String titulo;
    private String genero;
    private Integer anoLancamento;
    private String sinopse;
}
