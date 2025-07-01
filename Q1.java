import javax.swing.*;
import java.awt.*;

public class Q1 extends JPanel {
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Color c = new Color(255, 0, 0);
		
		g.setColor(c);
		
		int[] point_1 = {100, 200};
		int[] point_2 = {200, 300};
		
		int[] translation = {50, 60};
		
		dda(g, point_1[0], point_1[1], point_2[0], point_2[1]);
		
		int[][] points = {point_1, point_2}; 
		
		translateLine(g, points, translation);
		
		g.setColor(Color.BLUE);
		dda(g, point_1[0], point_1[1], point_2[0], point_2[1]);
	}
	
	public void translateLine(Graphics g, int P[][], int T[]) {
		for(int i = 0; i < P.length; i++) {
			P[i][0] += T[0];
			P[i][1] += T[1];
		}
	}
	
	public void translatePoint(Graphics g, int[] P, int[] T) {
        P[0] += T[0];
		P[1] += T[1];
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
		JFrame frame = new JFrame("Q1");
		
		Q1 panel = new Q1();
		
		frame.add(panel);
		frame.setSize(500, 500);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		

	}

}