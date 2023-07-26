package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MealWishListTest {

    MealWishList mealList;
    Meal meal1 = new Meal("Pizza", "Italian", 20);
    Meal meal2 = new Meal("Sushi", "Japanese", 22);
    Meal meal3 = new Meal("Mac and Cheese", "American", 18);
    Meal meal4 = new Meal("Pasta", "Italian", 32);

    @BeforeEach
    void setUp() {
        mealList = new MealWishList("testList");
    }

    @Test
    void testConstructor() {
        assertEquals(0, mealList.getListOfMeals().size());
    }

    @Test
    void testAdd() {
        assertEquals(0, mealList.getListOfMeals().size());
        mealList.add(meal1);
        assertEquals(1, mealList.getListOfMeals().size());
        assertEquals(meal1, mealList.getListOfMeals().get(0));
        assertTrue(mealList.getListOfMeals().contains(meal1));
        mealList.add(meal2);
        mealList.add(meal3);
        assertEquals(3, mealList.getListOfMeals().size());
        assertEquals(meal2, mealList.getListOfMeals().get(1));
        assertTrue(mealList.getListOfMeals().contains(meal2));

    }

    @Test
    void testRemove() {
        assertEquals(0, mealList.getListOfMeals().size());
        mealList.add(meal1);
        assertEquals(1, mealList.getListOfMeals().size());
        assertTrue(mealList.getListOfMeals().contains(meal1));
        mealList.remove(meal1);
        assertEquals(0, mealList.getListOfMeals().size());
        assertFalse(mealList.getListOfMeals().contains(meal1));
        mealList.add(meal2);
        mealList.add(meal2);
        mealList.add(meal3);
        assertEquals(3, mealList.getListOfMeals().size());
        mealList.remove(meal2);
        assertEquals(2, mealList.getListOfMeals().size());
        assertEquals(meal3, mealList.getListOfMeals().get(1));
    }


    @Test
    void testRemoveByIndex() {
        mealList.add(meal1);
        mealList.add(meal2);
        mealList.add(meal3);

        assertEquals(3, mealList.getListOfMeals().size());
        assertEquals(meal1, mealList.getListOfMeals().get(0));
        assertFalse(mealList.getListOfMeals().contains(meal4));
        assertTrue(mealList.getListOfMeals().contains(meal2));

        assertFalse(mealList.removeMealByIndex(4));
        assertFalse(mealList.removeMealByIndex(3));
        assertFalse(mealList.removeMealByIndex(-1));

        assertTrue(mealList.removeMealByIndex(0));
        assertEquals(2, mealList.getListOfMeals().size());
        assertEquals(meal2, mealList.getListOfMeals().get(0));
        assertEquals(meal3, mealList.getListOfMeals().get(1));
        assertFalse(mealList.getListOfMeals().contains(meal1));
        assertTrue(mealList.getListOfMeals().contains(meal2));
        assertTrue(mealList.getListOfMeals().contains(meal3));

        assertFalse(mealList.removeMealByIndex(2));

        assertTrue(mealList.removeMealByIndex(0));
        assertEquals(1, mealList.getListOfMeals().size());
        assertEquals(meal3, mealList.getListOfMeals().get(0));
        assertFalse(mealList.getListOfMeals().contains(meal2));
        assertTrue(mealList.getListOfMeals().contains(meal3));

        assertFalse(mealList.removeMealByIndex(1));
    }


    @Test
    void testMealListToString() {
        mealList.add(meal1);
        assertEquals("0. Pizza/Italian/$20\n", mealList.toString());

        mealList.add(meal2);
        assertEquals("0. Pizza/Italian/$20\n1. Sushi/Japanese/$22\n", mealList.toString());

        mealList.add(meal3);
        assertEquals("0. Pizza/Italian/$20\n1. Sushi/Japanese/$22\n2. Mac and Cheese/American/$18\n", mealList.toString());

    }
}

