package it.da.be.challenge.fruit.dto;

public interface FruitProjection {

	long getId();
	FruitNutritionsProjection getNutritions();
	String getName();
	String getFamily();
	String getGenus(); 
	String getOrder();
}
