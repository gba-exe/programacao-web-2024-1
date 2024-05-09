package exe.gba.projeto02verboshttp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    private List<Musica> musicas = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Musica>> listar() {
        if (musicas.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(musicas);
    }

    @GetMapping("/{indice}")
    public ResponseEntity<Musica> recuperar(@PathVariable int indice) {
        if (existeMusica(indice)){
            return ResponseEntity.status(200).body(musicas.get(indice));
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping
    public ResponseEntity<Musica> cadastar(@RequestBody Musica musica) {
        musicas.add(musica);
        return ResponseEntity.status(201).body(musica);
    }

    @PutMapping("/{indice}")
    public ResponseEntity<Musica> atualizar(@PathVariable int indice, @RequestBody Musica musica) {
        if(existeMusica(indice)) {
            musicas.set(indice, musica);
            return ResponseEntity.status(200).body(musicas.get(indice));
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{indice}")
    public ResponseEntity<Void> deletar(@PathVariable int indice) {
        if (existeMusica(indice)) {
            musicas.remove(indice);
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();
    }
    public boolean existeMusica(int indice) {
        return indice >= 0 && indice < musicas.size();
    }
}
