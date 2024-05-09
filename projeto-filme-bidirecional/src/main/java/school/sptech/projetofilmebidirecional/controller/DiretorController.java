package school.sptech.projetofilmebidirecional.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.projetofilmebidirecional.dto.diretor.DiretorCriacaoDto;
import school.sptech.projetofilmebidirecional.dto.diretor.DiretorListagemDto;
import school.sptech.projetofilmebidirecional.dto.diretor.DiretorMapper;
import school.sptech.projetofilmebidirecional.entity.Diretor;
import school.sptech.projetofilmebidirecional.repository.DiretorRepository;

import java.util.List;

@RestController
@RequestMapping("/diretores")
@RequiredArgsConstructor
public class DiretorController {

    private final DiretorRepository diretorRepository;

    @PostMapping
    public ResponseEntity<DiretorListagemDto> criar(@RequestBody @Valid DiretorCriacaoDto diretorCriacaoDto) {

        Diretor diretorEntity = DiretorMapper.toEntity(diretorCriacaoDto);
        Diretor diretorSalvo = diretorRepository.save(diretorEntity);
        DiretorListagemDto diretorListagemDto = DiretorMapper.toListagemDto(diretorSalvo);

        return ResponseEntity.created(null).body(diretorListagemDto);
    }

    @GetMapping
    public ResponseEntity<List<DiretorListagemDto>> listar() {
        List<Diretor> diretores = diretorRepository.findAll();

        if (diretores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<DiretorListagemDto> diretoresListagemDto = DiretorMapper.toListagemDto(diretores);

        return ResponseEntity.ok(diretoresListagemDto);
    }
}