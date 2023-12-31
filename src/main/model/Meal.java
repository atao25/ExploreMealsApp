package model;

import org.json.JSONObject;
import persistence.Writable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


// This class represents a meal with a name, cuisine, price, and ingredients
public class Meal implements Writable {
    private String name;
    private String cuisine;
    private int price;

    private String imagePath;
    private int imageWidth = 100;
    private int imageHeight = 100;

    private List<String> ingredients;



    // EFFECTS: creates a meal with name, cuisine, empty list of ingredients
    public Meal(String name, String cuisine, int price, String imagePath, List<String> ingredients) {
        this.name = name;
        this.cuisine = cuisine;
        this.price = price;
        this.imagePath = imagePath;
        this.ingredients = ingredients;

    }

    // EFFECTS: gets the name of the meal
    public String getName() {
        return name;
    }

    // EFFECTS: gets the cuisine of the meal
    public String getCuisine() {
        return cuisine;
    }

    // EFFECTS: gets the price of the meal
    public int getPrice() {
        return price;
    }

    // EFFECTS: gets image from file
    public Image getImage() throws IOException {
        BufferedImage img = ImageIO.read(new File(imagePath));
        return img.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);

    }

    // EFFECTS: returns the meal information in form of String
    public String mealToText() {
        return name + "/" + cuisine + "/" + "$" + price;
    }

    // EFFECTS: returns the list of ingredients
    public List<String> getIngredients() {
        return ingredients;
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("cuisine", cuisine);
        json.put("price", price);
        json.put("image", imagePath);
        json.put("ingredients", ingredients);

        return json;
    }

}



