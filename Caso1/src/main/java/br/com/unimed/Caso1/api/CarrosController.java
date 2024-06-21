package br.com.unimed.Caso1.api;

import br.com.unimed.Caso1.domain.Carro;
import br.com.unimed.Caso1.domain.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/carros")
public class CarrosController {

    @Autowired
    private CarroService service;

    @GetMapping
    public Iterable<Carro> get() {
        return service.getCarros();
    }

    @GetMapping("/{id}")
    public Optional<Carro> get(@PathVariable("id") Long id) {
        return service.getCarroById(id);
    }

    @GetMapping("/tipo/{tipo}")
    public Iterable<Carro> getCarroByTipo(@PathVariable("tipo") String tipo) {
        return service.getCarroByTipo(tipo);
    }

    @PostMapping
    public String post(@RequestBody Carro carro) {
        Carro c = service.insert(carro);

        return "Carro salvo com Sucesso: " + c.getId();
    }

}
