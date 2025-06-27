import javax.swing.*;
import java.awt.*;

public class SmileyFace extends JPanel {

    private void drawCircleBresenham(Graphics g, int xc, int yc, int r, Color color) {
        g.setColor(color);
        int x = 0, y = r;
        int d = 3 - 2 * r;
        
        while (y >= x) {
            plotCirclePoints(g, xc, yc, x, y);
            x++;
            if (d > 0) {
                y--;
                d = d + 4 * (x - y) + 10;
            } else {
                d = d + 4 * x + 6;
            }
            plotCirclePoints(g, xc, yc, x, y);
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

   
    private void drawLineDDA(Graphics g, int x1, int y1, int x2, int y2, Color color) {
        g.setColor(color);
        int dx = x2 - x1, dy = y2 - y1;
        int steps = Math.max(Math.abs(dx), Math.abs(dy));
        
        float xInc = (float) dx / steps;
        float yInc = (float) dy / steps;
        
        float x = x1, y = y1;
        for (int i = 0; i <= steps; i++) {
            g.fillRect(Math.round(x), Math.round(y), 1, 1);
            x += xInc;
            y += yInc;
        }
    }

 
    private void drawSmileArc(Graphics g, int xc, int yc, int r, Color color) {
        g.setColor(color);
        int x = 0, y = r;
        int d = 1 - r;
        
        while (x < y) {
            x++;
            if (d < 0) {
                d = d + 2 * x + 1;
            } else {
                y--;
                d = d + 2 * (x - y) + 1;
            }
            plotArcPoints(g, xc, yc, x, y);
        }
    }

    private void plotArcPoints(Graphics g, int xc, int yc, int x, int y) {
       
        g.fillRect(xc + x, yc + y, 1, 1);
        g.fillRect(xc - x, yc + y, 1, 1);
        g.fillRect(xc + y, yc + x, 1, 1);
        g.fillRect(xc - y, yc + x, 1, 1);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

     
        int centerX = 150, centerY = 150, headRadius = 100;
        int eyeRadius = 10, eyeOffsetX = 35, eyeOffsetY = 30;
        int eyebrowOffsetY = 50, eyebrowLength = 20;
        int smileY = centerY + 30, smileRadius = 40;

      
        drawCircleBresenham(g, centerX, centerY, headRadius, Color.GRAY);

       
        drawCircleBresenham(g, centerX - eyeOffsetX, centerY - eyeOffsetY, eyeRadius, Color.BLACK);
        drawCircleBresenham(g, centerX + eyeOffsetX, centerY - eyeOffsetY, eyeRadius, Color.BLACK);

     
        drawLineDDA(g, centerX - eyeOffsetX - 10, centerY - eyebrowOffsetY, centerX - eyeOffsetX + eyebrowLength, centerY - eyebrowOffsetY - 10, Color.BLACK);
        drawLineDDA(g, centerX + eyeOffsetX - eyebrowLength, centerY - eyebrowOffsetY - 10, centerX + eyeOffsetX + 10, centerY - eyebrowOffsetY, Color.BLACK);

     
        drawSmileArc(g, centerX, smileY, smileRadius, Color.RED);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Smiley Face Drawing");
        SmileyFace panel = new SmileyFace();
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
