package exe.gba.projetobidirecionalnested.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProfessorListagemDto {

    private Integer id;
    private String nome;
    private List<Aluno> alunos;

    @Data
    @Builder
    public static class Aluno {
        private Integer id;
        private String nome;
        private String ra;
    }
}
