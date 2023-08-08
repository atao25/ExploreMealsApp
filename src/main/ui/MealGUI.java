package ui;

import model.Meal;
import model.MealWishList;

import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

// Represents graphical user interface
public class MealGUI {

    // for main menu
    private JFrame mainFrame;
    private Dimension frameDimensions;
    private JPanel mainContainer;
    private JLabel welcomeMessage;
    private JButton viewMealsButton;
    private JButton wishListButton;
    private JButton saveButton;
    private JButton exitButton;

    // for view meals frame
    private JFrame viewMealsFrame;
    private JPanel masterListPanel;
    private JButton addMealButton;
    private MealWishList mealWishList;
    protected MealListDisplay mealDisplay;
    private DefaultListModel<Meal> listModel = new DefaultListModel<>();  // masterlist
    private JList<Meal> masterList = new JList<>(listModel);

    // for wishlist frame
    private JFrame viewPersonalWishListFrame;
    private JPanel wishListPanel;
    private JButton deleteMealButton;
    private DefaultListModel<Meal> wishListModel = new DefaultListModel<>();   // wishlist
    private JList<Meal> wishList = new JList<>(wishListModel);

    // json
    private JsonReader jsonReader;
    private JsonWriter jsonWriter;
    private static final String JSON_STORE = "./data/mealWishList.json";



    // EFFECTS: constructs the main application window
    public MealGUI() {
        mealWishList = new MealWishList("My Wishlist");

        mainFrame = new JFrame();
        frameDimensions = new Dimension(750, 500);
        setFrame();
        mainContainer = setUpMainPanel();
        makeMainContainer();
        mainFrame.add(mainContainer);
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        loadWishListDialog();

        mealDisplay = new MealListDisplay();

    }

    public static void main(String[] args) {
        new MealGUI();
    }

    // MODIFIES: mainFrame
    // EFFECTS: sets up the main frame
    public void setFrame() {
        mainFrame.setTitle("ExploreMeals App");
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.setSize(frameDimensions.width, frameDimensions.height);

    }

    // MODIFIES: mainFrame
    // EFFECTS: sets up the layout of the main panel
    private JPanel setUpMainPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 0, 12));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 130, 50, 130));

        return panel;
    }

    // MODIFIES: mainFrame
    // EFFECTS: sets up the main container with the welcome message and buttons
    private void makeMainContainer() {
        welcomeMessage = new JLabel("Welcome to Explore Meals!", SwingConstants.CENTER);
        welcomeMessage.setFont(new Font(Font.SERIF, Font.BOLD, 26));

        mainContainer.add(welcomeMessage);
        mainContainer.add(createViewMealsButton());
        mainContainer.add(createWishListButton());
        mainContainer.add(createSaveButton());
        mainContainer.add(createExitButton());
    }

    // MODIFIES: mainFrame
    // EFFECTS: creates the view meals button and allows user to view master list of meals when clicked
    private JButton createViewMealsButton() {
        viewMealsButton = new JButton("View Meals");
        viewMealsButton.setFocusable(false);
        viewMealsButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewMealsFrame();
            }
        });

        return viewMealsButton;
    }

    // MODIFIES: mainFrame
    // EFFECTS: creates view personal wishlist button and allows user to view wishlist when clicked
    private JButton createWishListButton() {
        wishListButton = new JButton("View Personal WishList");
        wishListButton.setFocusable(false);
        wishListButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                personalWishListFrame();
            }
        });

        return wishListButton;
    }

    // MODIFIES: mainFrame
    // EFFECTS: creates save button and allows user to save their data when clicked
    private JButton createSaveButton() {
        saveButton = new JButton("Save WishList");
        saveButton.setFocusable(false);
        saveButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveWishListToFile();

            }
        });

        return saveButton;
    }

    // EFFECTS: saves data to file
    private void saveWishListToFile() {
        try {
            jsonWriter = new JsonWriter(JSON_STORE);
            jsonWriter.open();
            jsonWriter.write(mealWishList);
            jsonWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error");  // change
        }
    }

    // MODIFIES: mainFrame
    // EFFECTS: creates exit button and allows user to quit the app when clicked,
    private JButton createExitButton() {
        exitButton = new JButton("Exit App");
        exitButton.setFocusable(false);
        exitButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeApp();
            }
        });

        return exitButton;
    }

    // MODIFIES: mainFrame
    // EFFECTS: closes the app, reminds user to save data using confirmation dialog
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

    // MODIFIES: mainFrame
    // EFFECTS: displays load wishlist dialog
    private void loadWishListDialog() {
        int result = JOptionPane.showConfirmDialog(null, "Would you like to load an existing wishlist of meals?",
                "Load Wishlist", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        switch (result) {
            case JOptionPane.NO_OPTION:
                System.out.println("No");
                break;
            case JOptionPane.YES_OPTION:
                try {
                    jsonReader = new JsonReader(JSON_STORE);
                    mealWishList = jsonReader.read();
                    wishListModel.clear();

                    for (Meal meal: mealWishList.getMeals()) {
                        wishListModel.addElement(meal);
                    }

                    wishList.setCellRenderer(new MealListDisplay());

                } catch (IOException e) {
                    System.out.println("Unable to read from file " + JSON_STORE);
                }
                break;
        }
    }

    // EFFECTS: creates viewMealsFrame
    private JFrame viewMealsFrame() {
        setUpViewMeal();

        masterListPanel = new JPanel(new BorderLayout());
        masterListPanel.add(makeNorthPanel(), BorderLayout.NORTH);
        masterListPanel.add(makeSelectionPanel(), BorderLayout.CENTER);

        viewMealsFrame.add(masterListPanel);
        viewMealsFrame.setVisible(true);

        return viewMealsFrame;
    }

    // MODIFIES: viewMealsFrame
    // EFFECTS: sets up the frame for view meals
    private void setUpViewMeal() {
        viewMealsFrame = new JFrame();
        viewMealsFrame.setSize(frameDimensions);
        viewMealsFrame.setTitle("Available Meals");
        viewMealsFrame.setLocationRelativeTo(null);
        viewMealsFrame.setResizable(false);
    }

    // MODIFIES: viewMealsFrame
    // EFFECTS: creates the top panel for viewMealsFrame
    private JPanel makeNorthPanel() {
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        northPanel.add(createAddMealButton());

        return northPanel;
    }

    // MODIFIES: viewMealsFrame
    // EFFECTS: creates the panel for the list of meals
    private JPanel makeSelectionPanel() {
        JPanel selectionPanel = new JPanel(new BorderLayout());
        selectionPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.CYAN, 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        JScrollPane mealScrollPane = new JScrollPane(createMasterList());
        mealScrollPane.createVerticalScrollBar();
        mealScrollPane.setHorizontalScrollBar(null);
        selectionPanel.add(mealScrollPane);

        return selectionPanel;
    }

    // MODIFIES: viewMealsFrame
    // EFFECTS: creates add meal button and allows user to add selected meal to personal wishlist
    private JButton createAddMealButton() {
        addMealButton = new JButton("Add to personal wishlist");
        addMealButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = masterList.getSelectedIndex();
                if (selectedIndex != -1) {
                    Meal selectedMeal = listModel.getElementAt(selectedIndex);
                    wishListModel.addElement(selectedMeal);
                    wishList.setCellRenderer(mealDisplay);
                    mealWishList.add(selectedMeal);
                }
            }
        });

        return addMealButton;
    }

    // MODIFIES: viewMealsFrame
    // EFFECTS: creates JList of available meals
    private JList<Meal> createMasterList() {

        listModel.addElement(new Meal("Pizza", "Italian", 25, "./data/pizza.jpeg"));
        listModel.addElement(new Meal("French Toast", "French", 22, "./data/frenchToast.png"));
        listModel.addElement(new Meal("Mac and Cheese", "American", 21, "./data/macAndCheese.png"));
        listModel.addElement(new Meal("Lemon Blueberry Scone", "British", 20, "./data/scone.png"));
        listModel.addElement(new Meal("Corn Dog", "American", 18, "./data/cornDog.png"));
        listModel.addElement(new Meal("Sushi", "Japan", 26, "./data/sushi.png"));
        listModel.addElement(new Meal("Sweet and Sour Pork", "Chinese", 30, "./data/sweetAndSourPork.png"));
        listModel.addElement(new Meal("Tomato Pasta", "Italian", 28, "./data/pasta.png"));
        listModel.addElement(new Meal("Chicken Curry", "Indian", 29, "./data/curry.png"));
        listModel.addElement(new Meal("Pho", "Vietnamese", 30, "./data/pho.png"));
        listModel.addElement(new Meal("Caesar Salad", "Italian", 25,"./data/caesarSalad.png"));
        listModel.addElement(new Meal("Bibimbap", "Korean", 32, "./data/bibimbap.png"));
        listModel.addElement(new Meal("Chicken Wings", "American", 26, "./data/chickenWings.png"));

        masterList.setCellRenderer(mealDisplay);

        return masterList;
    }

    // EFFECTS: creates the view personal wishlist frame
    private JFrame personalWishListFrame() {
        setUpWishList();

        wishListPanel = new JPanel(new BorderLayout());

        wishListPanel.add(makeTopPanel(), BorderLayout.NORTH);
        wishListPanel.add(makeListPanel(), BorderLayout.CENTER);


        viewPersonalWishListFrame.add(wishListPanel);
        viewPersonalWishListFrame.setVisible(true);

        return viewPersonalWishListFrame;

    }

    // MODIFIES: viewPersonalWishListFrame
    // EFFECTS: sets up the view personal wishlist frame
    private void setUpWishList() {
        viewPersonalWishListFrame = new JFrame();
        viewPersonalWishListFrame.setSize(frameDimensions);
        viewPersonalWishListFrame.setTitle("Available Meals");
        viewPersonalWishListFrame.setLocationRelativeTo(null);
        viewPersonalWishListFrame.setResizable(false);
    }

    // MODIFIES: viewPersonalWishListFrame
    // EFFECTS: constructs the top panel for the frame
    private JPanel makeTopPanel() {
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        topPanel.add(createDeleteMealButton());

        return topPanel;
    }

    // MODIFIES: viewPersonalWishListFrame
    // EFFECTS: creates panel for wishlist
    private JPanel makeListPanel() {
        JPanel selectionPanel = new JPanel(new BorderLayout());
        selectionPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.CYAN, 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        JScrollPane wishListScrollPane = new JScrollPane(wishList);
        wishListScrollPane.createVerticalScrollBar();
        wishListScrollPane.setHorizontalScrollBar(null);
        selectionPanel.add(wishListScrollPane);

        return selectionPanel;
    }

    // MODIFIES: viewPersonalWishListFrame
    // EFFECTS: creates delete meal button and allows user to delete selected meal from wishlist
    private JButton createDeleteMealButton() {
        deleteMealButton = new JButton("Delete selected meal");
        deleteMealButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteDialog();
            }
        });

        return deleteMealButton;
    }

    // MODIFIES: viewPersonalWishListFrame
    // EFFECTS: creates delete confirmation dialog
    private void deleteDialog() {
        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this meal?",
                "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        switch (result) {
            case JOptionPane.NO_OPTION:
                // don't do anything, close the dialog
                break;

            case JOptionPane.YES_OPTION:
                int selectedMeal = wishList.getSelectedIndex();
                wishListModel.remove(selectedMeal);
                mealWishList.removeMealByIndex(selectedMeal);

        }

    }
}


