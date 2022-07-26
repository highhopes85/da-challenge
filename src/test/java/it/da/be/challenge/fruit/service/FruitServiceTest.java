package it.da.be.challenge.fruit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import it.da.be.challenge.fruit.dto.FruitProjection;
import it.da.be.challenge.fruit.dto.NutritionsInfoProjection;
import it.da.be.challenge.fruit.repository.FruitRepository;

@ExtendWith(MockitoExtension.class)
class FruitServiceTest {

	private static final String TEST_FAMILY = "test family";
	private static final String TEST_NAME = "test name";
	private static final int TEST_MAX_CALORIES = 150;
	@InjectMocks
	private FruitService service;
	@Mock
	private FruitRepository repositoryMock;
	
	@Test
	void testGetAllByMaxCaloriesShouldInvokeRepository() {
		service.getAllByMaxCalories(TEST_MAX_CALORIES);
		verify(repositoryMock, times(1)).findByNutritionsCaloriesLessThanEqual(TEST_MAX_CALORIES);
	}
	
	@Test
	void testGetAllByMaxCaloriesReturnProperResult() {
		List<FruitProjection> fruitDtoMockList = Arrays.asList(mock(FruitProjection.class));
		when(repositoryMock.findByNutritionsCaloriesLessThanEqual(TEST_MAX_CALORIES)).thenReturn(fruitDtoMockList);
		List<FruitProjection> allByMaxCalories = service.getAllByMaxCalories(TEST_MAX_CALORIES);
		assertEquals(fruitDtoMockList, allByMaxCalories);
	}
	
	@Test
	void testGetNutritionDifferencesShouldInvokeRepository() throws Exception {
		service.getNutritionsDifferences(TEST_NAME+1, TEST_NAME+2);
		verify(repositoryMock, times(1)).findNutritionsDifferences(TEST_NAME+1, TEST_NAME+2);
	}
	
	@Test
	void testGetNutritionDifferencesShouldReturnProperResult() throws Exception {
		NutritionsInfoProjection nutritionsDifferencesMock = mock(NutritionsInfoProjection.class);
		when(repositoryMock.findNutritionsDifferences(TEST_NAME+1, TEST_NAME+2)).thenReturn(nutritionsDifferencesMock);
		NutritionsInfoProjection nutritionsDifferences = service.getNutritionsDifferences(TEST_NAME+1, TEST_NAME+2);
		assertEquals(nutritionsDifferencesMock, nutritionsDifferences);
	}
	
	@Test
	void testGetFamilyNutritionsAverageShouldInvokeRepository() throws Exception {
		service.getFamilyNutritionsAverage(TEST_FAMILY);
		verify(repositoryMock, times(1)).findFamilyNutritionsAverage(TEST_FAMILY);
	}
	
	@Test
	void testGetFamilyNutritionsAverageShouldReturnProperResult() throws Exception {
		NutritionsInfoProjection nutritionsAverageMock = mock(NutritionsInfoProjection.class);
		when(repositoryMock.findFamilyNutritionsAverage(TEST_FAMILY)).thenReturn(nutritionsAverageMock);
		NutritionsInfoProjection nutritionsDifferences = service.getFamilyNutritionsAverage(TEST_FAMILY);
		assertEquals(nutritionsAverageMock, nutritionsDifferences);
	}

}
