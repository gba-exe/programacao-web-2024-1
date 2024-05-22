package school.sptech.atividaderelacionamento.dto.tarefa;

import school.sptech.atividaderelacionamento.dto.projeto.ProjetoMapper;
import school.sptech.atividaderelacionamento.entity.projeto.Projeto;
import school.sptech.atividaderelacionamento.entity.tarefa.Tarefa;

import java.util.List;

public class TarefaMapper {

    public static TarefaListagemDto toTarefaListagemDto(Tarefa entity) {
        if (entity == null) return null;

        return TarefaListagemDto.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .descricao(entity.getDescricao())
                .concluida(entity.isConcluida())
                .prioridade(entity.getPrioridade())
                .projeto(toProjetoListagemDto(entity.getProjeto()))
                .build();
    }

    public static List<TarefaListagemDto> toTarefaListagemDto(List<Tarefa> entities) {
        if (entities == null) return null;

        return entities.stream()
                .map(TarefaMapper::toTarefaListagemDto)
                .toList();
    }

    public static Tarefa toEntity(TarefaCriacaoDto dto) {
        if (dto == null) return null;

        return Tarefa.builder()
                .nome(dto.getNome())
                .descricao(dto.getDescricao())
                .prioridade(dto.getPrioridade())
                .build();
    }

    public static TarefaListagemDto.ProjetoListagemDto toProjetoListagemDto(Projeto entity) {
        if (entity == null) return null;

        return TarefaListagemDto.ProjetoListagemDto.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .descricao(entity.getDescricao())
                .dataInicio(entity.getDataInicio())
                .dataFim(entity.getDataFim())
                .build();
    }
}
