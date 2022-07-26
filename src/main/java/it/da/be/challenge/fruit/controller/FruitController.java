package it.da.be.challenge.fruit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.da.be.challenge.fruit.dto.FruitProjection;
import it.da.be.challenge.fruit.service.FruitService;

@RestController
@RequestMapping("fruits")
public class FruitController {

	@Autowired
	private FruitService service;

	@GetMapping
	public ResponseEntity<List<FruitProjection>> getAllByMaxCalories(@RequestParam(required = true) int maxCalories) {
		return ResponseEntity.ok(service.getAllByMaxCalories(maxCalories));
	}

}
