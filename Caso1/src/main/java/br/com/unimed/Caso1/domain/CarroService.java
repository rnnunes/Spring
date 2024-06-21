package br.com.unimed.Caso1.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarRepository rep;

    public Iterable<Carro> getCarros(){
        return rep.findAll();
    }

    public List<Carro> getCarrosFake() {
        List<Carro> carros = new ArrayList<>();
        carros.add(new Carro(1L, "Fuscão Preto"));
        carros.add(new Carro(2L, "Gol Quadrado"));
        carros.add(new Carro(3L, "Chevete"));

        return carros;
    }
}
