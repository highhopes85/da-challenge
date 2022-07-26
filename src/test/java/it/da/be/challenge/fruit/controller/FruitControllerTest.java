package it.da.be.challenge.fruit.controller;

import static org.junit.jupiter.api.Assertions.*;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import it.da.be.challenge.fruit.dto.FruitProjection;
import it.da.be.challenge.fruit.service.FruitService;

@ExtendWith(MockitoExtension.class)
class FruitControllerTest {

	private static final int TEST_MAX_CALORIES = 200;
	@InjectMocks
	private FruitController controller;
	@Mock
	private FruitService serviceMock;

	@Test
	void testGetAllByMaxCaloriesShouldInvokeService() {
		controller.getAllByMaxCalories(TEST_MAX_CALORIES);
		verify(serviceMock, times(1)).getAllByMaxCalories(TEST_MAX_CALORIES);
	}
	
	@Test
	void testGetAllByMaxCaloriesShouldReturnProperResponse() throws Exception {
		List<FruitProjection> fruitDtoMockList = Arrays.asList(mock(FruitProjection.class));
		when(serviceMock.getAllByMaxCalories(TEST_MAX_CALORIES)).thenReturn(fruitDtoMockList);
		ResponseEntity<List<FruitProjection>> response = controller.getAllByMaxCalories(TEST_MAX_CALORIES);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		List<FruitProjection> body = response.getBody();
		assertNotNull(body);
		assertEquals(fruitDtoMockList, body);
	}
 
}
