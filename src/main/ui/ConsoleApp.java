package ui;

// This class represents the underlying operations for the user interface,
// and it keeps the program running

import model.Meal;
import model.MealWishList;

import java.util.Scanner;

// Meal application
// Citation: TellerApp https://github.students.cs.ubc.ca/CPSC210/TellerApp.git

public class ConsoleApp {
    private Meal pizza;
    private Meal frenchToast;
    private Meal macAndCheese;
    private Meal scones;
    private Meal cornDog;
    private Meal sushi;
    private Meal pork;
    private Meal pasta;
    private Meal curry;
    private Meal pho;
    private Meal salad;
    private Meal rice;
    private Meal wings;
    private MealWishList masterList;
    private MealWishList wishList;
    private Scanner input;

    // EFFECTS: runs the MealApp
    public ConsoleApp() {
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
        if (command.equals("1")) {
            doViewMeals();

        } else if (command.equals("2")) {
            doViewWishlist();
        } else if (command.equals("exit")) {
            System.out.println("Goodbye!");
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

        System.out.println("To add meal to personal wishlist, input 0, 1, 2, 3...\n");
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
        System.out.println("1. View Meals");
        System.out.println(("2. View Personal Wishlist\n"));
        System.out.println(("Select 1 or 2"));
        System.out.println("Input exit to end session");
    }

    // MODIFIES: this
    // EFFECTS: initializes meals
    private void init() {
        pizza = new Meal("Pizza", "Italian", 25);
        frenchToast = new Meal("French Toast", "French", 22);
        macAndCheese = new Meal("Mac and Cheese", "American", 21);
        scones = new Meal("Lemon Blueberry Scones", "British", 20);
        cornDog = new Meal("Corn Dog", "American", 18);
        sushi = new Meal("California Roll Sushi", "Japan", 26);
        pork = new Meal("Sweet and Sour Pork", "Chinese", 30);
        pasta = new Meal("Tomato Pasta", "Italian", 28);
        curry = new Meal("Chicken Curry", "Indian", 29);
        pho = new Meal("Pho", "Vietnamese", 30);
        salad = new Meal("Caesar Salad", "Italian", 25);
        rice = new Meal("Bibimbap", "Korean", 32);
        wings = new Meal("Chicken Wings", "American", 26);

        initializeList();

        input = new Scanner(System.in);

    }

    // MODIFIES: this
    // EFFECTS: initializes available list of meals
    private void initializeList() {
        masterList = new MealWishList();
        wishList = new MealWishList();

        masterList.add(pizza);
        masterList.add(frenchToast);
        masterList.add(macAndCheese);
        masterList.add(scones);
        masterList.add(cornDog);
        masterList.add(sushi);
        masterList.add(pork);
        masterList.add(pasta);
        masterList.add(curry);
        masterList.add(pho);
        masterList.add(salad);
        masterList.add(rice);
        masterList.add(wings);
    }
}


