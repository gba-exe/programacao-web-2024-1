package school.sptech.projetofilmebidirecional.dto.filme;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class FilmeCriacaoDto {

    @NotBlank
    @Size(min = 3)
    private String titulo;

    @NotBlank
    @Size(min = 3)
    private String genero;

    @NotNull
    @Positive
    private Integer anoLancamento;

    @NotBlank
    @Size(min = 3, max = 255)
    private String sinopse;

    @NotNull
    @Positive
    private Integer diretorId;
}
