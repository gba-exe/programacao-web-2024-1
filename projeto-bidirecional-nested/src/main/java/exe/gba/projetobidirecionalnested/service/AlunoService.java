package exe.gba.projetobidirecionalnested.service;

import exe.gba.projetobidirecionalnested.entity.Aluno;
import exe.gba.projetobidirecionalnested.entity.Professor;
import exe.gba.projetobidirecionalnested.entity.exception.ConflitoException;
import exe.gba.projetobidirecionalnested.entity.exception.NaoEncontradoException;
import exe.gba.projetobidirecionalnested.repository.AlunoRepository;
import exe.gba.projetobidirecionalnested.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    private final ProfessorService professorService;

    public Aluno porId(Integer id) {
        return alunoRepository.findById(id).orElseThrow(
                () -> new NaoEncontradoException("Aluno")
        );
    }

    public Aluno criar(Aluno aluno, Integer professorId) {
        if (alunoRepository.existsByRa(aluno.getRa())) throw new ConflitoException("Aluno");
        
        Professor professor = professorService.porId(professorId);

        aluno.setProfessor(professor);
        return alunoRepository.save(aluno);
    }

}
