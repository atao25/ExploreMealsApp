package model;

import java.util.ArrayList;
import java.util.List;

// This class represents the list of meals in the program, and can be used in presenting the wishlist
public class MealWishList {

    private ArrayList<Meal> listOfMeals;
   // private int index;

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

    // REQUIRES: index >= 0
    // MODIFIES: this
    // EFFECT: gets a meal by its index
    public Meal getMealByIndex(int index) {
        Meal temp = new Meal("", "", 0);
        if (index >= 0 && index < listOfMeals.size()) {
            temp = listOfMeals.get(index);
        }
        return temp;
    }

    // MODIFIES: this
    // EFFECT: removes a meal from meal list by index
    //         returns true if meal is removed and false if index doesn't exist in meal list
    public boolean removeMealByIndex(int index) {
        if (index >= 0 && index < listOfMeals.size()) {
            listOfMeals.remove(index);
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < listOfMeals.size(); i++) {
            int mealNumber = i;
            Meal meal = listOfMeals.get(i);
            String mealInfo = meal.mealToText();
            output = output + mealNumber + ". " + mealInfo + "\n";
        }
        return output;

    }


}
