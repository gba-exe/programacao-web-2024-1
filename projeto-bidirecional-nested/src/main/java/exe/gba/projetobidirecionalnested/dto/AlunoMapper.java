package exe.gba.projetobidirecionalnested.dto;

import exe.gba.projetobidirecionalnested.entity.Aluno;

public class AlunoMapper {

    public static AlunoListagemDto toAlunoListagemDto(Aluno entity) {
        if (entity == null) return null;

        return AlunoListagemDto.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .ra(entity.getRa())
                .professor(toProfessor(entity))
                .build();

    }

    public static AlunoListagemDto.Professor toProfessor (Aluno entity) {
        if (entity == null) return null;

        return AlunoListagemDto.Professor.builder()
                .id(entity.getProfessor().getId())
                .nome(entity.getProfessor().getNome())
                .build();
    }

    public static Aluno toAlunoEntity(AlunoCriacaoDto dto) {
        if (dto == null) return null;

        return Aluno.builder()
                .nome(dto.getNome())
                .ra(dto.getRa())
                .build();
    }
}
