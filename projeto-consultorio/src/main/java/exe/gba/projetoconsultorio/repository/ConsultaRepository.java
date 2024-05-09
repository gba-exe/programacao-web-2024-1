package exe.gba.projetoconsultorio.repository;

import exe.gba.projetoconsultorio.entity.Consulta;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

    List<Consulta> findByMedicoId(int id);

//    @Query("SELECT c FROM Consulta c WHERE c.medico.id = :id")
//    List<Consulta> buscaPorMedicoId(int id);

    @Query("SELECT COALESCE(AVG(c.preco), 0) FROM Consulta c")
    double mediaPrecoConsulta();

    @Query("SELECT COALESCE(SUM(c.preco), 0) FROM Consulta c WHERE c.medico.id = :id")
    double somaPrecoPorMedicoId(int id);

    List<Consulta> findByMedico_IdAndDataAgendamentoBetween(
            Integer medicoId, LocalDate dataInicio, LocalDate dataFim);

    @Transactional
    @Modifying
    @Query("UPDATE Consulta c SET c.nome = :nome WHERE c.id = :id")
    void atualizaNome(int id, String nome);

    @Transactional
    @Modifying
    void  deleteByMedicoId(int id);
}
