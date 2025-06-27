package com88;

import java.awt.*;
import javax.swing.*;

public class Picture extends JPanel {
	
	@Override
	public void paint(Graphics g) {
		g.setColor(new Color(50, 150, 210));
		g.fillRect(0, 0, 800, 800);
		
		g.setColor(new Color(150, 100, 100));
		drawDDA(g, 0, 470, 600, 470);
		drawDDA(g, 0, 300, 600, 300);
		
		g.setColor(Color.BLACK);
		drawBresenhamCircle(g, 50, 460, 10);
		drawBresenhamCircle(g, 100, 460, 10);
		drawBresenhamCircle(g, 145, 460, 10);
		drawBresenhamCircle(g, 195, 460, 10);
		
		drawBox(g, 400, 320, 10, 10);
		drawDDA(g, 405, 330, 405, 350);
		drawDDA(g, 405, 335, 395, 340);
		drawDDA(g, 405, 335, 415, 340);
		drawDDA(g, 405, 350, 395, 360);
		drawDDA(g, 405, 350, 415, 360);
		
		
		g.setColor(new Color(150, 125, 100));
		drawBox(g, 30, 399, 90, 50);
		drawBox(g, 130, 399, 90, 50);
		
		drawDDA(g, 40, 380, 110, 380);
		drawDDA(g, 40, 380, 30, 399);
		drawDDA(g, 110, 380, 120, 399);
		
		drawBox(g, 40, 360, 20, 20);
		
		drawBox(g, 140, 410, 20, 20);
		drawBox(g, 180, 410, 20, 20);
		
		g.setColor(new Color(170, 100, 100));
		drawTri(g, 10, 300, 120, 125);
		drawTri(g, 105, 300, 120, 140);
		drawTri(g, 210, 300, 120, 105);
		drawTri(g, 315, 300, 120, 135);
		drawTri(g, 420, 300, 120, 100);
		
		g.setColor(new Color(100, 255, 100));
		drawTree(g, 50, 300);
		drawTree(g, 105, 300);
		drawTree(g, 180, 300);
		drawTree(g, 225, 300);
		drawTree(g, 300, 300);
		
		g.setColor(Color.ORANGE);
		drawBox(g, 460, 370, 90, 60);
		drawTri(g, 460, 370, 90, 30);
		
		g.setColor(new Color(255, 255, 255));
		drawBresenhamCircle(g, 120, 75, 25);
		drawBresenhamCircle(g, 95, 85, 20);
		drawBresenhamCircle(g, 140, 85, 20);
		
		g.setColor(Color.YELLOW);
		drawBresenhamCircle(g, 400, 90, 40);
		drawDDA(g, 400, 130, 400, 150);
		drawDDA(g, 400, 50, 400, 30);
		drawDDA(g, 360, 90, 340, 90);
		drawDDA(g, 440, 90, 460, 90);
		
	}
	
	public void drawBox(Graphics g, int x, int y, int width, int height) {
		drawDDA(g, x, y, x+width, y);
		drawDDA(g, x, y, x, y+height);
		drawDDA(g, x+width, y, x+width, y+height);
		drawDDA(g, x, y+height, x+width, y+height);
	}
	
	public void drawTri(Graphics g, int x, int y, int width, int height) {
		drawDDA(g, x, y, x+width, y);
		drawDDA(g, x, y, (x+width/2), y-height);
		drawDDA(g, x+width, y, (x+width/2), y-height);
	}
	
	public void drawTree(Graphics g, int x, int y) {
		drawTri(g, x, y, 30, 30);
		drawDDA(g, x+15, y, x +15, y +20);
	}
	
	public void drawDDA(Graphics g, int x1, int y1, int x2, int y2) {
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
	
	private void drawBresenhamCircle(Graphics g, int xc, int yc, int r) {
		 int x = 0, y = r;
		 int d = 3 - 2 * r; 
		 plotPoints(g, xc, yc, x, y);
		 
		 while (y >= x) {
			 x++;
			 if (d > 0) {
				 y--;
				 d = d + 4 * (x - y) + 10;
			 } else {
				 d = d + 4 * x + 6;
			 }
			 
			 plotPoints(g, xc, yc, x, y);
			 
			 }
		 }
		
	private void plotPoints(Graphics g, int xc, int yc, int x, int y) {
		 g.fillRect(xc + x, yc + y, 2, 2);
		 g.fillRect(xc - x, yc + y, 2, 2);
		 g.fillRect(xc + x, yc - y, 2, 2);
		 g.fillRect(xc - x, yc - y, 2, 2);
		 g.fillRect(xc + y, yc + x, 2, 2);
		 g.fillRect(xc - y, yc + x, 2, 2);
		 g.fillRect(xc + y, yc - x, 2, 2);
		 g.fillRect(xc - y, yc - x, 2, 2);
	}
		 

	public static void main(String[] args) {
		JFrame picture = new JFrame("Picture");
		
		Picture pic = new Picture();
		
		picture.add(pic);
		picture.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		picture.setSize(600, 600);
		picture.setVisible(true);

	}

}
