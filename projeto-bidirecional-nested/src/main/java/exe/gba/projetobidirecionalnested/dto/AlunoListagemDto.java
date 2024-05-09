package exe.gba.projetobidirecionalnested.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlunoListagemDto {

    private Integer id;
    private String nome;
    private String ra;
    private Professor professor;

    @Data
    @Builder
    public static class Professor {
        private Integer id;
        private String nome;
    }
}
