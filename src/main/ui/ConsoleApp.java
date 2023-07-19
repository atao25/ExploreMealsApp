package ui;

// This class represents the underlying operations for the user interface
// and it keeps the program running

import model.Meal;
import model.MealWishList;

import java.util.Scanner;

// Meal application
public class ConsoleApp {
    private Meal pizza;
    private Meal frenchToast;
    private Meal macAndCheese;
    private Meal scones;
    private Meal cornDog;
    private Meal sushi;
    private Meal pork;
    private MealWishList masterList;
    private MealWishList wishList;
    private Scanner input;


    public ConsoleApp() {
        runMealApp();
    }

    // MODIFIES: this
    // EFFECTS: processes user input,
    //          citations: TellerApp https://github.students.cs.ubc.ca/CPSC210/TellerApp
    private void runMealApp() {
        boolean keepGoing = true;
        String command;
        Scanner input = new Scanner((System.in));
        System.out.println("Explore Meals!");

        init();  //init

        while (keepGoing) {
            displayMenu();
            command = input.next();
            processUserInput(command);
        }
        System.out.println("Thank you for buying from us!");
    }

    private void processUserInput(String command) {
        if (command.equals("1")) {
            doViewMeals();

        } else if (command.equals("2")) {
            doViewWishlist();

        } else {
            System.out.println("Invalid Selection");
        }
    }


    private void doViewMeals() {
        System.out.println("Available Meals:\n");
        String masterListString = masterList.toString();
        System.out.println(masterListString);

        System.out.println("To add meal to personal wishlist, input 0, 1, 2, 3...\n");
        int index = input.nextInt();
        Meal mealSelected = masterList.getMealByIndex(index);
        wishList.add(mealSelected);
        System.out.println("Meal added!");


    }

    private void doViewWishlist() {
        System.out.println("My WishList:\n");
        String wishListString = wishList.toString();
        System.out.println(wishListString);

        System.out.println("To remove meal from personal wishlist, input 0, 1, 3...\n");
        int index = input.nextInt();
        boolean mealRemoved = wishList.removeMealByIndex(index);
        System.out.println("Meal removed!");

    }

    private void displayMenu() {
        System.out.println("1. View Meals");
        System.out.println(("2. View Personal Wishlist"));
        System.out.println(("Select 1 or 2"));
    }

    private void init() {
        pizza = new Meal("Pizza", "Italian", 25);
        frenchToast = new Meal("French Toast", "French", 22);
        macAndCheese = new Meal("Mac and Cheese", "American", 21);
        scones = new Meal("Lemon Blueberry Scones", "British", 20);
        cornDog = new Meal("Corn Dog", "American", 18);
        sushi = new Meal("California Roll Sushi", "Japan", 26);
        pork = new Meal("Sweet and Sour Pork", "Chinese", 30);

        masterList = new MealWishList();
        wishList = new MealWishList();

        masterList.add(pizza);
        masterList.add(frenchToast);
        masterList.add(macAndCheese);
        masterList.add(scones);
        masterList.add(cornDog);
        masterList.add(sushi);
        masterList.add(pork);

        input = new Scanner(System.in);

    }
}


