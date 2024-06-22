package br.com.unimed.Caso1.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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
        Assert.isNull(carro.getId(), "Não foi possível inserir o registro");
        return rep.save(carro);
    }

    public Carro update(Carro carro, Long id) {
        Assert.notNull(id, "Não foi possivel atualizar o registro");

        //busca o carro no banco de dados
        Optional<Carro> optional = getCarroById(id);
        if (optional.isPresent()) {
            Carro db = optional.get();

            //copiar as propriedades
            db.setNome(carro.getNome());
            db.setTipo(carro.getTipo());
            System.out.println("Carro id " + db.getId());

            //atualiza o carro
            rep.save (db);
            return db;
        } else {
            throw new RuntimeException("Não foi possivel atualizar o registro");
        }
    }

    public void delete(Long id) {
        Optional<Carro> carro = getCarroById(id);
        if (carro.isPresent()) {
            rep.deleteById(id);
        }
    }

    public List<Carro> getCarrosFake() {
        List<Carro> carros = new ArrayList<>();
        carros.add(new Carro(1L, "Fuscão Preto", "Velho"));
        carros.add(new Carro(2L, "Gol Quadrado", "Estranho"));
        carros.add(new Carro(3L, "Chevete", "Escrito Errado"));

        return carros;
    }


}
