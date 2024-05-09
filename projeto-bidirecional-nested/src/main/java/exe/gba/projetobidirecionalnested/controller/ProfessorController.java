package exe.gba.projetobidirecionalnested.controller;

import exe.gba.projetobidirecionalnested.dto.ProfessorListagemDto;
import exe.gba.projetobidirecionalnested.dto.ProfessorMapper;
import exe.gba.projetobidirecionalnested.entity.Professor;
import exe.gba.projetobidirecionalnested.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professores")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorListagemDto> porId(@PathVariable Integer id) {
        ProfessorListagemDto dto = ProfessorMapper.toProfessorListagemDto(
                professorService.porId(id));
        return ResponseEntity.ok(dto);
    }
}
