package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// This class represents the list of meals in the program, and can be used in presenting the wishlist
public class MealWishList implements Writable {
    private String name;
    private ArrayList<Meal> meals;

    // constructs a list of meals that is empty
    public MealWishList(String name) {
        this.name = name;
        meals = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds meal to the meal list
    public void add(Meal meal) {

        meals.add(meal);
        EventLog.getInstance().logEvent(new Event("Meal: " + meal.getName() + " was added to "
                 + getName() + "."));

    }

    // MODIFIES: this
    // EFFECTS: removes meal from the meal list
    public void remove(Meal meal) {
        meals.remove(meal);
    }

    public String getName() {

        return name;
    }

    public int getNumMeals() {

        return meals.size();
    }

    public List<Meal> getMeals() {
        return Collections.unmodifiableList(meals);
    }

    // EFFECTS: returns the list of meals
    public ArrayList<Meal> getListOfMeals() {

        return meals;
    }

    // REQUIRES: index >= 0
    // MODIFIES: this
    // EFFECT: removes a meal from meal list by index,
    //         returns true if meal is removed and false if index doesn't exist in meal list
    public boolean removeMealByIndex(int index) {
        String name = meals.get(index).getName();

        EventLog.getInstance().logEvent(new Event("Meal: " + name + " was removed from "
                + getName() + "."));

        if (index >= 0 && index < meals.size()) {
            meals.remove(index);
            return true;
        } else {
            return false;
        }

    }

    // EFFECTS: returns the list of meals in form of String
    public String toString() {
        String output = "";
        for (int i = 0; i < meals.size(); i++) {
            Meal meal = meals.get(i);
            String mealInfo = meal.mealToText();
            output = output + i + ". " + mealInfo + "\n";
        }
        return output;

    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("meals", mealsToJson());
        return json;
    }

    // EFFECTS: returns meals in this list of meals
    private JSONArray mealsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Meal m: meals) {
            jsonArray.put(m.toJson());
        }

        return jsonArray;
    }


}

