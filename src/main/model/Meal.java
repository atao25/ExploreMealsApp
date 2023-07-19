package model;

// This class represents a meal with a name, cuisine, price, and ingredients
import java.util.ArrayList;
import java.util.List;

public class Meal {
    private String name;
    private String cuisine;
    private int price;
    private List<String> ingredients;


    // EFFECTS: creates a meal with name, cuisine, empty list of ingredients
    public Meal(String name, String cuisine, int price) {
        this.name = name;
        this.cuisine = cuisine;
        this.price = price;
        this.ingredients = new ArrayList<>();
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

    public List<String> getIngredients() {
        return ingredients;
    }

    // EFFECTS: sets the name of the meal
    public void setName(String name) {
        this.name = name;
    }

    // EFFECTS: sets the cuisine of the meal
    public void setCuisine() {
        this.cuisine = cuisine;
    }

    // EFFECTS: sets the price of the meal
    public void setPrice(int price) {
        this.price = price;
    }

    // EFFECTS: returns the meal information in form of String
    public String mealToText() {
        String text = "";
        text = name + "/" + cuisine + "/" + "$" + price;
        return text;
    }

}


