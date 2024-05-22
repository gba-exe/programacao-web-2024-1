package school.sptech.atividaderelacionamento.controller.projeto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.atividaderelacionamento.dto.projeto.ProjetoCriacaoDto;
import school.sptech.atividaderelacionamento.dto.projeto.ProjetoListagemDto;
import school.sptech.atividaderelacionamento.dto.projeto.ProjetoMapper;
import school.sptech.atividaderelacionamento.entity.projeto.Projeto;
import school.sptech.atividaderelacionamento.service.projeto.ProjetoService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/projetos")
@RequiredArgsConstructor
public class ProjetoController {

    private final ProjetoService projetoService;

    @GetMapping
    public ResponseEntity<List<ProjetoListagemDto>> listarProjetos() {
        List<Projeto> projetos = projetoService.listarProjetos();

        if (projetos.isEmpty()) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(ProjetoMapper.toProjeoListagemDto(projetos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoListagemDto> buscarProjeto(@PathVariable Integer id) {
        Projeto projeto = projetoService.buscarProjetoPorId(id);
        return ResponseEntity.ok(ProjetoMapper.toProjetoListagemDto(projeto));
    }

    @PostMapping
    public ResponseEntity<ProjetoListagemDto> criarProjeto(@RequestBody @Valid ProjetoCriacaoDto projetoCriacaoDto) {
        Projeto projeto = projetoService.salvarProjeto(ProjetoMapper.toProjetoEntity(projetoCriacaoDto));

        URI uri = URI.create("/projetos/" + projeto.getId());
        return ResponseEntity.created(uri).body(ProjetoMapper.toProjetoListagemDto(projeto));
    }
}
