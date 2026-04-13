import java.awt.*;

/**
 * Represents a single topping placed on the pizza.
 */
public class Topping {

    //Used for dimensions for topping design
    private int x, y;
    private String type;

    public Topping(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    //Draws the topping based on its type.

    public void draw(Graphics g) {

        // Used graphics 2d here to change the stroke thickness for some outlines
        Graphics2D g2 = (Graphics2D) g;

        if (type.equals("pepperoni")) {
            g.setColor(Color.RED);
            g.fillOval(x - 15, y - 15, 30, 30);
            g.setColor(new Color(142, 43, 0));

            g.drawOval(x - 15, y - 15, 30, 30);
        }

        else if (type.equals("mushroom")) {
            
            g2.setStroke(new BasicStroke(4));
            g2.setColor(new Color(112,92,36));
            g2.drawOval(x - 16, y - 8, 32, 16);
            g2.drawRect(x - 8, y, 17, 17);

            g.setColor(new Color(201, 182, 130));
            g.fillOval(x - 16, y - 8, 32, 16);
            g.fillRect(x-8, y, 16, 16);

        }

        else if (type.equals("olive")) {

            //g2.setStroke(new BasicStroke(4));
            //g2.setColor(Color.BLACK);
            //g2.drawOval(x - 8, y - 8, 16, 16);

            //g2.setStroke(new BasicStroke(1));

            g.setColor(Color.BLACK);
            g.fillOval(x-8,y-8, 16,16);
        }

        else if (type.equals("cheese")) {

            g.setColor(new Color(255, 225, 140));
            g.fillOval(x-20,y-20, 40,40);
        }
    }
}