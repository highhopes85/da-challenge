package it.da.be.challenge.fruit.dto;

public interface FruitProjection {

	long getId();
	NutritionsInfoProjection getNutritions();
	String getName();
	String getFamily();
	String getGenus(); 
	String getOrder();
}
