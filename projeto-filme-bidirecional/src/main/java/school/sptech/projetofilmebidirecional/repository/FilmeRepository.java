package school.sptech.projetofilmebidirecional.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.projetofilmebidirecional.entity.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Integer> {
}
