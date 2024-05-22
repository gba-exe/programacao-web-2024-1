package school.sptech.atividaderelacionamento.service.tarefa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import school.sptech.atividaderelacionamento.entity.tarefa.Tarefa;
import school.sptech.atividaderelacionamento.exception.EntidadeNaoEncontradaException;
import school.sptech.atividaderelacionamento.repository.tarefa.TarefaRepository;
import school.sptech.atividaderelacionamento.service.projeto.ProjetoService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final ProjetoService projetoService;
    
    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    public Tarefa buscarTarefaPorId(Integer id) {
        return tarefaRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Tarefa")
        );
    }

    public Tarefa salvarTarefa(Tarefa tarefa, Integer idProjeto) {
        tarefa.setProjeto(projetoService.buscarProjetoPorId(idProjeto));
        return tarefaRepository.save(tarefa);
    }
}
