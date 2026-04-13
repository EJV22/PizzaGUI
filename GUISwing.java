import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUISwing {

    public GUISwing() {

        //Added a title and the Frame size for the app, also making sure that 

        JFrame frame = new JFrame("Eiron's Pizzaria!");
        frame.setSize(900, 700);

        //Closes program when user clicks off the application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Panel panel = new Panel();

        //Buttons for toppings and clear/cook
        JButton pepperoniBtn = new JButton("Pepperoni");
        JButton mushroomBtn = new JButton("Mushroom");
        JButton oliveBtn = new JButton("Olive");
        JButton cheeseBtn = new JButton("Cheese");
        JButton clearBtn = new JButton("Clear");
        JButton cookBtn = new JButton("Cook");

        // Label to indicate the pizza readiness/status of pizza
        JLabel statusLabel = new JLabel("Click on pizza to place toppings");
        

        // ComboBox for all the different sauces!
        String[] sauces = {"Tomato", "Pesto", "Alfredo", "Cheese"};
        JComboBox<String> sauceBox = new JComboBox<>(sauces);

        // Action Listeners______________________________________

        // The toping buttoms allows to set specific topings to draw on!
        pepperoniBtn.addActionListener(e -> panel.setCurrentTopping("pepperoni"));
        mushroomBtn.addActionListener(e -> panel.setCurrentTopping("mushroom"));
        oliveBtn.addActionListener(e -> panel.setCurrentTopping("olive"));
        cheeseBtn.addActionListener(e -> panel.setCurrentTopping("cheese"));

        // Clears the entire pizza and changes its status! 
        clearBtn.addActionListener(e -> {
                panel.clearPizza();
                statusLabel.setText("Click on pizza to place toppings");
                });

        // Changes cookPizza() status and indicates through text based on cooked labelling
        cookBtn.addActionListener(e -> {
                panel.cookPizza();
                            
                if (panel.getCookPizza() > 2){
                    statusLabel.setText("Pizza is too burnt! Please reset!");
                }
                else if (panel.getCookPizza() == 1){
                    statusLabel.setText("Cooking!");
                }
                else if (panel.getCookPizza() == 2) statusLabel.setText("Perfect!");
            });
        

        // Uses a getter on the selected sauce in the box!
        sauceBox.addActionListener(e -> panel.setSauce((String)sauceBox.getSelectedItem()));

        
        // Panels for each interface Area!______________________________________________________
        JPanel top = new JPanel();
        top.add(statusLabel);

        JPanel left = new JPanel();
        left.setLayout(new GridLayout(0, 1));
        left.add(pepperoniBtn);
        left.add(mushroomBtn);
        left.add(oliveBtn);
        left.add(cheeseBtn);

        JPanel bottom = new JPanel();
        bottom.add(clearBtn);
        bottom.add(cookBtn);
        bottom.add(sauceBox);
        

        // Makes sure all the buttons, boxes, and text are not in the same area of the Frame!!
        frame.add(top, BorderLayout.NORTH);
        frame.add(left, BorderLayout.WEST);
        frame.add(bottom, BorderLayout.SOUTH);
        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void main(String[] args) {

        // Creates a new PizzaGame Object each run!
        new GUISwing();
    }
}