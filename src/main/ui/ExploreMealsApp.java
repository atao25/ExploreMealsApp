package ui;

import model.Meal;
import model.MealWishList;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

public class ExploreMealsApp extends JFrame {

    private static final String JSON_STORE = "./data/mealWishList.json";

    private MealWishList mealWishList;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private Dimension frameDimensions;
    private JLabel welcomeMessage;
    private JButton viewMealsButton;
    private JPanel mainContainer;
    private JButton wishListButton;
    private JButton exitButton;
    private JButton saveButton;

    public static void main(String[] args) {
        new ExploreMealsApp();
    }


    public ExploreMealsApp() {
        frameDimensions = new Dimension(750, 500);
        setFrame();
        mainContainer = setUpMainPanel();
        makeMainContainer();
        add(mainContainer);
        pack();
        setVisible(true);
        loadWishListDialog();

    }

    public void setFrame() {
        setTitle("ExploreMeals App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(frameDimensions.width, frameDimensions.height);

    }

    public JPanel setUpMainPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 0, 12));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 130, 50, 130));

        return panel;
    }

    private void makeMainContainer() {
        welcomeMessage = new JLabel("Welcome to Explore Meals!", SwingConstants.CENTER);
        welcomeMessage.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        
        mainContainer.add(welcomeMessage);
        mainContainer.add(createViewMealsButton());
        mainContainer.add(createWishListButton());
        mainContainer.add(createSaveButton());
        mainContainer.add(createExitButton());
    }

    private JButton createViewMealsButton() {
        viewMealsButton = new JButton("View Meals");
        viewMealsButton.setFocusable(false);
        viewMealsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MasterListWindow();
               // dispose();
            }

        });
        return viewMealsButton;
    }

    private JButton createWishListButton() {
        wishListButton = new JButton("View Personal Wishlist");
        wishListButton.setFocusable(false);
        viewMealsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MasterListWindow();
            }
        });

        return wishListButton;
    }


    private JButton createSaveButton() {
        saveButton = new JButton("Save Wishlist");
        saveButton.setFocusable(false);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        return saveButton;
    }

    private JButton createExitButton() {
        exitButton = new JButton("Exit App");
        exitButton.setFocusable(false);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeApp();
            }
        });

        return exitButton;
    }


    private void closeApp() {

        int result = JOptionPane.showConfirmDialog(null, "Did you save your data?", "Confirm Save",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        switch (result) {
            case JOptionPane.NO_OPTION:
                System.out.println("No");
                break;
            case JOptionPane.YES_OPTION:
                System.exit(0);
        }
    }

    private void loadWishListDialog() {

        int result = JOptionPane.showConfirmDialog(null, "Would you like to load an existing wishlist of meals?",
                "Load Wishlist", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        switch (result) {
            case JOptionPane.NO_OPTION:
                System.out.println("No");
                break;
            case JOptionPane.YES_OPTION:
                try {
                    mealWishList = jsonReader.read();                   // check later
                } catch (IOException e) {
                    System.out.println("Unable to read from file " + JSON_STORE);
                }
        }
    }
}




// panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.cyan, 1),
//                BorderFactory.createEmptyBorder(5, 5, 5, 5)));