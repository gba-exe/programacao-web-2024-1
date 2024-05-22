package school.sptech.atividaderelacionamento.dto.projeto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProjetoCriacaoDto {

    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    @NotNull
    @FutureOrPresent
    private LocalDate dataInicio;
    @NotNull
    @Future
    private LocalDate dataFim;
}
