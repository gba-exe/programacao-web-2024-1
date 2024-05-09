package exe.gba.projetobidirecionalnested.controller;

import exe.gba.projetobidirecionalnested.dto.AlunoListagemDto;
import exe.gba.projetobidirecionalnested.dto.AlunoMapper;
import exe.gba.projetobidirecionalnested.entity.Aluno;
import exe.gba.projetobidirecionalnested.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @GetMapping("/{id}")
    public ResponseEntity<AlunoListagemDto> porId(@PathVariable Integer id) {
        Aluno aluno = alunoService.porId(id);
        return ResponseEntity.ok(AlunoMapper.toAlunoListagemDto(aluno));
    }
}
