package exe.gba.projetobidirecionalnested.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlunoCriacaoDto {

    private String nome;
    private String ra;
    private Integer professorId;
}
