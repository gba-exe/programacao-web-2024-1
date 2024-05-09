package exe.gba.projetoconsultorio.controller;

import exe.gba.projetoconsultorio.entity.Consulta;
import exe.gba.projetoconsultorio.repository.ConsultaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.SpinnerUI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/consultas")
@RequiredArgsConstructor //faz oq esta comentado embaixo, porem "por tras dos panos" e para todos
                        //os atributos
public class ConsultaController {

//    @Autowired - faz basicamente oq ta aq embaixo, porem mt menos performatico

//    private final ConsultaRepository consultaRepository;
//
//    public ConsultaController(ConsultaRepository consultaRepository) {
//        this.consultaRepository = consultaRepository;
//    }

    private final ConsultaRepository consultaRepository;

    @GetMapping
    public ResponseEntity<List<Consulta>> listar() {
        List<Consulta> consultas = consultaRepository.findAll();

        if (consultas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(consultas);
    }

    @GetMapping("/filtro-medico/{medicoId}")
    public ResponseEntity<List<Consulta>> buscarMedicoPorId(@PathVariable int medicoId) {
        List<Consulta> consultas = consultaRepository.findByMedicoId(medicoId);

        if (consultas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(consultas);
    }

    @GetMapping("/media-preco")
    public ResponseEntity<Double> mediaConsultas() {
        return ResponseEntity.ok(consultaRepository.mediaPrecoConsulta());
    }

    @GetMapping("/soma-preco-medico/{medicoId}")
    public ResponseEntity<Double> somaPorMedicoId(@PathVariable int medicoId) {
        return ResponseEntity.ok(consultaRepository.somaPrecoPorMedicoId(medicoId));
    }

    @GetMapping("/filtro-medico-agendamento/{medicoId}")
    public ResponseEntity<List<Consulta>> filtroMedicoAgendamento(
            @PathVariable int medicoId,
            @RequestParam LocalDate dataInicio,
            @RequestParam LocalDate dataFim) {
        return null;
    }

    @PatchMapping("/{id}/nome")
    public ResponseEntity<Consulta> atualizaNome(
            @PathVariable int id,
            @RequestParam String novoNome) {
        if (!consultaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        consultaRepository.atualizaNome(id, novoNome);

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Consulta> criar (@RequestBody Consulta novaConsulta) {
        Consulta consultaSalva = consultaRepository.save(novaConsulta);

        return ResponseEntity.created(null).body(consultaSalva);
    }
}
