package it.da.be.challenge.fruit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.da.be.challenge.fruit.constants.PathConstants;
import it.da.be.challenge.fruit.dto.FruitProjection;
import it.da.be.challenge.fruit.dto.NutritionsInfoProjection;
import it.da.be.challenge.fruit.service.FruitService;

@RestController
@RequestMapping(PathConstants.FRUITS)
public class FruitController {

	@Autowired
	private FruitService service;

	@GetMapping
	public ResponseEntity<List<FruitProjection>> getAllByMaxCalories(@RequestParam(required = true) int maxCalories) {
		return ResponseEntity.ok(service.getAllByMaxCalories(maxCalories));
	}

	@GetMapping(PathConstants.NUTRITIONS_DIFFERENCES)
	public ResponseEntity<NutritionsInfoProjection> getNutritionsDifferences(
			@RequestParam(required = true) String fruit1Name, @RequestParam(required = true) String fruit2Name) {
		return ResponseEntity.ok(service.getNutritionsDifferences(fruit1Name, fruit2Name));
	}

	@GetMapping("/nutritions/average")
	public ResponseEntity<NutritionsInfoProjection> getFamilyNutritionsAverage(@RequestParam(required = true) String family) {
		return ResponseEntity.ok(service.getFamilyNutritionsAverage(family));
	}

}
