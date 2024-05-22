package school.sptech.atividaderelacionamento.controller.projeto;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.atividaderelacionamento.dto.projeto.ProjetoCriacaoDto;
import school.sptech.atividaderelacionamento.dto.projeto.ProjetoListagemDto;

import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @GetMapping
    public ResponseEntity<List<ProjetoListagemDto>> listarProjetos() {
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoListagemDto> buscarProjeto(@PathVariable Integer id) {
        return ResponseEntity.internalServerError().build();
    }

    @PostMapping
    public ResponseEntity<ProjetoListagemDto> criarProjeto(@RequestBody @Valid ProjetoCriacaoDto projetoCriacaoDto) {
        return ResponseEntity.internalServerError().build();
    }
}
