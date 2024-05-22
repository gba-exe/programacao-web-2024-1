package school.sptech.atividaderelacionamento.controller.tarefa;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.atividaderelacionamento.dto.tarefa.TarefaCriacaoDto;
import school.sptech.atividaderelacionamento.dto.tarefa.TarefaListagemDto;
import school.sptech.atividaderelacionamento.dto.tarefa.TarefaMapper;
import school.sptech.atividaderelacionamento.entity.tarefa.Tarefa;
import school.sptech.atividaderelacionamento.service.tarefa.TarefaService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<List<TarefaListagemDto>> listarTarefas() {
        List<Tarefa> tarefas = tarefaService.listarTarefas();

        if (tarefas.isEmpty()) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(TarefaMapper.toTarefaListagemDto(tarefas));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaListagemDto> buscarTarefa(@PathVariable Integer id) {
        Tarefa tarefa = tarefaService.buscarTarefaPorId(id);

        return ResponseEntity.ok(TarefaMapper.toTarefaListagemDto(tarefa));
    }

    @PostMapping
    public ResponseEntity<TarefaListagemDto> criarTarefa(@RequestBody @Valid TarefaCriacaoDto tarefaCriacaoDto) {
        Tarefa tarefa = TarefaMapper.toEntity(tarefaCriacaoDto);
        tarefa = tarefaService.salvarTarefa(tarefa, tarefaCriacaoDto.getProjetoId());

        URI uri = URI.create("/tarefas/" + tarefa.getId());

        return ResponseEntity.created(uri).body(TarefaMapper.toTarefaListagemDto(tarefa));
    }
}
