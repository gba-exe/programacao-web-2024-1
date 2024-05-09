package school.sptech.exercicio;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    private List<Carro> carros = new ArrayList<>();
    private int idAtual = 0;

    @PostMapping
    public ResponseEntity<Carro> cadastrar (@RequestBody Carro carro) {

        if (placaExists(carro.getPlaca())) {
            return ResponseEntity.status(409).build();
        }

        if (placaIsValid(carro.getPlaca())) {
            carros.add(carro);
            addId(carro);
            return ResponseEntity.status(201).body(carro);
        }

        return ResponseEntity.status(400).build();
    }

    @GetMapping
    public ResponseEntity<List<Carro>> listar(){
        return carros.isEmpty() ? ResponseEntity.status(204).build() :
                ResponseEntity.status(200).body(carros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> listarPorId (@PathVariable int id) {

        Carro carroEncontrado = carros.stream().filter(carro -> carro.getId() == id).findAny().orElse(null);
        return carroEncontrado == null ?
                ResponseEntity.status(404).build() :
                ResponseEntity.status(200).body(carroEncontrado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> atualizar(@PathVariable int id, @RequestBody Carro novoCarro) {


        if (placaIsValid(novoCarro.getPlaca())) {
            for (int i = 0; i < carros.size(); i++) {
                if (carros.get(i).getId() == id) {
                    if (placaExists(novoCarro.getPlaca()) &&
                            !(carros.get(i).getPlaca().equals(novoCarro.getPlaca()))) {
                        return ResponseEntity.status(409).build();
                    }
                    novoCarro.setId(id);
                    carros.set(i, novoCarro);
                    return ResponseEntity.status(200).body(novoCarro);
                }
            }
        }

        return ResponseEntity.status(400).build();

    }

    @PatchMapping("/{id}/emplacamento/{placa}")
    public ResponseEntity<Carro> atualizarPlaca(@PathVariable int id, @PathVariable String placa) {

        if(placaExists(placa)){
            return ResponseEntity.status(409).build();
        }

        if (carros.isEmpty()){
            return ResponseEntity.status(404).build();
        }

        if (!placaIsValid(placa)) {
            return ResponseEntity.status(400).build();
        }

        for (int i = 0; i < carros.size(); i++) {
            if (carros.get(i).getId() == id) {
                carros.get(i).setPlaca(placa);
                return ResponseEntity.status(200).body(carros.get(i));
            }
        }

        return ResponseEntity.status(404).build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id) {
        for (int i = 0; i < carros.size(); i++) {
            if (carros.get(i).getId() == id) {
                carros.remove(i);
                return ResponseEntity.status(204).build();
            }
        }

        return ResponseEntity.status(404).build();
    }

    @GetMapping("/valor-medio")
    public ResponseEntity<Double> getMedia(@RequestParam String marca) {
        double soma = 0.0;
         int qtdCarros = 0;

        for (Carro carro : carros) {
            if (carro.getMarca().equalsIgnoreCase(marca)) {
                qtdCarros++;
                soma += carro.getPreco();
            }
        }

        if (qtdCarros == 0){
            return ResponseEntity.status(204).build();
        }

        double media = soma/qtdCarros;
        return ResponseEntity.status(200).body(media);
    }
    private boolean placaExists(String placa) {
        return carros.stream().anyMatch(carro -> carro.getPlaca().equalsIgnoreCase(placa));
    }
    private boolean placaIsValid(String placa) {
        return placa.matches("^[A-Z]{3}[0-9][A-Z][0-9]{2}$");
    }

    private void addId(Carro carro){
        idAtual++;
        carro.setId(idAtual);
    }

}
