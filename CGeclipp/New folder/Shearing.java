import javax.swing.*;
import java.awt.*;

public class Shearing extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Ensures proper rendering

        // Original square
        g.setColor(Color.BLUE);
        // Square coordinates
        int[] x = { 0, 200, 200, 0 }; // X-coordinates
        int[] y = { 0, 0, 200, 200 }; // Y-coordinates
        ddaLine(x[0], y[0], x[1], y[1], g);
        ddaLine(x[1], y[1], x[2], y[2], g);
        ddaLine(x[2], y[2], x[3], y[3], g);
        ddaLine(x[3], y[3], x[0], y[0], g);

        // Shear the square
        // shear(x, y, 1.0f, 0.5f); // Shear X by 1.0, Y by 0.5
        // shear(x, y, 0, 0.5f); // Shear X by 0, Y by 0.5
        shear(x, y, 1.0f, 0); // Shear X by 1.0, Y by 0

        // Draw sheared square
        g.setColor(Color.RED);
        ddaLine(x[0], y[0], x[1], y[1], g);
        ddaLine(x[1], y[1], x[2], y[2], g);
        ddaLine(x[2], y[2], x[3], y[3], g);
        ddaLine(x[3], y[3], x[0], y[0], g);
    }

    public void ddaLine(int x1, int y1, int x2, int y2, Graphics g) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        int steps = Math.max(Math.abs(dx), Math.abs(dy));

        float Xinc = (float) dx / steps;
        float Yinc = (float) dy / steps;

        float x = x1;
        float y = y1;

        for (int i = 0; i <= steps; i++) {
            g.fillRect(Math.round(x), Math.round(y), 1, 1);
            x += Xinc;
            y += Yinc;
        }
    }

    public void shear(int[] x, int[] y, float shx, float shy) {
        for (int i = 0; i < x.length; i++) {
            int newX = Math.round(x[i] + shx * y[i]);
            int newY = Math.round(y[i] + shy * x[i]);
            x[i] = newX;
            y[i] = newY;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("2D Shearing Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.add(new Shearing());
        frame.setVisible(true);
    }
}