package br.com.unimed.Caso1.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CarRepository extends CrudRepository<Carro, Long> {

    Iterable<Carro> findByTipo(String tipo);

}
