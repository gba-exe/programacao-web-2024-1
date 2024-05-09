package exe.gba.projetobidirecionalnested.service;

import exe.gba.projetobidirecionalnested.entity.Aluno;
import exe.gba.projetobidirecionalnested.entity.exception.NaoEncontradoException;
import exe.gba.projetobidirecionalnested.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public Aluno porId(Integer id) {
        return alunoRepository.findById(id).orElseThrow(
                () -> new NaoEncontradoException("Aluno")
        );
    }
}
