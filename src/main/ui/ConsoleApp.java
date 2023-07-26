package ui;

// This class represents the underlying operations for the user interface,
// and it keeps the program running

import model.Meal;
import model.MealWishList;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Meal application
// Citation: TellerApp https://github.students.cs.ubc.ca/CPSC210/TellerApp.git

public class ConsoleApp {
    private MealWishList masterList;
    private MealWishList wishList;

    private static final String JSON_STORE = "./data/mealWishList.json";
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;


    // EFFECTS: constructs list of meals and runs the meal app
    public ConsoleApp() throws FileNotFoundException {
        input = new Scanner(System.in);
        wishList = new MealWishList("MealWishList");
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);
        runMealApp();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runMealApp() {
        boolean keepGoing = true;
        String command;
        Scanner input = new Scanner((System.in));
        System.out.println("\nExplore Meals!");

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            if (command.equals("exit")) {
                keepGoing = false;
            }
            processUserCommand(command);
        }
        System.out.println("Thank you for your time!");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processUserCommand(String command) {
        if (command.equals("m")) {
            doViewMeals();
        } else if (command.equals("p")) {
            doViewWishlist();
        } else if (command.equals("q")) {
            System.out.println("Goodbye!");
        } else if (command.equals("s")) {
            saveMealWishList();
        } else if (command.equals("l")) {
            loadMealWishList();
        } else {
            System.out.println("Invalid selection");
        }
    }

    // MODIFIES: this
    // EFFECTS: displays list of all available meals in meal app
    //          allows user to select meal to add to wishlist
    private void doViewMeals() {
        System.out.println("Available Meals:\n");
        String masterListString = masterList.toString();
        System.out.println(masterListString);
        System.out.println("To add meal to personal wishlist, input 0, 1, 2, 3...");
        System.out.println("To exit View Meals, input b\n");

        if (input.hasNextInt()) {
            int index = input.nextInt();
            Meal mealSelected = masterList.getListOfMeals().get(index);
            wishList.add(mealSelected);
            System.out.println("Meal added!\n");
        } else {
            String text = input.next();
            if (text.equals("b")) {
                System.out.println("Heading back to main menu:");
            } else {
                System.out.println("Invalid selection: heading back to main menu:\n");
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: displays all meal items in wishlist
    //          allows user to remove meals from wishlist
    private void doViewWishlist() {
        System.out.println("My WishList:\n");
        String wishListString = wishList.toString();
        System.out.println(wishListString);

        System.out.println("To remove meal from Personal Wishlist, input 0, 1, 3...");
        System.out.println("To exit WishList, input b\n");

        if (input.hasNextInt()) {
            int index = input.nextInt();
            wishList.removeMealByIndex(index);
            System.out.println("Meal removed!\n");
        } else {
            String text = input.next();
            if (text.equals("b")) {
                System.out.println("Heading back to main menu:\n");
            } else {
                System.out.println("Invalid: heading back to main menu:\n");
            }
        }
    }

    // EFFECTS: displays menu of options to select
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("m -> View Meals");
        System.out.println(("p -> View Personal Wishlist"));
        System.out.println("s -> save meal wishlist to file");
        System.out.println("l -> load meal wishlist to file");
        System.out.println("q -> quit");
    }

    // MODIFIES: this
    // EFFECTS: initializes meals
    private void init() {

        try {
            JsonReader reader = new JsonReader("./data/MasterMealWishList.json");
            masterList = new MealWishList("masterList");
            masterList = reader.read();
        } catch (IOException e) {
            System.out.println("File doesn't exist");
        }

        input = new Scanner(System.in);

    }

    // EFFECTS: saves meal wishlist to file
    private void saveMealWishList() {
        try {
            jsonWriter.open();
            jsonWriter.write(wishList);
            jsonWriter.close();
            System.out.println("Saved " + wishList.getName() + " to" + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads meal wishlist to file
    private void loadMealWishList() {
        try {
            wishList = jsonReader.read();
            System.out.println("Loaded " + wishList.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}

