package br.com.unimed.Caso1.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarRepository rep;

    public Iterable<Carro> getCarros(){
        return rep.findAll();
    }

    public Optional<Carro> getCarroById(Long id) {
        return  rep.findById(id);
    }

    public Iterable<Carro> getCarroByTipo(String tipo) {
        return rep.findByTipo(tipo);
    }

    public Carro insert(Carro carro) {
         return rep.save(carro);
    }


    public List<Carro> getCarrosFake() {
        List<Carro> carros = new ArrayList<>();
        carros.add(new Carro(1L, "Fuscão Preto", "Velho"));
        carros.add(new Carro(2L, "Gol Quadrado", "Estranho"));
        carros.add(new Carro(3L, "Chevete", "Escrito Errado"));

        return carros;
    }



}
