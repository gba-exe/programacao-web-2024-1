package sptech.school.projetoserviceexception.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sptech.school.projetoserviceexception.entity.Estabelecimento;
import sptech.school.projetoserviceexception.entity.Pessoa;
import sptech.school.projetoserviceexception.entity.exception.ConfiltoException;
import sptech.school.projetoserviceexception.entity.exception.NaoEncontradoException;
import sptech.school.projetoserviceexception.repository.EstabelecimentoRepository;
import sptech.school.projetoserviceexception.repository.PessoaRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstabelecimentoService {

    private final EstabelecimentoRepository estabelecimentoRepository;
    private final PessoaService pessoaService;

    public List<Estabelecimento> listar() {
        return estabelecimentoRepository.findAll();
    }

    public Estabelecimento porId(int id) {
        Optional<Estabelecimento> estabelecimentoOpt = estabelecimentoRepository.findById(id);
        if (estabelecimentoOpt.isEmpty()) throw new NaoEncontradoException("Estabelecimento");
        return estabelecimentoOpt.get();
    }

    public Estabelecimento criar(Estabelecimento estabelecimento) {
        if (estabelecimentoRepository.existsByCnpj(estabelecimento.getCnpj())) throw new ConfiltoException("Estabelecimento");

        return estabelecimentoRepository.save(estabelecimento);
    }

    public Estabelecimento adicionarPessoa(int idEstabelecimento, int idPessoa) {
        Estabelecimento estabelecimento = porId(idEstabelecimento);
        Pessoa pessoa = pessoaService.porId(idPessoa);

        estabelecimento.setPessoa(pessoa);

        return estabelecimentoRepository.save(estabelecimento);
    }


}
