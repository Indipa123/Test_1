import javax.swing.*;
import java.awt.*;

public class Rotate extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Ensures proper rendering

        // Original square coordinates
        int[] x = { 100, 300, 300, 100 };
        int[] y = { 100, 100, 300, 300 };

        // Draw original square in BLUE
        g.setColor(Color.BLUE);
        drawPolygon(x, y, g);

        // Apply rotation (relative to origin)
        double angle = Math.toRadians(30); // 60 degrees
        rotate(x, y, angle);

        // Draw transformed square in RED
        g.setColor(Color.RED);
        drawPolygon(x, y, g);
    }

    private void drawPolygon(int[] x, int[] y, Graphics g) {
        for (int i = 0; i < x.length - 1; i++) {
            ddaLine(x[i], y[i], x[i + 1], y[i + 1], g);
        }
        // Close the polygon
        ddaLine(x[x.length - 1], y[y.length - 1], x[0], y[0], g);
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

    public void rotate(int[] x, int[] y, double angle) {
        for (int i = 0; i < x.length; i++) {
            int oldX = x[i];
            int oldY = y[i];
            x[i] = Math.round((float) (oldX * Math.cos(angle) - oldY * Math.sin(angle)));
            y[i] = Math.round((float) (oldX * Math.sin(angle) + oldY * Math.cos(angle)));
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Scaling and Rotation Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(new Rotate());
        frame.setVisible(true);
    }
}