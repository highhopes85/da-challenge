package it.da.be.challenge.fruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.da.be.challenge.fruit.dto.FruitProjection;
import it.da.be.challenge.fruit.dto.NutritionsInfoProjection;
import it.da.be.challenge.fruit.entity.Fruit;

public interface FruitRepository extends CrudRepository<Fruit, Long>{

	List<FruitProjection> findByNutritionsCaloriesLessThanEqual(double maxCalories);
	
	@Query(value="select"
			+ " (n1.carbohydrates-n2.carbohydrates) carbohydrates, "
			+ " (n1.protein-n2.protein) protein, "
			+ " (n1.fat-n2.fat) fat, "
			+ " (n1.calories-n2.calories) calories,"
			+ " (n1.sugar-n2.sugar) sugar "
			+ " from fruit f1"
			+ " join fruit f2 on f1.name = :fruit1Name and f2.name = :fruit2Name"
			+ " join fruit_nutritions n1 on n1.id = f1.nutritions_id"
			+ " join fruit_nutritions n2 on n2.id = f2.nutritions_id",
			nativeQuery =true)
	NutritionsInfoProjection findNutritionsDifferences(String fruit1Name, String fruit2Name);

	@Query(value="select"
			+ " avg(n.carbohydrates) carbohydrates,"
			+ " avg(n.protein) protein,"
			+ " avg(n.fat) fat,"
			+ " avg(n.calories) calories,"
			+ " avg(n.sugar) sugar"
			+ " from fruit f"
			+ " join fruit_nutritions n on n.id = f.nutritions_id"
			+ " where f.family = :family"
			+ " group by f.family",
			nativeQuery =true)
	NutritionsInfoProjection findFamilyNutritionsAverage(String family);

}
