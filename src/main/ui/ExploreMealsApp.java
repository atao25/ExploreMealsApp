package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;

// the GUI for the Explore Meals app
public class ExploreMealsApp extends JFrame {
    Dimension frameDimensions;
    JPanel mainContainer;

    public static void main(String[] args) {
        new ExploreMealsApp();
    }

    // EFFECTS: constructs a new window
    public ExploreMealsApp() {
        frameDimensions = new Dimension(800, 500);
        setFrame();
        mainContainer = setUpMainPanel();
        makeNewContainer();
        add(mainContainer);

        setVisible(true);


    }

    public void setFrame() {
        setTitle("EXPLORE MEALS");
        setSize(frameDimensions.width, frameDimensions.height);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        closeMessage();
    }

    public void closeMessage() {
        // deal with later
    }

    public JPanel setUpMainPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 0, 12));
        BorderFactory.createEmptyBorder(60, 130, 60, 130);

      //  JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.CYAN, 1),
                BorderFactory.createEmptyBorder(8, 9, 6, 12))); // borders the text

        return panel;

    }

    public void makeNewContainer() {
        JLabel label = new JLabel("Welcome to ExploreMeals!");


//        JPanel panel = new JPanel();
//        panel.setLayout(new BorderLayout());
//
//        panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.CYAN, 1),
//                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
//
//        label.setFont(new Font(Font.SERIF, Font.BOLD, 24));
//
//        mainContainer.add(panel);


    }
}







