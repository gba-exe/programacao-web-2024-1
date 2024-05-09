package exe.gba.projetoaula01respostajson;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/herois")
public class HeroiController {

    private List<Heroi> herois = new ArrayList<>();

    public HeroiController() {
        Heroi heroi = new Heroi("Homem Sereia", 6000, "Nada", 500, true);
        herois.add(heroi);
    }

    @GetMapping("/favorito")
    public Heroi favorito() {
        return herois.get(0);
    }

    @GetMapping
    public List<Heroi> listagem() {
        return herois;
    }
}
