package sptech.school.projetoserviceexception.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sptech.school.projetoserviceexception.entity.Pessoa;
import sptech.school.projetoserviceexception.entity.exception.ConfiltoException;
import sptech.school.projetoserviceexception.entity.exception.NaoEncontradoException;
import sptech.school.projetoserviceexception.repository.PessoaRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository repository;

    public Pessoa criar(Pessoa pessoa) {
        if (repository.existsByEmail(pessoa.getEmail())) throw new ConfiltoException("Pessoa");

        return repository.save(pessoa);
    }

    public Pessoa porId(int id) {
        Optional<Pessoa> pessoaOpt = repository.findById(id);

        if (pessoaOpt.isEmpty()) throw new NaoEncontradoException("Pessoa");

        return pessoaOpt.get();
    }

    public List<Pessoa> listar() {
        return repository.findAll();
    }
}