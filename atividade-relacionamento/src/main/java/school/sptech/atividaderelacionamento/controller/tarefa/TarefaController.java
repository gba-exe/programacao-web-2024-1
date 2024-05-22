package school.sptech.atividaderelacionamento.controller.tarefa;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.atividaderelacionamento.dto.tarefa.TarefaCriacaoDto;
import school.sptech.atividaderelacionamento.dto.tarefa.TarefaListagemDto;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @GetMapping
    public ResponseEntity<List<TarefaListagemDto>> listarTarefas() {
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaListagemDto> buscarTarefa(@PathVariable Integer id) {
        return ResponseEntity.internalServerError().build();
    }

    @PostMapping
    public ResponseEntity<TarefaListagemDto> criarTarefa(@RequestBody @Valid TarefaCriacaoDto tarefaCriacaoDto) {
        return ResponseEntity.internalServerError().build();
    }
}
