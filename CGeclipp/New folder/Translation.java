import javax.swing.*;
import java.awt.*;

public class Translation extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Ensures proper rendering

        int[] x = { 0, 200, 200, 0 }; // X-coordinates
        int[] y = { 0, 0, 200, 200 }; // Y-coordinates
        // Original square
        g.setColor(Color.BLUE);
        ddaLine(x[0], y[0], x[1], y[1], g);
        ddaLine(x[1], y[1], x[2], y[2], g);
        ddaLine(x[2], y[2], x[3], y[3], g);
        ddaLine(x[3], y[3], x[0], y[0], g);

        // Translated square

        translate(x, y, 250, 250); // Translate by (20, 20)

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

    public void translate(int x[], int y[], int tx, int ty) {
        for (int i = 0; i < x.length; i++) {
            x[i] += tx;
            y[i] += ty;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Translation Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(new Translation());
        frame.setVisible(true);
    }
}