package it.da.be.challenge.fruit.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.da.be.challenge.fruit.dto.FruitProjection;
import it.da.be.challenge.fruit.dto.NutritionsDifferencesProjection;
import it.da.be.challenge.fruit.repository.FruitRepository;

@Service
public class FruitService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FruitService.class);
	
	@Autowired
	private FruitRepository repository;
	
	public List<FruitProjection> getAllByMaxCalories(int maxCalories) {
		LOGGER.info("getAllByMaxCalories invoked with parameter {}", maxCalories);
		List<FruitProjection> dtoList = repository.findByNutritionsCaloriesLessThanEqual(maxCalories);
		LOGGER.info("getAllByMaxCalories returning {} results", dtoList.size());
		return dtoList;
	}

	public NutritionsDifferencesProjection getNutritionsDifferences(String fruit1Name, String fruit2Name) {
		LOGGER.info("getNutritionsDifferences invoked with parameters {}, {}", fruit1Name, fruit2Name);
		NutritionsDifferencesProjection nutritionsDifferences = repository.findNutritionsDifferences(fruit1Name, fruit2Name);
		LOGGER.info("getNutritionsDifferences returning result");
		return nutritionsDifferences;
	}

}
