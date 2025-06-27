import javax.swing.*;
import java.awt.*;

public class Scaling1 extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Ensures proper rendering

        // Original square coordinates
        int[] x = { 0, 300, 300, 0 };
        int[] y = { 0, 0, 300, 300 };

        // Draw original square in BLUE
        g.setColor(Color.BLUE);
        drawPolygon(x, y, g);

        float sx = 1.5f;
        float sy = 0.5f;
        scale(x, y, sx, sy);

        g.setColor(Color.RED);
        drawPolygon(x, y, g);
    }

    private void drawPolygon(int[] x, int[] y, Graphics g) {
        for (int i = 0; i < x.length - 1; i++) {
            ddaLine(x[i], y[i], x[i + 1], y[i + 1], g);
        }
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

    public void scale(int[] x, int[] y, float sx, float sy) {
        for (int i = 0; i < x.length; i++) {
            x[i] = Math.round(x[i] * sx);
            y[i] = Math.round(y[i] * sy);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Scaling Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(new Scaling1());
        frame.setVisible(true);
    }
}
