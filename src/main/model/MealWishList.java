package model;

import java.util.ArrayList;

// This class represents the list of meals in the program, and can be used in presenting the wishlist
public class MealWishList {

    private ArrayList<Meal> listOfMeals;

    // constructs a list of meals that is empty
    public MealWishList() {
        listOfMeals = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds meal to the meal list
    public void add(Meal meal) {

        listOfMeals.add(meal);

    }

    // MODIFIES: this
    // EFFECTS: removes meal from the meal list
    public void remove(Meal meal) {

        listOfMeals.remove(meal);

    }

    // EFFECTS: returns the number of meals in the list
    public int getNumOfMeals() {

        return listOfMeals.size();
    }

    // EFFECTS: returns the list of meals
    public ArrayList<Meal> getListOfMeals() {
        return listOfMeals;
    }



}
