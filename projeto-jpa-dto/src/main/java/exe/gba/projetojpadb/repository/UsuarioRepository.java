package exe.gba.projetojpadb.repository;

import exe.gba.projetojpadb.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
