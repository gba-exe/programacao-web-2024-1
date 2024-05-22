package school.sptech.atividaderelacionamento.dto.tarefa;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class TarefaListagemDto {

    private Integer id;
    private String nome;
    private String descricao;
    private boolean concluida;
    private String prioridade;
    private ProjetoListagemDto projeto;

    @Data
    @Builder
    public static class ProjetoListagemDto {
        private Integer id;
        private String nome;
        private String descricao;
        private LocalDate dataInicio;
        private LocalDate dataFim;
    }
}
