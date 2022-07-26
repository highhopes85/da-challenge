package it.da.be.challenge.fruit.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.da.be.challenge.fruit.dto.FruitProjection;
import it.da.be.challenge.fruit.entity.Fruit;

public interface FruitRepository extends CrudRepository<Fruit, Long>{

	List<FruitProjection> findByNutritionsCaloriesLessThanEqual(int maxCalories);
	
}
