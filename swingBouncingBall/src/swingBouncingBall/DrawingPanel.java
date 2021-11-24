package swingBouncingBall;

import javax.swing.*;
import java.awt.*;
import java.util.*;
@SuppressWarnings("serial")
public class DrawingPanel extends JPanel {
	Random rand = new Random();
	Color clr = Color.BLACK;
	public static final int HEIGHT = 400, WIDTH = 800, BALL_SIZE = 40
				, MAX_X_P = (WIDTH - BALL_SIZE)-8, MIN_X_P = 5
				,MIN_Y_P = 12, MAX_Y_P = HEIGHT-(108);
	double pX = MIN_X_P, pY = MIN_Y_P, velX = 2, velY = 0, accY = 0.09;
	
	DrawingPanel() {
		setBackground(Color.WHITE);
		setSize(WIDTH, HEIGHT);
		setVisible(true);
	}
	
	public void setVelocityX(int inVel) {
		this.velX = inVel;
	}
	public void setVelocityY(int inVel) {
		this.velY = inVel;
	}
	
	public void loop() {
		while(true) {
			velY += accY;
			pX += velX;
			pY += velY;
			repaint();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(pX >= MAX_X_P ) {
				pX = MAX_X_P;
				velX *= - 0.94;
			} else if(pX <= MIN_X_P) {
				pX = MIN_X_P;
				velX *= - 0.94;
			} else if(pY >= MAX_Y_P) {
				pY = MAX_Y_P;
				velY *= - 0.98;
			} else if(pY <= MIN_Y_P) {
				pY = MIN_Y_P;
				velY *= - 0.98;
			}
		}
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.drawLine(0, 7, WIDTH, 7);
		g.setColor(clr);
		g.fillOval((int) Math.round(pX), (int) Math.round(pY), BALL_SIZE, BALL_SIZE);
	}

}
