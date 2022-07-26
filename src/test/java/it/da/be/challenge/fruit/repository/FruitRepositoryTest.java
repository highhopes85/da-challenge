package it.da.be.challenge.fruit.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import it.da.be.challenge.fruit.dto.NutritionsInfoProjection;
import it.da.be.challenge.fruit.entity.Fruit;
import it.da.be.challenge.fruit.entity.FruitNutritions;

@SpringBootTest
@Transactional
@ActiveProfiles("junit")
class FruitRepositoryTest {

	private static final double TEST_SUGAR = 11.0;
	private static final double TEST_PROTEIN = 22.5;
	private static final double TEST_FAT = 33.0;
	private static final double TEST_CARBOHYDRATES = 55.5;
	private static final int TEST_CALORIES = 13;
	private static final String TEST_ORDER = "test order";
	private static final String TEST_GENUS = "test genus";
	private static final String TEST_NAME = "test name";
	private static final String TEST_FAMILY = "test family";
	@Autowired
	private FruitRepository repository;

	@Test
	void testFindNutritionsDifferencesShouldComputeNutritionsDifferences() {
		repository.saveAll(
				Arrays.asList(givenFruit(1, TEST_FAMILY), givenFruit(20, TEST_FAMILY), givenFruit(30, TEST_FAMILY)));
		assertNutritionDifferences(29, repository.findNutritionsDifferences(TEST_NAME + 30, TEST_NAME + 1));
		assertNutritionDifferences(19, repository.findNutritionsDifferences(TEST_NAME + 20, TEST_NAME + 1));
		assertNutritionDifferences(10, repository.findNutritionsDifferences(TEST_NAME + 30, TEST_NAME + 20));
	}

	@Test
	void testFindNutritionsDifferencesShouldComputeNutritionsAverage() {
		repository.saveAll(Arrays.asList(givenFruit(1, TEST_FAMILY), givenFruit(20, TEST_FAMILY + 2),
				givenFruit(30, TEST_FAMILY)));
		NutritionsInfoProjection familyNutritionsAverage = repository.findFamilyNutritionsAverage(TEST_FAMILY);
		assertEquals(26.5, familyNutritionsAverage.getSugar());
		assertEquals(28.5, familyNutritionsAverage.getCalories());
		assertEquals(71, familyNutritionsAverage.getCarbohydrates());
		assertEquals(48.5, familyNutritionsAverage.getFat());
		assertEquals(38, familyNutritionsAverage.getProtein());
	}

	private void assertNutritionDifferences(int expectedDifference, NutritionsInfoProjection nutritionsDifferences) {
		assertEquals(expectedDifference, nutritionsDifferences.getSugar());
		assertEquals(expectedDifference, nutritionsDifferences.getCalories());
		assertEquals(expectedDifference, nutritionsDifferences.getCarbohydrates());
		assertEquals(expectedDifference, nutritionsDifferences.getFat());
		assertEquals(expectedDifference, nutritionsDifferences.getProtein());
	}

	private Fruit givenFruit(int index, String family) {
		Fruit fruit = new Fruit();
		fruit.setFamily(family);
		fruit.setGenus(TEST_GENUS + index);
		fruit.setName(TEST_NAME + index);
		fruit.setOrder(TEST_ORDER + index);
		FruitNutritions nutritions = new FruitNutritions();
		nutritions.setCalories(TEST_CALORIES + index);
		nutritions.setCarbohydrates(TEST_CARBOHYDRATES + index);
		nutritions.setFat(TEST_FAT + index);
		nutritions.setProtein(TEST_PROTEIN + index);
		nutritions.setSugar(TEST_SUGAR + index);
		fruit.setNutritions(nutritions);
		return fruit;
	}

}
