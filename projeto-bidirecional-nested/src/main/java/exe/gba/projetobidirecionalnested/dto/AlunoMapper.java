package exe.gba.projetobidirecionalnested.dto;

import exe.gba.projetobidirecionalnested.entity.Aluno;

public class AlunoMapper {

    public static AlunoListagemDto toAlunoListagemDto(Aluno entity) {
        if (entity == null) return null;

        return AlunoListagemDto.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .ra(entity.getRa())
                .professor(
                        AlunoListagemDto.Professor.builder()
                            .id(entity.getProfessor().getId())
                            .nome(entity.getProfessor().getNome())
                            .build()
                )
                .build();

    }
}
