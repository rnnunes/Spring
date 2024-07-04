package br.com.unimed.Caso1.domain;

import br.com.unimed.Caso1.domain.DTO.CarroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroService {

    @Autowired
    private CarRepository rep;

    public List<CarroDTO> getCarros(){
        return rep.findAll().stream().map(CarroDTO::create).collect(Collectors.toList());

//        List<CarroDTO> list = new ArrayList<>();
//        for (Carro c : carros) {
//            list.add(new CarroDTO(c));
//        }
//        return list;
    }

    public Optional<CarroDTO> getCarroById(Long id) {
        return rep.findById(id).map(CarroDTO::create);
//        Optional<Carro> carro = rep.findById(id);
//        if(carro.isPresent()) {
//            return Optional.of(new CarroDTO(carro.get()));
//        } else {
//            return null;
//        }
    }

    public List<CarroDTO> getCarroByTipo(String tipo) {
        return rep.findByTipo(tipo).stream().map(CarroDTO::create).collect(Collectors.toList());
//        List<CarroDTO> list = new ArrayList<>();
//        for (Carro c : carros) {
//            list.add(new CarroDTO(c));
//        }
//        return list;
    }

    public CarroDTO insert(Carro carro) {
        Assert.isNull(carro.getId(), "Não foi possível inserir o registro");
        return CarroDTO.create(rep.save(carro));
    }

    public CarroDTO update(Carro carro, Long id) {
        Assert.notNull(id, "Não foi possivel atualizar o registro");

        //busca o carro no banco de dados
        Optional<Carro> optional = rep.findById(id);
        if (optional.isPresent()) {
            Carro db = optional.get();

            //copiar as propriedades
            db.setNome(carro.getNome());
            db.setTipo(carro.getTipo());
            System.out.println("Carro id " + db.getId());

            //atualiza o carro
            rep.save (db);
            return CarroDTO.create(db);
        } else {
            return null;
//            throw new RuntimeException("Não foi possivel atualizar o registro");
        }
    }

    public boolean delete(Long id) {

        if (getCarroById(id).isPresent()) {
            rep.deleteById(id);
            return true;
        }
        return false;
    }

    //teste lista na memoria
    public List<Carro> getCarrosFake() {
        List<Carro> carros = new ArrayList<>();
        carros.add(new Carro(1L, "Fuscão Preto", "Velho"));
        carros.add(new Carro(2L, "Gol Quadrado", "Estranho"));
        carros.add(new Carro(3L, "Chevete", "Escrito Errado"));

        return carros;
    }


}
