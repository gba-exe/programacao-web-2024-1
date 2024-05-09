package exe.gba.projetoecommerce.repository;

import exe.gba.projetoecommerce.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    List<Produto> findAllByCategoriaContainingIgnoreCaseAndPrecoVendaBetween(
            String categoria,
            double precoInicial,
            double precoFinal);

    List<Produto> findAllByQuantidadeVendidosGreaterThan(int quantidadeVendidos);
}
