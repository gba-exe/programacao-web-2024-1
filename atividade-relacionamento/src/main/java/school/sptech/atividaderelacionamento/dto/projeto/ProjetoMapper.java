package school.sptech.atividaderelacionamento.dto.projeto;

import school.sptech.atividaderelacionamento.entity.projeto.Projeto;
import school.sptech.atividaderelacionamento.entity.tarefa.Tarefa;

import java.util.List;

public class ProjetoMapper {

    public static ProjetoListagemDto toProjetoListagemDto(Projeto entity) {
        if (entity == null) return null;

        return ProjetoListagemDto.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .descricao(entity.getDescricao())
                .dataInicio(entity.getDataInicio())
                .dataFim(entity.getDataFim())
                .tarefas(toTarefaListagemDto(entity.getTarefas()))
                .build();
    }

    public static List<ProjetoListagemDto> toProjeoListagemDto(List<Projeto> entityList) {
        if (entityList == null) return null;

        return entityList.stream()
                .map(ProjetoMapper::toProjetoListagemDto)
                .toList();
    }

    public static Projeto toProjetoEntity(ProjetoCriacaoDto dto) {
        if (dto == null) return null;

        return Projeto.builder()
                .nome(dto.getNome())
                .descricao(dto.getDescricao())
                .dataInicio(dto.getDataInicio())
                .dataFim(dto.getDataFim())
                .build();
    }

    public static List<ProjetoListagemDto.TarefaListagemDto> toTarefaListagemDto(List<Tarefa> entities) {
        if (entities == null) return null;

        return entities.stream()
                .map(entity ->
                        ProjetoListagemDto.TarefaListagemDto.builder()
                                .id(entity.getId())
                                .nome(entity.getNome())
                                .descricao(entity.getDescricao())
                                .concluida(entity.isConcluida())
                                .prioridade(entity.getPrioridade())
                                .build())
                .toList();
    }

    public static List<Tarefa> toTarefaEntity(List<ProjetoListagemDto.TarefaListagemDto> dtos) {
        if (dtos == null) return null;

        return dtos.stream()
                .map(dto ->
                        Tarefa.builder()
                                .id(dto.getId())
                                .nome(dto.getNome())
                                .descricao(dto.getDescricao())
                                .concluida(dto.isConcluida())
                                .prioridade(dto.getPrioridade())
                                .build())
                .toList();
    }
}
