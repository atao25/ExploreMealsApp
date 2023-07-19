package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MealTest {
    Meal testMeal;
    List<String> testIngredients;

    @BeforeEach
    void setUp() {
        testMeal = new Meal("Pizza", "Italian", 20);
        testIngredients = new ArrayList<>();
        Meal meal1 = new Meal("Pizza", "Italian", 20);
        Meal meal2 = new Meal("Sushi", "Japanese", 22);
        Meal meal3 = new Meal("Mac and Cheese", "American", 18);
    }

    @Test
    void testConstructor() {
        assertEquals("Pizza", testMeal.getName());
        assertEquals("Italian", testMeal.getCuisine());
        assertEquals(20, testMeal.getPrice());
    }

    @Test
    void testGetName() {

        assertEquals("Pizza", testMeal.getName());
    }

    @Test
    void testGetCuisine() {

        assertEquals("Italian", testMeal.getCuisine());
    }

    @Test
    void testGetPrice() {

        assertEquals(20, testMeal.getPrice());
    }

    @Test
    void testGetIngredients() {
        testIngredients.add("salt");
        testIngredients.add("flour");
        testIngredients.add("vinegar");
        assertEquals(3, testIngredients.size());
        assertEquals("salt", testIngredients.get(0));
        assertTrue(testIngredients.contains("flour"));

    }

    @Test
    void testMealToString() {
        assertEquals("Pizza/Italian/$20", testMeal.mealToText());


    }
}
