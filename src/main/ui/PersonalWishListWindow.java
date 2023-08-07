//package ui;
//
//import model.Meal;
//import model.MealWishList;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//
//public class PersonalWishListWindow extends JFrame {
//
//    private JButton deleteMealButton;
//    private Dimension frameDimensions;
//    private JPanel wishListPanel;
//    protected MealListDisplay mealDisplay;
//
//    private DefaultListModel<Meal> wishListModel = new DefaultListModel<>();
//    private JList<Meal> wishList = new JList<>(wishListModel);
//
//    private MealWishList mealWishList;
//
//    public PersonalWishListWindow() {
//
//        frameDimensions = new Dimension(750, 500);
//        setUpFrame();
//
//        mealDisplay = new MealListDisplay();
//        wishListPanel = createPanel();
//
//        wishListPanel.add(makeNorthPanel(), BorderLayout.NORTH);
//        wishListPanel.add(makeListPanel(), BorderLayout.CENTER);
//
//        add(wishListPanel);
//        setVisible(true);
//
//    }
//
//
//    private void setUpFrame() {
//        setSize(frameDimensions.width, frameDimensions.height);
//        setTitle("My Wishlist");
//        setLocationRelativeTo(null);
//        setResizable(false);
//        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // maybe dispose?
//    }
//
//    private JPanel createPanel() {
//        return new JPanel(new BorderLayout());
//    }
//
//    private JPanel makeNorthPanel() {
//        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
//        northPanel.add(deleteMealButton());
//
//        return northPanel;
//    }
//
//    private JPanel makeListPanel() {
//        JPanel selectionPanel = new JPanel(new BorderLayout());
//        selectionPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.CYAN, 1),
//                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
//        JScrollPane wishListScrollPane = new JScrollPane(wishList);
//        wishListScrollPane.createVerticalScrollBar();
//        wishListScrollPane.setHorizontalScrollBar(null);
//        selectionPanel.add(wishListScrollPane);
//
//        return selectionPanel;
//    }
//
//    private JButton deleteMealButton() {
//        deleteMealButton = new JButton("Delete meal");
//        deleteMealButton.addActionListener(new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                deleteDialog();
//            }
//        });
//
//        return deleteMealButton;
//    }
//
//    private void deleteDialog() {
//        int selectedIndex = wishList.getSelectedIndex();
//        if (selectedIndex != -1) {
//            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this meal?",
//                    "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
//
//            if (result == JOptionPane.YES_OPTION) {
//                wishListModel.remove(selectedIndex);
//            }
////
////            if (result == JOptionPane.YES_OPTION) {
////                Meal selectedMeal = wishListModel.getElementAt(selectedIndex);
////                mealWishList.remove(selectedMeal);
////                updateWishList();
////            } else if (result == JOptionPane.NO_OPTION) {
////                dispose();
////            }
////        }
//
//        }
//
//
//    }
//}
//
//
