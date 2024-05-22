package school.sptech.atividaderelacionamento.service.projeto;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.atividaderelacionamento.entity.projeto.Projeto;
import school.sptech.atividaderelacionamento.exception.EntidadeNaoEncontradaException;
import school.sptech.atividaderelacionamento.repository.projeto.ProjetoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjetoService {

    private final ProjetoRepository projetoRepository;

    public List<Projeto> listarProjetos() {
        return projetoRepository.findAll();
    }

    public Projeto buscarProjetoPorId(Integer id) {
        return projetoRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Projeto")
        );
    }

    public Projeto salvarProjeto(Projeto projeto) {
        if (projeto.getDataInicio().isAfter(projeto.getDataFim())){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Data de início não pode ser maior que a data de fim");
        }

        return projetoRepository.save(projeto);
    }
}
