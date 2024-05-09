package exe.gba.atividadeheroi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/herois")
public class HeroiController {

    private List<Heroi> herois = new ArrayList<>();

    private boolean heroiExiste(int indice) {
        return indice >= 0 && indice < herois.size();
    }
    // http://localhost:8080/herois/favorito
    @GetMapping("/favorito")
    public Heroi favorito() {
        Heroi heroiFavorito = new Heroi("Homem Sereia", 6000, "Nada", 500, true);

        herois.add(heroiFavorito);

        return heroiFavorito;
    }

    // http://localhost:8080/herois
    @GetMapping
    public List<Heroi> herois() {
        return herois;
    }

    @GetMapping("/{indice}")
    public Heroi buscarHeroi(@PathVariable int indice) {

        return heroiExiste(indice) ? herois.get(indice) : null;
    }

    @GetMapping("/cadastrar/{nome}/{habilidade}/{idade}/{forca}/{vivo}")
    public Heroi cadastrar(@PathVariable String nome, @PathVariable String habilidade, @PathVariable int idade, @PathVariable int forca, @PathVariable boolean vivo) {
        Heroi heroi = new Heroi(nome, forca, habilidade, idade, vivo);

        herois.add(heroi);
        return heroi;
    }

    @GetMapping("/atualizar/{indice}/{nome}/{habilidade}/{idade}/{forca}/{vivo}")
    public Heroi atualizar(@PathVariable int indice, @PathVariable String nome, @PathVariable String habilidade, @PathVariable int idade, @PathVariable int forca, @PathVariable boolean vivo) {
        Heroi novoHeroi = new Heroi(nome, forca, habilidade, idade, vivo);

        if (heroiExiste(indice)) {
            herois.set(indice, novoHeroi);
            return novoHeroi;
        }
        return null;
    }

    @GetMapping("/remover/{indice}")
    public String remover(@PathVariable int indice){
        if (heroiExiste(indice)) {
            herois.remove(indice);
            return "Heroi removido";
        }
        return "Heroi nao encontrado";
    }
}
