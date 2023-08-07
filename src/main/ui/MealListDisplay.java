package ui;

import model.Meal;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MealListDisplay implements ListCellRenderer<Meal> {
    private JPanel panel;
    private JPanel detailsPanel;
    private JLabel name;
    private JLabel cuisine;
    private JLabel price;

    private Meal value;
    private JList<? extends Meal> list;

    private ArrayList<Meal> mealsSelected;

    public MealListDisplay() {

        panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        name = new JLabel();
        cuisine = new JLabel();
        price = new JLabel();

        detailsPanel = new JPanel(new GridLayout(0, 1));
        detailsPanel.add(name);
        detailsPanel.add(cuisine);
        detailsPanel.add(price);

        panel.add(detailsPanel, BorderLayout.WEST);  // change later with added image

        mealsSelected = new ArrayList<>();

    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Meal> list,
                                                  Meal value, int index, boolean isSelected, boolean cellHasFocus) {
        this.value = value;
        this.list = list;

        setUp();

        name.setOpaque(true);
        cuisine.setOpaque(true);
        price.setOpaque(true);

        if (isSelected) {

            isSelected();

        } else {

            notSelected();

//            if (mealsSelected.contains(value)) {
//                mealsSelected.remove(value);
//            }
        }

        if (cellHasFocus) {
            detailsPanel.setBorder(BorderFactory.createLineBorder(Color.cyan));
        } else {
            detailsPanel.setBorder(BorderFactory.createEmptyBorder());
        }

        return panel;

    }

    private void setUp() {
        name.setText(value.getName());
        cuisine.setText(value.getCuisine());
        price.setText(String.valueOf(value.getPrice()));
    }

    private void isSelected() {
        price.setBackground(list.getSelectionBackground());
        name.setBackground(list.getSelectionBackground());
        cuisine.setBackground(list.getSelectionBackground());
        mealsSelected.add(value);
    }

    private void notSelected() {
        detailsPanel.setBorder(BorderFactory.createLineBorder(list.getBackground(), 10));
        price.setBackground(list.getBackground());
        name.setBackground(list.getBackground());
        cuisine.setBackground(list.getBackground());
    }


}


