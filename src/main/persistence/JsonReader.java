package persistence;

import model.Meal;
import model.MealWishList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// This class references code from:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

// Represents a reader that reads wishlist of meals from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads meal wishlist from file and returns it,
    //          throws IOException is an error occurs reading the data from file
    public MealWishList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseMealWishList(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses meal wishlist from JSON object and returns it
    private MealWishList parseMealWishList(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        MealWishList ml = new MealWishList(name);
        addMeals(ml, jsonObject);
        return ml;
    }

    // MODIFIES: ml
    // EFFECTS: parses meals from JSON object and adds them to the meal wishlist
    private void addMeals(MealWishList ml, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray(("meals"));
        for (Object json: jsonArray) {
            JSONObject nextMeal = (JSONObject) json;
            addMeal(ml, nextMeal);
        }
    }

    // MODIFIES: ml
    // EFFECTS: parses meal from JSON object and adds it to the meal wishlist
    private void addMeal(MealWishList ml, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String cuisine = jsonObject.getString("cuisine");
        int price = jsonObject.getInt("price");
        String image = jsonObject.getString("image");

        Meal meal = new Meal(name, cuisine, price, image);
        ml.add(meal);

    }

}
