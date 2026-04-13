import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

//Panel responsible for drawing the pizza and handling user interaction.

public class Panel extends JPanel {

    // Different statuses for toppings, sauces, and cooked level
    private ArrayList<Topping> toppings;
    private String currentTopping;
    private String sauceType;
    private int cookPizza;

    public Panel() {
        toppings = new ArrayList<>();
        currentTopping = "pepperoni";
        sauceType = "Tomato";
        cookPizza = 0;

        // Mouse listener for placing toppings, making sure it isn't outside of the pizza
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                if (cookPizza > 2) return;

                int x = e.getX();
                int y = e.getY();

                int radius = 200;
                int margin = 10;

                int centerX = radius + 150;
                int centerY = radius + 100;

                int dx = x - centerX;
                int dy = y - centerY;
                

                if (dx * dx + dy * dy <= (radius-margin)*(radius-margin)){
                    toppings.add(new Topping(x, y, currentTopping));
                    repaint();
            }
        }});
    }

    // Sets the current topping type.

    public void setCurrentTopping(String topping) {
        currentTopping = topping;
    }

    //Clears all toppings from the pizza.

    public void clearPizza() {
        toppings.clear();
        cookPizza = 0;
        repaint();
    }

    // Sets sauce type.

    public void setSauce(String sauce) {
        sauceType = sauce;
        repaint();
    }

    // Changes pizza status

    public void cookPizza(){
        cookPizza++;
        repaint();
    }

    // Returns pizza status

    public int getCookPizza(){
        return cookPizza;
    }

    // This draws all the toppings sauces and the pizza itself!!!__________

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int pizzaX = 150;
        int pizzaY = 100;
        int pizzaSize = 400;  
        
        g.setColor( new Color(210,170,90));
        g.fillOval(pizzaX - 40, pizzaY - 35, 475, 475);
        g.fillRect(pizzaX + 125, pizzaY + 50, 550, 300);

        // Draws crust according to the state of the pizza

        if (cookPizza == 0){
            g.setColor(new Color(255, 220, 120));
            g.fillOval(pizzaX, pizzaY, pizzaSize, pizzaSize);
        }
        else if (cookPizza == 1){
            g.setColor(new Color(175,140,50));
            g.fillOval(pizzaX, pizzaY, pizzaSize, pizzaSize);
        }
        else if (cookPizza == 2){
            g.setColor(new Color(120,90,10));
            g.fillOval(pizzaX, pizzaY, pizzaSize, pizzaSize);
        }
        else {
            g.setColor(Color.BLACK);
            g.fillOval(pizzaX, pizzaY, pizzaSize, pizzaSize);
        }

        // Draws sauce
        if (sauceType.equals("Tomato")) {
            g.setColor(Color.RED);
        }
        
        else if (sauceType.equals("Pesto")) {
            g.setColor(new Color(8, 156, 18));
        }
        
        else if (sauceType.equals("Alfredo")) {
            g.setColor(new Color(240,245,198));
        }

        else{
            g.setColor(new Color(255, 225, 140));
        }
        g.fillOval(pizzaX + 20, pizzaY + 20, pizzaSize - 40, pizzaSize - 40);

        
        // Draws cheese based on the state of the pizza

        if (cookPizza == 0){
            g.setColor(new Color(255, 225, 140));
            g.fillOval(pizzaX + 40, pizzaY + 40, pizzaSize - 80, pizzaSize - 80);
        }
        else if (cookPizza <= 2){
            g.setColor(new Color(230, 180, 50));
            g.fillOval(pizzaX + 40, pizzaY + 40, pizzaSize - 80, pizzaSize - 80);
        }
        else {
            g.setColor(new Color(140, 110, 30));
            g.fillOval(pizzaX + 40, pizzaY + 40, pizzaSize - 80, pizzaSize - 80);
        }

        // Draws toppings on top of everything!
        for (Topping t : toppings) {
            t.draw(g);
        }
    }
}