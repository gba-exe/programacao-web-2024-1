package exe.gba.projetobidirecionalnested.controller;

import exe.gba.projetobidirecionalnested.dto.AlunoCriacaoDto;
import exe.gba.projetobidirecionalnested.dto.AlunoListagemDto;
import exe.gba.projetobidirecionalnested.dto.AlunoMapper;
import exe.gba.projetobidirecionalnested.entity.Aluno;
import exe.gba.projetobidirecionalnested.entity.Professor;
import exe.gba.projetobidirecionalnested.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    private final ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/{id}")
    public ResponseEntity<AlunoListagemDto> porId(@PathVariable Integer id) {
        Aluno aluno = alunoService.porId(id);
        return ResponseEntity.ok(AlunoMapper.toAlunoListagemDto(aluno));
    }

    @PostMapping
    public ResponseEntity<AlunoListagemDto> criar(@RequestBody AlunoCriacaoDto novoAluno) {
//        Aluno aluno = modelMapper.map(novoAluno, Aluno.class);
        Aluno aluno = AlunoMapper.toAlunoEntity(novoAluno);

        Aluno alunoSalvo = alunoService.criar(aluno, novoAluno.getProfessorId());

        URI location = URI.create("/alunos/" + alunoSalvo.getId());

        return ResponseEntity.created(location).body(AlunoMapper.toAlunoListagemDto(alunoSalvo));
    }
}
