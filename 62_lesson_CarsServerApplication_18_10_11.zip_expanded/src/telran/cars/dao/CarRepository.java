package telran.cars.dao;



import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

import telran.cars.entities.CarJpa;

public interface CarRepository extends 
JpaRepository<CarJpa, String> {

	Stream<CarJpa> findAllBy();

	

}
