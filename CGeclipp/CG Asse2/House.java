package house;

import javax.swing.*;
import java.awt.*;

public class House extends JPanel {
	int[][] base = {{-100, 100}, {100, 100}, {100, 300}, {-100, 300}, {-100, 100}};
	int[][] roof = {{-100, 100}, {0, 0}, {100, 100}, {-100, 100}};
	int[][] door = {{-30, 300}, {30, 300}, {30, 220}, {-30, 220}, {-30, 300}};
	
	public void paint(Graphics g) {
		scale();
		
		double angle = Math.toRadians(90);
		        
        translate(400, 100);
		g.setColor(Color.RED);
		drawHouse(g);
		
		translate(-400, -100);
        rotate(angle);
        translate(650, 350);
        g.setColor(Color.GREEN);
		drawHouse(g);
		
		translate(-650, -350);
        rotate(angle);
        translate(400, 600);
        g.setColor(Color.YELLOW);
		drawHouse(g);
		
		translate(-400, -600);
        rotate(angle);
        translate(150, 350);
        g.setColor(new Color(255, 140, 210));
		drawHouse(g);
	}
	
	void drawHouse(Graphics g) {
		for(int i = 0; i < this.base.length-1; i++) {
			this.drawLine(g, this.base[i][0], this.base[i][1], this.base[i+1][0], this.base[i+1][1]);
		}
				
		for(int i = 0; i < this.roof.length-1; i++) {
			this.drawLine(g, this.roof[i][0], this.roof[i][1], this.roof[i+1][0], this.roof[i+1][1]);
		}
		
		for(int i = 0; i < this.door.length-1; i++) {
			this.drawLine(g, this.door[i][0], this.door[i][1], this.door[i+1][0], this.door[i+1][1]);
		}
	}
	
	void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
		 int dx = x2 - x1;
		 int dy = y2 - y1;
		 int steps = Math.max(Math.abs(dx), Math.abs(dy));

		 float x_inc = (float) dx / steps;
		 float y_inc = (float) dy / steps;

		 float x = x1;
		 float y = y1;

		 for (int i = 0; i <= steps; i++) {
			 g.fillRect(Math.round(x), Math.round(y), 2, 2);
			 
			 x += x_inc;
			 y += y_inc;
		 }
	}
	
	void scale() {
	     for (int i = 0; i < this.base.length; i++) {
	         this.base[i][0] = Math.round(this.base[i][0] * 0.6f);
	         this.base[i][1] = Math.round(this.base[i][1] * 0.6f);
	     }
	     
	     for (int i = 0; i < this.roof.length; i++) {
	         this.roof[i][0] = Math.round(this.roof[i][0] * 0.6f);
	         this.roof[i][1] = Math.round(this.roof[i][1] * 0.6f);
	     }
	     
	     for (int i = 0; i < this.door.length; i++) {
	         this.door[i][0] = Math.round(this.door[i][0] * 0.6f);
	         this.door[i][1] = Math.round(this.door[i][1] * 0.6f);
	     }
	}
	
	void rotate(double angle) {
        for (int i = 0; i < this.base.length; i++) {
            int oldX = this.base[i][0];
            int oldY = this.base[i][1];
            
            this.base[i][0] = Math.round((float)(oldX * Math.cos(angle) - oldY * Math.sin(angle)));
            this.base[i][1] = Math.round((float)(oldX * Math.sin(angle) + oldY * Math.cos(angle)));
        }
        
        for (int i = 0; i < this.roof.length; i++) {
            int oldX = this.roof[i][0];
            int oldY = this.roof[i][1];
            
            this.roof[i][0] = Math.round((float)(oldX * Math.cos(angle) - oldY * Math.sin(angle)));
            this.roof[i][1] = Math.round((float)(oldX * Math.sin(angle) + oldY * Math.cos(angle)));
        }
        
        for (int i = 0; i < this.door.length; i++) {
            int oldX = this.door[i][0];
            int oldY = this.door[i][1];
            
            this.door[i][0] = Math.round((float)(oldX * Math.cos(angle) - oldY * Math.sin(angle)));
            this.door[i][1] = Math.round((float)(oldX * Math.sin(angle) + oldY * Math.cos(angle)));
        }
    }
	
	public void translate(int tx, int ty) {
	        for (int i = 0; i < this.base.length; i++) {
	            this.base[i][0] += tx;
	            this.base[i][1] += ty;
	        }
	        
	        for (int i = 0; i < this.roof.length; i++) {
	            this.roof[i][0] += tx;
	            this.roof[i][1] += ty;
	        }
	        
	        for (int i = 0; i < this.door.length; i++) {
	            this.door[i][0] += tx;
	            this.door[i][1] += ty;
	        }
    }


	public static void main(String[] args) {
		JFrame frame = new JFrame("House");
		 
		House panel = new House();
		 
		frame.add(panel);
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}

}
