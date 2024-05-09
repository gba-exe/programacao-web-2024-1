package exe.gba.projetobidirecionalnested.repository;

import exe.gba.projetobidirecionalnested.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    boolean existsByRa(String ra);
}
