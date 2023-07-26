package persistence;

import model.Meal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkMeal(String name, String cuisine, int price, Meal m) {
        assertEquals(name, m.getName());
        assertEquals(cuisine, m.getCuisine());
        assertEquals(price, m.getPrice());
    }
}

