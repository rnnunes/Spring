package br.com.unimed.Caso1.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Carro, Long> {

    List<Carro> findByTipo(String tipo);

}
