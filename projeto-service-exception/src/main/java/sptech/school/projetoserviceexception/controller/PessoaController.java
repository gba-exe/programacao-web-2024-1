package sptech.school.projetoserviceexception.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sptech.school.projetoserviceexception.entity.Pessoa;
import sptech.school.projetoserviceexception.service.PessoaService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService service;

    @PostMapping
    public ResponseEntity<Pessoa> criar(Pessoa pessoa) {
        Pessoa pessoaCriada = service.criar(pessoa);

        URI uri = URI.create("/pessoas/" + pessoaCriada.getId());
        return ResponseEntity.created(uri).body(pessoaCriada);
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listar() {
        List<Pessoa> pessoas = service.listar();

        if (pessoas.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> listarPorId(int id) {
        Pessoa pessoa = service.porId(id);
        return ResponseEntity.ok(pessoa);
    }
}
