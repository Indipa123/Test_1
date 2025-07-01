import javax.swing.*;
import java.awt.*;

public class Q2 extends JPanel {
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int[] x = {100, 200, 150};
		int[] y = {400, 400, 300};
		
		g.setColor(Color.BLUE);
		drawPolygon(x, y, g);
		
		translate(x, y, 200, 0, g);
		g.setColor(Color.RED);
		drawPolygon(x, y, g);
		translate(x, y, -200, 0, g);
		
		
		scale(x, y, 1.5f, 1.5f);
		g.setColor(Color.GREEN);
		drawPolygon(x, y, g);
		scale(x, y, (float) 10/15, (float) 10/15);
		
		double angle = Math.toRadians(-30);
		rotate(x, y, angle);
		g.setColor(Color.BLACK);
		drawPolygon(x, y, g);
		 
		
		
		
	}
	
	void drawPolygon(int[] x, int[] y, Graphics g) {
		for(int i = 0; i < x.length - 1; i++) {
			dda(g, x[i], y[i], x[i+1], y[i+1]);
		}
		
		dda(g, x[0], y[0], x[x.length-1], y[y.length-1]);
	}
	
	void translate(int[] x, int[] y, int tx, int ty, Graphics g) {
		for(int i = 0; i < x.length; i++) {
			x[i] += tx;
			y[i] += ty;
		}
	}
	
	public void scale(int[] x, int[] y, float sx, float sy) {
        for (int i = 0; i < x.length; i++) {
            x[i] = Math.round(x[i] * sx);
            y[i] = Math.round(y[i] * sy);
        }
    }
	
	public void rotate(int[] x, int[] y, double angle) {
        for (int i = 0; i < x.length; i++) {
            int oldX = x[i];
            int oldY = y[i];
            x[i] = Math.round((float)(oldX * Math.cos(angle) - oldY * Math.sin(angle)));
            y[i] = Math.round((float)(oldX * Math.sin(angle) + oldY * Math.cos(angle)));
        }
    }
	
	public void dda(Graphics g, int x0, int y0, int x1, int y1) {
        int dx = x1 - x0;
        int dy = y1 - y0;

        int steps = Math.max(Math.abs(dx), Math.abs(dy));

        float Xinc = (float) dx / steps;
        float Yinc = (float) dy / steps;

        float x = x0;
        float y = y0;

        for (int i = 0; i <= steps; i++) {
            g.fillRect(Math.round(x), Math.round(y), 1, 1);
            x += Xinc;
            y += Yinc;
        }
    }

	public static void main(String[] args) {
		JFrame frame = new JFrame("Q2");
		
		Q2 panel = new Q2();
		
		frame.add(panel);
		frame.setSize(500, 500);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		

	}

}