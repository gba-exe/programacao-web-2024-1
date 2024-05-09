package sptech.school.projetoserviceexception.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.projetoserviceexception.entity.Estabelecimento;
import sptech.school.projetoserviceexception.service.EstabelecimentoService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/estabelecimentos")
@RequiredArgsConstructor
public class EstabelecimentoController {

    private final EstabelecimentoService service;

    @GetMapping
    public ResponseEntity<List<Estabelecimento>> listar() {
        List<Estabelecimento> estabelecimentos = service.listar();

        if (estabelecimentos.isEmpty()) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(estabelecimentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estabelecimento> listarPorId(@PathVariable int id) {
        Estabelecimento estabelecimento = service.porId(id);
        return ResponseEntity.ok(estabelecimento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estabelecimento> atualizar(@PathVariable int id, @RequestBody Estabelecimento novoEstabelecimento) {
        Estabelecimento estabelecimento = service.porId(id);
        estabelecimento.setNome(novoEstabelecimento.getNome());
        estabelecimento.setCnpj(novoEstabelecimento.getCnpj());

        return ResponseEntity.ok(estabelecimento);
    }

    @PostMapping
    public ResponseEntity<Estabelecimento> criar(@RequestBody Estabelecimento estabelecimento) {
        Estabelecimento estabelecimentoCriado = service.criar(estabelecimento);

        URI uri = URI.create("/estabelecimentos/" + estabelecimentoCriado.getId());
        return ResponseEntity.created(uri).body(estabelecimentoCriado);
    }

    @PatchMapping("/{id}/dono/{idPessoa}")
    public ResponseEntity<Estabelecimento> adicionarPessoa(@PathVariable int id, @PathVariable int idPessoa) {
        return ResponseEntity.ok(service.adicionarPessoa(id, idPessoa));
    }
}
