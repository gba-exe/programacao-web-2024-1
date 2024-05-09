package exe.gba.miniexercicio;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private List<Produto> produtos = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Produto> postProduto(@RequestBody Produto produto) {

        produtos.add(produto);
        return ResponseEntity.status(201).body(produto);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getProdutos(){

        if (produtos.isEmpty()) {
            return ResponseEntity.status(204).body(produtos);
        }

        return ResponseEntity.status(200).body(produtos);
    }

    @PutMapping("/{indice}")
    public ResponseEntity<Produto> putProduto(@RequestBody Produto produto, @PathVariable int indice){

        if (existsProduto(indice)){
            produtos.set(indice, produto);
            return ResponseEntity.status(200).body(produto);
        }

        return ResponseEntity.status(404).build();
    }

    @GetMapping("/estoque")
    public ResponseEntity<List<Produto>> getEstoqueMaior(@RequestParam int qtdEstoque) {

        List<Produto> produtosFiltrados =
                produtos.stream().filter(produto -> produto.getQtdEstoque() >= qtdEstoque).toList();

        if (produtosFiltrados.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(produtosFiltrados);
    }

    @GetMapping("/busca-por-nome")
    public ResponseEntity<List<Produto>> buscaPorNome(@RequestParam String nome) {

        List<Produto> listaFiltrada = produtos.stream().filter(produto -> produto.getNome().contains(nome)).toList();

        if (listaFiltrada.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(listaFiltrada);
    }

    @DeleteMapping("/{indice}")
    public ResponseEntity<Void> excluirProduto(@PathVariable int indice) {

        if (existsProduto(indice)) {
            produtos.remove(indice);
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).build();
    }

    private boolean existsProduto(int i){
        return i >= 0 && i < produtos.size();
    }

}
