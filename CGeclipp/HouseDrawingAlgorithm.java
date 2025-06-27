package lab8;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HouseDrawingAlgorithm extends JPanel {

    
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

       
        drawLine(g, 100, 150, 300, 150, Color.RED); 
        drawLine(g, 100, 150, 100, 300, Color.RED); 
        drawLine(g, 300, 150, 300, 300, Color.RED); 
        drawLine(g, 100, 300, 300, 300, Color.RED); 

       
        drawLine(g, 100, 150, 200, 50, Color.ORANGE);
        drawLine(g, 200, 50, 300, 150, Color.ORANGE);

       
        drawLine(g, 175, 300, 175, 230, Color.MAGENTA);
        drawLine(g, 225, 300, 225, 230, Color.MAGENTA);
        drawLine(g, 175, 230, 225, 230, Color.MAGENTA);

        
        drawCircle(g, 130, 190, 20, Color.GREEN); 
        drawCircle(g, 270, 190, 20, Color.GREEN); 
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("House Drawing");
        HouseDrawingAlgorithm house = new HouseDrawingAlgorithm();
        frame.add(house);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
