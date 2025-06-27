import javax.swing.*;
import java.awt.*;

public class ReflectionX extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Ensures proper rendering

        // Original square coordinates
        int[] x = { 0, 200, 200, 0 };
        int[] y = { 0, 0, 200, 200 };

        // Draw original square in BLUE
        g.setColor(Color.BLUE);
        drawPolygon(x, y, g);

        // Apply reflection across X-axis
        reflectAcrossXAxis(y);

        // Draw reflected square in RED
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

    // Reflect across the X-axis: y → -y
    public void reflectAcrossXAxis(int[] y) {
        for (int i = 0; i < y.length; i++) {
            y[i] = -y[i] + 400; // Reflect and shift vertically to stay visible
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Reflection Across X-Axis");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(new ReflectionX());
        frame.setVisible(true);
    }
}