package exe.gba.projetobidirecionalnested.dto;

import exe.gba.projetobidirecionalnested.entity.Professor;

import java.util.List;

public class ProfessorMapper {

    public static ProfessorListagemDto toProfessorListagemDto(Professor entity) {
        if (entity == null) return null;

        return ProfessorListagemDto.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .alunos(
                        entity.getAlunos().stream()
                            .map(aluno ->
                                    ProfessorListagemDto.Aluno.builder()
                                        .id(aluno.getId())
                                        .nome(aluno.getNome())
                                        .ra(aluno.getRa())
                                        .build())
                            .toList()
                )
                .build();
    }
}
