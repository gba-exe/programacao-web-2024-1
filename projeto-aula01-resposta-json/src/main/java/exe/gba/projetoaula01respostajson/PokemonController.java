package exe.gba.projetoaula01respostajson;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private List<String> pokemon = new ArrayList<>();

    private boolean existePokemon(int indice) {

        return indice >= 0 && indice < pokemon.size();
    }
    @GetMapping
    public String pokemon (){

        return "Total de pokemon cadastrados: " + pokemon.size();
    }

    @GetMapping("/cadastrar/{nome}")
    public String cadastrar (@PathVariable String nome) {

        pokemon.add(nome);
        return "Pokemon cadastrado";
    }

    @GetMapping("/recuperar/{indice}")
    public String recuperar (@PathVariable int indice) {

        if (existePokemon(indice)) {
            pokemon.get(indice);
        }
        return "Pokemon nao encontrado";
    }

    @GetMapping("/excluir/{indice}")
    public String excluir (@PathVariable int indice) {

        if (existePokemon(indice)) {
            pokemon.remove(indice);
            return "Excluido";
        }

        return "Pokemon nao encontrado";
    }

    @GetMapping("/atualizar/{indice}/{novoNome}")
    public String atualizar (@PathVariable int indice, @PathVariable String novoNome) {

        if (existePokemon(indice)) {
            pokemon.set(indice, novoNome);
            return "Pokemon Atualizado";
        }

        return "Pokemon nao encontrado";
    }
}