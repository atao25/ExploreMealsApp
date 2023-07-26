package model;


import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// This class represents a meal with a name, cuisine, price, and ingredients
public class Meal implements Writable {
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


    // EFFECTS: returns the meal information in form of String
    public String mealToText() {
        return name + "/" + cuisine + "/" + "$" + price;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("cuisine", cuisine);
        json.put("price", price);
        return json;
    }

}



