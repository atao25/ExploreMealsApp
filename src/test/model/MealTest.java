package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MealTest {
    Meal testMeal;

    @BeforeEach
    void setUp() {
        testMeal = new Meal("Pizza", "Italian", 20);
    }

    @Test
    void testConstructor() {
        assertEquals("Pizza", testMeal.getName());
        assertEquals("Italian", testMeal.getCuisine());
        assertEquals(20, testMeal.getPrice());
    }

    @Test
    void getName() {
        assertEquals("Pizza", testMeal.getName());
    }

    @Test
    void getCuisine() {
        assertEquals("Italian", testMeal.getCuisine());
    }

    @Test
    void getPrice() {
        assertEquals(20, testMeal.getPrice());
    }
}
