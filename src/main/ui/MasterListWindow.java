package ui;

import model.Meal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MasterListWindow extends JFrame {
    private Dimension frameDimensions;
    private JButton addMealButton;
    private JPanel masterListPanel;
    private DefaultListModel<Meal> listModel = new DefaultListModel<>();
    private JList<Meal> masterList = new JList<>(listModel);

   // protected MealListDisplay mealDisplay;


    public MasterListWindow() {
        frameDimensions = new Dimension(750, 500);
        setUpFrame();
        masterListPanel = createPanel();

        masterListPanel.add(makeNorthPanel(), BorderLayout.NORTH);
        masterListPanel.add(makeSelectionPanel(), BorderLayout.CENTER);

        add(masterListPanel);
        setVisible(true);

    }

    private void setUpFrame() {
        setSize(frameDimensions.width, frameDimensions.height);
        setTitle("Available Meals");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private JPanel createPanel() {
        return new JPanel(new BorderLayout());
    }


    private JButton createAddMealButton() {
        addMealButton = new JButton("Add to personal wishlist");
        addMealButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        return addMealButton;
    }


    private JPanel makeNorthPanel() {
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        northPanel.add(createAddMealButton());

        return northPanel;
    }


    private JPanel makeSelectionPanel() {
        JPanel selectionPanel = new JPanel(new BorderLayout());
        selectionPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.CYAN, 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        selectionPanel.add(new JScrollPane(createMasterList()));

        return selectionPanel;
    }

    private JList<Meal> createMasterList() {

        listModel.addElement(new Meal("Pizza", "Italian", 25));
        listModel.addElement(new Meal("Pasta", "Italian", 22));

       // masterList.setCellRenderer(mealDisplay);

        return masterList;
    }

}










