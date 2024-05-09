package sptech.school.projetoserviceexception.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.school.projetoserviceexception.entity.Estabelecimento;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Integer> {

    boolean existsByCnpj(String cnpj);
}
