//package ui;
//
//import model.Meal;
//import model.MealWishList;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//
//public class MasterListWindow extends JFrame {
//
//    private Dimension frameDimensions;
//    private JButton addMealButton;
//    private JPanel masterListPanel;
//    private DefaultListModel<Meal> listModel = new DefaultListModel<>();
//    private JList<Meal> masterList = new JList<>(listModel);
//
//    protected MealListDisplay mealDisplay;
//
//    public MasterListWindow() {
//
//        frameDimensions = new Dimension(750, 500);
//        setUpFrame();
//
//        mealDisplay = new MealListDisplay();
//        masterListPanel = createPanel();
//
//        masterListPanel.add(makeNorthPanel(), BorderLayout.NORTH);
//        masterListPanel.add(makeSelectionPanel(), BorderLayout.CENTER);
//
//        add(masterListPanel);
//        setVisible(true);
//
//    }
//
//    private void setUpFrame() {
//        setSize(frameDimensions.width, frameDimensions.height);
//        setTitle("Available Meals");
//        setLocationRelativeTo(null);
//        setResizable(false);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//    }
//
//    private JPanel createPanel() {
//        return new JPanel(new BorderLayout());
//    }
//
//
//    private JButton createAddMealButton() {
//        addMealButton = new JButton("Add to personal wishlist");
//        addMealButton.addActionListener(new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                Meal selectedMeal = masterList.getSelectedValue();
////                if (selectedMeal != null) {
////                    PersonalWishListWindow.addToWishList(selectedMeal);
////                }
//            }
//        });
//
//        return addMealButton;
//    }
//
//
//    private JPanel makeNorthPanel() {
//        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
//        northPanel.add(createAddMealButton());
//
//        return northPanel;
//    }
//
//
//    private JPanel makeSelectionPanel() {
//        JPanel selectionPanel = new JPanel(new BorderLayout());
//        selectionPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.CYAN, 1),
//                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
//
//        JScrollPane mealScrollPane = new JScrollPane(createMasterList());
//        mealScrollPane.createVerticalScrollBar();
//        mealScrollPane.setHorizontalScrollBar(null);
//        selectionPanel.add(mealScrollPane);
//
//        return selectionPanel;
//    }
//
//    private JList<Meal> createMasterList() {
//
//        listModel.addElement(new Meal("Pizza", "Italian", 25));
//        listModel.addElement(new Meal("French Toast", "French", 22));
//        listModel.addElement(new Meal("Mac and Cheese", "American", 21));
//        listModel.addElement(new Meal("Lemon Blueberry Scone", "British", 20));
//        listModel.addElement(new Meal("Corn Dog", "American", 18));
//        listModel.addElement(new Meal("Sushi", "Japan", 26));
//        listModel.addElement(new Meal("Sweet and Sour Pork", "Chinese", 30));
//        listModel.addElement(new Meal("Tomato Pasta", "Italian", 28));
//        listModel.addElement(new Meal("Chicken Curry", "Indian", 29));
//        listModel.addElement(new Meal("Pho", "Vietnamese", 30));
//        listModel.addElement(new Meal("Caesar Salad", "Italian", 25));
//        listModel.addElement(new Meal("Bibimbap", "Korean", 32));
//        listModel.addElement(new Meal("Chicken Wings", "American", 26));
//
//        masterList.setCellRenderer(mealDisplay);
//
//        return masterList;
//    }
//
//}
//
//
//
//
//
