package exe.gba.projetobidirecionalnested.service;

import exe.gba.projetobidirecionalnested.dto.ProfessorListagemDto;
import exe.gba.projetobidirecionalnested.entity.Professor;
import exe.gba.projetobidirecionalnested.entity.exception.NaoEncontradoException;
import exe.gba.projetobidirecionalnested.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public Professor porId(Integer id) {
        return professorRepository.findById(id).orElseThrow(
                () -> new NaoEncontradoException("Professor")
        );
    }


}
