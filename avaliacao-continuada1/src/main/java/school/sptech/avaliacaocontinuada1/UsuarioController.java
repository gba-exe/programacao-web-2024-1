package school.sptech.avaliacaocontinuada1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {

        if (emailExists(usuario.getEmail())) {
            return ResponseEntity.status(409).build();
        }

        if (emailIsValid(usuario.getEmail())) {
            usuarios.add(usuario);
            return ResponseEntity.status(201).body(usuario);
        }

        return ResponseEntity.status(400).build();
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listar () {

        if (usuarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> listarPorId (@PathVariable int id) {

        if (idExists(id)) {
            return ResponseEntity.status(200).body(buscarPorId(id));
        }

        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarPorId (@PathVariable int id, @RequestBody Usuario usuario) {

        if (!idExists(id)) {
            return ResponseEntity.status(404).build();
        }

        if (!emailIsValid(usuario.getEmail())) {
            return ResponseEntity.status(400).build();
        }

        if (emailExists(usuario.getEmail(), id)) {
            return ResponseEntity.status(409).build();
        }

        return ResponseEntity.status(200).body(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {

        if (buscarPorId(id) != null) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();
    }

    private boolean emailIsValid (String email) {
        return email.contains("@") && email.length() >= 10;
    }

    private boolean emailExists (String email) {
        return usuarios.stream().anyMatch(usuario -> usuario.getEmail().equalsIgnoreCase(email));
    }

    private boolean emailExists (String email, int id) {
        return emailExists(email) && !buscarPorId(id).getEmail().equalsIgnoreCase(email);
    }

    private boolean idExists (int id) {
        return usuarios.stream().anyMatch(usuario -> usuario.getId() == id);
    }

    private Usuario buscarPorId (int id) {
        return usuarios.stream().filter(usuario -> usuario.getId() == id).findAny().orElse(null);
    }
}
