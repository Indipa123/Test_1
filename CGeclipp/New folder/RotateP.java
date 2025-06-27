import javax.swing.*;
import java.awt.*;

public class RotateP extends JPanel {

    // House components: Base, Roof, and Door
    int[][] base = { { 100, 200 }, { 300, 200 }, { 300, 400 }, { 100, 400 }, { 100, 200 } };
    int[][] roof = { { 100, 200 }, { 200, 100 }, { 300, 200 }, { 100, 200 } };
    int[][] door = { { 170, 400 }, { 230, 400 }, { 230, 320 }, { 170, 320 }, { 170, 400 } };

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw original house (Blue)
        g.setColor(Color.BLUE);
        drawShape(base, g);
        drawShape(roof, g);
        drawShape(door, g);

        // translate the house by (-100,-400)
        translate(base, -100, -400);
        translate(roof, -100, -400);
        translate(door, -100, -400);

        // rotate the house by 15
        rotate(base, 15);
        rotate(roof, 15);
        rotate(door, 15);

        // translate the house by (100,400)
        translate(base, 100, 400);
        translate(roof, 100, 400);
        translate(door, 100, 400);
        // Draw house after rotation about pivot point (Red)
        g.setColor(Color.RED);
        drawShape(base, g);
        drawShape(roof, g);
        drawShape(door, g);
    }

    // Draw a shape using DDA line algorithm
    private void drawShape(int[][] shape, Graphics g) {
        for (int i = 0; i < shape.length - 1; i++) {
            ddaLine(shape[i][0], shape[i][1], shape[i + 1][0], shape[i + 1][1], g);
        }
    }

    // DDA Line Algorithm
    private void ddaLine(int x1, int y1, int x2, int y2, Graphics g) {
        int dx = x2 - x1, dy = y2 - y1, steps = Math.max(Math.abs(dx), Math.abs(dy));
        float Xinc = (float) dx / steps, Yinc = (float) dy / steps;
        float x = x1, y = y1;
        for (int i = 0; i <= steps; i++) {
            g.fillRect(Math.round(x), Math.round(y), 3, 3);
            x += Xinc;
            y += Yinc;
        }
    }

    // Translation function
    private void translate(int[][] square, int tx, int ty) {
        for (int i = 0; i < square.length; i++) {
            square[i][0] += tx;
            square[i][1] += ty;
        }
    }
    // Rotate function

    public void rotate(int[][] shape, double angleDegrees) {
        double angle = Math.toRadians(angleDegrees); // Convert to radians
        for (int i = 0; i < shape.length; i++) {
            int x = shape[i][0];
            int y = shape[i][1];
            shape[i][0] = (int) Math.round(x * Math.cos(angle) - y * Math.sin(angle));
            shape[i][1] = (int) Math.round(x * Math.sin(angle) + y * Math.cos(angle));
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        JFrame frame = new JFrame("House Rotation Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 900);
        frame.add(new RotateP());
        frame.setVisible(true);
    }
}