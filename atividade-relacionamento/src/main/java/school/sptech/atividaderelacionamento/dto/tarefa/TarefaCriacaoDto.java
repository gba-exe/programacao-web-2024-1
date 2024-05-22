package school.sptech.atividaderelacionamento.dto.tarefa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TarefaCriacaoDto {

    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    @NotBlank
    private String prioridade;
    @NotNull
    private Integer projetoId;
}
