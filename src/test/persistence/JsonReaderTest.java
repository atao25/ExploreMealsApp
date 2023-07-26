package persistence;

import model.Meal;
import model.MealWishList;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile/json");
        try {
            MealWishList ml = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyMealWishList() {
        JsonReader reader = new JsonReader("./data/testWriterEmptyMealWishlist.json");
        try {
            MealWishList ml = reader.read();
            assertEquals("MealWishList", ml.getName());
            assertEquals(0, ml.getNumMeals());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralMealWishList() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralMealWishList.json");
        try {
            MealWishList ml = reader.read();
            assertEquals("MealWishList", ml.getName());
            List<Meal> meals = ml.getMeals();
            assertEquals(2, meals.size());
            checkMeal("Pizza", "Italian", 25, meals.get(0));
            checkMeal("French Toast", "French", 22, meals.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}




