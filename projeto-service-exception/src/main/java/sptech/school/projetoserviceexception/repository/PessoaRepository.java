package sptech.school.projetoserviceexception.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.school.projetoserviceexception.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    boolean existsByEmail(String email);
}
