package lab8;

import javax.swing.*;
import java.awt.*;

public class LandscapeDrawing extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

      
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, getWidth(), getHeight());

     
        g.setColor(new Color(34, 139, 34));
        g.fillRect(0, getHeight() - 100, getWidth(), 100);

       
        g.setColor(new Color(139, 69, 19));
        int[] xPoints1 = {50, 200, 350};
        int[] yPoints1 = {300, 150, 300};
        g.fillPolygon(xPoints1, yPoints1, xPoints1.length);

        int[] xPoints2 = {200, 400, 600};
        int[] yPoints2 = {300, 100, 300};
        g.fillPolygon(xPoints2, yPoints2, xPoints2.length);

        int[] xPoints3 = {450, 600, 750};
        int[] yPoints3 = {300, 180, 300};
        g.fillPolygon(xPoints3, yPoints3, xPoints3.length);

   
        g.setColor(Color.YELLOW);
        g.fillOval(500, 50, 80, 80);


        for (int i = 0; i < 360; i += 30) {
            double angle = Math.toRadians(i);
            int x1 = 540 + (int) (40 * Math.cos(angle));
            int y1 = 90 + (int) (40 * Math.sin(angle));
            int x2 = 540 + (int) (50 * Math.cos(angle));
            int y2 = 90 + (int) (50 * Math.sin(angle));
            g.drawLine(x1, y1, x2, y2);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Landscape Drawing");
        LandscapeDrawing panel = new LandscapeDrawing();
        frame.add(panel);
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

