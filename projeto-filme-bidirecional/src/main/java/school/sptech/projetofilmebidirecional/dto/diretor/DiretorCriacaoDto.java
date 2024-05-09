package school.sptech.projetofilmebidirecional.dto.diretor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Singular;

import java.time.LocalDate;

@Data
public class DiretorCriacaoDto {

    @NotBlank
    @Size(min = 3)
    private String nome;

    @NotBlank
    private String nacionalidade;

    @NotNull
    @Past
    private LocalDate dataNascimento;
}
