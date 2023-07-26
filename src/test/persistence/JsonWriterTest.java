package persistence;

import model.Meal;
import model.MealWishList;
import org.junit.jupiter.api.Test;

import javax.imageio.IIOException;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest {
    @Test
    void testWriterInvalidFile() {
        try {
            MealWishList ml = new MealWishList("MealWishList");
            JsonWriter writer = new JsonWriter("./datamy\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyMealWishList() {
        try {
            MealWishList ml = new MealWishList("MealWishList");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyMealWishList.json");
            writer.open();
            writer.write(ml);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyMealWishList.json");
            ml = reader.read();
            assertEquals("MealWishList", ml.getName());
            assertEquals(0, ml.getNumMeals());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralMealWishList() {
        try {
            MealWishList ml = new MealWishList("MealWishList");
            ml.add(new Meal("Pizza", "Italian", 25));
            ml.add(new Meal("French Toast", "French", 22));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralMealWishList.json");
            writer.open();
            writer.write(ml);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralMealWishList.json");
            ml = reader.read();
            assertEquals("MealWishList", ml.getName());
            List<Meal> meals = ml.getMeals();
            assertEquals(2, meals.size());
            checkMeal("Pizza", "Italian", 25, meals.get(0));
            checkMeal("French Toast", "French", 22, meals.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
