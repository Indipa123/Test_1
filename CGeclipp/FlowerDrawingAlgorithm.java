package lab8;

import javax.swing.*;
import java.awt.*;

public class FlowerDrawingAlgorithm extends JPanel {

    private void drawLine(Graphics g, int x1, int y1, int x2, int y2, Color color) {
        g.setColor(color);
        int dx = Math.abs(x2 - x1), dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1, sy = y1 < y2 ? 1 : -1;
        int err = dx - dy;

        while (true) {
            g.fillRect(x1, y1, 1, 1);
            if (x1 == x2 && y1 == y2) break;
            int e2 = 2 * err;
            if (e2 > -dy) { err -= dy; x1 += sx; }
            if (e2 < dx) { err += dx; y1 += sy; }
        }
    }

    private void drawCircle(Graphics g, int xc, int yc, int r, Color color) {
        g.setColor(color);
        int x = 0, y = r;
        int d = 1 - r;

        while (x <= y) {
            plotCirclePoints(g, xc, yc, x, y);
            x++;
            if (d < 0) {
                d += 2 * x + 1;
            } else {
                y--;
                d += 2 * (x - y) + 1;
            }
        }
    }

    private void plotCirclePoints(Graphics g, int xc, int yc, int x, int y) {
        g.fillRect(xc + x, yc + y, 1, 1);
        g.fillRect(xc - x, yc + y, 1, 1);
        g.fillRect(xc + x, yc - y, 1, 1);
        g.fillRect(xc - x, yc - y, 1, 1);
        g.fillRect(xc + y, yc + x, 1, 1);
        g.fillRect(xc - y, yc + x, 1, 1);
        g.fillRect(xc + y, yc - x, 1, 1);
        g.fillRect(xc - y, yc - x, 1, 1);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

      
        drawLine(g, 200, 250, 200, 400, Color.GREEN);

        
        drawCircle(g, 170, 300, 20, Color.GREEN);
        drawCircle(g, 230, 300, 20, Color.GREEN);

      
        int petalRadius = 50;
        int centerX = 200;
        int centerY = 200;
        for (int i = 0; i < 8; i++) {
            double angle = Math.toRadians(i * 45);
            int x = (int) (centerX + Math.cos(angle) * petalRadius);
            int y = (int) (centerY + Math.sin(angle) * petalRadius);
            drawCircle(g, x, y, petalRadius / 2, Color.RED);
        }

     
        drawCircle(g, centerX, centerY, 20, Color.YELLOW);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Flower Drawing");
        FlowerDrawingAlgorithm flower = new FlowerDrawingAlgorithm();
        frame.add(flower);
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

