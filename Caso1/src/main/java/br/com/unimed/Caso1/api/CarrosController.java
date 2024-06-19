package br.com.unimed.Caso1.api;

import br.com.unimed.Caso1.domain.Carro;
import br.com.unimed.Caso1.domain.CarroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carros")
public class CarrosController {

    private CarroService service = new CarroService();

    @GetMapping
    public List<Carro> get() {
        return service.getCarros();
    }

}
