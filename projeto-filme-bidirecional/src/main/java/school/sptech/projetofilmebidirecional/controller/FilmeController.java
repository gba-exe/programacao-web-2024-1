package school.sptech.projetofilmebidirecional.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.projetofilmebidirecional.dto.filme.FilmeCriacaoDto;
import school.sptech.projetofilmebidirecional.dto.filme.FilmeListagemDto;
import school.sptech.projetofilmebidirecional.dto.filme.FilmeMapper;
import school.sptech.projetofilmebidirecional.entity.Diretor;
import school.sptech.projetofilmebidirecional.entity.Filme;
import school.sptech.projetofilmebidirecional.repository.DiretorRepository;
import school.sptech.projetofilmebidirecional.repository.FilmeRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filmes")
@RequiredArgsConstructor
public class FilmeController {

    private final FilmeRepository filmeRepository;
    private final DiretorRepository diretorRepository;

    @PostMapping
    public ResponseEntity<Filme> criar(@RequestBody @Valid FilmeCriacaoDto dto) {

        Optional<Diretor> diretorOpt = diretorRepository.findById(dto.getDiretorId());

        if (diretorOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }





        Filme filme = FilmeMapper.toEntity(dto, diretorOpt.get());
        filme = filmeRepository.save(filme);
        return ResponseEntity.created(null).body(filme);
    }

    @GetMapping
    public ResponseEntity<List<FilmeListagemDto>> listar() {
        List<Filme> filmes = filmeRepository.findAll();

        if (filmes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(FilmeMapper.toListagemDto(filmes));
    }
}
