package br.com.unimed.Caso1.domain;

import java.util.ArrayList;
import java.util.List;

public class CarroService {

    public List<Carro> getCarros() {
        List<Carro> carros = new ArrayList<>();
        carros.add(new Carro(1L, "Fuscão Preto"));
        carros.add(new Carro(2L, "Gol Quadrado"));
        carros.add(new Carro(3L, "Chevete"));

        return carros;
    }
}
