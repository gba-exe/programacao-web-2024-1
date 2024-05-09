package exe.gba.projetoecommerce.controller;

import exe.gba.projetoecommerce.dto.*;
import exe.gba.projetoecommerce.entity.Produto;
import exe.gba.projetoecommerce.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @PostMapping
    public ResponseEntity<ProdutoListagemDto> cadsatrar(
            @RequestBody @Valid ProdutoCriacaoDto novoProduto) {
        if (novoProduto == null) return ResponseEntity.status(400).build();

        Produto entity = ProdutoMapper.toEntity(novoProduto);
        Produto produtoSalvo = produtoRepository.save(entity);

        return ResponseEntity.status(201).body(ProdutoMapper.toDto(produtoSalvo));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoListagemDto>> listar() {
        List<Produto> produtos = produtoRepository.findAll();

        if (produtos.isEmpty()) return ResponseEntity.status(204).build();

        return ResponseEntity.status(200).body(ProdutoMapper.toDto(produtos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoListagemDto> listarPorId(@PathVariable Integer id) {
        Optional<Produto> produtoOpt = produtoRepository.findById(id);

        if (produtoOpt.isEmpty()) return ResponseEntity.status(404).build();

        Produto produto = produtoOpt.get();

        return ResponseEntity.status(200).body(ProdutoMapper.toDto(produto));
    }

    @GetMapping("/{id}/cliente")
    public ResponseEntity<ProdutoClienteListagemDto> listarPorIdCliente(@PathVariable Integer id) {
        Optional<Produto> produtoOpt = produtoRepository.findById(id);

        if (produtoOpt.isEmpty()) return ResponseEntity.status(404).build();

        Produto produto = produtoOpt.get();

        return ResponseEntity.status(200).body(ProdutoMapper.toClienteDto(produto));
    }

    @PatchMapping("/{id}/estoque")
    public ResponseEntity<ProdutoListagemDto> alterarEstoque(
            @RequestBody ProdutoEstoqueAtualizacaoDto novoEstoque, @PathVariable Integer id) {
        Optional<Produto> produtoOpt = produtoRepository.findById(id);

        if (produtoOpt.isEmpty()) return ResponseEntity.status(404).build();

        Produto produto = produtoOpt.get();

        produto.setQuantidadeEstoque(novoEstoque.getNovaQuantidade());
        Produto produtoSalvo = produtoRepository.save(produto);

        return ResponseEntity.status(200).body(ProdutoMapper.toDto(produtoSalvo));
    }

    @PostMapping("/{id}/compra")
    public ResponseEntity<ProdutoListagemDto> comprar(@PathVariable Integer id) {
        Optional<Produto> produtoOpt = produtoRepository.findById(id);

        if (produtoOpt.isEmpty()) return ResponseEntity.status(404).build();

        Produto produto = produtoOpt.get();

        if (produto.getQuantidadeEstoque() < 1) return ResponseEntity.status(400).build();

        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - 1);
        produto.setQuantidadeVendidos(produto.getQuantidadeVendidos() + 1);
        Produto produtoSalvo = produtoRepository.save(produto);

        return ResponseEntity.status(200).body(ProdutoMapper.toDto(produtoSalvo));
    }

    @GetMapping("/filtro")
    public ResponseEntity<List<ProdutoClienteListagemDto>> filtrar(
            @RequestParam String categoria,
            @RequestParam double precoInicial,
            @RequestParam double precoFinal) {
        List<Produto> produtos = produtoRepository
                .findAllByCategoriaContainingIgnoreCaseAndPrecoVendaBetween(
                        categoria, precoInicial, precoFinal);

        if (produtos.isEmpty()) return ResponseEntity.status(204).build();

        return ResponseEntity.status(200).body(ProdutoMapper.toClienteDto(produtos));
    }

    @GetMapping("/mais-vendidos")
    public ResponseEntity<List<ProdutoListagemDto>> listarMaisVendidos(
            @RequestParam int quantidadeVendidos) {
        List<Produto> produtos = produtoRepository
                .findAllByQuantidadeVendidosGreaterThan(quantidadeVendidos);

        if (produtos.isEmpty()) return ResponseEntity.status(204).build();

        return ResponseEntity.status(200).body(ProdutoMapper.toDto(produtos));
    }
}
